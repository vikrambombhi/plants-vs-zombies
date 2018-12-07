package model;

import java.io.*;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.Random;

import view.Listener;
import event.BoardEvent;

/*
 * Model representing the game board
 */
public class Board implements Serializable {
    private List<Listener> listeners;
	private Tile[][] tiles;
	private int height, width;
    private int zombiesEliminated = 0;
    private int numZombiesToGenerate = 10;
    private static Board board = null;

    private Random random;

    /*
     * The game board. This class is a singleton.
     * @param height: height of the game board
     * @param width: width of the game board
     */
	public Board(int height, int width) {
        // Return exiting board if one exists
        if(Board.board != null) {
            Board.board = this;
        } else {
            Board.board = this;

            this.listeners = new ArrayList<>();
            this.tiles = new Tile[height][width];
            this.height = height;
            this.width = width;

            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    this.tiles[row][col] = new Tile();
                }
            }
        }

        this.random = new Random(System.currentTimeMillis());
	}

    /*
     * Register listeners to be notified on changes to this model
     * @param listener: listener to register to this model
     */
    public void addActionListener(Listener listener) {
        this.listeners.add(listener);
    }

    // Notifies listeners of current board state
    public void notifyListeners() {
        BoardEvent event = new BoardEvent(this, this.tiles);
        for(Listener listener: listeners) listener.handleEvent(event);
    }

    public void loadBoardConfig(int height, int width) {
        this.listeners = new ArrayList<>();
        this.tiles = new Tile[height][width];
        this.height = height;
        this.width = width;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                this.tiles[row][col] = new Tile();
            }
        }
    }

    /*
     * Places plant on board
     * @param plant: plant to place
     * @param row, col: row and column where the plant is should be placed
     */
	public boolean placePlant(Plants plant, int row, int col) {
		try {
            // Check if there is already a plant on selected location
			if (this.tiles[row][col].getPlant() != null) {
				System.out.println("Already a plant on that tile");
				return false;
			}
            this.tiles[row][col].setPlant(plant);
            Stats stats = Stats.getStats();
            // Remove sunpoints from user for buying the plant
            stats.removeSunPoints(plant.getSunPointCost());
            // Notify listeners that a plant has been placed
            notifyListeners();
            return true;
		}catch(ArrayIndexOutOfBoundsException e1) {
			System.out.println("Out of Range");
            return false;
		}
	}

    /*
     * Place zombie on board
     * @param zombie: zombie to place
     * @param row, col: row and column to place zombie at
     */
	public void placeZombie(Zombies zombie, int row, int col) {
		this.tiles[row][col].addZombie(zombie);
        // Notify listeners that a zombie has been placed on the board
        notifyListeners();
    }
    
    /*
     * Generate's a type of zombie somewhere in the last column based on pseudo randomization.
     * @param chancePerTurn: starting from 0 to chancePerTurn, if the random number matches an n value then spawn given zombie.
     */
    private void generateZombie(int chancePerTurn) {
        // Generate random int
        int n = this.random.nextInt(chancePerTurn);
        if (n == 0 || n == 1) {
            // Place the zombie on the board
            this.placeZombie(new Zombie(), random.nextInt(height), width - 1);
            // Decrement number of zombies that need to be generated
            // TODO: update numZombiesToGenerate on stats model
            numZombiesToGenerate--;
        } else if (n == 2) {
            this.placeZombie(new TankZombie(), random.nextInt(height), width - 1);
            numZombiesToGenerate--;
        }
    }

    /*
     * Move's the projectiles that currently still have travel distance one tile over.
     * @param turn: the current game turn. If the projectile's turn is higher than game turn, it will not move.
     * @param row: the row of the projectiles to move.
     * @param col: the column of the projectiles to move.
     */
    private void moveProjectiles(int turn, int row, int col) {
        ArrayDeque<Projectile> projectiles = this.tiles[row][col].getProjectiles();
        for (Projectile projectile : projectiles) {
            if (projectile.move(turn)) {
                projectiles.remove(projectile);
                if (col < width-1) {
                    this.tiles[row][col+1].addProjectile(projectile);
                }
            }
        }
    }
    
    /*
     * Move's the projectiles that currently still have travel distance one tile over.
     * @param stats: the game's stats. Includes the current game turn. If the zombies's turn is higher than player turn, it will not move.
     * @param row: the row of the zombies to move.
     * @param col: the column of the zombies to move.
     */
    private void moveZombies(Stats stats, int row, int col) {
        ArrayDeque<Zombies> zombies = this.tiles[row][col].getZombies();
        for (Zombies zombie : zombies) {
            // If a plant is to the zombie's left, it attacks it.
            Plants plant = this.tiles[row][col-1].getPlant();
            if (col > 0 &&  plant != null) {
                damagePlant(stats, plant, zombie, row, col-1);
            } else {
                // zombie moves until it can't move anymore for the turn or dies from projectile collision or encounters a plant to its immediate left
                int moveTo = col;
                while (zombie.getHP() > 0 && zombie.move(stats.getTurn()) && moveTo >= 0 && this.tiles[row][moveTo].getPlant() == null) {
                    this.tiles[row][moveTo].turn(zombie);
                    moveTo--;
                }
                zombies.remove(zombie);
                if (zombie.getHP() > 0) {
                    zombie.queueNextTurn();
                    this.tiles[row][moveTo].addZombie(zombie);
                    // If zombie moves to column 0, player loses.
                    if (moveTo == 0) {
                        stats.playerLost();
                        notifyListeners();
                    }
                }
            }
        }
    }

    /*
     * Damage the plant when the given zombie attacks. Zombie attacks plant's to its immediate left.
     * @param stats: the game's stats. Used for decreasing sun point generation rate if a sunflower plant dies.
     * @param row: the row of the plant being attacked.
     * @param col: the column of the plant being attacked.
     */
    private void damagePlant(Stats stats, Plants plant, Zombies zombie, int row, int col) {
        plant.takeDamage(zombie.getDamage());
        if (plant.getHP() == 0) {
            // if the plant that dies is a sunflower, decrease sunpoint generation
            if (plant.getType() == PlantTypes.SUNFLOWER.getType()) {
                Sunflower sunflower = (Sunflower) plant;
                stats.decreaseSunPointsGenerationRate(sunflower.getSunPointGeneratedPerTurn());
            }
            this.tiles[row][col].removePlant();
        }
    }
    
    /*
     * A turn plays out. Each tile is investigated to see if a plant does an action or if projectiles move or if a zombie moves or attacks.
     */
	public void turn() { 
		Stats stats = Stats.getStats();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                this.tiles[row][col].turn();

                moveProjectiles(stats.getTurn(), row, col);
                moveZombies(stats, row, col);
            }
        }

        if (numZombiesToGenerate > 0) {
            generateZombie(10);
        }
        
        notifyListeners();
	}

    // return height of the board
	public static int getHeight() {
		return Board.board.height;
	}

    // return width of the board
	public static int getWidth() {
		return Board.board.width;
	}

    // return the board
    public static Board getBoard() {
        return Board.board;
    }

    public byte[] saveBoard() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);

        out.writeObject(board);
        byte[] b = bos.toByteArray();
        out.close();
        bos.close();

        return b;
    }

    public void undoBoard(byte[] b) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(b);
        ObjectInputStream in = new ObjectInputStream(bis);

        board.setTiles(((Board)in.readObject()).getTiles());

        in.close();
        bis.close();
        notifyListeners();
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                this.tiles[row][col] = tiles[row][col];
            }
        }
    }
}

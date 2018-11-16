package model;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import view.Listener;
import event.BoardEvent;

public class Board {
    private List<Listener> listeners;
	private Tile[][] tiles;
	private int height, width;
	private int zombiesEliminated = 0;
    private static Board board = null;

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
	}

    public void addActionListener(Listener listener) {
        this.listeners.add(listener);
    }

    public void notifyListeners() {
        BoardEvent event = new BoardEvent(this, this.tiles);
        for(Listener listener: listeners) listener.handleEvent(event);
    }

	public boolean placePlant(Plants plant, int row, int col) {
		try {
			if (this.tiles[row][col].getPlant() != null) return false;
			this.tiles[row][col].setPlant(plant);
            notifyListeners();
            return true;
		}catch(ArrayIndexOutOfBoundsException e1) {
			System.out.println("Out of Range");
            return false;
		}
	}

	public void placeZombie(Zombies zombie, int row, int col) {
		this.tiles[row][col].addZombie(zombie);
        notifyListeners();
	}

	public TurnResult turn() {
		int generatedSunPoints = 0;
		int zombiesEliminated = 0;

		for (int row = 0; row < height; row++) {
			int[] projectileCache = new int[width];
			for (int col = 0; col < width; col++) {
                // stores number of projectiles starting on each tile so that the following doesn't loop a projectile's movement				
                projectileCache[col] = this.tiles[row][col].getProjectiles().size(); 
			}
			for (int col = 0; col < width; col++) {
				TurnResult tileResult = this.tiles[row][col].turn();

				generatedSunPoints += tileResult.getGeneratedSunPoints();
				zombiesEliminated += tileResult.getZombiesEliminated();
                int projectilesHit = tileResult.getProjectilesHit();

				if (this.tiles[row][col].getPlant() == null && this.tiles[row][col].getZombies().size() > 0) {
					for (Zombies zombie : this.tiles[row][col].getZombies()) {
						int distance = zombie.getMovespeed();
						int trajectory = col; 
						while (distance > 0 && trajectory > 0 && this.tiles[row][trajectory].getPlant() == null) { // need to implement zombie running into projectile IF his movespeed > 1
							distance--;
							trajectory--;
						}
						if (trajectory == 0 && distance > 0)
							return new TurnResult(-1, tileResult.getZombiesEliminated()); // lost game
						this.tiles[row][trajectory].addZombie(zombie); // also need to implement for zombies with movespeed higher than 1
					}
					this.tiles[row][col].removeZombies();
                } else if (col < this.width && projectileCache[col] > 0) {
                    ListIterator iter = this.tiles[row][col].getProjectiles().listIterator(0);
                    int movingProjectiles = projectileCache[col] - projectilesHit;
                    while (movingProjectiles > 0 && iter.hasNext()) {
                        movingProjectiles--;
                        Projectile projectile = (Projectile) iter.next();
                        this.tiles[row][col].removeFirstProjectile();
                        int distance = projectile.getSpeed();
                        int trajectory = col;
                        // if it encounters a tilewith zombies, add to tile projectile list as its still same turn, one problem with this is that if the projectile has some distance left to cover and zombie dies before the projectile hits it, the projectile will still stop on this tile
                        while (distance > 0 && trajectory < width && this.tiles[row][trajectory].getZombies().size() == 0) {
                            distance--;
                            trajectory++;
                        }
                        if (trajectory < width) {
                            this.tiles[row][trajectory].addProjectile(projectile);
                        }
                    }
                }
			}
		}

        notifyListeners();
        return new TurnResult(generatedSunPoints, zombiesEliminated);
	}

	public void print() {
		for (Tile[] row : this.tiles) {
			for (Tile tile : row) {
				System.out.print(tile.toString() + " ");
			}
			System.out.println();
		}
	}

	public static int getHeight() {
		return Board.board.height;
	}

	public static int getWidth() {
		return Board.board.width;
	}

    public static Board getBoard() {
        return Board.board;
    }
}

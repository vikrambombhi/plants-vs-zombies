import java.util.Arrays;
import java.util.ListIterator;

public class Board {
	private Tile[][] tiles;
	private int height, width;
	private int zombiesEliminated = 0;

	public Board(int height, int width) {
		this.tiles = new Tile[height][width];
		this.height = height;
		this.width = width;

		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				this.tiles[row][col] = new Tile();
			}
		}
	}

	public boolean placePlant(Plants plant, int row, int col) {
		try {
			if (this.tiles[row][col].getPlant() != null)
				return false;
			this.tiles[row][col].setPlant(plant);
			return true;
		}catch(ArrayIndexOutOfBoundsException e1) {
			System.out.println("Out of Range");
		}
		return false;
//		if (this.tiles[row][col].getPlant() != null)
//			return false;
//		this.tiles[row][col].setPlant(plant);
//		return true;
	}

	public void placeZombie(Zombies zombie, int row, int col) {
		this.tiles[row][col].addZombie(zombie);
	}

	public TurnResult turn() {
		int generatedSunPoints = 0;
		int zombiesEliminated = 0;

		for (int row = 0; row < height; row++) {
			int[] projectileCache = new int[width];
			for (int col = 0; col < width; col++) {
				projectileCache[col] = this.tiles[row][col].getProjectiles().size(); // stores number of projectiles
																						// starting on each tile so that
																						// the following doesn't loop a
																						// projectile's movement
			}
			for (int col = 0; col < width; col++) {
				int numProjectilesMovedIntoTile = this.tiles[row][col].getProjectiles().size() - projectileCache[col];
				TurnResult tileResult = this.tiles[row][col].turn();
				int numProjectilesToMoveTiles = this.tiles[row][col].getProjectiles().size() - projectileCache[col] > 0
						? this.tiles[row][col].getProjectiles().size() - projectileCache[col]
						: 0;

				generatedSunPoints += tileResult.getGeneratedSunPoints();
				zombiesEliminated += tileResult.getZombiesEliminated();

				if (this.tiles[row][col].getPlant() == null && this.tiles[row][col].getZombies().size() > 0) {
					for (Zombies zombie : this.tiles[row][col].getZombies()) {
						int distance = zombie.getMovespeed();
						int trajectory = col;
						while (distance > 0 && trajectory > 0 && this.tiles[row][trajectory].getPlant() == null) { // need
																													// to
																													// implement
																													// zombie
																													// running
																													// into
																													// projectile
																													// IF
																													// his
																													// movespeed
																													// >
																													// 1
							distance--;
							trajectory--;
						}
						if (trajectory == 0 && distance > 0)
							return new TurnResult(-1, tileResult.getZombiesEliminated()); // lost game
						this.tiles[row][trajectory].addZombie(zombie); // also need to implement for zombies with
																		// movespeed higher than 1
					}
					this.tiles[row][col].removeZombies();
				} else if (col < this.width && projectileCache[col] > 0) {
					ListIterator iter = this.tiles[row][col].getProjectiles().listIterator(0);
					int movingProjectiles = projectileCache[col];
					while (movingProjectiles > 0 && iter.hasNext()) {
						movingProjectiles--;
						Projectile projectile = (Projectile) iter.next();
						int distance = projectile.getSpeed();
						int trajectory = col;
						while (distance > 0 && trajectory < width
								&& this.tiles[row][trajectory].getZombies().size() == 0) { // if it encounters a tile
																							// with zombies, add to tile
																							// projectile list as its
																							// still same turn, one
																							// problem with this is that
																							// if the projectile has
																							// some distance left to
																							// cover and zombie dies
																							// before the projectile
																							// hits it, the projectile
																							// will still stop on this
																							// tile
							distance--;
							trajectory++;
						}
						if (trajectory < width) {
							this.tiles[row][trajectory].addProjectile(projectile);
						}
					}
					this.tiles[row][col].removeNProjectiles(numProjectilesToMoveTiles);
				}
			}
		}

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

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}
}

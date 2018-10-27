import java.util.Arrays;

public class Board {
	private Tile[][] tiles;
  private int height, width;

  public Board(int height, int width) {
  	this.tiles = new Tile[height][width];
    this.height = height;
    this.width = width;

		for(int row=0; row<height; row++) {
			for(int col=0; col<width; col++) {
				this.tiles[row][col] = new Tile();
			}
		}
  }

	public boolean placePlant(Plant plant, int row, int col) {
    if (this.tiles[row][col].getPlant() != null) return false;
		this.tiles[row][col].setPlant(plant);
    return true;
	}

  public void placeZombie(Zombies zombie, int row, int col) {
		this.tiles[row][col].addZombie(zombie);
	}

  public int turn() {
    int sunPointsGenerated = 0;

    for (int row=0; row<height; row++) {
      for (int col=0; col<width; col++) {
        int sunPoints = this.tiles[row][col].turn();

        if (sunPoints == -1) return -1; // lost game

        sunPointsGenerated += sunPoints;

        if (this.tiles[row][col].getPlant() == null && this.tiles[row][col].getZombies().size() > 0) {
          for (Zombies zombie : this.tiles[row][col].getZombies()) {
            int distance = zombie.getMovespeed();
            int trajectory = col;
            while (distance > 0 && trajectory > 0 && this.tiles[row][trajectory].getPlant() == null) {
              distance--;
              trajectory--;
            }
            if (trajectory == 0 && distance > 0) return -1; // lost game
            this.tiles[row][trajectory].addZombie(zombie);
          }
          this.tiles[row][col].removeZombies();
        } else if (col < this.width-1 && this.tiles[row][col].getProjectiles().size() > 0) {
          for (Projectile projectile : this.tiles[row][col].getProjectiles()) {
            int distance = projectile.getSpeed();
            int trajectory = col;
            while (distance > 0 && trajectory < width && this.tiles[row][trajectory].getZombies().size() == 0) { // if it encounters a tile with zombies, add to tile projectile list as its still same turn
              distance--;
              trajectory++;
            }
            if (trajectory < width) {
              this.tiles[row][trajectory].addProjectile(projectile);
            }
          }
          this.tiles[row][col].removeProjectiles();
        }
      }
    }

    return sunPointsGenerated;
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

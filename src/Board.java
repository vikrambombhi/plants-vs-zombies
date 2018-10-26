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
    if (this.tiles[row][col].getPlant() != nil) return false;
		this.tiles[row][col].setPlant(plant);
    return true;
	}

  public void placeZombie(Zombie zombie, int row, int col) {
		this.tiles[row][col].addZombie(zombie);
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

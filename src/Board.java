import java.util.Arrays;

public class Board {
	private Tile[][] tiles;

  public Board(int height, int width) {
  	this.tiles = new Tile[height][width];

		for(int row=0; row<height; row++) {
			for(int col=0; col<width; col++) {
				this.tiles[row][col] = new Tile();
			}
		}
  }

	public void placePiece(Piece piece, int col, int row) {
		this.tiles[col][row].setPiece(piece);
	}

  public void print() {
    for (Tile[] row : this.tiles) {
      for (Tile tile : row) {
        System.out.print(tile.toString() + " ");
      }
      System.out.println();
    }
  }
}

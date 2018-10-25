import java.util.ArrayList;

public class Game {
  static ArrayList<Zombie> zombies = new ArrayList<Zombie>();
  static Board board = new Board(4, 4);

  public static void main(String args[]) {
    Zombie zombie = new Zombie();
    board.print();
		board.placePiece(zombie, 1, 1);
    board.print();
  }
}

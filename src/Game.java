import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Game {
  static Board board = new Board(4, 4);

  private static void printOptions() {
    System.out.println("1: Place sunflower");
    System.out.println("2: Place peashooter");
    System.out.println("3: Skip Turn");
    System.out.println("4: Quit");
    System.out.print("Enter option number of what you would like to do: ");
  }

  private static PieceLocation parseCoordinates(String input){
    //split coordinates by comma and remove any spaces
    String[] locationSplit = input.split(",");
    int row = Integer.parseInt(locationSplit[0].trim());
    int col = Integer.parseInt(locationSplit[1].trim());
    if(row > 3 || col > 3){
      throw new IllegalArgumentException("Out of range");
    }
    return new PieceLocation(row, col);
  }

  public static void main(String args[]) {
    Scanner userInput = new Scanner(System.in);
    Date lastTick = new Date();
    Random random = new Random();
    PieceLocation newLocation;

    while(true) {
      board.print();

      printOptions();
      String input = userInput.nextLine();

      switch(input) {
        case "1":
          System.out.print("Enter where to place sunflower ex(row,col): ");
          newLocation = parseCoordinates(userInput.nextLine());
          Sunflower sunflower = new Sunflower();
          board.placePiece(sunflower, newLocation.getRow(), newLocation.getCol());
          break;
        case "2":
          System.out.print("Enter where to place peashooter ex(row,col): ");
          newLocation = parseCoordinates(userInput.nextLine());
          Peashooter peashooter = new Peashooter();
          board.placePiece(peashooter, newLocation.getRow(), newLocation.getCol());
          break;
        case "4":
          return;
        default:
          // If it has been longer than 1 seconds
          if ((Math.abs(new Date().getTime() - lastTick.getTime())/1000) > 1) {
            // Spawnzombie
            Zombie zombie = new Zombie();
            board.placePiece(zombie, random.nextInt(4), 3);
          }
      }
    }
  }
}

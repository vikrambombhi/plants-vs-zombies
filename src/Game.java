import java.util.Scanner;

public class Game {
  static Board board = new Board(4, 4);

  private static void printOptions() {
    System.out.println("1: Place sunflower");
    System.out.println("2: Place peashooter");
    System.out.println("3: Quit");
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
    Zombie zombie = new Zombie();

    Scanner userInput = new Scanner(System.in);
    while(true) {
      board.print();

      printOptions();
      String input = userInput.nextLine();

      if (input.equalsIgnoreCase("1")){
        System.out.print("Enter where to place sunflower ex(row,col): ");
        PieceLocation currentLocation = parseCoordinates(userInput.nextLine());
        Sunflower sunflower = new Sunflower();
        board.placePiece(sunflower, currentLocation.getRow(), currentLocation.getCol());
      }

      if (input.equalsIgnoreCase("2")){
        System.out.print("Enter where to place peashooter ex(row,col): ");
        PieceLocation currentLocation = parseCoordinates(userInput.nextLine());
        Peashooter peashooter = new Peashooter();
        board.placePiece(peashooter, currentLocation.getRow(), currentLocation.getCol());
      }

      if (input.equalsIgnoreCase("3")){
        break;
      }
    }
  }
}

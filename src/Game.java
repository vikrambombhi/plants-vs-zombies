import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Game {

  private static final int SUN_PER_TURN = 5;
  private static Board board = new Board(4, 4);

  private static Random random;
  
  // Start with enough sunpoints to spawn a sunflower, or wait one turn to get a peashooter 
  private static int sunPoints = 10;
  private static int numZombiesToGenerate, numZombiesToEliminate;

  public Game(int numZombies) {
    Game.numZombiesToGenerate = numZombies;
    Game.numZombiesToEliminate = numZombies;
    Game.random = new Random(System.currentTimeMillis());
  }

  private static void printOptions() {
    System.out.println("You have " + sunPoints + " sun points.");
    System.out.println("1: Place sunflower (Cost: " + new Sunflower().getSunPointCost() + ")");
    System.out.println("2: Place peashooter (Cost: " + new Peashooter().getSunPointCost() + ")");
    System.out.println("3: Skip Turn");
    System.out.println("4: Quit");
    System.out.print("Enter option number of what you would like to do: ");
  }

  private static void placePlant(Plant plant, Scanner userInput) {
    System.out.print("Enter where to place " + plant.toString() + " ex(row,col): ");
    PlantLocation loc = parseCoordinates(userInput.nextLine());
    while (board.placePlant(plant, loc.getRow(), loc.getCol()) == false) {
      System.out.print("A plant is already located there! Try a different spot: ");
      loc = parseCoordinates(userInput.nextLine());
    }
  }

  private static PlantLocation parseCoordinates(String input){
    //split coordinates by comma and remove any spaces
    String[] locationSplit = input.split(",");
    int row = Integer.parseInt(locationSplit[0].trim());
    int col = Integer.parseInt(locationSplit[1].trim());
    if(row >= board.getHeight() || col >= board.getWidth()) {
      throw new IllegalArgumentException("Out of range");
    }
    return new PlantLocation(row, col);
  }

  /*
   * Will generate a zombie on average of 1 in every chancePerTurn
   * If chancePerTurn is 3, will generate a zombie on average of once per three turns
   */
  private static void generateZombie(int chancePerTurn) {
    int n = random.nextInt(chancePerTurn);
    if (n == 0) {
      board.placeZombie(new Zombie(), random.nextInt(board.getHeight()), board.getWidth()-1);
      numZombiesToGenerate--;
    }
  }

  private static void play() {
    Game game = new Game(10);
    Scanner userInput = new Scanner(System.in);
    Date lastTick = new Date();
    PlantLocation newLocation;

    while(numZombiesToEliminate > 0) { // Number of Zombies to eliminate
      board.print();

      // need to implement something so that if sunPoints - plant.getSunPointCost() < 0, makes the move invalid
      boolean valid = false;

      while (!valid) {
        printOptions();
        String input = userInput.nextLine();
        switch(input) {
          case "1":
            Sunflower sunflower = new Sunflower();
            if (sunPoints - sunflower.getSunPointCost() >= 0) {
              placePlant(sunflower, userInput);
              sunPoints -= sunflower.getSunPointCost();
              valid = true;
            } else {
              System.out.println("Sorry, you don't have enough sun points to purchase this plant, try a different option.");
            }          
            break;
          case "2":
            Peashooter peashooter = new Peashooter();
            if (sunPoints - peashooter.getSunPointCost() >= 0) {
              placePlant(peashooter, userInput);
              sunPoints -= peashooter.getSunPointCost();
              valid = true;
            } else {
              System.out.println("Sorry, you don't have enough sun points to purchase this plant, try a different option.");
            }
            break;
          case "4":
            return;
          default:
            valid = true;
        }
      }

      
      TurnResult turnResult = board.turn();
      if (turnResult.getGeneratedSunPoints() == -1) {
        System.out.println("Zombies have reached your house! Sorry you lost, better luck next time.");
        return;
      }

      numZombiesToEliminate -= turnResult.getZombiesEliminated();
      sunPoints += turnResult.getGeneratedSunPoints() + SUN_PER_TURN;

      if (numZombiesToGenerate > 0) generateZombie(3);
    }
    System.out.println("Congratulations, you won!");
  }

  public static void main(String args[]) {
    play();
  }
}

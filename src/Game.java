import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Game {

  private static final int SUN_PER_TURN = 5;
  private static Board board = new Board(4, 4);

  private Random random;
  
  private static int sunPoints = 0;
  private static int numSunFlowers = 0;
  private int numZombiesToGenerate, numZombiesToEliminate;

  public Game(int numZombies) {
    this.numZombiesToGenerate = numZombies;
    this.numZombiesToEliminate = numZombies;
    this.random = new Random(System.currentTimeMillis());
  }

  private void playerOptions() {
    printOptions();
    String input = userInput.nextLine();

    // need to implement something so that if sunPoints - plant.getSunPointCost() < 0, makes the move invalid
    switch(input) {
      case "1":
        Sunflower sunflower = new Sunflower();
        placePlant(sunflower, userInput);
        sunPoints -= sunflower.getSunPointCost();
        numSunFlowers++;
        break;
      case "2":
        Peashooter peashooter = new Peashooter();
        placePlant(peashooter, userInput);
        sunPoints -= peashooter.getSunPointCost();
        break;
      case "4":
        return;
      default:
        generateZombie(3);
    }
  }

  private static void printOptions() {
    System.out.println("You have " + sunPoints + " sun points.");
    System.out.println("1: Place sunflower");
    System.out.println("2: Place peashooter");
    System.out.println("3: Skip Turn");
    System.out.println("4: Quit");
    System.out.print("Enter option number of what you would like to do: ");
  }

  private static void placePlant(Plant plant, Scanner userInput) {
    System.out.print("Enter where to place " + plant.toString() + " ex(row,col): ");
    PlantLocation loc = parseCoordinates(userInput.nextLine());
    while (board.placePlant(plant, loc.getRow(), loc.getCol() == false) {
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
  private void generateZombie(int chancePerTurn) {
    int n = random.nextInt(chancePerTurn);
    if (n == 0) {
      board.placeZombie(zombie, random.nextInt(board.getHeight()), board.getWidth()-1);
    }
  }

  private void play() {
    Game game = new Game(10);
    Scanner userInput = new Scanner(System.in);
    Date lastTick = new Date();
    PlantLocation newLocation;

    while(this.numZombiesToEliminate > 0) { // Number of Zombies to eliminate
      board.print();

      sunPoints += SUN_PER_TURN;
      sunPoints += 2 * numSunFlowers;

      playerOptions();
    }
    System.out.println("Congratulations, you won!");
  }

  public static void main(String args[]) {
    play();
  }
}

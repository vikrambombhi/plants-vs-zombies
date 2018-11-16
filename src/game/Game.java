package game;

import java.util.Date; 
import java.util.Random;
import java.util.Scanner;

import model.*;
import controller.SettingsController;

public class Game {

    private static final int SUN_PER_TURN = 5;
    private static Board board = new Board(5, 10);
    private static int turnPhase = 1;

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
        System.out.println("You have " + sunPoints + " Sun points. \n" + "Number of Zombies to kill: " + numZombiesToEliminate);
        System.out.println("Turn Phase: " + turnPhase + "\n");
        System.out.println("1: Place sunflower (Cost: " + new Sunflower().getSunPointCost() + ")");
        System.out.println("2: Place peashooter (Cost: " + new Peashooter().getSunPointCost() + ")");
        System.out.println("3: End Turn");
        System.out.println("4: Quit");
        System.out.print("Enter option number of what you would like to do: ");
    }

    /* Checks if input is valid and fulfills the required parameter to place plant onto a tile 
     * Checks for out of bound, Strings, null, formats */
    private static PlantLocation inputValidation(Plants plant, Scanner userInput) {
        PlantLocation loc;
        do {
            try {
                System.out.print("Enter where to place " + plant.toString() + " ex(row,col): ");
                loc = parseCoordinates(userInput.nextLine());
                break;
            }catch(ArrayIndexOutOfBoundsException e1) {
                System.out.print("Invalid input, please try again. \n");
            }catch(NumberFormatException e2) {
                System.out.print("Invalid input, please try again. \n");
            }
        } while (true);
        return loc;
    }

    private static void placePlant(Plants plant, Scanner userInput) {
        PlantLocation loc;
        loc = inputValidation(plant, userInput);

        while (board.placePlant(plant, loc.getRow(), loc.getCol()) == false) {
            if(loc.getRow() > board.getHeight() || loc.getCol() > board.getWidth()) {
                System.out.print("This is a non existent location! Try a different spot: \n");
                loc = inputValidation(plant, userInput);
            }else {
                System.out.print("A plant is already located there! Try a different spot: \n");
                loc = inputValidation(plant, userInput);
            }
        }
    }

    private static PlantLocation parseCoordinates(String input) {
        // split coordinates by comma and remove any spaces
        String[] locationSplit = input.split(",");
        int row = Integer.parseInt(locationSplit[0].trim());
        int col = Integer.parseInt(locationSplit[1].trim());
        try{
            return new PlantLocation(row, col);
        } catch(IllegalArgumentException e1) {
            System.out.println("Out of Range");
        }
        return new PlantLocation(row, col);
    }

    /*
     * Will generate a zombie on average of 1 in every chancePerTurn If
     * chancePerTurn is 3, will generate a zombie on average of once per three turns
     */
    private static void generateZombie(int chancePerTurn) {
        int n = random.nextInt(chancePerTurn);
        if (n == 0) {
            board.placeZombie(new Zombie(), random.nextInt(board.getHeight()), board.getWidth() - 1);
            numZombiesToGenerate--;
        }
    }

    private static void play() {
        printInstructions();
        Game game = new Game(10);
        Scanner userInput = new Scanner(System.in);
        Date lastTick = new Date();
        PlantLocation newLocation;

        while (numZombiesToEliminate > 0) { // Number of Zombies to eliminate
            board.print();

            // need to implement something so that if sunPoints - plant.getSunPointCost() < 0, makes the move invalid
            boolean valid = false;

            while (!valid) {
                printOptions();
                String input = userInput.nextLine();
                switch (input) {
                    case "1":
                        Sunflower sunflower = new Sunflower();
                        if (sunPoints - sunflower.getSunPointCost() >= 0) {
                            placePlant(sunflower, userInput);
                            sunPoints -= sunflower.getSunPointCost();
                            System.out.println("\nYou have spawned a Sunflower!");
                            board.print();
                        } else {
                            System.out.println(
                                    "\nSorry, you don't have enough sun points to purchase this plant, try a different option.");
                        }
                        break;
                    case "2":
                        Peashooter peashooter = new Peashooter();
                        if (sunPoints - peashooter.getSunPointCost() >= 0) {
                            placePlant(peashooter, userInput);
                            sunPoints -= peashooter.getSunPointCost();
                            System.out.println("\nYou have spawned a Pea Shooter!");
                            board.print();
                        } else {
                            System.out.println(
                                    "\nSorry, you don't have enough sun points to purchase this plant, try a different option.");
                        }
                        break;
                    case "3":
                        System.out.println("\nNext Turn!");
                        turnPhase++;
                        valid = true;
                        break;
                    case "4":
                        System.out.println("Thank you for playing. Goodbye!");
                        return;
                    default:
                        System.out.println("\nInvalid input, please try again.");
                        valid = false;
                }
            }

            TurnResult turnResult = board.turn();
            if (turnResult.getGeneratedSunPoints() == -1) {
                System.out.println("Zombies have reached your house! Sorry you lost, better luck next time.");
                return;
            }

            numZombiesToEliminate -= turnResult.getZombiesEliminated();
            sunPoints += turnResult.getGeneratedSunPoints() + SUN_PER_TURN;

            if (numZombiesToGenerate > 0)
                generateZombie(3);
        }
        System.out.println("Congratulations, you won!");
        System.out.println("You finished the game in " + turnPhase + " turn phases");
    }

    private static void printInstructions() {
        System.out.println("The objective of this game is to stop zombies from reaching the left side of the board, the zombies are denoted with 'Z'");
        System.out.println("You can buy plants with sunpoints that you earn every round");
        System.out.println("The sunflower will increase the number of sunpoints you earn per round, the sunflower is denoted with 'S'");
        System.out.println("The peashooter will shoot damage dealing peas every two turns at the incoming zombies, the peashooter is denoted with 'P'");
        System.out.println("If the zombie reaches a plant it will start damaging it, this is denoted with 'B'");
        System.out.println("The flower projectiles are denoted with '.'");
    }

    public static void main(String args[]) {
    	SettingsController controller = new SettingsController();
    	play();
    }
}

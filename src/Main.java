import java.util.Scanner;
import static java.lang.Math.random;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String playAgain = "No";
        boolean validValue = false;
        int numPlayers = 0;
        int numSides = 0;
        int highestP = 0;
        int highestPScore = 0;
        int lowestP = 0;
        int lowestPScore = 0;

        /*
        int randomSide;
        int randomSide2;
        */

        do {//gets number of players and permanently sets that for all rounds
            System.out.println("How many people are playing (>1)?");
            if (scan.hasNextInt()) {
                numPlayers = scan.nextInt();
                if (numPlayers > 1) {//making sure it's more than one player
                    validValue = true;
                } else {
                    System.out.println("You entered an invalid value. Please try again.\n"); //making new line after all errors for readability
                }
            } else {
                System.out.println("You entered an invalid value. Please try again.\n");
            }
            scan.nextLine();
        } while (!validValue);
        validValue = false; //resetting value to be reused

        do { //this part repeats with playAgain depending on input
            do { //gets the number of sides just for this round
                System.out.println("Enter the number of sides on your die (>1):");
                if (scan.hasNextInt()) {
                    numSides = scan.nextInt();
                    if (numSides > 1) {
                        validValue = true;
                    } else {
                        System.out.println("You entered an invalid value. Please try again.\n");
                    }
                } else {
                    System.out.println("You entered an invalid value. Please try again.\n");
                }
                scan.nextLine();
            } while (!validValue);
            validValue = false; //resetting value to be reused

            int[] players = new int[numPlayers];
            for (int i = 0; i < numPlayers; i++) {
                players[i] = (int) (Math.random() * numSides) + 1;
            }

            do { //asks the player if they want to roll another round
                System.out.println("Do you want to play again?");
                if (scan.hasNextDouble()) { //cant check all input to see if it is yes or no but this eliminates numbers
                    System.out.println("You have entered an invalid value. Please try again.\n");
                    scan.nextLine();
                } else {
                    playAgain = scan.nextLine();
                    validValue = true;
                }
            } while (!validValue);
            validValue = false;
            numSides = 0; //resetting so it doesn't break code if played again
            /*
            System.out.println("Enter the number of sides on your die (>1):");
            if (scan.hasNextInt()) {
                numSides = scan.nextInt();
                if (numSides <= 0) {
                    System.out.println("You have entered an invalid number of sides.");
                    System.exit(0);
                }
                if (numSides != 1) {
                    randomSide = (int) (Math.random() * numSides) + 1;
                    System.out.println("Player 1 rolled " + randomSide);
                    randomSide2 = (int) (Math.random() * numSides) + 1;
                    System.out.println("Player 2 rolled " + randomSide2);

                    if (randomSide2 == randomSide) {
                        System.out.println("It's a tie!");
                    } else if (randomSide > randomSide2) {
                        System.out.println("Player 1 wins. Player 2 owes Player 1 " + (randomSide - randomSide2) + " gold.");
                    } else {
                        System.out.println("Player 2 wins. Player 1 owes Player 2 " + (randomSide2 - randomSide) + " gold.");
                    }
                }
            } else {
                System.out.println("You have entered an invalid data type.");
                scan.nextLine();
            */
        }while(playAgain.equalsIgnoreCase("Yes") || playAgain.equalsIgnoreCase("Y") || playAgain.equalsIgnoreCase("Yea"));
        System.out.println("Thanks for playing!");
    }
}
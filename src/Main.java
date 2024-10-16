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
        int difference = 0;

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
        int[] playerTotals = new int[numPlayers]; //declaring list that hold overall money won/lost, this has to be declared here so it isn't reset every round

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

            int[] players = new int[numPlayers]; //declaring list that holds the score for players every round
            for (int i = 0; i < numPlayers; i++) { //assigning and outputting player rolls
                players[i] = (int) (Math.random() * numSides) + 1;
                System.out.println("Player " + (i + 1) + " rolled " + players[i]);
            }

            highestP = 0;
            highestPScore = players[0];
            for (int i = 0; i < numPlayers; i++) { //determines the player with the highest score and stores the player and what the score is
                if (players[i] > highestPScore) {
                    highestP = i;
                    highestPScore = players[i];
                }
            }

            lowestP = 0;
            lowestPScore = players[0];
            for (int i = 0; i < numPlayers; i++) { //determines the player with the lowest score and stores the player and what the score is
                if (players[i] < lowestPScore){
                    lowestP = i;
                    lowestPScore = players[i];
                }
            }

            difference = highestPScore - lowestPScore;
            playerTotals[highestP] += difference;
            playerTotals[lowestP] -= difference;
            System.out.println("Player " + (lowestP + 1) + " owes Player " + (highestP + 1) + " " + difference + " gold.");

            //prints overall money gained/lost for every player
            System.out.println("Money gained/lost per player:");
            for (int i = 0; i < numPlayers; i++) {
                System.out.println("Player " + (i + 1) + ": " + playerTotals[i]);
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

        }while(playAgain.equalsIgnoreCase("Yes") || playAgain.equalsIgnoreCase("Y") || playAgain.equalsIgnoreCase("Yea"));
        System.out.println("Thanks for playing!");
    }
}
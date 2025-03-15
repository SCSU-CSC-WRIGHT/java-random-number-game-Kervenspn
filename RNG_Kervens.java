import java.util.Random;
import java.util.Scanner;

public class RNG_Kervens {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner user = new Scanner(System.in);

        // Ask the user to pick a difficulty level
        System.out.println("Welcome to the 'Guess-the-number' game! Choose a difficulty level: ");
        System.out.println("Easy (E: 1-50), Medium (M: 1-100), Hard (H: 1-500)");

        char difficultySelect = user.next().charAt(0);

        int range = 0;
        int maximumTries = 0;
        int randomNumber = 0;

        // Loops if user enters incorrect character.
        while (true) {
            // Checks if letter matches difficulty
            if (difficultySelect == 'E' || difficultySelect == 'e') {  // Easy
                range = 50;
                maximumTries = 5;
                randomNumber = random.nextInt(range) + 1;  // creates number between 1 and 50
                break;
            } else if (difficultySelect == 'M' || difficultySelect == 'm') {  // Medium
                range = 100;
                maximumTries = 10;
                randomNumber = random.nextInt(range) + 1;  // creates number between 1 and 100
                break;
            } else if (difficultySelect == 'H' || difficultySelect == 'h') {  // Hard
                range = 500;
                maximumTries = 20;
                randomNumber = random.nextInt(range) + 1;  // creates number between 1 and 500
                break;
            } else {
                // ask again if the user doesn't properly select difficulty
                System.out.println("???");
                System.out.println("try again! (E, M, H): ");
                difficultySelect = user.next().charAt(0);
            }
        }

        System.out.println("Guess the number between 1 and " + range + ":");

        // loop
        int attempts = 0;
        boolean guessedCorrectly = false;

        while (attempts < maximumTries && !guessedCorrectly) {
            attempts++;  // Increase attempts
            System.out.print("Attempt " + attempts + " of " + maximumTries + ". Enter a number: ");

            // restarts if the user enters anything other than a number
            while (!user.hasNextInt()) {
                user.next();
                System.out.print("Attempt " + attempts + " of " + maximumTries + ". Enter a number: ");
            }

            int userGuess = user.nextInt();  // Get user's guess

            // checks guess
            if (userGuess < randomNumber) {
                System.out.println("Too low!");
            } else if (userGuess > randomNumber) {
                System.out.println("Too high!");
            } else {
                guessedCorrectly = true;  // Correct guess
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts!");
            }
        }

        // If the user failed
        if (!guessedCorrectly) {
            System.out.println("Sorry, you've run out of attempts! The number was " + randomNumber + ".");
        }

    }
}

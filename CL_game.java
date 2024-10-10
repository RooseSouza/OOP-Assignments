
import java.util.Random;
import java.util.Scanner;

public class CL_game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxTries = 10;
        int currentTry = 0;
        int secretNumber = random.nextInt(100) + 1;
        boolean guessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have " + maxTries + " attempts to guess the number between 1 and 100.");

        while (currentTry < maxTries && !guessedCorrectly) {
            System.out.print("Enter your guess (1-100): ");
            int guess = scanner.nextInt();
            currentTry++;

            if (guess == secretNumber) {
                System.out.println("Congratulations! You've guessed the correct number!");
                guessedCorrectly = true;
            } else if (guess < secretNumber) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }

            if (!guessedCorrectly) {
                System.out.println("Attempts remaining: " + (maxTries - currentTry));
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Game over! You've used all your attempts. The number was: " + secretNumber);
        }
    }
}

import java.util.Random;
import java.util.Scanner;

public class Numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;

        System.out.println(" Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // 
            int attemptsLeft = 5;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess a number between 1 and 100. You have " + attemptsLeft + " attempts.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attemptsLeft--;

                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You've guessed the number.");
                    guessedCorrectly = true;
                    score += 10;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println(" Too low!");
                } else {
                    System.out.println("Too high!");
                }

                if (attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've run out of attempts. The number was: " + numberToGuess);
            }

            System.out.println("Your current score: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Game Over! Final Score: " + score);
        scanner.close();
    }
}
import java.util.Random;
import java.util.Scanner;

public class Numbergame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int score = 0; // total rounds won
        boolean playAgain = true;

        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between 1 and 100.\n");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // random number 1–100
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("A number has been chosen between 1 and 100.");

            while (attempts < maxAttempts) {
                System.out.print("\nAttempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess ➤ ");
                
                // validate integer input
                if (!sc.hasNextInt()) {
                    System.out.println("⚠️ Please enter a valid number.");
                    sc.next(); // clear invalid input
                    continue;
                }

                int guess = sc.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("🔻 Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("🔺 Too high! Try again.");
                } else {
                    System.out.println("🎉 Correct! The number was " + numberToGuess + ".");
                    System.out.println("You guessed it in " + attempts + " attempts!");
                    guessedCorrectly = true;
                    score++;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all " + maxAttempts + " attempts. The number was " + numberToGuess + ".");
            }

            System.out.println("🏆 Your current score: " + score);

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = sc.next().toLowerCase();

            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
                System.out.println("\n🎮 Game Over! Final Score: " + score);
                System.out.println("Thanks for playing! 👋");
            }
        }

        sc.close();
    }
}

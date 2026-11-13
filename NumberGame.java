import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalRoundsWon = 0;
        int totalScore = 0;

        int maxAttempts = 7;
        String playAgain;

        System.out.println("==================================");
        System.out.println("       WELCOME TO NUMBER GAME     ");
        System.out.println("==================================");

        do {

            // Generate random number between 1 and 100
            int number = random.nextInt(100) + 1;

            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            // Repeat until correct guess or attempts finish
            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");

                int guess;

                if (!sc.hasNextLine()) {
                    System.out.println("\nInput ended. Exiting the game.");
                    sc.close();
                    return;
                }

                // Validate input
                try {
                    guess = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Enter a valid number.");
                    continue;
                }

                // Validate number range
                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                attempts++;

                // Compare guess with random number
                if (guess == number) {

                    System.out.println("\nCongratulations!");
                    System.out.println("You guessed the correct number.");

                    System.out.println("Attempts used: " + attempts);

                    guessedCorrectly = true;

                    totalRoundsWon++;

                    // Higher score for fewer attempts
                    int roundScore = (maxAttempts - attempts + 1) * 10;
                    totalScore += roundScore;

                    System.out.println("You earned " + roundScore + " points!");

                    break;

                } else if (guess < number) {

                    System.out.println("Too Low! Try a higher number.");

                } else {

                    System.out.println("Too High! Try a lower number.");

                }

                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }

            // Display result if user fails
            if (!guessedCorrectly) {

                System.out.println("\nSorry! You couldn't guess the number.");
                System.out.println("The correct number was: " + number);

            }

            // Ask user to play another round
            System.out.print("\nDo you want to play again? (yes/no): ");

            if (!sc.hasNextLine()) {
                System.out.println("\nInput ended. Exiting the game.");
                break;
            }

            playAgain = sc.nextLine().trim();

            while (!playAgain.equalsIgnoreCase("yes")
                    && !playAgain.equalsIgnoreCase("no")) {

                System.out.print("Please enter yes or no: ");

                if (!sc.hasNextLine()) {
                    System.out.println("\nInput ended. Exiting the game.");
                    sc.close();
                    return;
                }

                playAgain = sc.nextLine().trim();
            }

        } while (playAgain.equalsIgnoreCase("yes"));

        // Final scoreboard
        System.out.println("\n==================================");
        System.out.println("           GAME SUMMARY           ");
        System.out.println("==================================");

        System.out.println("Total rounds won: " + totalRoundsWon);
        System.out.println("Total score: " + totalScore);

        System.out.println("\nThank you for playing!");
        System.out.println("==================================");

        sc.close();
    }
}

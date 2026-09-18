import java.util.Scanner;

public class MovieRatingSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Step 1: User Input Handling
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Step 2: Accept and Validate Movie Ratings
        String[] movies = new String[5];
        int[] ratings = new int[5];

        System.out.println("\nEnter the names of five movies you recently watched:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Movie " + (i + 1) + ": ");
            movies[i] = scanner.nextLine();

            int rating;
            while (true) {
                System.out.print("Rate " + movies[i] + " (1–10): ");
                if (scanner.hasNextInt()) {
                    rating = scanner.nextInt();
                    if (rating >= 1 && rating <= 10) {
                        break;
                    } else {
                        System.out.println("Invalid input. Rating must be between 1 and 10.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // clear invalid token
                }
            }
            ratings[i] = rating;
            scanner.nextLine(); // clear buffer
        }

        // Step 3: Calculate the Average Rating
        int sum = 0;
        for (int r : ratings) {
            sum += r;
        }
        double average = sum / 5.0;

        System.out.printf("\nAverage Rating: %.2f\n", average);

        // Step 4: Rating Classification (if-else)
        if (average >= 9) {
            System.out.println("You are a cinephile!");
        } else if (average >= 7) {
            System.out.println("You enjoy movies quite a bit.");
        } else if (average >= 5) {
            System.out.println("You have mixed feelings about movies.");
        } else {
            System.out.println("You are a tough critic!");
        }

        // Step 5: Nested if Statements
        boolean foundMasterpiece = false;
        boolean foundBadMovie = false;

        for (int r : ratings) {
            if (r == 10) {
                foundMasterpiece = true;
            } else if (r < 4) {
                foundBadMovie = true;
            }
        }

        if (foundMasterpiece) {
            System.out.println("Wow! You found a masterpiece.");
        } else {
            if (foundBadMovie) {
                System.out.println("That movie didn’t impress you much.");
            }
        }

        // Step 6: Logical Operators
        boolean allHigh = true;
        boolean anyVeryLow = false;

        for (int r : ratings) {
            if (r < 7) {
                allHigh = false;
            }
            if (r < 3) {
                anyVeryLow = true;
            }
        }

        if (allHigh) {
            System.out.println("You seem to enjoy most movies.");
        } else if (anyVeryLow) {
            System.out.println("You have strong opinions on movies!");
        }

        // Step 7: Switch Statement for Genre Preferences
        System.out.print("\nEnter your favorite genre (Action, Comedy, Horror, Drama, Sci-Fi): ");
        String genre = scanner.nextLine().toLowerCase();

        switch (genre) {
            case "action":
                System.out.println("You love excitement and thrills!");
                break;
            case "comedy":
                System.out.println("You enjoy a good laugh.");
                break;
            case "horror":
                System.out.println("You have a taste for fear!");
                break;
            case "drama":
                System.out.println("You appreciate deep storytelling.");
                break;
            case "sci-fi":
                System.out.println("You love futuristic and imaginative worlds!");
                break;
            default:
                System.out.println("Interesting choice!");
        }

        // Step 8: Conditional Operator Recommendation
        String recommendation = genre.equals("sci-fi")
                ? "Recommended Movie: Interstellar"
                : "Recommended Movie: The Dark Knight";

        System.out.println(recommendation);

        System.out.println("\nThanks for using the Movie Rating System, " + name + "!");
        scanner.close();
    }
}

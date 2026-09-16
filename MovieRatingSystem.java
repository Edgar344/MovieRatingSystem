import java.util.Scanner;

public class MovieRatingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] ratings = new double[5];
        double total = 0;

        System.out.println("=== Movie Rating System ===");

        // Input and validation loop for 5 ratings
        for (int i = 0; i < ratings.length; i++) {
            double rating;
            while (true) {
                System.out.print("Enter rating #" + (i + 1) + " (1 to 10): ");
                if (scanner.hasNextDouble()) {
                    rating = scanner.nextDouble();
                    if (rating >= 1 && rating <= 10) {
                        break;
                    } else {
                        System.out.println("Invalid input. Rating must be between 1 and 10.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Clear invalid token
                }
            }
            ratings[i] = rating;
            total += rating;
        }

        // Average calculation
        double average = total / ratings.length;
        System.out.printf("\nAverage Rating: %.2f\n", average);

        // Conditional classification using if-else and nested if
        if (average >= 8.0) {
            System.out.println("Taste Classification: Enthusiast");
            if (average >= 9.5) {
                System.out.println("Status: Master Critic!");
            }
        } else if (average >= 5.0 && average < 8.0) {
            System.out.println("Taste Classification: Moderate Viewer");
        } else {
            System.out.println("Taste Classification: Harsh Critic");
        }

        // Logic check using logical/conditional operators
        boolean consistentHigh = (ratings[0] >= 7.0 && ratings[4] >= 7.0);
        if (consistentHigh) {
            System.out.println("Rating Consistency: Consistently positive feedback across reviews.");
        }

        // Switch statement for genre recommendation
        System.out.println("\nSelect your favorite genre:");
        System.out.println("1. Action");
        System.out.println("2. Drama");
        System.out.println("3. Comedy");
        System.out.print("Enter choice (1-3): ");

        int choice = scanner.hasNextInt() ? scanner.nextInt() : 0;
        switch (choice) {
            case 1:
                System.out.println("Recommendation: Check out top-tier Action blockbusters!");
                break;
            case 2:
                System.out.println("Recommendation: Explore award-winning Drama films!");
                break;
            case 3:
                System.out.println("Recommendation: Enjoy classic Comedy hits!");
                break;
            default:
                System.out.println("Recommendation: Explore general popular movies!");
                break;
        }

        scanner.close();
    }
}

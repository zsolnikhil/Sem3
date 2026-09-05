import java.util.Scanner;

public class MovieReviewWordLengthProfiler {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("===== Movie Review Word Length Profiler =====");
            System.out.print("Enter movie review: ");
            String review = scanner.nextLine();
            classifyWordLengths(review);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void classifyWordLengths(String review) {
        if (review == null) {
            throw new IllegalArgumentException("Review cannot be null.");
        }

        String trimmedReview = review.trim();
        if (trimmedReview.isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = trimmedReview.split("\\s+");
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (int i = 0; i < words.length; i++) {
            String cleanedWord = stripPunctuation(words[i]);
            int length = cleanedWord.length();
            if (length == 0) {
                continue;
            } else if (length <= 4) {
                shortCount++;
            } else if (length <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static String stripPunctuation(String word) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (Character.isLetterOrDigit(current)) {
                builder.append(current);
            }
        }
        return builder.toString();
    }
}

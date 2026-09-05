import java.util.Scanner;

public class TypingSpeedTestAccuracyChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("===== Typing Speed Test Accuracy Checker =====");
            System.out.print("Enter original passage: ");
            String original = scanner.nextLine();
            System.out.print("Enter typed text: ");
            String typed = scanner.nextLine();
            checkTypingAccuracy(original, typed);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            throw new IllegalArgumentException("Original and typed text cannot be null.");
        }
        if (original.length() != typed.length()) {
            throw new IllegalArgumentException("Both strings must be of equal length.");
        }

        int totalCharacters = original.length();
        int matchedCharacters = 0;
        int firstMismatchPosition = -1;
        char originalMismatch = ' ';
        char typedMismatch = ' ';

        for (int i = 0; i < totalCharacters; i++) {
            char originalChar = original.charAt(i);
            char typedChar = typed.charAt(i);
            if (originalChar == typedChar) {
                matchedCharacters++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i + 1;
                originalMismatch = originalChar;
                typedMismatch = typedChar;
            }
        }

        double accuracy = totalCharacters == 0 ? 0.0 : (matchedCharacters * 100.0) / totalCharacters;

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%",
                matchedCharacters, totalCharacters, accuracy);

        if (firstMismatchPosition == -1) {
            System.out.println(" | No Mismatches");
        } else {
            System.out.println(" | First Mismatch at position " + firstMismatchPosition
                    + " ('" + originalMismatch + "' vs '" + typedMismatch + "')");
        }
    }
}

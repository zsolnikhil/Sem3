import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("===== Traffic Signal Streak Analyzer =====");
            System.out.print("Enter signal log (R/Y/G only, e.g. RRGGGYRR): ");
            String signalLog = scanner.nextLine().trim().toUpperCase();
            findLongestStreak(signalLog);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            throw new IllegalArgumentException("Signal log cannot be null or empty.");
        }

        char longestColor = signalLog.charAt(0);
        int longestLength = 1;
        char currentColor = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char current = signalLog.charAt(i);
            if (current == currentColor) {
                currentLength++;
            } else {
                currentColor = current;
                currentLength = 1;
            }
            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated " + longestLength + " times");
    }
}

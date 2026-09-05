import java.util.Scanner;

public class ExamHallSeatDuplicationChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("===== Exam Hall Seat Duplication Checker =====");
            System.out.print("Enter seat numbers separated by spaces: ");
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                throw new IllegalArgumentException("Seat list cannot be empty.");
            }

            String[] parts = line.split("\\s+");
            int[] seatNumbers = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                seatNumbers[i] = Integer.parseInt(parts[i]);
            }

            checkDuplicateSeats(seatNumbers);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid seat number. Please enter integers only.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            throw new IllegalArgumentException("Seat number array cannot be null or empty.");
        }

        boolean[] alreadyReported = new boolean[seatNumbers.length];
        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            if (alreadyReported[i]) {
                continue;
            }
            boolean isDuplicate = false;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    isDuplicate = true;
                    alreadyReported[j] = true;
                }
            }
            if (isDuplicate) {
                System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                duplicateFound = true;
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }
}

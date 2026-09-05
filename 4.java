import java.util.Scanner;

public class LibraryIsbnNormalizer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter scanned code: ");
        String raw = scanner.nextLine();
        String normalized = normalizeCode(raw);
        System.out.println(validateAndFormat(normalized));
        scanner.close();
    }

    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        String publisher = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return publisher + rest;
    }

    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: non-letter publisher code";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(publisher).append("] YEAR: ")
                .append(year).append(" | CATALOG: ").append(catalog);
        return formatted.toString();
    }
}

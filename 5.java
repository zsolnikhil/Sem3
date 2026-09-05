import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StopWordFilteredWordFrequency {

    private static final String[] STOP_WORDS = {
            "the", "was", "and", "a", "is", "of", "in"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter feedback paragraph: ");
        String feedback = scanner.nextLine();
        printFilteredWordFrequency(feedback);
        scanner.close();
    }

    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            System.out.println("No words to report.");
            return;
        }

        String cleaned = feedback.toLowerCase();
        cleaned = cleaned.replace(".", "");
        cleaned = cleaned.replace(",", "");
        cleaned = cleaned.replace("!", "");
        cleaned = cleaned.replace("?", "");
        cleaned = cleaned.replace(";", "");
        cleaned = cleaned.replace(":", "");
        cleaned = cleaned.replace("\"", "");
        cleaned = cleaned.replace("'", "");

        String[] words = cleaned.split("\\s+");
        HashMap<String, Integer> frequencyMap = new HashMap<String, Integer>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i].trim();
            if (word.isEmpty() || isStopWord(word)) {
                continue;
            }
            Integer count = frequencyMap.get(word);
            if (count == null) {
                frequencyMap.put(word, 1);
            } else {
                frequencyMap.put(word, count + 1);
            }
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<Map.Entry<String, Integer>>(frequencyMap.entrySet());

        for (int i = 0; i < entries.size() - 1; i++) {
            for (int j = i + 1; j < entries.size(); j++) {
                if (entries.get(j).getValue() > entries.get(i).getValue()) {
                    Map.Entry<String, Integer> temp = entries.get(i);
                    entries.set(i, entries.get(j));
                    entries.set(j, temp);
                }
            }
        }

        for (int i = 0; i < entries.size(); i++) {
            System.out.println(entries.get(i).getKey() + ": " + entries.get(i).getValue());
        }
    }

    public static boolean isStopWord(String word) {
        for (int i = 0; i < STOP_WORDS.length; i++) {
            if (STOP_WORDS[i].equals(word)) {
                return true;
            }
        }
        return false;
    }
}

package lecture12.exercises.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> wordCount = new HashMap<>();

        while (true) {
            String word = scanner.nextLine();

            if ("stop".equalsIgnoreCase(word)) {
                break;
            }

            Integer occurrence = wordCount.get(word);

            if (occurrence == null) {
                wordCount.put(word, 1);
            } else {
                wordCount.put(word, occurrence + 1);
            }
        }

        String maxWord = null;
        int max = 0;

        for (Map.Entry<String, Integer> currentEntry : wordCount.entrySet()) {

            String currentWord = currentEntry.getKey();
            int occurrence = currentEntry.getValue();

            if (max < occurrence) {
                maxWord = currentWord;
                max = occurrence;
            }
        }

        System.out.println("Most frequent word is '" + maxWord + "' with " + max + " ocurrances.");
    }
}

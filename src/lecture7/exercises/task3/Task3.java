package lecture7.exercises.task3;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] words = input.split("\\s"); // раздели текста на space-ове

        String longestWord = findLongest(words);

        System.out.printf("length: %d word: %s", longestWord.length(), longestWord);
    }

    private static String findLongest(String[] words) {
        String longestWord = null;
        int maxLength = 0;

        for (String word : words) {
            if (word.length() > maxLength) {
                longestWord = word;
            }
        }

        return longestWord;
    }
}

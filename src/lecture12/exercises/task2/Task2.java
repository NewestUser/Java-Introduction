package lecture12.exercises.task2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> uniqueWords = new HashSet<>();

        boolean shouldPromptUser = true;
        while (shouldPromptUser) {

            System.out.print("Въведете текст: ");
            String sentence = scanner.nextLine();

            String[] words = sentence.split(" ");

            for (String currentWord : words) {

                if ("stop".equals(currentWord)) {
                    shouldPromptUser = false;
                    break;
                }

                if (uniqueWords.contains(currentWord)) {
                    System.out.printf("Думата '%s' вече е въведена.%n", currentWord);
                } else {
                    uniqueWords.add(currentWord);
                }
            }
        }

        System.out.printf("%nРезултат: ");
        for (String eachUniqueWord : uniqueWords) {
            System.out.print(eachUniqueWord + " ");
        }
    }
}

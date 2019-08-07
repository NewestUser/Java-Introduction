package lecture7.exercises.task4;

import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] words = input.split("\\s");

        int maxWeight = 0;
        String heaviestWord = null;

        for (String word : words) {
            int weight = computeWeight(word);

            if (weight > maxWeight) {
                maxWeight = weight;
                heaviestWord = word;
            }
        }

        System.out.printf("weight: %d word: %s", maxWeight, heaviestWord);
    }

    static int computeWeight(String word) {
        int weight = 0;

        for (int i = 0; i < word.length(); i++) {
            char symbol = word.charAt(i);
            weight += computeWeight(symbol);
        }

        return weight;
    }

    static int computeWeight(char letter) {
        // 'A' is 10 and 'Z' is 35 that's why I subtract 9 so that I can fit between 1 and 26
        return Character.getNumericValue(letter) - 9;
    }
}

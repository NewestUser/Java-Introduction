package lecture7.exercises.task5;

import java.util.Scanner;

public class Task5 {

    /**
     * Напишете програма, която проверява дали даден списък от числа е подреден.
     * Един списък е подреден, когато следващото число <b>НЕ</b> е по-малко от предишното.
     * <p>
     * - Пример за подреден спиък: `-8,3,4,5,5,10`
     * <p>
     * - Пример за неподреден списък: `-8,-10,3,4`
     * <p>
     * Програмата, първо трябва да изисква число `n`, представляващо броя редове, които ще се въведат.
     * След това програмата, изисква редовете с числа. Един ред представлява числа разделени със запетая.
     * <p>
     * Програмата, като краен резултат трябва да изпише `n` на брой пъти `true` или `false`, съответно
     * за сортиран или несортиран списък.
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Въведете брой редове: ");
        int n = userInput.nextInt();

        boolean[] sortedLists = new boolean[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Въведете списък с числа:");
            String input = userInput.next();
            String[] firstList = input.split(",");


            if (firstList.length == 0 || firstList.length == 1) {
                sortedLists[i] = true;
                continue;
            }

            for (int j = 1; j < firstList.length; j++) {
                int previous = Integer.parseInt(firstList[j - 1]);
                int current = Integer.parseInt(firstList[j]);

                if (previous <= current) {
                    sortedLists[i] = true;
                } else {
                    sortedLists[i] = false;
                    break;
                }
            }
        }

        for (boolean isSorted : sortedLists) {
            System.out.println(isSorted);
        }
    }

}

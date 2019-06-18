package lecture12.exercises.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {

    private static final double STOP_NUMBER = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> myNumbers = new ArrayList<>();

        double min = STOP_NUMBER;

        while (true) {
            System.out.print("Въведете число: ");
            double currentNum = scanner.nextDouble();

            if (currentNum == STOP_NUMBER) {
                break;
            }

            if (min == STOP_NUMBER) {
                min = currentNum;
            } else if (min > currentNum) {
                min = currentNum;
            }

            myNumbers.add(currentNum);
        }

        System.out.printf("%nРезултат: ");
        for (int i = myNumbers.size() - 1; i >= 0; i--) {
            double element = myNumbers.get(i);

            System.out.print(element + " ");
        }

        System.out.printf("%nНай-малкото число е: " + min);
    }
}

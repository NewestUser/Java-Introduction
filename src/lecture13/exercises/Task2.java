package lecture13.exercises;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double sum = 0;
        int count = 0;

        while (count < 5) {

            try {
                String text = scanner.nextLine();

                System.out.print("Въведете число: ");
                double number = Double.parseDouble(text);

                sum += number;
                count++;

            } catch (NumberFormatException e) {
                System.out.println("Въведеното от вас число е невалидно");
            }
        }

        System.out.println("Сумата от 5-те числа е: " + sum);
    }
}

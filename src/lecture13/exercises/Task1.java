package lecture13.exercises;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            String text = scanner.nextLine();

            System.out.print("Въведете число: ");
            double number = Double.parseDouble(text);

            System.out.println("Вие въведохте " + number);
        } catch (NumberFormatException e) {
            System.out.println("Въведеното от вас число е невалидно");
        }
    }
}

package lecture1;

import java.util.Scanner;

public class Lecture1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter °F: ");
        double fahrenheit = scanner.nextDouble();

        double celsius = (fahrenheit - 32) * 5d / 9d;

        System.out.println(fahrenheit + "°F = " + celsius + "°C");
    }

    /**
     * Въведете 2 различни целочислени числа от конзолата. Запишете тяхната сума, разлика, произведение,
     * остатък от деление и целочислено деление в отделни променливи и разпечатайте тези резултати в конзолата.
     * Опитайте същото с числа с плаваща запетая.
     */
    private static void arithmeticOperations() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first whole number: ");
        int firstWholeNumber = scanner.nextInt();
        System.out.print("Enter second whole number: ");
        int secondWholeNumber = scanner.nextInt();

        int wholeSum = firstWholeNumber + secondWholeNumber;
        int wholeDifference = firstWholeNumber - secondWholeNumber;
        int wholeMultiplication = firstWholeNumber * secondWholeNumber;
        int wholeQuotient = firstWholeNumber / secondWholeNumber;
        int wholeReminder = firstWholeNumber % secondWholeNumber;

        System.out.println("wholeSum = " + wholeSum);
        System.out.println("wholeDifference = " + wholeDifference);
        System.out.println("wholeMultiplication = " + wholeMultiplication);
        System.out.println("wholeQuotient = " + wholeQuotient);
        System.out.println("wholeReminder = " + wholeReminder);

        System.out.print("Enter first rational number: ");
        double firstRationalNumber = scanner.nextDouble();
        System.out.print("Enter second rational number: ");
        double secondRationalNumber = scanner.nextDouble();

        double rationalSum = firstRationalNumber + secondRationalNumber;
        double rationalDifference = firstRationalNumber - secondRationalNumber;
        double rationalMultiplication = firstRationalNumber * secondRationalNumber;
        double rationalQuotient = firstRationalNumber / secondRationalNumber;
        double rationalReminder = firstRationalNumber % secondRationalNumber;

        System.out.println("rationalSum = " + rationalSum);
        System.out.println("rationalDifference = " + rationalDifference);
        System.out.println("rationalMultiplication = " + rationalMultiplication);
        System.out.println("rationalQuotient = " + rationalQuotient);
        System.out.println("rationalReminder = " + rationalReminder);
    }

}

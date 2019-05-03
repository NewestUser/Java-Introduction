package lecture3;

import java.util.Scanner;

public class Lecture3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        int[] array = {5, 6, 45, 99, 13, 5, 6};

        if (n > array.length || n <= 0) {
            System.out.println("n is not within the range of the array");
            return;
        }

        boolean areElementsEqual = true;
        int endIndex = n - 1;

        int[] equalElements = new int[n];
        int[] differentElements = new int[2];

        for (int i = 0, j = array.length - n; i < n; i++, j++) {

            if (array[i] == array[j]) {
                equalElements[i] = array[i];

            } else {
                endIndex = i - 1;

                differentElements[0] = array[i];
                differentElements[1] = array[j];

                areElementsEqual = false;
                break;
            }
        }

        System.out.print(areElementsEqual + " ");
        for (int i = 0; i <= endIndex; i++) {
            System.out.print(equalElements[i] + ", ");
        }

        if (!areElementsEqual) {
            System.out.print(differentElements[0] + ", ");
            System.out.print(differentElements[1]);
        }
    }

    /**
     * Sum all the numbers between 1 and 100 but omit all the numbers between 51 and 74.
     */
    private static void sumFrom1To100WithExclusions() {
        int sum = 0;

        for (int i = 1; i <= 100; i++) {
            if (i > 51 && i < 74) {
                continue;
            }

            sum += i;
        }

        System.out.println("sum = " + sum);
    }


    /**
     * Task 3:
     * • Calculate factorial of a number, where the numer is entered by the user
     * • Hint: n! = 1 * 2 * 3 ... (n - 2) * (n - 1) * n;
     */
    private static void factorialOfN() {
        int n = 5;

        int factorial = 1;
        for (int i = 1; i <= n; i++) {

            factorial *= i;
        }

        System.out.println(n + "! = " + factorial);
    }

    /**
     * Task 4:
     * • Calculate the sum of the first n numers of the Fibonacci sequence:
     * • Hint: F = 0 + 1 + 1 + 2 + 3 + 5 + 8 + ...
     */
    private static void fibonacciSum() {
        int n = 13;

        int sum = 0;

        int previous = 0;
        int current = 1;

        for (int i = 0; i < n; i++) {

            System.out.print(previous + ", ");

            sum += previous;
            int tmp = previous;
            previous = current;

            current = tmp + current;
        }

        System.out.println("\nsum fibonacci(" + n + ") = " + sum);
    }

    /**
     * Task 5:
     * • Calculate the following for user specified n:
     * (1!) / (1^1) + (2!) / (2^2) + ... + (n!) / (n^n)
     */
    private static void factorialOfNDividedByPowerOfN() {
        int n = 10;

        double sum = 0;

        for (int i = 1; i <= n; i++) {

            double factorial = 1;
            for (int j = 1; j <= i; j++) {
                factorial *= j;
            }

            double power = i;
            for (int j = 2; j <= i; j++) {
                power *= i;
            }

            sum += factorial / power;
        }

        System.out.println(sum);
    }

    /**
     * *
     * * *
     * * * *
     */
    private static void printTriangle() {
        int rows = 4;

        for (int i = 0; i < rows; i++) {

            for (int j = rows; j >= i; j--) {
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }

            System.out.print("\n");
        }
    }


    /**
     * Additional Task:
     * <p>
     * You are given an array of numbers and a number N. If the group of N numbers at the start and end of
     * the array are the same return true + the equal characters, separated by comma. If they are not the
     * same, return false + the first pair of characters that is different. You may assume that n is in the
     * range 1..nums.length inclusive.
     * <p>
     * Example:
     * With numbers {5, 6, 45, 99, 13, 5, 6} and N = 3 you should output the following:
     * <p>
     * Result:
     * false 5,13
     * <p>
     * Explanation:
     * We are comparing the first 3 and the last 3 numbers, but 5 and 13 are different.
     */
    private static void printFrondAndBackArrayElements() {
        int n = 2;

        int[] array = {5, 6, 45, 99, 13, 5, 6};

        if (n > array.length || n <= 0) {
            System.out.println("n is not within the range of the array");
            return;
        }


        boolean areElementsEqual = true;
        int endIndex = n - 1;

        int[] equalElements = new int[n];
        int[] differentElements = new int[2];

        for (int i = 0, j = array.length - n; i < n; i++, j++) {

            if (array[i] == array[j]) {
                equalElements[i] = array[i];

            } else {
                endIndex = i - 1;

                differentElements[0] = array[i];
                differentElements[1] = array[j];

                areElementsEqual = false;
                break;
            }
        }

        System.out.print(areElementsEqual + " ");
        for (int i = 0; i <= endIndex; i++) {
            System.out.print(equalElements[i] + ", ");
        }

        if (!areElementsEqual) {
            System.out.print(differentElements[0] + ", ");
            System.out.print(differentElements[1]);
        }
    }
}




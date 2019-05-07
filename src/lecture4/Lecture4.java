package lecture4;

import java.util.Scanner;

public class Lecture4 {

    public static void main(String[] args) {
        dynamicArray();
    }

    private static void dynamicArray() {
        Scanner scanner = new Scanner(System.in);

        int stopNumber = -1;
        int[] array = new int[1];

        System.out.println("To stop entering numbers type: " + stopNumber);

        int i = 0;
        while (true) {
            System.out.print("Enter number: ");
            int input = scanner.nextInt();

            if (input == stopNumber) {
                break;
            }

            array[i] = input;
            i++;

            if (array.length == i) {
                // create new array with bigger size
                int[] tmpArray = new int[array.length + 1];

                // copy old values in new array
                for (int j = 0; j < array.length; j++) {
                    tmpArray[j] = array[j];
                }

                // change array to new array
                array = tmpArray;
            }
        }

        // array.length - 1 because there is one extra item at the end of the array
        System.out.print("You entered: ");
        for (int j = 0; j < array.length - 1; j++) {
            System.out.print(array[j] + " ");
        }
    }

}

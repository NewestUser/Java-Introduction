package lecture2;

import java.util.Scanner;

public class Homework2 {

    public static void main(String[] args) {

    }

    /**
     * Да се прочетат 2 числа от клавиатурата А и В.
     * Да се изведат всички числа от А до В на степен 2 (разделени със запетая).
     * Ако някое число е кратно на 3, да се изведе съобщение, че числото се пропуска - „skip 3“.
     * Ако сумата от всички изведени числа (без пропуснатите) стане по-голяма от 200, да се прекрати извеждането.
     */
    private static void task14SumMod3PowOf2() {
        Scanner number = new Scanner(System.in);

        System.out.print("Enter number A: ");
        int a = number.nextInt();

        System.out.print("Enter number B: ");
        int b = number.nextInt();

        int sum = 0;
        for (int i = a; i <= b; i++) {
            int powOf2 = i * i;

            if (powOf2 % 3 == 0) {
                System.out.print("Skip " + i + ", ");
            } else {
                System.out.print(powOf2 + ", ");
                sum += powOf2;
            }

            if (sum > 200) {
                break;
            }
        }
    }


    /**
     * По зададено число n, да се изведат на екрана числа по следния начин
     * (всяко въвеждане на n е ново пускане на програмата):
     * <p>
     * Пример:
     * <p>
     * Въведете n: 2
     * 11
     * 33
     * <p>
     * Въведете n: 1
     * 0
     * <p>
     * Въведете n: 4
     * 3333
     * 5555
     * 7777
     * 9999
     * <p>
     * Въведете n: 3
     * 222
     * 444
     * 666
     */
    private static void task13PrintSequences() {
        Scanner number = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = number.nextInt();

        int showNumber = n - 1;

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                System.out.print(showNumber);
            }
            System.out.println();
            showNumber += 2;
        }
    }

    /**
     * Въведете число от клавиатурата и определете дали е просто. Просто число е това което се дели САМО на 1 и на себе си.
     */
    private static void task12isPrimeNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        boolean isPrime = true;

        if (number < 2) {
            isPrime = false;
        } else if (number == 2) {
            isPrime = true;
        } else if (number % 2 == 0) {
            isPrime = false;
        } else {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(number + " is a prime number");
        } else {
            System.out.println(number + " is NOT a prime number");
        }
    }

    /**
     * Започвайки от 3, да се изведат на екрана първите n числа които се делят на 3. Числата да са разделени със запетая.
     */
    private static void task11NumMod3() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number greater than 3: ");
        int number = scanner.nextInt();

        if (number <= 3) {
            System.out.println("The number must be grater than 3");
            return;
        }

        for (int i = 3; i <= number; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * Да се прочете число от екрана(конзолата) и да се изведе сбора на всички числа от 1 до въведеното число.
     */
    private static void task10Sum1ToN() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        if(number == 1){
            System.out.println("sum 1...1 = 0");
            return;
        }

        int start;
        int end;
        if (number < 1) {
            start = number;
            end = 1;
        } else {
            start = 1;
            end = number;
        }

        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }

        System.out.println("sum " + start + "..." + end + " = " + sum);
    }

    /**
     * Да се въведат от потребителя 2 числа. И да се изведат на екрана всички числа от по-малкото до по-голямото.
     */
    private static void task9PrintInDescOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int first = scanner.nextInt();
        System.out.print("Enter second number: ");
        int second = scanner.nextInt();

        if (first == second) {
            System.out.println("The numbers are equal");
            return;
        }

        int min;
        int max;

        if (first < second) {
            min = first;
            max = second;
        } else {
            min = second;
            max = first;
        }

        for (int i = min; i <= max; i++) {
            System.out.println(i + " ");
        }
    }

    /**
     * Да се изведат на екрана числата от 10 до 1 в обратен ред.
     */
    private static void task8Print10To1() {
        for (int i = 10; i >= 1; i--) {
            System.out.print(i + " ");
        }
    }

    /**
     * Да се изведат на екрана всички нечетни числа от -10 до 10
     */
    private static void task7PrintAllMod2Num() {
        for (int i = -10; i <= 10; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * Да се изведат на екрана числата от -20 до 50.
     */
    private static void task6Print1To100() {
        for (int i = -20; i <= 50; i++) {
            System.out.print(i + " ");
        }
    }

    /**
     * Да се изведат на екрана числата от 1 до 100.
     */
    private static void task5Print1To100() {
        for (int i = 0; i < 100; i++) {
            System.out.print(i + 1 + " ");
        }
    }

    /**
     * Въведете 2 променливи от клавиатурата – сума пари (число с плаваща запетая), дали съм здрав – булев тип. Съставете програма, която взема решения на базата на тези данни по следния начин:
     * - ако съм болен няма да излизам
     * - ако имам пари ще си купя лекарства
     * - ако нямам – ще стоя вкъщи и ще пия чай
     * - ако съм здрав
     * - ако имам по-малко от 10 лв ще отида на кафе и т.н
     * Полученото решение покажете като съобщение в конзолата.
     */
    private static void task4AreYouHealthy() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        System.out.println("Are you healthy? (y/n): ");
        char isHealthyChar = scanner.next().charAt(0);

        boolean isHealthy = isHealthyChar == 'y';

        if (isHealthy) {
            System.out.println("I am healthy");

            if (amount < 10) {
                System.out.println("I will drink coffee");
            } else {
                System.out.println("I won't go to the cinema");
            }
        } else {
            System.out.println("I am sick");

            if (amount > 0) {
                System.out.println("I will go buy medicine");
            } else {
                System.out.println("I will stay at home and drink tea");
            }
        }
    }


    /**
     * Въведете 3 различни числа от конзолата и ги разпечатайте в низходящ ред.
     */
    private static void task3Print3NumInDescOrder2() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Въведете първото число: ");
        int a = scan.nextInt();
        System.out.print("Въведете второто число: ");
        int b = scan.nextInt();
        System.out.print("Въведете третото число: ");
        int c = scan.nextInt();

        if (a >= b && b >= c) {
            System.out.println(a + ", " + b + ", " + c);
        } else if (a >= c && c >= b) {
            System.out.println(a + ", " + c + ", " + b);
        } else if (b >= a && a >= c) {
            System.out.println(b + ", " + a + ", " + c);
        } else if (b >= c && c >= a) {
            System.out.println(b + ", " + c + ", " + a);
        } else if (c >= a && a >= b) {
            System.out.println(c + ", " + a + ", " + b);
        } else if (c >= b && b >= a) {
            System.out.println(c + ", " + b + ", " + a);
        }
    }

    /**
     * Въведете 3 различни числа от конзолата и ги разпечатайте в низходящ ред.
     */
    private static void task3Print3NumInDescOrder() {
        Scanner number = new Scanner(System.in);

        System.out.print("Enter three different numbers!\nEnter first number: ");
        int a = number.nextInt();

        System.out.print("Enter second number: ");
        int b = number.nextInt();

        System.out.print("Enter third number: ");
        int c = number.nextInt();

        int min = a;
        int mid = b;
        int max = c;

        if (a < b && a < c) {
            min = a;

            if (b < c) {
                mid = b;
                max = c;
            } else {
                mid = c;
                max = b;
            }
        }

        if (b < a && b < c) {
            min = b;

            if (a < c) {
                mid = a;
                max = c;
            } else {
                mid = c;
                max = a;
            }
        }

        if (c < a && c < b) {
            min = c;

            if (a < b) {
                mid = a;
                max = b;
            } else {
                mid = b;
                max = a;
            }
        }

        System.out.println(max + " " + mid + " " + min);
    }

    private static void task3PrintInAscOrder() {
        Scanner scan = new Scanner(System.in);

        System.out.print("A1 = ");
        int a = scan.nextInt();
        System.out.print("A2 = ");
        int b = scan.nextInt();
        System.out.print("A3 = ");
        int c = scan.nextInt();

        System.out.println();

        if (a < b && a < c) {
            if (b < c) {
                System.out.println(a + " " + b + " " + c);
            } else {
                System.out.println(a + " " + c + " " + b);
            }
        }

        if (b < a && b < c) {
            if (a < c) {
                System.out.println(b + " " + a + " " + c);
            } else {
                System.out.println(b + " " + c + " " + a);
            }
        }

        if (c < a && c < b) {
            if (a < b) {
                System.out.println(c + " " + a + " " + b);
            } else {
                System.out.println(c + " " + b + " " + a);
            }
        }

        System.out.println();

        if (a < b && b < c) {
            System.out.print(a + " " + b + " " + c);
        } else if (b < a && a < c) {
            System.out.println(b + " " + a + " " + c);
        } else if (c < a && a < b) {
            System.out.println(c + " " + a + " " + b);
        } else if (a < c && c < b) {
            System.out.println(a + " " + c + " " + b);
        } else if (b < c && c < a) {
            System.out.println(b + " " + c + " " + a);
        } else if (c < b && b < a) {
            System.out.println(c + " " + b + " " + a);
        }
    }

    /**
     * Въведете 2 различни числа от конзолата и ги разпечатайте в нарастващ ред.
     */
    private static void task2print2NumbersInAscOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int first = scanner.nextInt();
        System.out.print("Enter second number: ");
        int second = scanner.nextInt();

        int min;
        int max;

        if (first < second) {
            min = first;
            max = second;
        } else {
            min = second;
            max = first;
        }

        System.out.println(min);
        System.out.println(max);
    }


    /**
     * Да се изведат съобщения към потребителя и да се прочетат 2 числа от клавиатурата A и B
     * (може да са с плаваща запетая – double). После да се прочете 3-то число C и да се провери
     * дали то е м/у A и B.Да се изведе подходящо съобщение за това дали C е между A и B.
     * Пример:
     */
    private static void task1cBetweenAAndB() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("A = ");
        int a = scanner.nextInt();
        System.out.print("B = ");
        int b = scanner.nextInt();
        System.out.print("C = ");
        int c = scanner.nextInt();

        if (c > a && c < b) {
            System.out.println("Number C=" + c + " is between Number A=" + a + " and Number B=" + b);
        } else {
            System.out.println("Number C=" + c + " is NOT between Number A=" + a + " and Number B=" + b);
        }
    }

}

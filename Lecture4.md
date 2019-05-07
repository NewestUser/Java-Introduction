# Lecture 4
#java course#

### Arrays Exercises

- Task 1

    ```text
    Създайте масив с 10 елемента.
    Запишете стойности на първите 3 елемента.
    Принтирайте втория елемент.
    Умножете третия елемент със 2 и го принтирайте.
    ```
    
    - solution
    ```java
    int[] array = new int[10];
    
    array[0] = 3;
    array[1] = 5;
    array[2] = 7;

    System.out.println("array[1] = " + array[1]);

    array[2] = 2 * array[2];

    System.out.println("array[2] = " + array[2]);
    ```
    
- Task 2

    ```text
    Създайте масив с дробни числа и принтирайте сойностите на масива.
    ```
    
    - solution
    ```java
    double[] array = new double[]{2.5, 3, 5, 8, -12.9, 7.0};

    for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
    }
    ```
    
- Task 3

    ```text
    Запишете 10 числа от клавиатурата в масив. И после ги принтирайте.
    ```
    
    - solution
    ```java
    Scanner scanner = new Scanner(System.in);

    int[] array = new int[10];

    System.out.println("Enter 10 numbers:");
    for (int i = 0; i < array.length; i++) {
        System.out.print("array[" + i + "] = ");
        array[i] = scanner.nextInt();
    }

    System.out.println("You entered:");
    for (int i = 0; i < array.length; i++) {
        System.out.println("array[" + i + "] = " + array[i]);
    }
    ```
    
- Task 4

    ```text
    Създайте масив с големина зададена от потребителя.
    Въведете стойностите на масива от конзолата.
    Намерете най-голямото въведено число.
    Принтирайте най-голямото число.
    ```
    
    - solution
    ```java
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter array size: ");

    int size = scanner.nextInt();

    int[] array = new int[size];

    System.out.println("Enter " + size + " numbers:");
    for (int i = 0; i < array.length; i++) {
        System.out.print("array[" + i + "] = ");
        array[i] = scanner.nextInt();
    }

    int max = array[0];

    for (int i = 0; i < array.length; i++) {
        if (max < array[i]) {
            max = array[i];
        }
    }

    System.out.println("max = " + max);
    ```
    
- Task 5

    ```text
    Инвертирайте даден масив използвайки 2 подхода:
    - Използвайки втори масив
    - Без да използвате втори масив
    ```
    
    - solution 1
    ```java
    int[] array = new int[]{1, 2, 3, 4, 5};
    int[] inverted = new int[array.length];

    for (int i = 0, j = array.length - 1; i < array.length; i++, j--) {
        inverted[i] = array[j];
    }

    for (int i = 0; i < inverted.length; i++) {
        System.out.print(inverted[i] + " ");
    }
    ```
    
    - solution 2
    ```java
    int[] array = new int[]{1, 2, 3, 4, 5};

    for (int i = 0, j = array.length - 1; i != j; i++, j--) {
        int tmp = array[i];

        array[i] = array[j];
        array[j] = tmp;
    }

    for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
    }
    ```
    
- Task 6

    ```text
    Напишете програма която чете масив стойностите на масив от кнозолата.
    После създайте втори масив с един елемент повече от началния.
    Всички елементи на втория масив трябва да са равни на предходния елемент от първия масив
    умножен по съответната позиция, с изключение на 1-вия елемент.
  
    Пример:
    [1 2 3 4 5]
    [1 1 4 9 16 25]  
  
    Пример:
    [9 2 4 -3 7 5]
    [9 9 4 12 -12 35 30]  
    ```
    
    - solution
    ```java
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter array size: ");

    int size = scanner.nextInt();

    int[] array = new int[size];

    System.out.println("Enter " + size + " numbers:");
    for (int i = 0; i < array.length; i++) {
        System.out.print("array[" + i + "] = ");
        array[i] = scanner.nextInt();
    }

    int[] derivedArray = new int[array.length + 1];

    derivedArray[0] = array[0];

    for (int i = 0; i < array.length; i++) {
        derivedArray[i + 1] = array[i] * (i + 1);
    }

    for (int i = 0; i < derivedArray.length; i++) {
        System.out.print(derivedArray[i] + " ");
    }
    ```

- Task 7

    ```text
    Напишете програма която запаметява в масив въведените от конзолата числа.
    Броя на числата, които трябва да се запаметят е неопределен.
    Въвеждането прекратява при въвеждането на числото -1.
    Принтирайте всички въведени от потребителя числа без -1.

    Пример:
    Enter number: 10
    Enter number: 32
    Enter number: -41
    Enter number: -1
    You entered: 10 32 -41
    ```
    
    - solution
    ```java
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
    for (int j = 0; j < array.length - 1; j++) {
        System.out.print(array[j] + " ");
    }
    ```


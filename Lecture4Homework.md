# Homework Lecture 4
#java course#

## Arrays 

### Task 1

```text
Да се прочете масив от екрана и да се намери най-малкото число кратно на 3 от масива 
(за улеснение, нека първият елемент на масива, въведен от потребителя да е винаги число кратно на 3).

Може да се опитате и без първото да е кратно на 3.
```

- solution 1
```java
Scanner scanner = new Scanner(System.in);

System.out.print("Enter size of the array: ");
int size = scanner.nextInt();

int[] myArray = new int[size];

System.out.println("First number should be multiple of 3!");
for (int i = 0; i < myArray.length; i++) {
    System.out.print("array[" + i + "] = ");
    myArray[i] = scanner.nextInt();
}

int min = myArray[0];

for (int i = 1; i < myArray.length; i++) {

    int currentElement = myArray[i];

    if (currentElement % 3 == 0 && currentElement < min) {
        min = currentElement;
    }
}

System.out.println("The smallest element multiple of 3 is: " + min);
```  

- solution 2
```java
Scanner scanner = new Scanner(System.in);

System.out.print("Enter size of the array: ");
int size = scanner.nextInt();

int[] myArray = new int[size];

for (int i = 0; i < myArray.length; i++) {
    System.out.print("array[" + i + "] = ");
    myArray[i] = scanner.nextInt();
}

int min = 0;
boolean minIsInitialized = false;

for (int i = 0; i < myArray.length; i++) {

    int currentElement = myArray[i];

    if (currentElement % 3 != 0) {
        continue;
    }

    if (!minIsInitialized) {
        min = currentElement;
        minIsInitialized = true;
    } else if (min > currentElement) {
        min = currentElement;
    }
}

if (minIsInitialized) {
    System.out.println("The smallest element multiple of 3 is: " + min);
} else {
    System.out.println("None of the numbers are multiple of 3!");
}
```

### Task 2

```text
Да се подкани потребителя да въведе размер на масива кратен на 2.
След това да се подкани потребителя с подходящи съобщения да въведе половината от елементите.
На останалите елементи на масива да се зададат стойности като на предишните 2.
Накрая да се изведе масива на екрана.

Пример:
Въведете размер за масива: 8
Въведете 1-я елемент:
10
Въведете 2-я елемент:
12
Въведете 3-я елемент:
 1
Въведете 4-я елемент:
-4

Резултат:
10 12 1 -4 10 12 1 -4
```

- solution
```java
Scanner scanner = new Scanner(System.in);

System.out.print("Enter size of the array multiple of 2: ");
int size = scanner.nextInt();

int[] array = new int[size];

int half = array.length / 2;

System.out.println("Enter " + half + " items\n");
for (int i = 0; i < half; i++) {
    System.out.print("array[" + i + "] = ");
    int value = scanner.nextInt();

    array[i] = value;
    array[half + i] = value;
}

System.out.println("Here is the array: ");

for (int i = 0; i < array.length; i++) {
    System.out.print(array[i] + ", ");
}
```  

### Task 3

```text
Да се въведе число от конзолата, след което да се създаде масив с 10 елемента по следния начин:
Първите 2 елемента на масива са въведеното число.
Всеки следващ елемент на масива е равен на сбора от предишните 2 елемента в масива.
(Задачата за Фибоначи но с числа запазени в масива и започващи от число, избрано от потребителя)
След това изведете масива на козолата.

Пример 1:
Въведете число: 1
1 1 2 3 5 8 13 21 34 55

Пример 2:
Въведете число: 3
3 3 6 9 15 24 39 63 102 167
```

- solution 1
```java
Scanner scanner = new Scanner(System.in);

System.out.print("Enter number: ");

int startNum = scanner.nextInt();

int current = startNum;
int next = startNum;

int[] fibonacciArray = new int[10];

for (int i = 0; i < fibonacciArray.length; i++) {
    fibonacciArray[i] = current;

    int tmp = current + next;

    current = next;
    next = tmp;
}

for (int i = 0; i < fibonacciArray.length; i++) {
    System.out.print(fibonacciArray[i] + ", ");
}
```  

- solution 2
```java
Scanner number = new Scanner(System.in);

int[] myArray = new int[10];

System.out.println("Enter the first element of the array");
myArray[0] = number.nextInt();
myArray[1] = myArray[0];

for (int i = 2; i < myArray.length; i++) {
    myArray[i] = myArray[i - 1] + myArray[i - 2];
}

System.out.println("Array:");

for (int i = 0; i < myArray.length; i++) {
    System.out.print(myArray[i] + " ");
}
```

### Task 4

```text
Да се прочете масив от екрана и да се провери дали е огледален. 

Следните масиви са огледални:
[3 7 7 3]
[4]
[1 55 1]
[6 27 -1 5 7 7 5 -1 27 6]

Пример:
Въведете размер за масива: 5
Въведете 1-я елемент: 10
Въведете 2-я елемент: 66
Въведете 3-я елемент: 1
Въведете 4-я елемент: 66
Въведете 5-я елемент: 10

Масивът е огледален
```

- solution 
```java
Scanner number = new Scanner(System.in);

System.out.print("Enter size of the array: ");
int size = number.nextInt();

int[] array = new int[size];

for (int i = 0; i < array.length; i++) {
    System.out.println("Enter the " + (i + 1) + " element of the array");
    array[i] = number.nextInt();
}

boolean isMirrored = true;

for (int i = 0, j = array.length - 1; i < j; i++, j--) {

    if (array[i] != array[j]) {
        isMirrored = false;
        break;
    }
}

if (isMirrored) {
    System.out.println("The array is mirrored");
} else {
    System.out.println("The array is not mirrored");
}
```

### Task 5

```text
Напишете програма, която създава масив с 10 елемента от
тип double и инициализира всеки от елементите със стойност
равна на индекса на елемента умножен по 3 и разделен на сумата от всички елементи.
Да се изведат елементите на екрана закръглени до втори знак след десетичната запетая.
```

- solution 
```java
double[] myArray = new double[10];
double sum = 0.0;

for (int i = 0; i < myArray.length; i++) {
    sum += i;
}

for (int i = 0; i < myArray.length; i++){
    myArray[i] = i * 3 / sum;
}

System.out.println("Array");

for (int i = 0; i < myArray.length; i++) {
    System.out.printf("%.2f ", myArray[i]);
}
```

### Task 6

```text
Напишете програма, която първо чете масив от клавиатурата и после
създава нов масив със същия размер по следния начин: 
стойността на всеки елемент от втория масив да е равна на сбора от 
предходния и следващият елемент на съответния елемент от първия масив.
Да се изведе получения масив.

Пример:
Въведете размер на масива: 4
Въведете елементите на масива:
2
3
-11
7
Полученият масив е: {3, -9, 10, -11}

Обяснение:
В полученият масив числото на индекс 0 е получено, 
като се сумират елементът с индекс 1 и елементът с индекс -1. 
Тъй като елемент на -1 индекс няма (ArrayIndexOutOfBounds), събираме с 0 (0 + 3 = 3). 
Числото на индекс 1 (-9) е получено, като се сумират числата с 
индекси 0 и 2 от входния масив (2 + -11 = 9). 
Числото на индекс 2 (10) е получено, като се съберат числата с индекси 1 и 3 
от входния масив (3 + 7 = 10). За числото на индекс 3 (последното), 
логиката е аналогична на тази първото число. Тъй като няма елемент на индекс 4, 
то е равно на числото с индекс 3 от входния масив (-11 + 0 = -11).
```

- solution 
```java
Scanner scanner = new Scanner(System.in);

System.out.print("Enter size of the array: ");

int size = scanner.nextInt();

int[] array = new int[size];

for (int i = 0; i < size; i++) {
    System.out.print("array[" + i + "] = ");
    array[i] = scanner.nextInt();
}

int[] result = new int[array.length];

for (int i = 1; i < array.length - 1; i++) {
    result[i] = array[i - 1] + array[i + 1];
}

if (result.length == 1) {
    result[0] = array[0];
} else if (result.length >= 2) {
    result[0] = array[1];
    result[result.length - 1] = array[result.length - 2];
}

System.out.println("Result");
for (int i = 0; i < result.length; i++) {
    System.out.print(result[i] + " ");
}
```

### Task 7

```text
Напишете програма, която намира и извежда най-дългата редица от еднакви поредни елементи в даден масив.
Пример:
Въведете размер на масива: 10
Въведете елементите на масива:
2
1
1
2
3
3
2
2
2
1

Максималната редица е: 2 2 2
```

- solution 
```java
Scanner scanner = new Scanner(System.in);

System.out.println("Enter size of the array: ");
int size = scanner.nextInt();

int[] array = new int[size];

for (int i = 0; i < array.length; i++) {
    System.out.print("array[" + i + "] = ");
    array[i] = scanner.nextInt();
}

int count = 1;
int maxCount = 1;

int element = array[0];
int maxElement = array[0];

for (int i = 1; i < array.length; i++) {
    int current = array[i];

    if (element == current) {
        count++;

        if (maxCount < count) {
            maxCount = count;
            maxElement = element;
        }
    } else {
        element = current;
        count = 1;
    }
}

for (int i = 0; i < maxCount; i++) {
    System.out.print(maxElement + " ");
}
```

### Task 8

```text
Напишете програма, която първо чете 2 масива от конзолата (от целочислен тип)
и после извежда съобщение дали са еднакви и дали са с еднакъв размер.

Пример:
Въведете размер за първия масив: 3
Въведете елементите на първия масив:
13
2
7

Въведете размер за втория масив: 3
Въведете елементите на втория масив:
13
5
7

Масивите са различни.
Масивите имат еднакъв размер.
```

- solution 
```java
Scanner number = new Scanner(System.in);

System.out.println("Enter the size of the first array");
int size = number.nextInt();

int[] firstArray = new int[size];

for (int i = 0; i < firstArray.length; i++) {
    System.out.println("Enter the " + (i + 1) + " element");
    firstArray[i] = number.nextInt();
}

System.out.println("\nEnter the size of the second array");
size = number.nextInt();

int[] secondArray = new int[size];

for (int i = 0; i < secondArray.length; i++) {
    System.out.println("Enter the " + (i + 1) + " element");
    secondArray[i] = number.nextInt();
}

if (firstArray.length == secondArray.length) {
    System.out.println("Both arrays are with the same size");

    boolean areTheSame = true;

    for (int i = 0; i < firstArray.length; i++) {
        if (firstArray[i] != secondArray[i]) {
            System.out.println("Both arrays are not the same");
            areTheSame = false;
            break;
        }
    }

    if (areTheSame) {
        System.out.println("Both arrays are the same");
    }

} else {
    System.out.println("Both arrays are not with the same size, so they can not be the same");
}
```


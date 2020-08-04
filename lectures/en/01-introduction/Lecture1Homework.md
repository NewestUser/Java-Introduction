# Homework Lecture 1
#java course#

## Primitive Types

### Task 1

```text
Enter 2 different hole number types from the console.
Save the sum, difference, product, quotient and modulo in different variables.
Print each of the variables.
Try to do the same using floating-point numbers.  
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
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
```

</p>
</details>

### Task 2

```text
Enter 2 different numbers using the console. Save the numbers in two variables.
Swap the values of the variables.
Print the swapped values.
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

###### Solution 1 (using a temporary variable `int tmp`)

```java
Scanner scanner = new Scanner(System.in);

System.out.print("Enter first number: ");
int first = scanner.nextInt();
System.out.print("Enter second number: ");
int second = scanner.nextInt();

int tmp = first;

first = second;
second = tmp;

System.out.print("first number: " + first);
System.out.print("second number: " + second);
```

###### Solution 2 (without temporary variable)

```java
Scanner scanner = new Scanner(System.in);

System.out.print("Enter first number: ");
int first = scanner.nextInt();
System.out.print("Enter second number: ");
int second = scanner.nextInt();

first = first + second;

second = first - second;
first = first - second;

System.out.print("first number: " + first);
System.out.print("second number: " + second);
```

</p>
</details>

### Task 3

```text
Enter 3 numbers from the console a1, a2 and a3.
Swap their values such that a1 receives the value of a2, a2 the value of a3 and a3 the value of a1.
```

### Task 4

```text
Write a Celsius to Fahrenheit temperature converter.
First enter a number from the console. This number will be the temperature in Celsius.
After which the program should print the temperature converted into Fahrenheit.

Hint: °C * 9/5 + 32 = °F
Where: °C is temperature in Celsius and °F is temperature in Fahrenheit.
```

### Task 5

```text
Write a Fahrenheit to Celsius temperature converter.
First enter a number from the console. This number will be the temperature in Fahrenheit.
After which the program should print the temperature converted into Celsius.

Hint: (°F – 32) * 5/9 = °C
Where: °C is temperature in Celsius and °F is temperature in Fahrenheit.
```

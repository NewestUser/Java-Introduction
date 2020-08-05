# Homework Lecture 2
#java course#

## if/else and Loops

### Task 1

```text
Write a program that reads 2 numbers A and B from the keyboard (the numbers can be floating-point – double).
The program should then read a third number C. The program should check if C is between A and B and print a message.

Example:

Enter A:
13.2
Enter B:
29.5
Enter C:
22.1

The number 22.1 is between 13.2 и 29.5
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
Scanner scanner = new Scanner(System.in);

System.out.print("A = ");
int a = scanner.nextInt();
System.out.print("B = ");
int b = scanner.nextInt();
System.out.print("C = ");
int c = scanner.nextInt();

if (c > a && c < b || c > b && c < a) {
    System.out.println("Number C=" + c + " is between Number A=" + a + " and Number B=" + b);
} else {
    System.out.println("Number C=" + c + " is NOT between Number A=" + a + " and Number B=" + b);
}
```

</p>
</details>

### Task 2

```text
Write a program that reads 2 numbers from the keyboard and prints them in ascending order. 📈

Example:
User input: 10 and 3
Print: 3 and 10

User input: 3 and 10
Print: 3 and 10
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
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
```

</p>
</details>

### Task 3

```text
Write a program that reads 3 different numbers from the keyboard and prints them in descending order. 📉
```

### Task 4

```text
Write a program that reads 2 variables from the keyboard. The first is amount of money (floating-point number).
The second is health condition (boolean type). The program should make a decision based
on the user input. The made decision should be printed on the console.
- If I am sick I won't go out.
- If I have money (more than or equal to 10) then I will buy medicine.
- If I don't have money I will stay at home and drink tea.
- If I am healthy print it.
- If I have money (more than or equal to 10) I will go to the cinema.
- If I don't have money (less than 10) I will drink coffee. 💵
```

### Task 5

```text
Write a program that prints the numbers from 1 to 100 including. 💯
```

### Task 6

```text
Write a program that prints the numbers from -20 to 50 including.
```

### Task 7

```text
Write a program that prints all the even numbers between -10 and 10 including.
```

### Task 8

```text
Write a program that prints the numbers from 10 to 1 in descending order.
```

### Task 9

```text
Write a program that reads 2 numbers from the keyboard.
The program should print the numbers in between starting from the smaller one.
```

### Task 10

```text
Write a program that reads a number from the keyboard. The program should print the sum of all the numbers between the 1 and the entered number.
```

### Task 11

```text
Write a program that reads a number N from the keyboard. The program should print the first N numbers that are divisable by 3 starting from 3. The printed numbers should be separated with a comma.
```

### Task 12

```text
Write a program that reads a hole number from the keyboard. The program should determine if the 
number is prime.
Hint: A prime number is a number that is divisible by 1 and itself. Example 2, 3, 5, 7, 11 etc...
```

### Task 13

```text
Write a program that reads a hole number n from the keyboard.
The program should print the numbers in the following pattern:
Example:

Enter n: 2
11
33

Enter n: 1
0

Enter n: 4
3333
5555
7777
9999

Enter n: 3
222
444
666
```

### Task 14

```text
Write a program that reads 2 numbers A and B from the keyboard.
The program should print all the numbers between A and B to the power of 2 separated with a comma.
If any of the numbers is divisible by 3 a message "skip 3" should be printed.
If the sum of the numbers between A and B to the power of 2 is more than 200 the program should stop its execution.
```

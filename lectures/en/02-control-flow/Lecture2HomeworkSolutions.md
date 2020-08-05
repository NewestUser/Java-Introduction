# 👀 Homework Solutions Lecture 2
#java course#

## if/else and Loops

### Task 1

```text
Write a program that reads 2 numbers A and B from the keyboard (the numbers can be floating-point – double).
The program should then read a third number C. The program should check if C is between A and B and print a message.
`
Example:

Enter A:
13.2
Enter B:
29.5
Enter C:
22.1`

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

<details><summary><b>Solution</b> 👀</summary> 
<p>

###### Solution 1
```java
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
```

###### Solution 2

```java
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
```

</p>
</details>

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

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
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
```

</p>
</details>

### Task 5

```text
Write a program that prints the numbers from 1 to 100 including. 💯
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
for (int i = 0; i < 100; i++) {
    System.out.print(i + 1 + " ");
}
```

</p>
</details>

### Task 6

```text
Write a program that prints the numbers from -20 to 50 including.
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
for (int i = -20; i <= 50; i++) {
    System.out.print(i + " ");
}
```

</p>
</details>

### Task 7

```text
Write a program that prints all the even numbers between -10 and 10 including.
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
for (int i = -10; i <= 10; i++) {
    if (i % 2 != 0) {
        System.out.print(i + " ");
    }
}
```

</p>
</details>

### Task 8

```text
Write a program that prints the numbers from 10 to 1 in descending order.
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
for (int i = 10; i >= 1; i--) {
    System.out.print(i + " ");
}
```

</p>
</details>

### Task 9

```text
Write a program that reads 2 numbers from the keyboard.
The program should print the numbers in between starting from the smaller one.
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
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
```

</p>
</details>

### Task 10

```text
Write a program that reads a number from the keyboard. The program should print the sum of all the numbers between the 1 and the entered number.
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
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
```

</p>
</details>

### Task 11

```text
Write a program that reads a number N from the keyboard. The program should print the first N numbers that are divisable by 3 starting from 3. The printed numbers should be separated with a comma.
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
Scanner scanner = new Scanner(System.in);

System.out.print("Enter a number: ");
int number = scanner.nextInt();

System.out.println("First " + number + " numbers divisible by 3 are:");
for (int i = 3, count = 0; count < number; i++) {
    if (i % 3 == 0) {
        System.out.print(i + ", ");
        count++;
    }
}
```

</p>
</details>

### Task 12

```text
Write a program that reads a hole number from the keyboard. The program should determine if the 
number is prime.
Hint: A prime number is a number that is divisible by 1 and itself. Example 2, 3, 5, 7, 11 etc...
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
Scanner scanner = new Scanner(System.in);

System.out.print("Enter a number: ");
int number = scanner.nextInt();

boolean isPrime = true;
for (int i = 2; i <= number / 2; i++) {
 if (number % i == 0) {
     isPrime = false;
     break;
 }
}

if (isPrime) {
 System.out.println(number + " is a prime number");
} else {
 System.out.println(number + " is NOT a prime number");
}
```

</p>
</details>

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

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
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
```

</p>
</details>

### Task 14

```text
Write a program that reads 2 numbers A and B from the keyboard.
The program should print all the numbers between A and B to the power of 2 separated with a comma.
If any of the numbers is divisible by 3 a message "skip 3" should be printed.
If the sum of the numbers between A and B to the power of 2 is more than 200 the program should stop its execution.
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
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
```

</p>
</details>

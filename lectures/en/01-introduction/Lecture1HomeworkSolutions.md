# 👀 Homework Solutions Lecture 1
#java course#

## Primitive Types

### Task 1

```text
Въведете 2 различни целочислени числа от конзолата.
Запишете тяхната сума, разлика, произведение, остатък от деление и 
целочислено деление в отделни променливи и разпечатайте тези резултати
в конзолата. Опитайте същото с числа с плаваща запетая.  
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
Въведете 2 различни числа от конзолата и разменете стойностите им.
Разпечатайте новите стойности.
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

###### Solution 1 (използвайки временна променлива `int tmp`)

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

###### Solution 2 (без временна променлива)

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
Въведете 3 числа от клавиатурата а1, а2 и а3.
Разменете стойностите им, така че а1 да има стойността на а2,
а2 да има стойността на а3, а а3 да има старата стойност на а1.
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
Scanner scanner = new Scanner(System.in);

System.out.print("a1 = ");
int a1 = scanner.nextInt();
System.out.print("a2 = ");
int a2 = scanner.nextInt();  
System.out.print("a3 = ");
int a3 = scanner.nextInt();

int tmp = a1;

a1 = a2;
a2 = a3;
a3 = tmp;

System.out.print("a1 = " + a1);
System.out.print("a2 = " + a2);
System.out.print("a3 = " + a3);
``` 

</p>
</details>
 
### Task 4

```text
Напишете конвертор на градуси от Целзий във Фаренхайт.
Въвеждате едно число от конзолата. Това число ще бъдат градусите в Целзий.
На конзолата трябва да бъде изведено съобщение със съответните градуси,
но трансформиране във Фаренхайт.

подсказка: °C * 9/5 + 32 = °F
където: °C е градуси в Целзий, а °F е градуси във Фаренхайт
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
Scanner scanner = new Scanner(System.in);

System.out.print("Enter °C: ");
double celsius = scanner.nextDouble();

double fahrenheit = celsius * 9d / 5d + 32;

System.out.println(celsius + "°C = " + fahrenheit + "°F");
```

</p>
</details>
     
### Task 5

```text
Напишете конвертор на градуси от Фаренхайт в Целзий. Въвеждате едно число от конзолата.
Това число ще бъдат градусите във Фаренхайт. На конзолата трябва да бъде изведено
съобщение със съответните градуси, но трансформиране във Целзий.

подсказка: (°F – 32) * 5/9=°C
където: °C е градуси в Целзий, а °F е градуси във Фаренхайт
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
Scanner scanner = new Scanner(System.in);

System.out.print("Enter °F: ");
double fahrenheit = scanner.nextDouble();

double celsius = (fahrenheit - 32) * 5d / 9d;

System.out.println(fahrenheit + "°F = " + celsius + "°C");
```    

</p>
</details>
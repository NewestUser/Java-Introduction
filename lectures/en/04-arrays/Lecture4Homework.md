# Homework Lecture 4
#java course#

## Arrays 

### Task 1

```text
Write a program that reads an array from the keyboard. The program has to find the smallest 
number in the array that is divisible by 3. 

Hint: In order to simplify the program you can assume that the 
first number entered by the user will always be divisible by 3.
You can also try solve the problem without this assumption.
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

###### Solution 1

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

###### solution 2

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

</p>
</details>

### Task 2

```text
Write a program that prompts the user to input an even array size.
After which the program should prompt the user to input half of the array elements.
The other half of the array must be set by the program with the same values that the user entered.
The program must print the resulting array.

Example:
Enter array size: 8
Enter element 1:
10
Enter element 2:
12
Enter element 3:
1
Enter element 4:
-4

Result:
10 12 1 -4 10 12 1 -4
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

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

</p>
</details>

### Task 3

```text
Write a program that reads a number from the keyboard, after which an array is created with a size of 10.
The first 2 elements of the array should be equal to the number that user entered.
Each following element in the array needs to take the value of the sum of the previous 2 elements.
(The Fibonacci problem but with a user defined start and values saved in an array) 
The program should print the values of the array.

Example 1:
Enter a number: 1
1 1 2 3 5 8 13 21 34 55

Example 2:
Enter a number: 3
3 3 6 9 15 24 39 63 102 167 🐚
```

> Some interesting Fibonacci facts:  
[The magic of Fibonacci numbers](https://www.youtube.com/watch?v=SjSHVDfXHQ4&fbclid=IwAR16DatoUczikQgzwQHtpBcIQe5DhGEcXWsXv0CGMZ6yjx4QMZL1y0yVOdw)  
[Nature by Numbers](https://www.youtube.com/watch?v=kkGeOWYOFoA&fbclid=IwAR1ClvHqnuBsG04hz7RgUZwG9D3j_mSYXCqSUuYAze1SylakjW0GMFOK5qI)  
[Константно намиране на n-тото число от поредицата на Фибоначи](http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibFormula.html)

### Task 4

```text
Write a program that creates an array with a user defined length.
The values of the array should be read from the keyboard.
The program should check if the array is mirrored.

The following arrays are mirrored:
[3 7 7 3]
[4]
[1 55 1]
[6 27 -1 5 7 7 5 -1 27 6]

Example:
Enter size of the array: 5
Enter element 1: 10
Enter element 2: 66
Enter element 3: 1
Enter element 4: 66
Enter element 5: 10

The array is mirrored.
```

### Task 5

```text
Write a program that creates a double array with a size of 10.
The program should set the values of the array.
Each element should be equal to the index of the element multiplied by 3 and divided 
by the sum of the array indices.
The program should print each of the array elements where the 
value should by rounded up to the second decimal place.
```

### Task 6

```text
Write a program that first creates an array with a user defined length and values.
After that the program should create a second array and calculate it's values based on the first array.
The value of each index needs to equal the sum of the adjacent values.
`result[n] = array[n-1] + array[n+1]`
The program should print the computed values.

Example:
Enter array size: 4
Enter array values:
2
3
-11
7
Resulting array: {3, -9, 10, -11}
```

> **Explanation:**  
In the resulting array the number on index `0` `(3)` is computed by summing element with index `1`
and element with index `-1`. However there is no `-1` index, `(ArrayIndexOutOfBounds)` 
for this reason we sum `0` `(0 + 3 = 3)`.
The value on index `1` `(-9)` is computed by adding numbers with indices `0` and `2` `(2 + (-11) = 9).
The number on index `2` `(10)` is computed by adding numbers with inidices `1` and `3` `(3 + 7 = 10)`.
The number on index `3` `(-11)` (the last one) is computed in a manner similar to the first one.   
Because there is no `4` index the value is equal to the sum of index `2` and 0 `(-11 + 0 = -11)`.

### Task 7

```text
Write a program that finds and prints the longest sequence of equal numbers in a given array.
Example:
Enter array size: 10
Enter array elements:
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

The longest sequence is: 2 2 2
```

### Task 8

```text
Write a program that first reads 2 integer arrays from using the keyboards 
and then outputs if the arrays are equal or have equal length. 

Example:
Enter size of the first array: 3
Enter first array values:
13
2
7

Enter size of the second array: 3
Enter second array values:
13
5
7

The arrays have different values.
The arrays have equal length.
```

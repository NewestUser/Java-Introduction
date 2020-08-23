# Lecture 4
#java course#

## Arrays Exercises

### Task 1

```text
Write a program that creates an integer array of 10 elements.
Save some values in the first 3 elements of the array.
Print the second element of the array.
Multiply the third element the array by 2 and print the value.
```

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

```java
int[] array = new int[10];

array[0] = 3;
array[1] = 5;
array[2] = 7;

System.out.println("array[1] = " + array[1]);

array[2] = 2 * array[2];

System.out.println("array[2] = " + array[2]);
```

</p>
</details>

### Task 2

```text
Write a program that creates an array with floating-point numbers and print the values of the array.
```

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

```java
double[] array = new double[]{2.5, 3, 5, 8, -12.9, 7.0};

for (int i = 0; i < array.length; i++) {
    System.out.print(array[i] + " ");
}
```

</p>
</details>
 
### Task 3

```text
Create a program that reads 10 numbers from the keyboard and saves them in an array.
The program should print the saved values.
```

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

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

</p>
</details>

### Task 4

```text
Write a program that creates an array with a user defined length N.
The user should also be able to enter N values of the array.
The program should be able to find and print the largest number.
```

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

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

</p>
</details>

### Task 5

```text
Write a program that inverts an array (the array can be user defined or hardcoded).
Try solving the problem by using two different approaches.
- with the help of a second array
- without using a second array

Example: [5, -3, 7, 30] -> [30, 7, -3, 5]
```

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

###### Solution 1

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

###### Solution 2

```java
int[] array = new int[]{1, 2, 3, 4, 5};

for (int i = 0, j = array.length - 1; i < j; i++, j--) {
    int tmp = array[i];

    array[i] = array[j];
    array[j] = tmp;
}

for (int i = 0; i < array.length; i++) {
    System.out.print(array[i] + " ");
}
```

</p>
</details>

### Task 6

```text
Write a program that reads the values of an array from the keyboard.
The program should create another array with the length of the first array + 1.
All the elements of the second array must be equal to the elements of the first array multiplied
by the index of the current element. This does not apply to the first element.
The program should print the resulting array.

Example:
index  =     0    1      2       3       4       6
array  = [   1    2      3       4       5  ]
result = [   1    1*1    2*2     3*3     4*4     5*5    ] = [ 1 1 4 9 16 25 ]

Example:
index  =        0   1      2       3    4       5       6
array  =    [   9   -2     4      -3    7       5  ]
result =    [   9   9*1    -2*2   4*3   -3*4    7*5     5*6 ] = [ 9 9 4 12 -12 35 30 ]  
```

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

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

</p>
</details>

### Task 7

```text
Write a program that reads the values of an array from the keyboard.
The number of values that the user can input is indefinite.
The user can stop entering array values if he types -1.
Print all the values that the user has entered excluding -1.

Example:
Enter number: 10
Enter number: 32
Enter number: -41
Enter number: -1
You entered: 10 32 -41
```

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

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

</p>
</details>
# Lecture 3
#java course#

## Recap Primitive Types

1. What are the components bellow and what is the relationship between them?

	-  `JVM`
	-  `JDK`
	-  `Compiler`
	-  `ByteCode`

<details><summary><b>Solution</b> 👀</summary> 
<p>

- `JVM` - Java Virtual Machine - Virtual machine that executes/interprets the compiled bytecode.

- `JDK` - Java Development Kit - A collection of tools that can be used to develop a Java application.
By installing JDK we also install JVM.

- `Compiler` - The compiler is a tool that is used for translating the human readable code 
written in `.java` files to bytecode which is saved in `.class` files.

- `ByteCode` - Already compiled java code which the JVM is capable of reading and executing.
</p>
</details>

2. What is a variable and what is it composed of?

<details><summary><b>Solution</b> 👀</summary> 
<p>

 - `TYPE`
 - `NAME`
 - Optional  `VALUE`

 ```java
 double pi = 3.1415; // create a variable and at the same time assign a value
 
 boolean myBoolean; // create a variable without assigning a value
 ```

</p>
</details>

3. Primitive Types

<details><summary><b>Solution</b> 👀</summary> 
<p>

- `byte` — 8 bit ( -128 — 127 )
- `short` — 16 bit ( -32768 — 32767 )
- `int` — 32 bit ( -2 147 483 648 — 2 147 483 647 )
- `long`— 64 bit ( -2^63 — 2^63 - 1 )
- `float` — 32 bit ( 1.4 E-45 — 3.4028235 E38 )
- `double` — 64 bit ( 4.9e-324 — 1.7976931348623157e+308)
- `boolean` — 1 bit ( true/false )
- `char` —16 bit

</p>
</details>

4. Arithmetic Operators

<details><summary><b>Solution</b> 👀</summary> 
<p>

- `+` — addition
- `-` — subtraction
- `*` — multiplication
- `/` — division
- `%` — modulo

</p>
</details>

5. Logical Operators

<details><summary><b>Solution</b> 👀</summary> 
<p>

- `!`  — logical NOT
- `&&` — logical AND
- `||` — logical OR

</p>
</details>

6. Equality and Relational Operators

<details><summary><b>Solution</b> 👀</summary> 
<p>

- `==` — equal
- `!=` — not equal 
- `>` — greater than
- `>=` — greater than or equal
- `<` — less than
- `>=` — less than or equal

</p>
</details>

7. What is a keyword?

<details><summary><b>Solution</b> 👀</summary> 
<p>
Words that are defined and reserved by the programming language.
These words have a concrete meaning and effect on the code. The language defines where and how each keyword can be used.
Keywords cannot be used as variable names.
</p>
</details>

8. Output to the `Console`

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
System.out.println("Hello world");
```

</p>
</details>

9. Input from the `Console`

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
Scanner scanner = new Scanner(System.in);

int myInput = scanner.nextInt();
```

</p>
</details>


## Recap if/else 

1. Control flow

2. if statements

    - if
    ```java
    if (condition) {
        System.out.println("condition is true");
    }
    ```

	- if / else

    ```java
    if (condition) {
        System.out.println("condition is true");
    } else {
        System.out.println("condition is false");
    }
    ```

	- if / else if

    ```java
    if (condition) {
      System.out.println("condition is true");
    } else if (otherCondition) {
      System.out.println("condition is false, otherCondition is true");
    }
    ``` 

	- if / else if / else 

    ```java
    if (condition) {
      System.out.println("condition is true");
    } else if (otherCondition) {
      System.out.println("condition is false, otherCondition is true");
    } else {
      System.out.println("condition && otherCondition are false")
    }
    ```

	 - Example

    ```java
    double a = 7.5;
    if (a < 0) {
    	System.out.println("a is smaller than 0");
    } else {
    	if (a == 0) {
    		System.out.println("a is 0");
    	} else {
    		System.out.println("a is bigger than 0");
    	}
    }
    ``` 
    
3. What is Scope ?

    ```java

    { // scope 1
     	int a = 0;
    
    	{ // scope 2
    		int b = a;
    		
    		{ // scope 3
    			int c = a + b;
    		} 
    	}
    
    	{ // scope 4
      		int c = a;
    	}
    
    }
    ```


![variable_scope](../../../assets/03-lecture/variable_scope.jpg)

> The inner block has access to the variables `var1` and `var2`.
The outer block has access to `var1` and `var`.

## Recap Loops	

1. `for`

    ```java
    for (int i = 0; i < 10; i++) {
    	System.out.println(i);
    }
    ```
	
2. `while`

    ```java
    int i = 0;
    while (i < 10) {
    	System.out.println(i);
    	i++;
    }
    ```
	
3. `do while`

    ```java
    int i = 0;
    do {
    	System.out.println(i);
    	i++;
    } while (i < 10);
    ```

1. Interrupting (breaking out of) loops `break`

    ```java
    for (int i = 0; i < 10; i++) {
      if (i % 2 == 0) {
    		break;
    	}
    
    	System.out.println(i);
    }
    ```
    
2. Skipping loop iterations `continue`

    ```java
    for (int i = 0; i < 10; i++) {
    	if (i % 2 == 0) {
    		continue;
    	}
    
    	System.out.println(i);
    }
    ```



## Exercise 

### Task 1

```
• Enter an integer. For example, if you enter 3, you shoud see the following:
    „3 3 3 !“

• If you enter 5, you should see:
    „5 5 5 5 5 !“
```

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

```java
System.out.print("Enter number: ");
Scanner scanner = new Scanner(System.in);

int num = scanner.nextInt();

for (int i = 0; i < num; i++) {
    System.out.print(num + ", ");
}

System.out.println("!");
```

</p>
</details>

### Task 2
```
• Sum all the numbers between 1 and 100 but omit all the numbers between 51 and 74.
```

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

```java
int sum = 0;

for (int i = 1; i <= 100; i++) {
    if (i > 51 && i < 74) {
        continue;
    }

    sum += i;
}

System.out.println("sum = " + sum);
```

</p>
</details>

### Task 3
```
• Calculate factorial of a number, where the numer is entered by the user
• Hint: n! = 1 * 2 * 3 ... (n - 2) * (n - 1) * n;
```

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

```java
Scanner scanner = new Scanner(System.in);

System.out.print("Enter n: ");
int n = scanner.nextInt();

int factorial = 1;

for (int i = 1; i <= n; i++) {  
    factorial *= i;
}

System.out.println(n + "! = " + factorial);
```

</p>
</details>

### Task 4
```
• Calculate the sum of the first n numers of the Fibonacci sequence:
• Hint: F = 0 + 1 + 1 + 2 + 3 + 5 + 8 + ...
```

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

```java
Scanner scanner = new Scanner(System.in);
System.out.print("Enter n: ");

int n = scanner.nextInt();  

int sum = 0;  

int previous = 0;
int current = 1;  

for (int i = 0; i < n; i++) {  
    System.out.print(previous + ", ");  
    
    sum += previous;
    
    int tmp = previous;
    
    previous = current;  
    current = tmp + current;
}  

System.out.println("\nsum fibonacci(" + n + ") = " + sum);
``` 

</p>
</details>

### Task 5
```
• Calculate the following for user specified n:
(1!) / (1^1) + (2!) / (2^2) + ... + (n!) / (n^n)
```

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

```java
Scanner scanner = new Scanner(System.in);

System.out.print("Enter n: ");
int n = scanner.nextInt();  

double sum = 0;  

for (int i = 1; i <= n; i++) {  

    double factorial = 1;
    for (int j = 1; j <= i; j++) {
        factorial *= j;
    }  
    
    double power = i;
    for (int j = 2; j <= i; j++) {
        power *= i;
    }  
    
    sum += factorial / power;
}  

System.out.println(sum);
```

</p>
</details>

### Additional Task
```
• You are given an array of numbers and a number N. If the group of N numbers at the start and end of
  the array are the same return true + the equal characters, separated by comma. If they are not the
  same, return false + the first pair of characters that is different. You may assume that n is in the
  range 1..nums.length inclusive.
• Example:
  With numbers {5, 6, 45, 99, 13, 5, 6} and N = 3 you should output the following:
• Result:
  false 5,13
• Explanation:
  We are comparing the first 3 and the last 3 numbers, but 5 and 13 are different.  
```

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

```java
Scanner scanner = new Scanner(System.in);

System.out.print("Enter n: ");
int n = scanner.nextInt();

int[] array = {5, 6, 45, 99, 13, 5, 6};

if (n > array.length || n <= 0) {
    System.out.println("n is not within the range of the array");
    return;
}

boolean areElementsEqual = true;

int endIndex = n - 1;

int[] equalElements = new int[n];
int[] differentElements = new int[2];

for (int i = 0, j = array.length - n; i < n; i++, j++) {

    if (array[i] == array[j]) {
        equalElements[i] = array[i];
    } else {
        endIndex = i - 1;
        
        differentElements[0] = array[i];
        differentElements[1] = array[j];
        
        areElementsEqual = false;
        break;
    }
}

System.out.print(areElementsEqual + " ");
for (int i = 0; i <= endIndex; i++) {
    System.out.print(equalElements[i] + ", ");
}  

if (!areElementsEqual) {
    System.out.print(differentElements[0] + ", ");
    System.out.print(differentElements[1]);
}
```

</p>
</details>

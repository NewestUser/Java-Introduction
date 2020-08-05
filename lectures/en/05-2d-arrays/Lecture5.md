# Lecture 5
#java course#

## Recap

##### Java naming conventions

###### variable names
- According to the Java conventions variable names start with a small letter and each new 
word in the name start with a capital letter. This is called **camelCase** 🐪 (just one hump).

![camelCase](../../../assets/05-lecture/camelCase.png)

- Example
    ```java
    int myVariable;
    ```

###### method names
- Method names start with a small letter where each consecutive word starts with a capital letter (camelCase)

- Example
    ```java
    void myMethod() {
      ...
    }
    ```

###### class names
- Each word in a class name starts with a capital letter (PascalCase)

- Example
    ```java
    class MyClass {
      ...
    }
    ```

> Did you know that there are different naming conventions like
 🍢 [kebab-case](https://wiki.c2.com/?KebabCase),
 🐍 [snake_case](https://en.wikipedia.org/wiki/Snake_case),
 🐫 [PascalCase](https://simple.wikipedia.org/wiki/CamelCase).

###### null value
- Reference types can have a `null` value.

- Example

    ```java
    int[] array = null;
    
    Scanner scanner = null;
    
    String foo = null;
    ```

##### Formatting

- `%d` - whole numbers (**int**, **long**)
- `%f` - floating-point numbers (**float**, **double**)
- `%.2f` - format floating-point numbers up to the 2nd decimal (**float**, **double**)
- `%s` - text (**String**)
- `%S` - text with capital letters (**String**)

    - Example
    ```java
    // Today it is May 2019 and the hour is 21.30
    System.out.printf("Today it is %s %d and the hour is %.2f", "May", 2019, 21.3);
    ```


|Format Specifier  |Data Type	                                                  |Output                                                                                                                   |
|------------------|--------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------|
|%a                |floating point (except BigDecimal)	                          |Returns Hex output of floating point number.                                                                             |           
|%b                |Any type	                                                  |"true" if non-null, "false" if null                                                                                      |           
|%c                |character	                                                  |Unicode character                                                                                                        |           
|%d                |integer (incl. byte, short, int, long, bigint)	              |Decimal Integer                                                                                                          |           
|%e                |floating point	                                              |decimal number in scientific notation                                                                                    |           
|%f                |floating point                                  	          |decimal number                                                                                                           |           
|%g                |floating point                                  	          |decimal number, possibly in scientific notation depending on the precision and value.                                    |           
|%h                |any type                                        	          |Hex String of value from hashCode() method.                                                                              |           
|%n                |none                                            	          |Platform-specific line separator.                                                                                        |           
|%o                |integer (incl. byte, short, int, long, bigint)  	          |Octal number                                                                                                             |           
|%s                |any type                                        	          |String value                                                                                                             |           
|%t                |Date/Time (incl. long, Calendar, Date and TemporalAccessor)   |%t is the prefix for Date/Time conversions. More formatting flags are needed after this. See Date/Time conversion below. |           
|%x                |integer (incl. byte, short, int, long, bigint)                |Hex string.                                                                                                              |           


##### Big O notation 🧮

Big O notation е математическа нотация, която описва ограничаващото поведение на дадена функция, 
когато аргументът се стреми към определена стойност или безкрайност.

[Big O Notation Cheat Sheet](https://cooervo.github.io/Algorithms-DataStructures-BigONotation/index.html)

###### O(1) constant time

- пример
    ```java
    int a = 10;
    int b = 20;
    int c = a * b;
    ```

###### O(n) linear time

- пример
    ```java
    int n = 10;
    
    int sum = 0;
    for (int i = 0; i < n; i++){
      sum += i;  
    }
    ```

###### O(n^2) polynomial time

- пример
    ```java
    int n = 10;
    
    int sum = 0;
    for (int i = 0; i < n; i++){
      for (int j =0; j < n; j++){
          sum += j;  
      }
    }
    ```

![big_O_notation_graph](../../../assets/05-lecture/big_O_notation_graph.png)  

> ℹ️ За повече информация относно **Big O Notation** изгледайте това 
[youtube видео](https://www.youtube.com/watch?v=v4cd1O4zkGw) и това 
[youtube видео](https://www.youtube.com/watch?v=D6xkbGLQesk).  
If you want a more comprehensive explanation of **Big O Notation** I recommend going through
through [A Gentle Introduction to Algorithm Complexity Analysis](http://discrete.gr/complexity/).

## Two Dimensional Arrays Exercises 🐫

### Task 1

Create a two-dimensional array with 2 rows and 3 columns.
Assign value to cell located at row 1 column 2.
Print the values of the array.

<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

```java
int[][] matrix = new int[2][3];

matrix[0][1] = 555;

for (int i = 0; i < matrix.length; i++) {
    System.out.print("[\t");
    
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + "\t");
    }

    System.out.println("]\t");
}
```

</p>
</details>

# Lecture 5
#java course#

## Recap

###### variable names
- имената на променливите започват с малка буква, като всяка следваща дума е с главна (camel case)

- пример
    ```java
    int myVariable;
    ```

###### method names
- имената на методите започват с малка буква, като всяка следваща дума е с главна (camel case)

- пример
    ```java
    void myMethod() {
      ...
    }
    ```

###### class names
- имената на класовете започват с главна буква, както и вся следваща дума (upper case)

- пример
    ```java
    class MyClass {
      ...
    }
    ```

###### null value
- референтните типове (reference types) могат да бъдат `null`

- пример

    ```java
    int[] array = null;
    
    Scanner scanner = null;
    
    String foo = null;
    ```

##### Formatting

- `%d` - цели числа (**int**, **long**)
- `%f` - числа с плаваща запетая (**float**, **double**)
- `%.2f` - закръгляне на числа до 2-рия знак (**float**, **double**)
- `%s` - текст (**String**)
- `%S` - текст с главни букви (**String**)

    - пример
    ```java
    // Днес е Май 2019 и часът е 21.30
    System.out.printf("Днес е %s %d и часът е %.2f", "Май", 2019, 21.3);
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


##### Big O notation

Big O notation е математическа нотация, която описва ограничаващото поведение на дадена функция, 
когато аргументът се стреми към определена стойност или безкрайност.

[Time Complexity Chart](https://adrianmejia.com/images/big-o-running-time-complexity.png)  

[Big O Notation Cheat Sheet](https://cooervo.github.io/Algorithms-DataStructures-BigONotation/index.html)

###### O(1) constant time (константно време)

- пример
    ```java
    int a = 10;
    int b = 20;
    int c = a * b;
    ```

###### O(n) linear time (линейно време)

- пример
    ```java
    int n = 10;
    
    int sum = 0;
    for (int i = 0; i < n; i++){
      sum += i;  
    }
    ```

###### O(n^2) polynomial time (полиномно време)

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


## Two Dimensional Arrays Exercises

### Task 1

```text
Създайте двумерен масив с 2 реда и 3 колони.
Задайте стойност на клетка в ред 1-ви и колкона 2-ра.
Принтирайте двумерния масив.
```

- solution
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
    
### Task 2

```text
Да се завърти двумерен масив (за по-лесно квадратен с четен брой елементи – 4х4, 6х6 и т.н.) 
по часовниковата стрелка:
Например за дадената матрица:

      { 1     12   13     5 }
      { 6     17   8      4 }
      { 3     2    13     8 }
      { 0     14   5      2 }
    
След завъртането да се получи:

      { 0     3    6      1 }
      { 14    2    17    12 }
      { 5     13   8     13 }
      { 2     8    4      5 }

```

- Ето [примерно решение](https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/) с добра илюстрация 
(с тази разлика че върти матрицата на обратно)

- solution

```java
public static void main(String[] args) {

    int[][] matrix = {
            {1, 12, 13, 5},
            {6, 17, 8, 4},
            {3, 2, 13, 8},
            {0, 14, 5, 2},
    };

    printMatrix(matrix);
    System.out.println("===============");

    for (int i = 0; i < matrix.length / 2; i++) {
        for (int j = i; j < matrix.length - i - 1; j++) {
            int topLeftRow = i;
            int topLeftCol = j;

            int topRightRow = j;
            int topRightCol = matrix.length - 1 - i;

            int bottomRightRow = matrix.length - 1 - i;
            int bottomRightCol = matrix.length - 1 - j;

            int bottomLeftRow = matrix.length - 1 - j;
            int bottomLeftCol = i;

            int topLeft = matrix[topLeftRow][topLeftCol];
            int topRight = matrix[topRightRow][topRightCol];

            int bottomRight = matrix[bottomRightRow][bottomRightCol];
            int bottomLeft = matrix[bottomLeftRow][bottomLeftCol];

            matrix[topLeftRow][topLeftCol] = bottomLeft;
            matrix[topRightRow][topRightCol] = topLeft;

            matrix[bottomRightRow][bottomRightCol] = topRight;
            matrix[bottomLeftRow][bottomLeftCol] = bottomRight;

            printMatrix(matrix);
        }
    }

    System.out.println("===============");
    printMatrix(matrix);
 }

private static void printMatrix(int[][] matrix) {
    System.out.println();

    for (int i = 0; i < matrix.length; i++) {
        System.out.print("[\t");
        for (int j = 0; j < matrix[i].length; j++) {
            System.out.print(matrix[i][j] + "\t");
        }
        System.out.println("]");
    }
}
```         

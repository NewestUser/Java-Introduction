# Lecture 5
### Two Dimensional Arrays Exercises

#java course#


### Task 1

```text
Създайте двумерен масив с 2 реда и 3 колони.
Задайте стойност на келтка в ред 1-ви и колкона 2-ра.
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

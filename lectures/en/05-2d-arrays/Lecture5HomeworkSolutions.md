# 👀 Homework Solutions Lecture 5
#java course#

## Two Dimensional Arrays 🐫 

### Task 1

Write a program that reads 2 numbers n and m using the keyboard.
The program should create a two-dimensional array with a size of `n x m` in the following way:
The examples below are for n=4 and m=4, however there is no requirement that n must be equal to m.

#### 1.1

###### Пример:

```
{   1,  5,  9,  13  }
{   2,  6,  10, 14  }
{   3,  7,  11, 15  }
{   4,  8,  12, 16  }
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
Scanner scanner = new Scanner(System.in);

System.out.print("Въведете брой редове: ");
int row = scanner.nextInt();

System.out.print("Въведете брой колони: ");
int col = scanner.nextInt();

int[][] matrix = new int[row][col];

int counter = 1;

for (int i = 0; i < col; i++) {
    for (int j = 0; j < row; j++) {
        matrix[j][i] = counter;
        counter++;
    }
}

for (int i = 0; i < row; i++) {
    System.out.print("[\t");
    for (int j = 0; j < col; j++) {
        System.out.print(matrix[i][j] + "\t");
    }
    System.out.print("]\n");
}
```

> We first iterate the columns and then the rows. For this reason the outer `for` we iterate `col`
and in the inner `for` we iterate `row` (the opposite of a normal iteration).

</p>
</details>

#### 1.2

###### Example:

```
{   1,  8,  9,  16  }
{   2,  7,  10, 15  }
{   3,  6,  11, 14  }
{   4,  5,  12, 13  }
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

###### solution 1

```java
Scanner scanner = new Scanner(System.in);

System.out.print("Въведете брой редове: ");
int rowCount = scanner.nextInt();

System.out.print("Въведете брой колони: ");
int colCount = scanner.nextInt();

int[][] matrix = new int[rowCount][colCount];

int counter = 1;

for (int col = 0; col < colCount; col++) {

    if (col % 2 == 0) {
        for (int j = 0; j < rowCount; j++) {
            matrix[j][col] = counter;
            counter++;
        }
    } else {
        for (int row = rowCount - 1; row >= 0; row--) {
            matrix[row][col] = counter;
            counter++;
        }
    }
}

for (int i = 0; i < rowCount; i++) {
    System.out.print("[\t");
    for (int j = 0; j < colCount; j++) {
        System.out.print(matrix[i][j] + "\t");
    }
    System.out.print("]\n");
}
```

> Depending if we are located on an ever or odd column we determine how will we iterate the inner `for`.
In the first case we iterate `0...rowCount` and in the second `rowCount...0`.

###### solution 2

```java
Scanner scanner = new Scanner(System.in);

System.out.print("Въведете брой редове: ");
int rowCount = scanner.nextInt();

System.out.print("Въведете брой колони: ");
int colCount = scanner.nextInt();

int[][] matrix = new int[rowCount][colCount];

int counter = 1;

for (int col = 0; col < colCount; col++) {
    for (int row = 0; row < rowCount; row++) {

        int currentRow = row;

        if (col % 2 != 0) {
            currentRow = rowCount - 1 - row;
        }

        matrix[currentRow][col] = counter;

        counter++;
    }
}

for (int i = 0; i < rowCount; i++) {
    System.out.print("[\t");
    for (int j = 0; j < colCount; j++) {
        System.out.print(matrix[i][j] + "\t");
    }
    System.out.print("]\n");
}
```

> Depending if we are on an even/odd column we determine the index of the row that we need to access.

</p>
</details>

#### 1.3.1

###### Пример:

```
{   1,  3,  6,  10  }
{   2,  5,  9,  13  }
{   4,  8,  12, 15  }
{   7,  11, 14, 16  }
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
int rowCount = 4;
int colCount = 5;
int[][] matrix = new int[rowCount][colCount];

int counter = 1;

for (int row = 0; row <= rowCount + colCount - 2; row++) {
    for (int col = 0; col <= row; col++) {

        int diagonalRow = row - col;

        if (diagonalRow < rowCount && col < colCount) {
            matrix[diagonalRow][col] = counter++;
        }
    }
}

for (int i = 0; i < matrix.length; i++) {
    System.out.print("[\t");
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + "\t");
    }
    System.out.print("]\n");
}
```

> We iterate the array diagonally starting from the top left corner.

</p>
</details>

#### 1.3.2 

###### Example:

```
{   7,  11, 14, 16  }
{   4,  8,  12, 15  }
{   2,  5,  9,  13  }
{   1,  3,  6,  10  }
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

```java
int rowCount = 4;
int colCount = 4;
int[][] matrix = new int[rowCount][colCount];

int counter = 1;

for (int row = rowCount - 1; row >= -rowCount; row--) {
    for (int col = 0; col < colCount; col++) {

        int diagonalRow = row + col;

        if (diagonalRow >= 0 && diagonalRow < rowCount) {
            matrix[diagonalRow][col] = counter++;
        }

    }
}

for (int i = 0; i < matrix.length; i++) {
    System.out.print("[\t");
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + "\t");
    }
    System.out.print("]\n");
}
```

</p>
</details>

#### 1.4

###### Example:

```
{   1,  2,  3,  4  }
{   12, 13, 14, 5  }
{   11, 16, 15, 6  }
{   10, 9,  8,  7  }
```

<details><summary><b>Solution</b> 👀</summary> 
<p>

###### (no solution)

```java

```

</p>
</details>

### Task 2

Rotate a tow-dimensional array clockwise (to simplify the task assume that the array has an 
even number of rows and columns – 4x4, 6x6 etc...)

Example:

Before rotation:

```
{ 1     12   13     5 }
{ 6     17   8      4 }
{ 3     2    13     8 }
{ 0     14   5      2 }
```    

After rotation:

```
{ 0     3    6      1 }
{ 14    2    17    12 }
{ 5     13   8     13 }
{ 2     8    4      5 }
``` 

> The solution of this task uses an additional method `printMatrix`, which is used to print the content of the 
array in each iteration of the loop along with the end result.

<details><summary><b>Solution</b> 👀</summary> 
<p>

###### solution 1 (with an additional array)

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

    int[][] rotatedMatrix = new int[matrix[0].length][matrix.length];

    for (int col = 0; col < matrix.length; col++) {
        for (int row = 0; row < matrix[col].length; row++) {

            int lastRow = matrix.length - col - 1;

            rotatedMatrix[row][col] = matrix[lastRow][row];
        }

        printMatrix(rotatedMatrix);
    }

    System.out.println("===============");
    printMatrix(rotatedMatrix);
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

###### solution 2 (without an additional array)

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

> Note how each of the elements changes position. From which row and column the value is transferred.
Here is an [example solution](https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/)
that contains a nice illustration of the solution (wit the only difference that the matrix is rotated counter clockwise)


</p>
</details>

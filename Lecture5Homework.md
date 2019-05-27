# Homework Lecture 5
#java course#

## Two Dimensional Arrays 🐫 

### Task 1

Да се напише програма която изисква от потребителя да въведе
2 числа n и m. След това да се построи матрица с размер n x m по следният
начин (примерите са дадени за въведени n=4 и m=4). Няма ограничение n да бъде равно на m:

#### 1.1

- Пример:
    ```
    {   1,  5,  9,  13  }
    {   2,  6,  10, 14  }
    {   3,  7,  11, 15  }
    {   4,  8,  12, 16  }
    ```

- solution

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
    > Обхождаме първо колоните и после редовете. За това във външния `for` итерираме `col`,
    а във вътрешния итерираме `row` (обратно на това което правихме до сега)
    

#### 1.2

- Пример:

    ```
    {   1,  8,  9,  16  }
    {   2,  7,  10, 15  }
    {   3,  6,  11, 14  }
    {   4,  5,  12, 13  }
    ```

- solution 1

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
    > В зависимост от това дали ще обходим четна или нечетна колона определяме, от къде
    да започнем да въртим вложения цикъл. В единия случай е от `0...rowCount`,
    а в другия от `rowCount...0`

- solution 2

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
    > В зависимост от това дали сме на четна/нечетна колона определяме индеска на реда,
    който трябва да достъпим

#### 1.3.1

- Пример:

    ```
    {   1,  3,  6,  10  }
    {   2,  5,  9,  13  }
    {   4,  8,  12, 15  }
    {   7,  11, 14, 16  }
    ```

- solution
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
    > Итерираме матрицата по диагонали започвайки от горе в ляво.

#### 1.3.2 (не е решена цялата)

- Пример:

    ```
    {   7,  11, 14, 16  }
    {   4,  8,  12, 15  }
    {   2,  5,  9,  13  }
    {   1,  3,  6,  10  }
    ```

- solution

    ```java
    int rowCount = 4;
    int colCount = 4;
    int[][] matrix = new int[rowCount][colCount];
    
    int counter = 1;
    
    for (int row = rowCount - 1; row >= 0; row--) {
        for (int col = 0; col < colCount - row; col++) {
    
            int diagonalRow = row + col;
            
            if (row < rowCount && col < colCount) {
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

#### 1.4
- Пример:
    ```
    {   1,  2,  3,  4  }
    {   12, 13, 14, 5  }
    {   11, 16, 15, 6  }
    {   10, 9,  8,  7  }
    ```

- solution
```java

```

### Task 2

Да се завърти двумерен масив (за по-лесно квадратен с четен брой елементи – 4х4, 6х6 и т.н.) 
по часовниковата стрелка:
Например за дадената матрица:

```
{ 1     12   13     5 }
{ 6     17   8      4 }
{ 3     2    13     8 }
{ 0     14   5      2 }
```    
След завъртането да се получи:
```
{ 0     3    6      1 }
{ 14    2    17    12 }
{ 5     13   8     13 }
{ 2     8    4      5 }
``` 


> Разгледайте как се променя позицият на всеки елемент поотделно. От кой ред и коя колона в кой ред и коя колона отива.  
Ето [примерно решение](https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/) с добра илюстрация 
(с тази разлика че върти матрицата на обратно) 💊

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
    > Използван е допълнителент метод `printMatrix`, чрез който се принтира съдържанието на
    матрицата при всяка итерация на цикъла, както и крайното и състояние.
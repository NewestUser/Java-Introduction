package lecture5;


public class Lecture5 {

    public static void main(String[] args) {

    }

    private static void task1CreateAndPrintMatrix() {
        int[][] matrix = new int[2][3];

        matrix[0][1] = 555;

        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[\t");

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }

            System.out.println("]\t");
        }
    }

    private static void task2RotateMatrixClockWise() {

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

}

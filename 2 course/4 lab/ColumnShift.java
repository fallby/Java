/*
* Выполнить циклический сдвиг каждого столбца заданной матрицы на некоторое количество
* позиций вниз так, чтобы максимальный элемент каждого столбца оказался в его низу.
*/

import java.util.Scanner;
import java.lang.Math;

public class ColumnShift {

    // функция ищет максимальный элемент в каждом столбце матрицы и сдвигает его так, что он оказывается в конце столбца
    // вход: целочисленная матрица matrix
    public static void maxElementDown(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int tmp,imax,max;

        for (int j=0; j < cols; j++) {
            imax=0;
            // поиск индекса максимального элемента столбца
            for (int i=0; i < rows; i++) {
                if (matrix[i][j] >= matrix[imax][j]) {
                    imax=i;
                }
            }

            max=matrix[imax][j];
            // сдвиг столбцов
            while (matrix[rows - 1][j] != max) {
                tmp = matrix[0][j];
                for (int k = 0; k < rows - 1; k++) {
                    matrix[k][j] = matrix[k + 1][j];
                }
                matrix[rows - 1][j] = tmp;
            }
        }
    }

    // функция выводит матрицу на экран
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for( int j = 0; j < matrix[i].length; j++) {
                System.out.print("  " + matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите размер матрицы: ");
        Scanner console = new Scanner(System.in);
        int row = console.nextInt();
        int column = console.nextInt();
        int[][] matrix = new int[row][column];

        // заполнение матрицы случайными числами
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = (int) ((Math.random() * 100));
            }
        }
        
        System.out.println("Исходная матрица: ");
        printMatrix(matrix);

        System.out.println("Матрица с максимальным элементом внизу: ");
        maxElementDown(matrix);
        printMatrix(matrix);

        console.close();
    }
}

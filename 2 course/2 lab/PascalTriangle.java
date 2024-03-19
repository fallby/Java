/*
* Дано натуральное число n. Напечатать треугольник Паскаля, состоящий из n строк.
*/
import java.util.Scanner;

public class PascalTriangle {
    public static void printPascalTriangle(int n) {
        for (int line = 1; line <= n; line++) {
            for (int j = 0; j <= n - line; j++) {
                System.out.print(" ");
            }

            int k = 1;
            for (int i = 1; i <= line; i++) {
                System.out.print(k + " ");
                k = k * (line - i) / i;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите n: ");
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();

        printPascalTriangle(n);
    }
}

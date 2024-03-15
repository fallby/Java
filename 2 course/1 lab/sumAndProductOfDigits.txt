/*
* Дано натуральное число n. Найти сумму и произведение цифр в десятичной записи 
* этого числа
*/
import java.util.Scanner;

public class sumAndProductOfDigits {
    public static int sumOfDigits(int number)
    {
        int sum = 0;
        while(number != 0){
            sum += (number%10);
            number = number/10;
        }
        return sum;
    }

    public static int productOfDigits(int number)
    {
        int product = 1;
        while(number != 0){
            product *= (number%10);
            number = number/10;
        }
        return product;
    }

    public static void main(String [] args)
    {
        System.out.println("Введите число: ");
        Scanner console = new Scanner(System.in);
        int number = console.nextInt();

        int sum = sumOfDigits(number);
        int product = productOfDigits(number);

        System.out.println("Сумма цифр числа: " + sum + "\nПроизведение цифр числа: " + product);

    }
}

/* * Дан линейный целочисленный массив, заполняемый с клавиатуры. 
 * Подсчитать, сколько различных значений принимают элементы массива.  * Вариант №4.
 */
import java.util.Arrays;
import java.util.Scanner;
public class UniqueElements { 
  //функция считает количество различных элементов в массиве
 //вход: массив array, количество элементов в массиве arrayLength //выход: количество различных элементов
 public static int findUniqueElements(int[] array, int arrayLength) 
 {  
    int countOfUniqueElements = 1;
    //сортировка массива по возрастанию
    Arrays.sort(array);  
    for (int i = 0; i < arrayLength-1; i++) {
      if (array[i] != array[i + 1]) {    
        countOfUniqueElements += 1;
      }  
    }
    return countOfUniqueElements;
 }
  
  public static void main(String[] args) {
    System.out.println("Введите длину массива: ");         
    Scanner console = new Scanner(System.in);
    
    int arrayLength = console.nextInt();         
    int[] array = new int[arrayLength];
         //ввод элементов массива
    System.out.println("Введите элементы массива: ");         
    for (int i = 0; i < arrayLength; i++) {
             array[i] = console.nextInt();         
    }
         //вывод исходного массива
         System.out.println("Исходный массив: " + Arrays.toString(array));
         //вывод количества различных элементов массива         System.out.println("Количество различных элементов массива: " + findUniqueElements(array, arrayLength));
         console.close();
     }
}

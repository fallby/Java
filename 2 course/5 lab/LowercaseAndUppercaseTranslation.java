///*//* Во входном текстовом файле дана строка символов, содержащая слова. 
// Записать в выходной файл слова данной строки так: // каждое четное по номеру слово в нижнем регистре, 
// каждое нечетное слово – в верхнем.//* Вариант №4.
//*/
import java.io.*;
public class LowercaseAndUppercaseTranslation {    
  //функция принимает на вход файл и читает его, считывая каждый символ и 
  //добавляя в resultingString    
  private static String readFromFile(InputStream inputStreamFile) throws IOException {
        StringBuilder resultingString = new StringBuilder();        
        int symbol;
        while ((symbol = inputStreamFile.read()) != -1) {            
          resultingString.append((char) symbol);
        }        
        return resultingString.toString(); 
    }
    //функция принимает на вход строку, делит её на слова и добавляет     
    // в массив words. если слово по порядку четное, то функция 
    // переводит её в нижний регистр, если нечетное - в верхний.     
    // возвращает обработанную строку 
    private static String replacingTheRegister(String resultingString) {        
      String[] words = resultingString.split("\\s+");
      StringBuilder line = new StringBuilder();        
      for (int i = 0; i < words.length; i++) {
        if (i % 2 != 0) {             
              line.append(words[i].toLowerCase()).append(" ");
            } else {             
              line.append(words[i].toUpperCase()).append(" ");
            }        
        }
        return line.toString();    
    }
    // функция принимает на вход строку и записывает её в файл
    private static void writeToFile(OutputStream outputStreamFile, String line) throws IOException {        
      outputStreamFile.write(line.getBytes()); 
    }
    public static void main(String[] args) {
        try {
            FileInputStream inputStreamFile = new FileInputStream("input.txt");            
            // вызываем функцию readFromFile и записываем результат в строку resultingString
            String resultingString = readFromFile(inputStreamFile);            
            inputStreamFile.close();
            String line = replacingTheRegister(resultingString);
            FileOutputStream outputStreamFile = new FileOutputStream("output.txt");
            // вызываем функцию writeToFile для того, чтобы записать             
            // обработанную строку в новый файл
            writeToFile(outputStreamFile, line);            
            outputStreamFile.close();
            System.out.println("Результат успешно записан в output.txt");
        } catch (IOException e) {            
          System.out.println("Ошибка файла: " + e);
        }    
    }
}

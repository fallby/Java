import java.util.Arrays;
/*
Группа. Определить класс, описывающий данные студенческой группы. По группе хранить информацию: название специальности, индекс группы, 
текущее количество студентов, фамилии студентов, имена студентов, отчества студентов. Реализовать клонирование объектов класса, 
сортировку списка студентов по фамилии-имени-отчеству. 
*/
public class GroupRun {     
  public static void main(String[] args) {
     // Список студентов          
        Group g1 = new Group ("ПИ", "ОБ-09.03.03-21" , 4);              
        g1.addStudent(new Student("Попов", "Иван", "Викторович"));
        g1.addStudent(new Student("Абашева", "Марина", "Игоревна"));        
        g1.addStudent(new Student("Попов", "Олег", "Игоревич"));
        g1.addStudent(new Student("Зорин", "Артём", "Семенович"));        
        //Вывод информации о группе на экран               
        System.out.println("Группа:");
        System.out.println("g1:" + g1);         
        //Сортировка списка студентов по алфавиту        
        g1.sortStudents();  
        //Вывод информации о группе с отсортированным списком студентов
        System.out.println("Отсортированный список группы:");                
        System.out.println("g1:" + g1);
        //Клонирование группы g1
        Group g2 = g1.clone();                 
        //Изменение индекса группы g2
        g2.setIndex("ОБ-09.03.03-31");        
        System.out.println("Группа:");        
        System.out.println("g1:" + g1);        
        System.out.println("Группа:");        
        System.out.println("g2:" + g2);    
  }
}

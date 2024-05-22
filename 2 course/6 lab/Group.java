import java.util.Arrays;
/*
 * Класс Group хранит информацию о специальности, индексе группы и количестве студентов 
*/

public class Group implements Cloneable {    
    private String specialty;
    private String index;    
    private int countOfStudents = 0;
    private Student[] students;
    public String getSpecialty() {        
      return specialty;
    }
    public void setSpecialty(String specialty) {        
      this.specialty = specialty;
    }
    public String getIndex() {        
      return index;
    }
    public void setIndex(String index) {        
      this.index = index;
    }
    public int getCountOfStudents() {
        return countOfStudents;    
    }
    public void setCountOfStudents(int countOfStudents) {
        this.countOfStudents = countOfStudents;    
    }
    public Student[] getStudents() {
        return students;    
    }
    public void setStudents(Student[] students) {
        this.students = students;    
    }
    // конструктор класса    
    public Group(String specialty, String index, int countOfStudents) {
        this.specialty =specialty;        
    this.index =index;
       // this.countOfStudents =countOfStudents;        
    this.students = new Student[countOfStudents];
    }
    public String toString() {        
      return "Group [specialty = " + specialty + ", index = " + index + ", countOfStudents = " + countOfStudents + " \n students = " + Arrays.toString(students) + " ]";
    }
    // функция позволяет клонировать объект класса Group
    public Group clone(){
        try{Group copy=(Group)super.clone();                
            copy.students=(Student[])
                        students.clone();return copy;                
           }
        catch(CloneNotSupportedException e){                
          throw new InternalError();
        }    
    }
    public int addStudent(Student student){
        if (countOfStudents < students.length){            
          students[countOfStudents++] = student;
            return countOfStudents;        
        }
        else            
          return -1;
    }
    public void sortStudents() {        
      Arrays.sort(students);
    }
}

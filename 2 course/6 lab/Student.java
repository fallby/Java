/*
 * Класс Student хранит информацию о студенте: фамилия, имя, отчество.
 */
public class Student implements Comparable<Student>{
    private String surname;
    private String name;
    private String patronymic;

    public Student() {
    }

    public String getSurname() {
        return surname; }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    // конструтор класса 
    public Student(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public String toString() {
        return "Student [surname = " + surname + ", name = " + name + ", patronymic = " + patronymic + " ]\n";
    }

    public int compareTo(Student student){
        if (surname.compareTo(student.getSurname()) != 0)
            return surname.compareTo(student.getSurname());
        else if (name.compareTo(student.getName()) != 0)
            return name.compareTo(student.getName());
        else
            return patronymic.compareTo(student.getPatronymic());
    }

}

/*
Сотрудники.  Сотрудники  организации  (ТабельныйНомер,  Фамилия,  Имя)  бывают
штатными работниками (СНИЛС) и внешними совместителями (основное место работы)
 */
public class EmployeeRun {
    public static void main(String[] args) {
        
        FullTimeEmployee fullTimeEmployee1 = new FullTimeEmployee(544, "Попыткин", "Игорь",8, 110, "123-456");
        FullTimeEmployee fullTimeEmployee2  = new FullTimeEmployee(961, "Симплов", "Алексей", 9, 100,"789-987" );
        ExternalPartTimeEmployee externalPartTimeEmployee1 = new ExternalPartTimeEmployee(1762, "Бобров", "Артём", 3, 100, "Шеф-повар в ресторане", 20000);
        ExternalPartTimeEmployee externalPartTimeEmployee2 = new ExternalPartTimeEmployee(52, "Комарова", "Елена", 4, 110, "Преподаватель фортепиано", 15000);

        Employee[] array = new Employee[4];
        array[0] = fullTimeEmployee1;
        array[1] = fullTimeEmployee2;
        array[2] = externalPartTimeEmployee1;
        array[3] = externalPartTimeEmployee2;

        for (Employee employee : array) {
            System.out.println(employee);
        }
    }
}

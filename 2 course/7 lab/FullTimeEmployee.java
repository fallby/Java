public class FullTimeEmployee extends Employee {

    private String snils;

    public FullTimeEmployee(int serviceNumber, String surname, String name, int numberOfWorkingHours, int hourlyPayment, String snils) {
        super(serviceNumber,surname, name, numberOfWorkingHours, hourlyPayment);
        this.snils = snils;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public String toString() {
        return "FullTimeEmployee [\n Табельный номер: " + serviceNumber + "\n Фамилия: " + surname + "\n Имя: " + name + "\n Снилс:" + snils +
                "\n Количество рабочих часов: " + numberOfWorkingHours +  "\n Почасовая оплата: " + hourlyPayment + "\n Зарплата: " + salary() + "]\n";
    }

    public int salary() {
        return getNumberOfWorkingHours() * getHourlyPayment();
    }
}

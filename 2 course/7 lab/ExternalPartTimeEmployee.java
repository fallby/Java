public class ExternalPartTimeEmployee extends Employee {
    private String mainJob;
    private int salaryAtMainJob;

    public ExternalPartTimeEmployee(int serviceNumber, String surname, String name, int numberOfWorkingHours, int hourlyPayment, String mainJob, int salaryAtMainJob) {
        super(serviceNumber,surname, name, numberOfWorkingHours, hourlyPayment);
        this.mainJob = mainJob;
        this.salaryAtMainJob = salaryAtMainJob;
    }

    public String getMainJob() {
        return mainJob;
    }

    public void setMainJob(String mainJob) {
        this.mainJob = mainJob;
    }

    public String getSalaryAtMainJob() {
        return mainJob;
    }

    public void setSalaryAtMainJob(int salaryAtMainJob) {
        this.salaryAtMainJob = salaryAtMainJob;
    }

    public String toString() {
        return "FullTimeEmployee [\n Табельный номер: " + serviceNumber + "\n Фамилия: " + surname + "\n Имя: " + name + "\n Основная работа: " + mainJob +
                "\n Количество рабочих часов: " + numberOfWorkingHours +  "\n Почасовая оплата: " + hourlyPayment +
                "\n Зарплата на основной работе: " + salaryAtMainJob + "\n Общая зарплата: " + salary() + "]\n";
    }

    public int salary() {
        return getNumberOfWorkingHours() * getHourlyPayment() + salaryAtMainJob;
    }
}

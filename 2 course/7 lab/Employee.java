public abstract class Employee {
    protected int serviceNumber;
    protected String surname;
    protected String name;
    protected int numberOfWorkingHours;
    protected int hourlyPayment;

    public Employee(int serviceNumber, String surname, String name, int numberOfWorkingHours, int hourlyPayment) {
        this.serviceNumber = serviceNumber;
        this.surname = surname;
        this.name = name;
        this.numberOfWorkingHours = numberOfWorkingHours;
        this.hourlyPayment = hourlyPayment;
    }

    public int getServiceNumber() {
        return serviceNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfWorkingHours() {
        return numberOfWorkingHours;
    }

    public int getHourlyPayment() {
        return hourlyPayment;
    }

    public void setServiceNumber(int serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfWorkingHours(int numberOfWorkingHours) {
        this.numberOfWorkingHours = numberOfWorkingHours;
    }

    public void setHourlyPayment(int hourlyPayment) {
        this.hourlyPayment = hourlyPayment;
    }

    public abstract int salary();

}

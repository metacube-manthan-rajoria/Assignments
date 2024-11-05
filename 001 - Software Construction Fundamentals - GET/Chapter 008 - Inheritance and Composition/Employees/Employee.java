package Employees;

abstract public class Employee implements Comparable<Employee>{
    private static int idInitilizer = 0;
    private final int employeeId;
    private final String employeeName;

    public Employee(String employeeName) {
        this.employeeId = idInitilizer++;
        this.employeeName = employeeName;
    }

    public int getId() {
        return this.employeeId;
    }

    public String getName() {
        return this.employeeName;
    }

    abstract public double getBasicSalary();

    abstract public double getBonus();

    abstract public double getCompensation();

    @Override
    public int compareTo(Employee other) {
        return employeeId - other.getId();
    }
}

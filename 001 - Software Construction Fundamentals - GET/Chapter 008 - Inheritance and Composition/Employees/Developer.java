package Employees;

public class Developer extends Employee{
    private final double employeeSalary;
    private final double employeeBonus;
    
    public Developer(String employeeName, double employeeSalary, double employeeBonus){
        super(employeeName);
        this.employeeSalary = employeeSalary;
        this.employeeBonus = employeeBonus;
    }

    public double getBasicSalary() {
        return this.employeeSalary;
    }

    public double getBonus() {
        return this.employeeBonus;
    };

    public double getCompensation() {
        return this.employeeSalary + this.employeeBonus;
    }
}

public class Employee implements EmployeeInterface {
    private static int idInitilizer = 0;
    private final int employeeId;
    private final String employeeName;
    private final int employeeDepartmentId;
    private final double employeeSalary;
    private final double employeeBonus;

    public Employee(String employeeName, double employeeSalary, double employeeBonus, int employeeDepartmentId) {
        this.employeeId = idInitilizer++;
        this.employeeName = employeeName;
        this.employeeDepartmentId = employeeDepartmentId;
        this.employeeSalary = employeeSalary;
        this.employeeBonus = employeeBonus;
    }

    public int getId() {
        return this.employeeId;
    }

    public String getName() {
        return this.employeeName;
    }

    public int getEmployeeDepartmentId(){
        return this.employeeDepartmentId;
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

abstract public class Employee {
    private static int idInitilizer = 0;
    private final int employeeId;
    private final String employeeName;
    private final int employeeDepartmentId;

    public Employee(String employeeName, int employeeDepartmentId) {
        this.employeeId = idInitilizer++;
        this.employeeName = employeeName;
        this.employeeDepartmentId = employeeDepartmentId;
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

    abstract public double getBasicSalary();

    abstract public double getBonus();

    abstract public double getCompensation();
}

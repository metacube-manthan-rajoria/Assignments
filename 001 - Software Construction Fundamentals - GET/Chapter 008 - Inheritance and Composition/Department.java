import java.util.List;
import java.util.ArrayList;

public class Department {
    private static int idInitilizer = 0; 
    private final int departmentId;
    private final String departmentName;
    private List<Employee> employees;

    public Department(String departmentName){
        this.departmentId = idInitilizer++;
        this.departmentName = departmentName;
        employees = new ArrayList<Employee>();
    }

    private int addEmployee(String employeeName, double employeeSalary, double employeeBonus){
        Employee employee = new Employee(employeeName, employeeSalary, employeeBonus, departmentId);
        employees.add(employee);
        return employees.size();
    }
    public int join(String employeeName, double employeeSalary, double employeeBonus){
        return addEmployee(employeeName, employeeSalary, employeeBonus);
    }

    private int removeEmployee(int employeeId){
        employees.remove(employeeId);
        return employees.size();
    }
    public int relieve(int employeeId){
        return removeEmployee(employeeId);
    }

    public String getDepartmentName(){
        return this.departmentName;
    }
    
    public List<Employee> getEmployees(){
        List<Employee> employeesCopy = new ArrayList<Employee>();
        employeesCopy.addAll(employees);
        return employeesCopy;
    }
}

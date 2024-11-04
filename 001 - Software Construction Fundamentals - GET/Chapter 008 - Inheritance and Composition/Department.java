import java.util.List;
import java.util.ArrayList;

public class Department {
    private static int idInitilizer = 0;
    private final int departmentId;
    private final String departmentName;
    private List<Employee> employees;

    public Department(String departmentName) {
        this.departmentId = idInitilizer++;
        this.departmentName = departmentName;

        if(!this.departmentName.equals("")){
            employees = new ArrayList<Employee>();
        }else{
            idInitilizer--;
            throw new IllegalArgumentException("Empty Department Name not allowed.");
        }
    }

    private int addEmployee(String employeeName, double employeeSalary, double employeeBonus) {
        if ("".equals(employeeName) || employeeSalary < 0 || employeeBonus < 0) {
            return -1;
        }

        Employee employee = new Employee(employeeName, employeeSalary, employeeBonus, departmentId);
        employees.add(employee);
        return employees.size();
    }

    public int join(String employeeName, double employeeSalary, double employeeBonus) {
        return addEmployee(employeeName, employeeSalary, employeeBonus);
    }

    private int removeEmployee(int employeeId) {
        if (employeeId >= employees.size())
            return -1;

        employees.remove(employeeId);
        idInitilizer--;
        return employees.size();
    }

    public int relieve(int employeeId) {
        return removeEmployee(employeeId);
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public List<Employee> getEmployees() {
        List<Employee> employeesCopy = new ArrayList<Employee>();
        employeesCopy.addAll(employees);
        return employeesCopy;
    }
}

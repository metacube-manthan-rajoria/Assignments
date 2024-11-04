import java.util.ArrayList;
import java.util.List;

import Departments.Department;
import Employees.Employee;

public final class Organization {
    private final List<Department> departments;

    public Organization() {
        departments = new ArrayList<Department>();
    }

    public int addDepartment(Department department) {
        if (!"".equals(department.getDepartmentName())) {
            departments.add(department);
        }

        return departments.size();
    }

    public Department getDepartment(int departmentId) {
        return departments.get(departmentId);
    }

    List<Employee> getAllEmployees() {
        List<Employee> result = new ArrayList<>();
        for (Department department : departments) {
            result.addAll(department.getEmployees());
        }
        return result;
    }

    public void printPaySlips() {
        List<Employee> employeesList = getAllEmployees();
        for (Employee employee : employeesList) {
            String slip = new Payroll(employee).toString();
            System.out.println(slip + "\n");
        }
    }
}

class Main {
    public static void main(String[] args) {
        try{
            Organization org = new Organization();

            Department dept1 = new Department("Finance");
            Department dept2 = new Department("IT");

            dept1.join("a", 400000,9);
            dept2.join("b", 20000,9);

            org.addDepartment(dept1);
            dept1.join("c", 70, 80);
            org.addDepartment(dept2);
            
            org.printPaySlips();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
package Departments;

import Employees.Employee;
import java.util.HashMap;

abstract public class Department {
    protected final String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;

        if(this.departmentName.equals("")) {
            throw new IllegalArgumentException("Empty Department Name not allowed.");
        }
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    // Abstract Methods for Department
    abstract public boolean join(Employee employee);

    abstract public boolean relieve(Employee employee);

    abstract public HashMap<Employee, Integer> getEmployees();
}

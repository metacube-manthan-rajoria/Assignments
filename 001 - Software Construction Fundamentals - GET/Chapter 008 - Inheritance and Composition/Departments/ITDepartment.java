package Departments;

import Employees.Developer;
import Employees.Employee;
import java.util.HashMap;

public class ITDepartment extends Department{
    private HashMap<Developer, Integer> employees;

    public ITDepartment(String departmentName){
        super(departmentName);
        employees = new HashMap<Developer, Integer>();
    }

    private boolean addEmployee(String employeeName, double employeeSalary, double employeeBonus) {
        if ("".equals(employeeName) || employeeSalary < 0 || employeeBonus < 0) {
            return false;
        }

        Developer employee = new Developer(employeeName, employeeSalary, employeeBonus);
        employees.put(employee, 1);
        return true;
    }

    public boolean join(Employee employee) {
        String employeeName = employee.getName();
        double employeeSalary = employee.getBasicSalary();
        double employeeBonus = employee.getBonus();

        return addEmployee(employeeName, employeeSalary, employeeBonus);
    }

    private boolean removeEmployee(Employee employee) {
        int isEmployeePresent = employees.getOrDefault(employee, 0);
        if (isEmployeePresent == 0)
            return false;

        employees.remove(employee);
        return true;
    }

    public boolean relieve(Employee employee) {
        return removeEmployee(employee);
    }

    public HashMap<Employee, Integer> getEmployees() {
        HashMap<Employee, Integer> employeesCopy = new HashMap<Employee, Integer>();
        employeesCopy.putAll(employees);
        return employeesCopy;
    }
}
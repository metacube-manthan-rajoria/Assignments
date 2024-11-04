package Departments;

import Employees.Manager;
import Employees.Employee;
import java.util.HashMap;

public class ManagerialDepartment extends Department{
    private HashMap<Manager, Integer> employees;

    public ManagerialDepartment(String departmentName){
        super(departmentName);
        employees = new HashMap<Manager, Integer>();
    }

    private boolean addEmployee(String employeeName, double employeeSalary, double employeeBonus) {
        if ("".equals(employeeName) || employeeSalary < 0 || employeeBonus < 0) {
            return false;
        }

        Manager employee = new Manager(employeeName, employeeSalary, employeeBonus);
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

    public HashMap<Manager, Integer> getEmployees() {
        HashMap<Manager, Integer> employeesCopy = new HashMap<Manager, Integer>();
        employeesCopy.putAll(employees);
        return employeesCopy;
    }
}

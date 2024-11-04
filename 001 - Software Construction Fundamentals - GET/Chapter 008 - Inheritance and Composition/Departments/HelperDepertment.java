package Departments;

import Employees.Helper;
import Employees.Employee;
import java.util.HashMap;

public class HelperDepertment extends Department{
    private HashMap<Helper, Integer> employees;

    public HelperDepertment(String departmentName){
        super(departmentName);
        employees = new HashMap<Helper, Integer>();
    }

    private boolean addEmployee(String employeeName, double employeeSalary, double employeeBonus) {
        if ("".equals(employeeName) || employeeSalary < 0 || employeeBonus < 0) {
            return false;
        }

        Helper employee = new Helper(employeeName, employeeSalary, employeeBonus);
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

    public HashMap<Helper, Integer> getEmployees() {
        HashMap<Helper, Integer> employeesCopy = new HashMap<Helper, Integer>();
        employeesCopy.putAll(employees);
        return employeesCopy;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import Departments.Department;
import Departments.ITDepartment;
import Departments.ManagerialDepartment;
import Departments.QADepartment;
import Departments.HelperDepertment;
import Employees.Employee;
import Employees.Developer;
import Employees.Manager;
import Employees.Tester;
import Employees.Helper;

public final class Organization {
    private final HashMap<Department, Integer> departments;

    public Organization() {
        departments = new HashMap<Department, Integer>();
    }

    /**
     * Adds a department to the Organization
     * 
     * @param department object of any 4 types
     * @return boolean if department was added.
     */
    public boolean addDepartment(Department department) {
        int isDepartmentAdded = departments.getOrDefault(department, 0);
        if ("".equals(department.getDepartmentName()) || isDepartmentAdded == 1)
            return false;

        departments.put(department, 1);
        return true;
    }

    /**
     * Returns a copy of all employees hashmap
     * 
     * @return Hashmap<Employee, Integer> of all employees in organisation
     */
    HashMap<Employee, Integer> getAllEmployees() {
        HashMap<Employee, Integer> result = new HashMap<Employee, Integer>();
        for (Department department : departments.keySet()) {
            result.putAll(department.getEmployees());
        }
        return result;
    }

    /**
     * Returns a sorted copy of getAllEmployees function
     * 
     * @return ArrayList<Employee> of all employees
     */
    public ArrayList<Employee> getSortedEmployeesList() {
        HashMap<Employee, Integer> employeesList = getAllEmployees();
        ArrayList<Employee> sortedEmployeesList = new ArrayList<Employee>();
        for (Employee employee : employeesList.keySet()) {
            sortedEmployeesList.add(employee);
        }
        Collections.sort(sortedEmployeesList);
        return sortedEmployeesList;
    }

    /**
     * Prints payslips of all employees
     */
    public void printPaySlips() {
        ArrayList<Employee> sortedEmployeesList = getSortedEmployeesList();

        for (Employee employee : sortedEmployeesList) {
            String slip = new Payroll(employee).toString();
            System.out.println(slip + "\n");
        }
    }
}

class Main {
    public static void main(String[] args) {
        try {
            Organization org = new Organization();

            Department dept1 = new ITDepartment("IT");
            Department dept2 = new ManagerialDepartment("Finance");
            Department dept3 = new HelperDepertment("Finance");
            Department dept4 = new QADepartment("Finance");

            Employee e1 = new Developer("Raja Pari", 10000000, 0);
            Employee e2 = new Developer("Hulla Hullare Hulle Hulle-Hulle", 1300000, 75000);
            Employee e3 = new Manager("Shona", 1200000, 100000);
            Employee e4 = new Tester("Alexandrovich Kasperov", 500000, 20000);
            Employee e5 = new Helper("Mukesh Panwala", 300000, 10000);
            Employee e6 = new Helper("Captain Marvel", 400000, 10000);

            dept1.join(e1);
            dept1.join(e2);
            dept2.join(e3);
            dept4.join(e4);
            dept3.join(e5);
            dept3.join(e6);

            org.addDepartment(dept1);
            org.addDepartment(dept2);
            org.addDepartment(dept3);
            org.addDepartment(dept4);

            org.printPaySlips();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
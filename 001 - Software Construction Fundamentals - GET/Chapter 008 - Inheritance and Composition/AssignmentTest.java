import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import Departments.Department;
import Departments.HelperDepertment;
import Departments.ITDepartment;
import Departments.ManagerialDepartment;
import Departments.QADepartment;
import Employees.Developer;
import Employees.Employee;
import Employees.Helper;
import Employees.Manager;
import Employees.Tester;

public class AssignmentTest {
    Organization org;

    public AssignmentTest(){
        org = new Organization();

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
    }

    @Test
    public void payoutTest() {
        ArrayList<Employee> empList = org.getSortedEmployeesList();
        Double taxableIncomeArray[] = new Double[empList.size()];

        int taxArrayIndex = 0;
        for (Employee employee : empList) {
            Payroll payroll = new Payroll(employee);
            taxableIncomeArray[taxArrayIndex] = payroll.getPayoutPerMonth();
            taxArrayIndex++;
        }

        Double output[] = { 583333.33, 91666.66, 86666.66, 41166.66, 24541.66, 32458.34 };
        assertArrayEquals(output, taxableIncomeArray);
    }

    @Test
    public void taxableIncomeTest() {
        ArrayList<Employee> empList = org.getSortedEmployeesList();
        Double taxableIncomeArray[] = new Double[empList.size()];

        int taxArrayIndex = 0;
        for (Employee employee : empList) {
            Payroll payroll = new Payroll(employee);
            taxableIncomeArray[taxArrayIndex] = payroll.getTaxableIncome();
            taxArrayIndex++;
        }

        Double output[] = { 250000.0, 22916.67, 21666.67, 2166.67, 1291.67, 1708.33 };
        assertArrayEquals(output, taxableIncomeArray);
    }
}

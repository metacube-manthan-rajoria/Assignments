import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
    @Test
    public void payoutTest() {
        Organization org = new Organization();

        Department dept1 = new ITDepartment("IT");
        Department dept2 = new ManagerialDepartment("Finance");
        Department dept3 = new HelperDepertment("Finance");
        Department dept4 = new QADepartment("Finance");

        Employee e1 = new Developer("Raja Pari", 1000000, 0);
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

        ArrayList<Employee> empList = org.getSortedEmployeesList();
        Double taxableIncomeArray[] = new Double[empList.size()];

        int taxArrayIndex = 0;
        for(Employee employee: empList){
            Payroll payroll = new Payroll(employee);
            taxableIncomeArray[taxArrayIndex] = payroll.getTaxableIncome();
            taxArrayIndex++;
        }

        Double output[] = {583333.33, 91666.66, 86666.66, 41166.66, 24541.66, 32458.34};
        assertArrayEquals(output, taxableIncomeArray);
    }

    // private static Stream<Arguments> maxMirrorStream() {
    //     return Stream.of(
    //             Arguments.of(new int[] { 1, 2, 3, 8, 9, 3, 2, 1 }, 3),
    //             Arguments.of(new int[] { 7, 1, 4, 9, 7, 4, 1 }, 2),
    //             Arguments.of(new int[] { 6, 5, 6, 4, 9, 7, 1, 4, 2, 7, 9, 2, 6, 5, 6 }, 3),
    //             Arguments.of(new int[] { 1, 2, 1, 4 }, 3),
    //             Arguments.of(new int[] { 1, 4, 5, 3, 5, 4, 1 }, 7),
    //             Arguments.of(new int[] { 1, 1, 2, 1, 1, 4 }, 3),
    //             Arguments.of(new int[] { 1, 4, 1, 5 }, 3),
    //             Arguments.of(new int[] { 1, 4, 1, 5, 5, 4, 1 }, 3),
    //             Arguments.of(new int[] { 1, 1, 1, 2, 1 }, 3),
    //             Arguments.of(new int[] { 10, 10 }, 2));
    // }

    // @ParameterizedTest
    // @MethodSource("maxMirrorStream")
    // public void maxMirrorTest(int arr[], int output) {
    //     ArrayList<Integer> arrList = new ArrayList<Integer>();

    //     for (int i = 0; i < arr.length; i++) {
    //         arrList.add(arr[i]);
    //     }

    //     ArrOperation arrop = new ArrOperation(arrList);
    //     assertEquals(output, arrop.maxMirror());
    // }
}

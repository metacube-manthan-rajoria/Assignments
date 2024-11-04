import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import Departments.Department;

public class AssignmentTest {
    @Test
    public void payoutTest(){
        Department dept1 = new Department("Founders");
        Department dept2 = new Department("Finance");
        Department dept3 = new Department("Admin");

        dept1.join("Head Arora Borealis", 100000, 20000);
        dept2.join("Rajni Gandha", 40000, 10000);
        dept2.join("Sastha Malik", 45000, 10000);
        dept3.join("Swastik Agarwal", 15000, 10000);
        dept3.join("Rahul Meena", 20000, 10000);
        dept3.join("V1", 18000, 10000);

        Organization organization = new Organization();
        organization.addDepartment(dept1);
        organization.addDepartment(dept2);
        organization.addDepartment(dept3);

        organization.printPaySlips();
    }
}

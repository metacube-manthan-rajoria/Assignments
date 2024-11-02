import java.util.ArrayList;
import java.util.List;

public final class Organization {
    private final List<Department> departments;

    public Organization(){
        departments = new ArrayList<Department>();
    }

    public int addDepartment(Department department){
        departments.add(department);
        return departments.size();
    }

    public Department getDepartment(int departmentId){
        return departments.get(departmentId);
    }

    List<Employee> getAllEmployees(){
        List<Employee> result = new ArrayList<>();
        for(Department department : departments){
            result.addAll(department.getEmployees());
        }
        return result;
    }
}

class Assignment {
    public static void main(String[] args) {
        Department dept1 = new Department("Founders");
        Department dept2 = new Department("Finance");
        Department dept3 = new Department("Admin");

        dept1.join("Head Arora Borealis", 100000, 20000);
        dept2.join("Rajni Gandha", 40000, 10000);
        dept2.join("Sastha Malik", 45000, 10000);
        dept3.join("Swastik Agarwal", 15000, 10000);
        dept3.join("Rahul Meena", 20000, 10000);
        dept3.join("V1", 18000, 10000);
    }
}
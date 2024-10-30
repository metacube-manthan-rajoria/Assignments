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
        



    }
}
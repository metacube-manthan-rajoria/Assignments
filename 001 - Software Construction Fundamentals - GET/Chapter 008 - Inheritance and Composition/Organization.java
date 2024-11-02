import java.util.ArrayList;
import java.util.List;

public final class Organization {
    private final List<Department> departments;

    public Organization(){
        departments = new ArrayList<Department>();
    }

    public int addDepartment(Department department){
        if(!"".equals(department.getDepartmentName())){
            departments.add(department);
        }
        
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
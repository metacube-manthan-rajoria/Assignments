# Problem Statement

Write a Payroll software that will dispatch salary and print payslips for a particular organization. Implement Inheritance and Composition concepts as discussed in the class.

### Details

- The system will have various types of employees implementing Inheritance
- There should abstract method in Employee class as, 
    - getBasicSalary()
    - getBonus()
    - getCompensation()
- The system will have various departments that will have employees specify to their departments. Departments will expose following additional methods like
    - boolean join(Employee)
    - boolean relieve(Employee)
    - List<Developer> getEmployees()
- The system will have an Organization class that will have departments. Organization will expose following additional methods like 
    - boolean addDepartment(Department)
    - List<Employee> getAllEmployees(), this will aggregate all the employees from all the departments
- Write a payroll class that will calculate tax and print the salary slip for all the employees of the organization
- Write JUnit to create a complete structure of one organization, a few departments and employees. And then print the salary slips for the created employees



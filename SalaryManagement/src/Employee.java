import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Employee {
    private String name;
    private String department;
    private double salary;

    

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //Filter employees acording to defined salary
    public List<Employee> filterEmployeesSalary(double salary, List<Employee> employees){

        List<Employee> filteredEmployees = new ArrayList<Employee>();
        if(employees.isEmpty()) return Collections.emptyList();

        for (Employee employee : employees) {
            if(employee.getSalary() >= salary){
                filteredEmployees.add(employee);
            }
        }

        return filteredEmployees;
    }

}

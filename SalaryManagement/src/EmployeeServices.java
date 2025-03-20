import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeServices {

    //Filter employees acording to defined salary
    //It's static method because we don't need create EmployeeServices object to use this function
    public static List<Employee> filterEmployeesSalary(double salary, List<Employee> employees){

        List<Employee> filteredEmployees = new ArrayList<Employee>();
        if(employees.isEmpty()) return Collections.emptyList();

        for (Employee employee : employees) {
            if(employee.getSalary() >= salary){
                filteredEmployees.add(employee);
            }
        }

        return filteredEmployees;
    }

    // Find highest salary employee
    public static Employee findHighestSalary(List<Employee> employees){

        if (employees.isEmpty()) throw new IllegalArgumentException("Employee list cannot be empty");

        Employee highestSalaryEmployee = null;
        double highestSalary = 0;

        for (Employee employee : employees) {
            //System.out.println(employee.getSalary());

            if(employee.getSalary() > highestSalary){
                highestSalaryEmployee = employee;
                highestSalary=employee.getSalary();
            }
        }

        return highestSalaryEmployee;
    }


}

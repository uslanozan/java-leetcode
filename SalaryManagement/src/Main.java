/*
3️⃣ Employee Salary Management (OOP + Stream API)
You have employee data in the following model:

class Employee {
String name;
String department;
double salary;
}
✅ Task:

Keep employees in List<Employee>.
Filter those with a salary greater than 5000.
Calculate the average salary by department. (Map<String, Double>)
Find the employee with the highest salary.
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Employee> employeeList = new ArrayList<>();

        Employee ozan = new Employee("Ozan Suslan","Software Engineer",90000);
        Employee ridvan = new Employee("Rıdvan Dilmen","Game Engine Engineer",100000);
        Employee emre = new Employee("Emre Shiny","AI Engineer",70000);
        Employee talha = new Employee("Talha Dev","Founder of Python 2 ",10);
        Employee issiz = new Employee("İşsiz Lavuk","Nothing ",0);

        employeeList.add(ozan);
        employeeList.add(ridvan);
        employeeList.add(emre);
        employeeList.add(talha);
        employeeList.add(issiz);

        List<Employee> salaryFilter = EmployeeServices.filterEmployeesSalary(70000,employeeList);
        
        for (Employee item : salaryFilter) {
            System.out.println(item.getName() + " Salary: " +((int)item.getSalary()));
        }

        System.out.println("-------------");

        Employee highestSalaryEmployee = EmployeeServices.findHighestSalary(employeeList);
        System.out.println("Highest salary: " + highestSalaryEmployee.getName() + " "+ (int)highestSalaryEmployee.getSalary());

    }
}

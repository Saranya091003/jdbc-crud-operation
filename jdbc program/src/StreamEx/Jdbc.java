package StreamEx;

import java.util.ArrayList;
import java.util.List;
import java.time.*;

public class Jdbc {

	public static void main(String[] args) {
		        IdbcDAO employeeDAO = new IdbcDAO();

		        // Save a new employee
		        Employee newEmployee = new Employee(1, "Saranya", "sales", 50000.0, LocalDate.of(2003, 10, 9), LocalDate.of(2022, 8, 18), "developer", "Bangalore");
		        employeeDAO.saveEmployee(newEmployee);

		        // Get an employee by ID
		        Employee employee = employeeDAO.getEmployeeById(1);
		        System.out.println(employee);

		        // Get all employees
		        List<Employee> employees = employeeDAO.getAllEmployees();
		        for (Employee emp : employees) {
		            System.out.println(emp);
		        }

		        // Update an employee's salary
		        employeeDAO.updateEmployeeSalary(1, 55000.0);
		        Employee updatedEmployee = employeeDAO.getEmployeeById(1);
		        System.out.println(updatedEmployee);

		        // Delete an employee
		        employeeDAO.deleteEmployee(1);
		        Employee deletedEmployee = employeeDAO.getEmployeeById(1);
		        System.out.println(deletedEmployee);  // Should print null
		        
		        //Display 2years of experience
		        List<Employee> employeesWithTwoYearsExperience = employeeDAO.getEmployeesWithTwoYearsExperience();
		        for (Employee emp : employeesWithTwoYearsExperience) {
		            System.out.println(emp);
		        }
		        
		    }
		

	}



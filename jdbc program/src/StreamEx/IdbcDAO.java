package StreamEx;
	import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
	import java.util.List;

	public class IdbcDAO {

	    public void saveEmployee(Employee employee) {
	        String sql = "INSERT INTO empss (id, name, dept, salary, dob, doj, designation, city) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, employee.getId());
	            pstmt.setString(2, employee.getName());
	            pstmt.setString(3, employee.getDept());
	            pstmt.setDouble(4, employee.getSalary());
	            pstmt.setDate(5, Date.valueOf(employee.getDob()));
	            pstmt.setDate(6, Date.valueOf(employee.getDoj()));
	            pstmt.setString(7, employee.getDesignation());
	            pstmt.setString(8, employee.getCity());
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public Employee getEmployeeById(int id) {
	        String sql = "SELECT * FROM empss WHERE id = ?";
	        Employee employee = null;
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                // Handle potential NULL date values
	                LocalDate dob = (rs.getDate("dob") != null) ? rs.getDate("dob").toLocalDate() : null;
	                LocalDate doj = (rs.getDate("doj") != null) ? rs.getDate("doj").toLocalDate() : null;
	                employee = new Employee(rs.getInt("id"),rs.getString("name"),rs.getString("dept"),rs.getDouble("salary"),dob,doj,rs.getString("designation"),rs.getString("city"));
	            }
	        }
	         catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return employee;
	    }

	    public List<Employee> getAllEmployees() {
	        String sql = "SELECT * FROM empss";
	        List<Employee> employees = new ArrayList<>();
	        try (Connection conn = DatabaseConnection.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            while (rs.next()) {
	                Employee employee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("dept"), rs.getDouble("salary"), rs.getDate("dob").toLocalDate(), rs.getDate("doj").toLocalDate(), rs.getString("designation"), rs.getString("city") );
	                employees.add(employee);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return employees;
	    }

	    public void updateEmployeeSalary(int id, double newSalary) {
	        String sql = "UPDATE empss SET salary = ? WHERE id = ?";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setDouble(1, newSalary);
	            pstmt.setInt(2, id);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteEmployee(int id) {
	        String sql = "DELETE FROM empss WHERE id = ?";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, id);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public List<Employee> getEmployeesWithTwoYearsExperience() {
	        List<Employee> twoYearsExperienceEmployees = new ArrayList<>();
	        String sql = "SELECT * FROM empss";

	        try (Connection conn = DatabaseConnection.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {

	            LocalDate currentDate = LocalDate.now();
	            while (rs.next()) {
	                LocalDate doj = (rs.getDate("doj") != null) ? rs.getDate("doj").toLocalDate() : null;
	                if (doj != null) {
	                    long yearsOfExperience = ChronoUnit.YEARS.between(doj, currentDate);

	                    if (yearsOfExperience >= 2) {
	                        LocalDate dob = (rs.getDate("dob") != null) ? rs.getDate("dob").toLocalDate() : null;
	                        Employee employee = new Employee(
	                            rs.getInt("id"),
	                            rs.getString("name"),
	                            rs.getString("dept"),
	                            rs.getDouble("salary"),
	                            dob,
	                            doj,
	                            rs.getString("designation"),
	                            rs.getString("city")
	                        );
	                        twoYearsExperienceEmployees.add(employee);
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return twoYearsExperienceEmployees;
	    }
	    
	}
	   
	    
	    




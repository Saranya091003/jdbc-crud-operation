package StreamEx;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Employee {
	private int id;
    private String name;
    private String dept;
    private double salary;
    private LocalDate dob;
    private LocalDate doj;
    private String designation;
    private String city;
    

    public Employee(int id, String name, String dept, double salary, LocalDate dob, LocalDate doj, String designation,
			String city) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.dob = dob;
		this.doj = doj;
		this.designation = designation;
		this.city = city;
	}
    public Employee(int id, String name, double salary) {
		// TODO Auto-generated constructor stub
    	this.id = id;
		this.name = name;
		this.salary = salary;
    	
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public LocalDate getDoj() {
		return doj;
	}


	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
	
	
	 public long getExperience() {
	        LocalDate currentDate = LocalDate.now();
	        return (doj != null) ? ChronoUnit.YEARS.between(doj, currentDate) : 0;
	    }

	 @Override
	    public String toString() {
	        return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + ", dob=" + dob + ", doj=" + doj + ", designation=" + designation + ", city=" + city + "]";
	    }
}



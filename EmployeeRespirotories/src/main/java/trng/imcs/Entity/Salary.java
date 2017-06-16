package trng.imcs.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Salary {
	
	@Id
	@GeneratedValue
	@Column(name ="employee_id")
	private Integer empNumber;
	


	private Double salary;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Employee employee;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + (int) (empNumber ^ (empNumber >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salary other = (Salary) obj;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (empNumber != other.empNumber)
			return false;
		return true;
	}

	public Salary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Salary(Double salary) {
		super();
		// TODO Auto-generated constructor stub
		this.salary = salary;
	}

	public Salary(Integer salary_id, Double salary, Employee employee) {
		super();
		this.empNumber = salary_id;
		this.salary = salary;
		this.employee = employee;
	}

	public long getSalary_id() {
		return empNumber;
	}

	public void setSalary_id(Integer salary_id) {
		this.empNumber = salary_id;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}

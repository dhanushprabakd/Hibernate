package trng.imcs.EmployeeRespirotories;

import trng.imcs.Entity.Employee;

public interface EmployeeDAO {
	Employee createEmployee(Employee student);
	void deleteEmployee(int  empid);
	Employee updateEmployee(Employee student);
	Employee findEmployee(int empid);

	
	public Employee viewRecordByHQL();
	public Employee viewRecordByCriteria();

}

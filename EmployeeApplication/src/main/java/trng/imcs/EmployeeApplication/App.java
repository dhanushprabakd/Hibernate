package trng.imcs.EmployeeApplication;

import java.util.Arrays;
import java.util.HashSet;

import trng.imcs.EmployeeRespirotories.EmployeeDAO;
import trng.imcs.EmployeeRespirotories.EmployeeDAOImpl;
import trng.imcs.EmployeeRespirotories.EmployeeImpl;
import trng.imcs.Entity.Addresses;
import trng.imcs.Entity.Employee;
import trng.imcs.Entity.Salary;
import trng.imcs.Util.HibernateUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	HibernateUtils.getSessionFactory();
		EmployeeDAO dao = new EmployeeDAOImpl();
		Employee newemployee = new Employee("Dhanush","P","M");
		Addresses address = new Addresses(1452L,75063L, "Malibu", "CA", "USA");
		Salary employeesalary = new Salary(12000.00);
		address.setEmployee(newemployee);
		newemployee.setAddress(new HashSet<Addresses>(Arrays.asList(address)));
		employeesalary.setEmployee(newemployee);
		newemployee.setSalary(employeesalary);
	 

		EmployeeImpl employeeimpl = new EmployeeImpl();
		employeeimpl.addRecords(newemployee, employeesalary, address);
		System.out.println("Name: "+employeeimpl.viewRecordByCriteria().getFirstName() + " "
				+ employeeimpl.viewRecordByCriteria().getLastName());
		System.err.println("Salary: "+employeeimpl.viewRecordByCriteria().getSalary().getSalary());
		System.out.println(employeeimpl.viewRecordByHQL().getFirstName() + " "
				+ employeeimpl.viewRecordByHQL().getLastName());    }
}

package trng.imcs.EmployeeRespirotories;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import trng.imcs.Entity.Employee;
import trng.imcs.Util.HibernateUtils;

public class EmployeeDAOImpl implements EmployeeDAO {
	SessionFactory sf = HibernateUtils.getSessionFactory();

	public Employee createEmployee(Employee employee) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Serializable identifier = session.save(employee);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return null;
	}

	public void deleteEmployee(int empid) {
		Session session = sf.openSession();
		Employee employee = findEmployee(empid);
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(employee);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	public Employee updateEmployee(Employee employee) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(employee);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return employee;
	}


	public Employee viewRecordByCriteria() {

		Session session = sf.openSession();

		Integer id = new Integer(1);

		try {
			session.beginTransaction();

			Criteria employeeCriteria = session.createCriteria(Employee.class);
			Criteria salCriteria = employeeCriteria.createCriteria("salary");
			salCriteria.add(Restrictions.ge("salary", new Integer(10000)));
			Employee employee = (Employee) salCriteria.uniqueResult();

			if (employee != null) {
				System.out.println(employee.getSalary().getSalary());
				return employee;
			}

			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.close();
		return null;

	}

	public Employee viewRecordByHQL() {
		Session session = sf.openSession();

		Transaction t = session.beginTransaction();

		Query query = session.createQuery("from Employee where salary.salary>10000");//
		Employee employee = (Employee) query.uniqueResult();
		System.out.println("salary= "+employee.getSalary().getSalary());
		t.commit();
		session.close();
		return employee;
	}	

	

	
	public Employee findEmployee(int empid) {
		return (Employee) sf.openSession().get(Employee.class, new Integer(empid));
	}


}


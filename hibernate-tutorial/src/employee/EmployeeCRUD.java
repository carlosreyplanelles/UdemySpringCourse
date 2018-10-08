package employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Employee;

public class EmployeeCRUD {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();		
	}
	
	public List<Employee> getAll(SessionFactory factory){
		
		Session session = factory.getCurrentSession();
		
		List<Employee> employees = session.createQuery("from employees").list();
		
		return employees;
		
		
	}
	
	public void createEmployee(SessionFactory factory, String firstName, String lastName, String company){
		
		Session session = factory.getCurrentSession();
		
		try {
			Employee newEmployee = new Employee(firstName, lastName, company);
			session.beginTransaction();
			session.save(newEmployee);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}

}

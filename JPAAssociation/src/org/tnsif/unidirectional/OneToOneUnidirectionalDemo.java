package org.tnsif.unidirectional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToOneUnidirectionalDemo {
	
	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em=factory.createEntityManager();
		
		em.getTransaction().begin();
		
		//first employee
		Employee emp1=new Employee();
		emp1.setEmpname("Bhushan Shinde");
		
		Employee emp2=new Employee();
		emp2.setEmpname("Saurabh");
		
		//first address
		Address a1=new Address();
		a1.setPincode(422003);
		a1.setArea("konark nagar");
		a1.setCity("nashik");
		a1.setState("maharstra");
		
		
		Address a2=new Address();
		a2.setPincode(422003);
		a2.setArea("jatra hotel");
		a2.setCity("nashik");
		a2.setState("maharstra");
		
		emp1.setAddress(a1);
		emp2.setAddress(a2);
		
		em.persist(emp1);
		em.persist(emp2);
		
		em.getTransaction().commit();
		System.out.println("Data addes successfully");
		em.close();
		
		factory.close();
	
	}
	

}
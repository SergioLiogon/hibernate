package test;



import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import antlr.collections.List;
import es.sergio.modelo.Empleado;



public class TestEmpleados {

	
	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
	public static void main(String[] args) {
	
		emf = Persistence.createEntityManagerFactory("Persistencia"); //La que esta en el persistence.xml
		manager = emf.createEntityManager();
		
	   Empleado empleado = new Empleado("Javier","Lazcano",  new GregorianCalendar(1996,01,02).getTime());
	      imprimirTodo(); 
	   manager.getTransaction().begin();
        manager.remove(42);
        manager.getTransaction().commit();
        
        imprimirTodo();
	}
	
	private static void imprimirTodo(){
		
		@SuppressWarnings("unchecked")
		ArrayList <Empleado> empleados = (ArrayList <Empleado>) manager.createQuery("from Empleado").getResultList();
		System.out.println("Hay "+ empleados.size()+ " empleados en el sistema");
		for(Empleado emp: empleados){
			System.out.println(emp.toString());
		}
	}

}

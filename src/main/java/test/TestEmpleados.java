package test;



import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.lang.model.element.Element;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import antlr.collections.List;
import es.sergio.modelo.Direccion;
import es.sergio.modelo.Empleado;



public class TestEmpleados {

	

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");;
	
	public static void main(String[] args) {
	
		 //La que esta en el persistence.xml
	
		
	// insertDato();
	     	
     //imprimirTodo();
	 	
     //mostrarDatos();
		//eliminarDato();
	}
	

	private static void insertDato(){
		EntityManager manager = emf.createEntityManager();
		
		    Direccion direccion = new Direccion("Calle falsa,123","SpringField","Field","EEUU");
		    Empleado empleado = new Empleado("Jose","Manuel",  new GregorianCalendar(1996,12,12).getTime());
		    empleado.setDireccion(direccion);
		    manager.getTransaction().begin();
	        manager.persist(empleado);
	        manager.getTransaction().commit();
	        manager.close();
	        imprimirTodo();
		
	}
	
	private static void eliminarDato(){
		EntityManager manager = emf.createEntityManager();
		   Empleado empleado = new Empleado(40L);
		    imprimirTodo(); 
		    manager.getTransaction().begin();
		    empleado = manager.merge(empleado);
		    manager.remove(empleado);
		    manager.getTransaction().commit();
		    manager.close();
	        imprimirTodo(); 
		
	}
	
	private static void mostrarDatos(){
		EntityManager manager = emf.createEntityManager();
		try{
		   Empleado empleado = manager.find(Empleado.class, 44L);
		   
		   System.out.println(empleado.toString());
		}catch(Exception e){
			 System.out.println("El empleado no existe");
			
		}
		 manager.close();   
	}
	
	private static void imprimirTodo(){
		EntityManager manager = emf.createEntityManager();
		
		@SuppressWarnings("unchecked")
		ArrayList <Empleado> empleados = (ArrayList <Empleado>) manager.createQuery("from Empleado").getResultList();
		System.out.println("Hay "+ empleados.size()+ " empleados en el sistema");
		for(Empleado emp: empleados){
			System.out.println(emp.toString());
		}
		manager.close();
	}
	
	 

}

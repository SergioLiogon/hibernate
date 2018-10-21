package test;



import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.lang.model.element.Element;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import es.sergio.modelo.Autor;
import es.sergio.modelo.Direccion;
import es.sergio.modelo.Empleado;
import es.sergio.modelo.Libro;



public class TestEmpleados {

	

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
	
	public static void main(String[] args) {
	
		 //La que esta en el persistence.xml
	
		
	 // insertDato();
	     	
    // imprimirTodo();
	 	
    // mostrarDatos();
     //eliminarDato();
		
	//	insertarAutor();
		imprimirDatosAutor();
	}
	
	
	
	
	//------------------------Autores----------------------------------------
	
	private static void insertarAutor(){
		EntityManager manager = emf.createEntityManager();
	
		    manager.getTransaction().begin();
	 
		    Autor autor1 = new Autor("Pablo Perez", "SPAIN");
		    Autor autor2 = new Autor("Elena gomez", "Mexicano");
		    Autor autor3 = new Autor("Miguel lopez", "Chile");
		    manager.persist(autor1);
		    manager.persist(autor2);
		    manager.persist(autor3);
		    
		    manager.persist (new Libro("Programar es facil", autor2));
		    manager.persist (new Libro("Como vestirse con estilo",autor3));
		    manager.persist (new Libro("Cocinar sin quemar la cocina",autor1));
		    manager.persist (new Libro("Programar en cobol es divertido",autor2));
		    manager.persist (new Libro("Programar en cobol no es  divertido",autor2));
	        manager.getTransaction().commit();
	        manager.close();

		
	}
	
	
	private static void imprimirDatosAutor(){
		EntityManager manager = emf.createEntityManager();
		Autor autor2  = manager.find(Autor.class, 2L);
		System.out.println(autor2);
		//  manager.getTransaction().commit();
		List<Libro> libros = autor2.getLibros();
		for(Libro libro : libros){
			System.out.println("* "+libro.toString());
			
		}
	        manager.close();

	}
	//-----------------------Empleado------------------------------------------
	

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

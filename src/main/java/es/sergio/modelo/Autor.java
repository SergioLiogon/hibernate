package es.sergio.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name ="AUTORES")
public class Autor {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AUTOR_ID", unique=true, nullable = false)
	private Long AUTOR_ID;


	@Column(name = "NOMBRE")
	private String NOMBRE;
	
	@Column(name = "NACIONALIDAD")
	private String NACIONALIDAD;
	
	
	
	
	public Autor(){
		
	}
	
	
	@OneToMany(mappedBy = "AUTOR_ID", cascade = CascadeType.ALL)
	private List<Libro> LIBRO_ID = new ArrayList<>();
	
	public List<Libro> getLibros() {
		return LIBRO_ID;
	}
	public void setLibros(List<Libro> libros) {
		this.LIBRO_ID = libros;
	}
	
public Autor( String nOMBRE, String nACIONALIDAD) {
		
	
		NOMBRE = nOMBRE;
		NACIONALIDAD = nACIONALIDAD;
	}

	public Autor(Long aUTOR_ID, String nOMBRE, String nACIONALIDAD) {
		
		AUTOR_ID = aUTOR_ID;
		NOMBRE = nOMBRE;
		NACIONALIDAD = nACIONALIDAD;
	}


	public Long getAUTOR_ID() {
		return AUTOR_ID;
	}


	public void setAUTOR_ID(Long aUTOR_ID) {
		AUTOR_ID = aUTOR_ID;
	}


	public String getNOMBRE() {
		return NOMBRE;
	}


	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}


	public String getNACIONALIDAD() {
		return NACIONALIDAD;
	}


	public void setNACIONALIDAD(String nACIONALIDAD) {
		NACIONALIDAD = nACIONALIDAD;
	}


	@Override
	public String toString() {
		return "Autor [AUTOR_ID=" + AUTOR_ID + ", NOMBRE=" + NOMBRE + ", NACIONALIDAD=" + NACIONALIDAD + "]";
	}

	
}

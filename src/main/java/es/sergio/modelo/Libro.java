package es.sergio.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRO")
public class Libro {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LIBRO_ID", unique=true, nullable = false)
	private Long LIBRO_ID;
	
	
	@Column(name = "TITULO")
	private String TITULO;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUTOR_ID")
    private Autor AUTOR_ID;
    

	public Libro(){
		
		
	}
	
	
	@Override
	public String toString() {
		return "Libro [LIBRO_ID=" + LIBRO_ID + ", TITULO=" + TITULO + "]";
	}

	public Libro(String tITULO,Autor autor) {
	    this.AUTOR_ID = autor;
	    this.TITULO = tITULO;
	}

	public Libro(Long LIBRO_ID, String TITULO,Autor autor) {
	    this.AUTOR_ID = autor;
	    this.LIBRO_ID = LIBRO_ID;
	    this.TITULO = TITULO;
	}
	public Long getLIBRO_ID() {
		return LIBRO_ID;
	}

	public Autor getAutor() {
		return AUTOR_ID;
	}


	public void setAutor(Autor autor) {
		this.AUTOR_ID = autor;
	}





	public void setLIBRO_ID(Long lIBRO_ID) {
		LIBRO_ID = lIBRO_ID;
	}


	public String getTITULO() {
		return TITULO;
	}


	public void setTITULO(String tITULO) {
		TITULO = tITULO;
	}
	

}

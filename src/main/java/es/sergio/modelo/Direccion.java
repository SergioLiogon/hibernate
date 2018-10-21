package es.sergio.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.omg.CORBA.PUBLIC_MEMBER;

@Entity
@Table(name = "Direccion")
public class Direccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DIRECCION", unique=true, nullable = false)
	private Long ID_DIRECCION;

	@Column(name = "DIRECCION")
	private String DIRECCION;
	
	@Column(name = "LOCALIDAD")
	private String LOCALIDAD;
	
	@Column(name = "PROVINCIA")
	private String PROVINCIA;
	
	@Column(name = "PAIS")
	private String PAIS;
     
	

	public Direccion(){
		
	}
	
	public Direccion(Long id, String direccion, String localicad, String provincia, String pais) {
		
		this.ID_DIRECCION = id;
		this.DIRECCION = direccion;
		this.LOCALIDAD = localicad;
		this.PROVINCIA = provincia;
		this.PAIS = pais;
	}

	public Direccion(String direccion, String localicad, String provincia, String pais) {
		
	
		this.DIRECCION = direccion;
		this.LOCALIDAD = localicad;
		this.PROVINCIA = provincia;
		this.PAIS = pais;
	}

	public Long getId() {
		return ID_DIRECCION;
	}

	public void setId(Long id) {
		this.ID_DIRECCION = id;
	}

	public String getDireccion() {
		return DIRECCION;
	}

	public void setDireccion(String direccion) {
		this.DIRECCION = direccion;
	}

	public String getLocalicad() {
		return LOCALIDAD;
	}

	public void setLocalicad(String localicad) {
		this.LOCALIDAD = localicad;
	}

	public String getProvincia() {
		return PROVINCIA;
	}

	public void setProvincia(String provincia) {
		this.PROVINCIA = provincia;
	}

	public String getPais() {
		return PAIS;
	}

	public void setPais(String pais) {
		this.PAIS = pais;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + ID_DIRECCION + ", direccion=" + DIRECCION + ", localicad=" + LOCALIDAD + ", provincia="
				+ PROVINCIA + ", pais=" + PAIS + "]";
	}
	
    

}


package fi.unju.edu.ar.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
/**
 * Nombre de la tabla en la BD
 *
 */
@Table(name="institucion")
public class Institucion {
	/**
	 * Se aplica al campo de clave principal de una entidad  con la anotación Id.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "inst_id")
	private Long id;
	
	@NotEmpty
	@Column(name = "inst_cuit")
	private String cuit;
	@NotEmpty
	@Column(name = "inst_nonmbre")
	private String nombre;
	@NotEmpty
	@Column(name = "inst_contrasenia")
	private String contrasenia;
	
	@Column(name="inst_tipo")
	private String tipo;
	@OneToMany(mappedBy = "institucion", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<Curso> cursos=new ArrayList<Curso>();
	
	public Institucion() {
		this.tipo="institucion";
	}





	public Institucion(Long id, String cuit, String nombre, String contrasenia, List<Curso> cursos) {
		super();
		this.id = id;
		this.cuit = cuit;
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.cursos = cursos;
	}




	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}





	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the cuit
	 */
	public String getCuit() {
		return cuit;
	}

	/**
	 * @param cuit the cuit to set
	 */
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	/**
	 * @return the contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * @param contrasenia the contrasenia to set
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	/**
	 * @return the cursos
	 */
	public List<Curso> getCursos() {
		return cursos;
	}

	/**
	 * @param cursos the cursos to set
	 */
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}





	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}





	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}





	@Override
	public String toString() {
		return "Institucion [id=" + id + ", cuit=" + cuit + ", nombre=" + nombre + ", contrasenia=" + contrasenia
				+ ", tipo=" + tipo + ", cursos=" + cursos + "]";
	}





	
	

	
}

package fi.unju.edu.ar.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
/**
 * Nombre de la tabla en la BD
 *
 */
@Table(name="cursos")
public class Curso {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cur_id")
	private Long id;
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="inst_id")
	Institucion institucion;
	
	
	@OneToMany(mappedBy = "curso",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<Empleado> inscriptos=new ArrayList<Empleado>();
	
	@Column(name = "curso_nombre")
	private String nombre;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "cur_fechaI")
	private LocalDate fechaInicio;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "cur_fechaF")
	private LocalDate fechaFin;
	@Column(name = "cur_categoriaC")
	private String categoriaC;
public Curso() {
	// TODO Auto-generated constructor stub
}




public Curso(Long id, Institucion institucion, List<Empleado> inscriptos, String nombre, LocalDate fechaInicio, LocalDate fechaFin,
		String categoriaC) {
	super();
	this.id = id;
	this.institucion = institucion;
	this.inscriptos = inscriptos;
	this.nombre = nombre;
	this.fechaInicio = fechaInicio;
	this.fechaFin = fechaFin;
	this.categoriaC = categoriaC;
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
 * @return the institucion
 */
public Institucion getInstitucion() {
	return institucion;
}
/**
 * @param institucion the institucion to set
 */
public void setInstitucion(Institucion institucion) {
	this.institucion = institucion;
}
/**
 * @return the fechaInicio
 */
public LocalDate getFechaInicio() {
	return fechaInicio;
}
/**
 * @param fechaInicio the fechaInicio to set
 */
public void setFechaInicio(LocalDate fechaInicio) {
	this.fechaInicio = fechaInicio;
}
/**
 * @return the fechaFin
 */
public LocalDate getFechaFin() {
	return fechaFin;
}
/**
 * @param fechaFin the fechaFin to set
 */
public void setFechaFin(LocalDate fechaFin) {
	this.fechaFin = fechaFin;
}
/**
 * @return the categoriaC
 */
public String getCategoriaC() {
	return categoriaC;
}
/**
 * @param categoriaC the categoriaC to set
 */
public void setCategoriaC(String categoriaC) {
	this.categoriaC = categoriaC;
}




/**
 * @return the inscriptos
 */
public List<Empleado> getInscriptos() {
	return inscriptos;
}




/**
 * @param inscriptos the inscriptos to set
 */
public void setInscriptos(List<Empleado> inscriptos) {
	this.inscriptos = inscriptos;
}




@Override
public String toString() {
	return "Curso [id=" + id + ", institucion=" + institucion + ", inscriptos=" + inscriptos + ", nombre=" + nombre
			+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", categoriaC=" + categoriaC + "]";
}




}

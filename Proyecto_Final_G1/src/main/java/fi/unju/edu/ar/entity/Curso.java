package fi.unju.edu.ar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	
	@Column(name = "curso_nombre")
	private String nombre;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "cur_fechaI")
	private int fechaInicio;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "cur_fechaF")
	private int fechaFin;
	@Column(name = "cur_categoriaC")
	private String categoriaC;
public Curso() {
	// TODO Auto-generated constructor stub
}
public Curso(String nombre, Long id, Institucion institucion, int fechaInicio, int fechaFin, String categoriaC) {
	super();
	this.nombre = nombre;
	this.id = id;
	this.institucion = institucion;
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
public int getFechaInicio() {
	return fechaInicio;
}
/**
 * @param fechaInicio the fechaInicio to set
 */
public void setFechaInicio(int fechaInicio) {
	this.fechaInicio = fechaInicio;
}
/**
 * @return the fechaFin
 */
public int getFechaFin() {
	return fechaFin;
}
/**
 * @param fechaFin the fechaFin to set
 */
public void setFechaFin(int fechaFin) {
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
@Override
public String toString() {
	return "Curso [nombre=" + nombre + ", id=" + id + ", institucion=" + institucion + ", fechaInicio=" + fechaInicio
			+ ", fechaFin=" + fechaFin + ", categoriaC=" + categoriaC + "]";
}


}

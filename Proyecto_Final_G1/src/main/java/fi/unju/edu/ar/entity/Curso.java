package fi.unju.edu.ar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
/**
 * Nombre de la tabla en la BD
 *
 */
@Table(name="cursos")
public class Curso {
	@Id
	@Column(name = "curso_nombre")
	private String nombreC;
	@Column(name = "curso_duracion")
	private int duracion;
	@Column(name = "curso_fechaI")
	private int fechaInicio;
	@Column(name = "curso_fechaF")
	private int fechaFin;
	@Column(name = "curso_categoriaC")
	private String categoriaC;
	public Curso() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor del objeto Curso
	 * @param nombreC
	 * @param duracion
	 * @param fechaInicio
	 * @param fechaFin
	 * @param categoriaC
	 */
	public Curso(String nombreC, int duracion, int fechaInicio, int fechaFin, String categoriaC) {
		super();
		this.nombreC = nombreC;
		this.duracion = duracion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.categoriaC = categoriaC;
	}
	public String getNombreC() {
		return nombreC;
	}
	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public int getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(int fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public int getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(int fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getCategoriaC() {
		return categoriaC;
	}
	public void setCategoriaC(String categoriaC) {
		this.categoriaC = categoriaC;
	}
	@Override
	public String toString() {
		return "Curso [nombreC=" + nombreC + ", duracion=" + duracion + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", categoriaC=" + categoriaC + "]";
	}
	

}

package fi.unju.edu.ar.entity;

public class Curso {
	private String nombreC;//nombre del curso
	private int duracion;
	private int fechaInicio;
	private int fechaFin;
	private String categoriaC;//categoria del curso(informatica,contable ,administrativa)
	public Curso() {
		// TODO Auto-generated constructor stub
	}
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

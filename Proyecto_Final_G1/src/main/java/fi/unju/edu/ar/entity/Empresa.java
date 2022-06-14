package fi.unju.edu.ar.entity;

public class Empresa {

	private int cantidadVacante;
	private String puestoRequerido;
	private	String disponibiidadHoraria;
	private String tareasPrincipales;
	private String datosContacto;
	private String jornada;
	private String requisitos;
	private int salario;
	private String beneficios;
	private String  disponible;//(solo permanece el true si aún no se completaron las vacantes)
	public Empresa() {
		// TODO Auto-generated constructor stub
	}
	public Empresa(int cantidadVacante, String puestoRequerido, String disponibiidadHoraria, String tareasPrincipales,
			String datosContacto, String jornada, String requisitos, int salario, String beneficios,
			String disponible) {
		super();
		this.cantidadVacante = cantidadVacante;
		this.puestoRequerido = puestoRequerido;
		this.disponibiidadHoraria = disponibiidadHoraria;
		this.tareasPrincipales = tareasPrincipales;
		this.datosContacto = datosContacto;
		this.jornada = jornada;
		this.requisitos = requisitos;
		this.salario = salario;
		this.beneficios = beneficios;
		this.disponible = disponible;
	}
	public int getCantidadVacante() {
		return cantidadVacante;
	}
	public void setCantidadVacante(int cantidadVacante) {
		this.cantidadVacante = cantidadVacante;
	}
	public String getPuestoRequerido() {
		return puestoRequerido;
	}
	public void setPuestoRequerido(String puestoRequerido) {
		this.puestoRequerido = puestoRequerido;
	}
	public String getDisponibiidadHoraria() {
		return disponibiidadHoraria;
	}
	public void setDisponibiidadHoraria(String disponibiidadHoraria) {
		this.disponibiidadHoraria = disponibiidadHoraria;
	}
	public String getTareasPrincipales() {
		return tareasPrincipales;
	}
	public void setTareasPrincipales(String tareasPrincipales) {
		this.tareasPrincipales = tareasPrincipales;
	}
	public String getDatosContacto() {
		return datosContacto;
	}
	public void setDatosContacto(String datosContacto) {
		this.datosContacto = datosContacto;
	}
	public String getJornada() {
		return jornada;
	}
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}
	public String getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public String getBeneficios() {
		return beneficios;
	}
	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}
	public String getDisponible() {
		return disponible;
	}
	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}
	@Override
	public String toString() {
		return "Empresa [cantidadVacante=" + cantidadVacante + ", puestoRequerido=" + puestoRequerido
				+ ", disponibiidadHoraria=" + disponibiidadHoraria + ", tareasPrincipales=" + tareasPrincipales
				+ ", datosContacto=" + datosContacto + ", jornada=" + jornada + ", requisitos=" + requisitos
				+ ", salario=" + salario + ", beneficios=" + beneficios + ", disponible=" + disponible + "]";
	}

}

package fi.unju.edu.ar.model;

public class OfertaLab {

	private String cantidadVac;//cantidad de vacantes
	private String puestoReq;//puesto requerido
	private String resumenPuesto;//resumen del puesto
	private String disponibilidadH;//disponibilidad horaria
	private String tareasPrin;//tareas principales
	private String datosContac;//datos del contacto????????revisar y editar 
	private int jornada;
	private String requisitos;
	private int salario;
	private String beneficio;
	private String disponible;//solo si esta disponible o no esta disponible
	
	public OfertaLab() {
		// TODO Auto-generated constructor stub
	}

	public OfertaLab(String cantidadVac, String puestoReq, String resumenPuesto, String disponibilidadH,
			String tareasPrin, String datosContac, int jornada, String requisitos, int salario, String beneficio,
			String disponible) {
		super();
		this.cantidadVac = cantidadVac;
		this.puestoReq = puestoReq;
		this.resumenPuesto = resumenPuesto;
		this.disponibilidadH = disponibilidadH;
		this.tareasPrin = tareasPrin;
		this.datosContac = datosContac;
		this.jornada = jornada;
		this.requisitos = requisitos;
		this.salario = salario;
		this.beneficio = beneficio;
		this.disponible = disponible;
	}

	public String getCantidadVac() {
		return cantidadVac;
	}

	public void setCantidadVac(String cantidadVac) {
		this.cantidadVac = cantidadVac;
	}

	public String getPuestoReq() {
		return puestoReq;
	}

	public void setPuestoReq(String puestoReq) {
		this.puestoReq = puestoReq;
	}

	public String getResumenPuesto() {
		return resumenPuesto;
	}

	public void setResumenPuesto(String resumenPuesto) {
		this.resumenPuesto = resumenPuesto;
	}

	public String getDisponibilidadH() {
		return disponibilidadH;
	}

	public void setDisponibilidadH(String disponibilidadH) {
		this.disponibilidadH = disponibilidadH;
	}

	public String getTareasPrin() {
		return tareasPrin;
	}

	public void setTareasPrin(String tareasPrin) {
		this.tareasPrin = tareasPrin;
	}

	public String getDatosContac() {
		return datosContac;
	}

	public void setDatosContac(String datosContac) {
		this.datosContac = datosContac;
	}

	public int getJornada() {
		return jornada;
	}

	public void setJornada(int jornada) {
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

	public String getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}

	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "OfertaLab [cantidadVac=" + cantidadVac + ", puestoReq=" + puestoReq + ", resumenPuesto=" + resumenPuesto
				+ ", disponibilidadH=" + disponibilidadH + ", tareasPrin=" + tareasPrin + ", datosContac=" + datosContac
				+ ", jornada=" + jornada + ", requisitos=" + requisitos + ", salario=" + salario + ", beneficio="
				+ beneficio + ", disponible=" + disponible + "]";
	}
	
	

}

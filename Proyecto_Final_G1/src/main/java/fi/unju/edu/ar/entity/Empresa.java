package fi.unju.edu.ar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="empresa")
public class Empresa {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "empresa_cantV")
	private int cantidadVacante;
	@Column(name = "empresa_puestoR")
	private String puestoRequerido;
	@Column(name = "empresa_disponibilidadH")
	private	String disponibilidadHoraria;
	@Column(name = "empresa_tareasP")
	private String tareasPrincipales;
	@Column(name = "empresa_datosC")
	private String datosContacto;
	@Column(name = "empresa_jornada")
	private String jornada;
	@Column(name = "empresa_requisitos")
	private String requisitos;
	@Column(name = "empresa_salario")
	private int salario;
	@Column(name = "empresa_beneficios")
	private String beneficios;
	@Column(name = "empresa_disponible")
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
		this.disponibilidadHoraria = disponibiidadHoraria;
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
		return disponibilidadHoraria;
	}
	public void setDisponibiidadHoraria(String disponibiidadHoraria) {
		this.disponibilidadHoraria = disponibiidadHoraria;
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
				+ ", disponibiidadHoraria=" + disponibilidadHoraria + ", tareasPrincipales=" + tareasPrincipales
				+ ", datosContacto=" + datosContacto + ", jornada=" + jornada + ", requisitos=" + requisitos
				+ ", salario=" + salario + ", beneficios=" + beneficios + ", disponible=" + disponible + "]";
	}

}

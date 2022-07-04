package fi.unju.edu.ar.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
/**
 * Nombre de la tabla en la BD
 */
@Table(name="ofertas")
public class OfertaLab {
	/**
	 * El id se genera automaticamente desde el sistema, en el no se aplican validaciones 
	 */
	@Id
	/**
	 * Se aplica al campo de clave principal de una entidad  con la anotación Id.
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ofe_id")
	private Long id;
	
	@Autowired
	/**
	 * ManytoOne especifica una asociación de un solo valor con otra clase de entidad que tiene una multiplicidad de muchos a uno.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="empr_id")
	private Empresa empresa;
	
	/**
	 * ManytoMany specifica una asociación de muchos valores con multiplicidad de muchos a muchos.
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	/** 
	 * Jointable hace referencia a la columna que es clave externa en la tabla y que se encarga de definir la relación
	 */
	@JoinTable(name="ofertas_empleados", joinColumns=@JoinColumn(referencedColumnName = "ofe_id"),
				inverseJoinColumns=@JoinColumn(referencedColumnName = "emp_id"))
	private List<Empleado> postulados=new ArrayList<Empleado>();
	/**
	 * Validacion Size permite especificar la cantidad de caracteres que puede contener.
	 */
	/**
	 *Validacion NotEmpty no deja que el campo quede vacio, Email verifica si la cadena alfanumerica es un e-mail.
	 */
	@NotNull
	@Column(name="ofe_vacante")
	private int cantidadVac;//cantidad de vacantes
	
	
	@NotNull
	@Column(name="ofe_puesto")
	private String puestoReq;//puesto requerido
	
	@NotNull
	@Column(name="ofe_informacion")
	private String resumenPuesto;//resumen del puesto
	
	@NotNull
	@Column(name="ofe_diponibilidad")
	private String disponibilidadH;//disponibilidad horaria
	
	@NotNull
	@Column(name="ofe_tareas")
	private String tareasPrin;//tareas principales
	
	@NotNull
	@Column(name="ofe_contacto")
	private String datosContac;//datos del contacto????????revisar y editar 
	
	@NotNull
	@Column(name="ofe_jornada")
	private int jornada;
	
	@NotNull
	@Column(name="ofe_requisitos")
	private String requisitos;
	
	@NotNull
	@Column(name="ofe_salario")
	private int salario;
	
	@NotNull
	@Column(name="ofe_beneficio")
	private String beneficio;
	
	@Column(name="ofe_disponible")
	private boolean disponible;//solo si esta disponible o no esta disponible
	
	
	public OfertaLab() {
		// TODO Auto-generated constructor stub
	}

	
/**
 * Constructor del objeto OfertaLab
 * @param id
 * @param empresa
 * @param postulados
 * @param cantidadVac
 * @param puestoReq
 * @param resumenPuesto
 * @param disponibilidadH
 * @param tareasPrin
 * @param datosContac
 * @param jornada
 * @param requisitos
 * @param salario
 * @param beneficio
 * @param disponible
 */
	public OfertaLab(Long id, Empresa empresa, List<Empleado> postulados, @NotNull int cantidadVac,
			@NotNull String puestoReq, @NotNull String resumenPuesto, @NotNull String disponibilidadH,
			@NotNull String tareasPrin, @NotNull String datosContac, @NotNull int jornada, @NotNull String requisitos,
			@NotNull int salario, @NotNull String beneficio, boolean disponible) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.postulados = postulados;
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



	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public int getCantidadVac() {
		return cantidadVac;
	}

	public void setCantidadVac(int cantidadVac) {
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

	public boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
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
	 * @return the postulados
	 */
	public List<Empleado> getPostulados() {
		return postulados;
	}

	/**
	 * @param postulados the postulados to set
	 */
	public void setPostulados(List<Empleado> postulados) {
		this.postulados = postulados;
	}

	@Override
	public String toString() {
		return "OfertaLab [id=" + id + ", empresa=" + empresa + ", postulados=" + postulados + ", cantidadVac="
				+ cantidadVac + ", puestoReq=" + puestoReq + ", resumenPuesto=" + resumenPuesto + ", disponibilidadH="
				+ disponibilidadH + ", tareasPrin=" + tareasPrin + ", datosContac=" + datosContac + ", jornada="
				+ jornada + ", requisitos=" + requisitos + ", salario=" + salario + ", beneficio=" + beneficio
				+ ", disponible=" + disponible + "]";
	}

	
	
	
	

}

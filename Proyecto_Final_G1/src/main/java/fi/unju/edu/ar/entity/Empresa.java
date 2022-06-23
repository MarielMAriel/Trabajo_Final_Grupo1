package fi.unju.edu.ar.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Past;
//import javax.validation.constraints.Size;

//import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empr_id")
	@Min(value=1,message = "La ID debe ser mayor a 1")
	//preguntar cuantos caracteres puede tener la id
	private Long id;
	
	// el identificador de la tabla
	@Column(name = "empr_contrasenia")
	//@Min(value=100000000,message = "Su contraseña de almenos 9 caracteres")
	private String contrasenia;
	@Column(name = "empr_cuit")//como poner la vilidacion el el cuit ,ya q no acepta los 11 numero
	//@NotEmpty 
	private String cuit;
	// el nombre proviene del nombre del socio/s se da en sociedades o por acciones
	@Column(name = "empr_rSocial")
	//@NotEmpty 
	private String razonSocial;
	@Column(name = "empr_nombre")
	//@NotEmpty 
	private String nombre;
	@Column(name = "empr_finicio")
	//@DateTimeFormat(pattern="yyyy-MM-dd")
//	@NotNull @Past (message = "Debe ingresar su fecha de inicio de actividad")//consultar si tambien ponemos fin de activiadad
	private LocalDate finicio;
	@Column(name = "empr_email")
	//@NotEmpty @Email (message = "Ingrese un e-mail valido")
	private String email;
	@Column(name = "empr_telefono")
	//@Min(value=1000000000,message = "Su numero de telefono celular debe ser correcto")
	private String telefono;
	// ciudad barrio calle y num
	@Column(name = "empr_domicilio")
	//@NotEmpty
	private String domicilio;
	// CONSULTAR PROVINCIA EN VALIDACION
	//@NotEmpty(message = "Debe elegir su provincia")
	@Column(name = "empr_provincia")
	private String provincia;
	@Column(name = "empr_pagina")
	//@NotEmpty
	private String pagina;
	@Column(name = "empr_descripcion")
	//@NotEmpty 
	private String descripcion;
	@Column(name ="empr_tipo")
	@NotEmpty private String tipo;

	/**
	 * 
	 * */
	public Empresa() {
		// TODO Auto-generated constructor stub
		this.setTipo("empresa");
	}

	public Empresa(String cuit, String contrasenia, String razonSocial, String nombre, LocalDate finicio, String email,
			String telefono, String domicilio, String provincia, String pagina, String descripcion) {
		super();
		this.cuit = cuit;
		this.contrasenia = contrasenia;
		this.razonSocial = razonSocial;
		this.nombre = nombre;
		this.finicio = finicio;
		this.email = email;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.provincia = provincia;
		this.pagina = pagina;
		this.descripcion = descripcion;
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
	 * @return the id
	 */
//	public Long getId() {
//		return id;
//	}
//
//	/**
//	 * @param id the id to set
//	 */
//	public void setId(Long id) {
//		this.id = id;
//	}

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
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return razonSocial;
	}

	/**
	 * @param razonSocial the razonSocial to set
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
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
	 * @return the finicio
	 */
	public LocalDate getFinicio() {
		return finicio;
	}

	/**
	 * @param finicio the finicio to set
	 */
	public void setFinicio(LocalDate finicio) {
		this.finicio = finicio;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the domicilio
	 */
	public String getDomicilio() {
		return domicilio;
	}

	/**
	 * @param domicilio the domicilio to set
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return the pagina
	 */
	public String getPagina() {
		return pagina;
	}

	/**
	 * @param pagina the pagina to set
	 */
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * 
	 * 
	 * */
	@Override
	public String toString() {
		return "Empresa [ contrasenia=" + contrasenia + ", cuit=" + cuit + ", razonSocial=" + razonSocial
				+ ", nombre=" + nombre + ", finicio=" + finicio + ", email=" + email + ", telefono=" + telefono
				+ ", domicilio=" + domicilio + ", provincia=" + provincia + ", pagina=" + pagina + ", descripcion="
				+ descripcion + "]";
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}

package fi.unju.edu.ar.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "empresa")
public class Empresa {
	//el id se genera automaticamente desde el sistema 
	//en el no se aplican validaciones 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empr_id")
	private Long id;
	
	// el identificador de la tabla
	@Size(min=7,message = "Su contraseña de almenos 7 caracteres")
	@Column(name = "empr_contrasenia")
	private String contrasenia;
	
	@NotEmpty
	@Column(name = "empr_cuit")//como poner la vilidacion el el cuit ,ya q no acepta los 11 numero 
	private String cuit;
	// el nombre proviene del nombre del socio/s se da en sociedades o por acciones
	@NotEmpty
	@Column(name = "empr_rSocial") 
	private String razonSocial;
	
	@NotEmpty
	@Column(name = "empr_nombre") 
	private String nombre;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull @Past (message = "Debe ingresar su fecha de inicio de actividad")//consultar si tambien ponemos fin de activiadad	
	@Column(name = "empr_finicio")
	private LocalDate finicio;
	
	@NotEmpty @Email (message = "Ingrese un e-mail valido")
	@Column(name = "empr_email")
	private String email;
	@Size(min=7,max=10,message = "Su numero de telefono celular debe ser correcto")
	@Column(name = "empr_telefono")
	private String telefono;
	// ciudad barrio calle y num
	@NotEmpty
	@Column(name = "empr_domicilio")
	private String domicilio;
	// CONSULTAR PROVINCIA EN VALIDACION
	
	@NotEmpty(message = "Debe elegir su provincia")
	@Column(name = "empr_provincia")
	private String provincia;
	
	@NotEmpty
	@Column(name = "empr_pagina")
	private String pagina;
	@NotEmpty
	@Column(name = "empr_descripcion") 
	private String descripcion;
	@Column(name ="empr_tipo")
	private String tipo;
	
	
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<OfertaLab> ofertas;
	

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
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	 * @return the ofertas
	 */
	public List<OfertaLab> getOfertas() {
		return ofertas;
	}

	/**
	 * @param ofertas the ofertas to set
	 */
	public void setOfertas(List<OfertaLab> ofertas) {
		this.ofertas = ofertas;
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



}

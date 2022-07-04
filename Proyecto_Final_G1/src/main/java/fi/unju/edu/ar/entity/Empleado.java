package fi.unju.edu.ar.entity;

import java.time.LocalDate;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

//import org.springframework.format.annotation.DateTimeFormat;
@Entity
/**
 * Nombre de la tabla en la BD
 */
@Table(name="empleados")
public class Empleado {

	@Id
	/** 
	 *  Se aplica al campo de clave principal de una entidad  con la anotación Id.
	 */
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name = "emp_id")
	private Long id;
	/**
	 * Cada usuario puede tener un solo CV a publicar
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cv_id")
	private Cv cv;
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cur_id")
	Curso curso;
	
	

	/**
	 * Validacion Size permite especificar la cantidad de caracteres que puede contener.
	 */
	/**
	 *Validacion NotEmpty no deja que el campo quede vacio, Email verifica si la cadena alfanumerica es un e-mail.
	 */
	@Size(min =7,max = 9,message="El empleado debe ingresar el dni ej:12000800")
	@Column(name = "emp_dni" )
	 private String dni;
	/**
	 * Validacion Size permite especificar la cantidad de caracteres que puede tener el num. de tramite.
	 */
	@Size(min=10 ,max=13,message = "El Nro. de Tramite debe ser mayor a 1.000.000.000")
	@Column(name = "emp_ntramite" )
	 private String nTramite;

	@NotEmpty@Email (message = "Ingrese un e-mail valido")
	@Column(name = "emp_email" )
	 private String email;
	
	@NotEmpty(message = "Su estado civil debe estar completo")
	@Column(name = "emp_eCivil" )
	 private String eCivil;

	@NotEmpty(message = "Provincia no puede estar vacio")
	@Column(name = "emp_provincia" )
	 private String provincia;
	
	@Size(min=7,message = "Su numero de telefono celular debe ser correcto")
	@Column(name = "emp_telefono" )
	 private String tel;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull @Past (message = "Debe ingresar su fecha de nacimiento")
	@Column(name = "emp_fechnac")
	 private LocalDate fnac;

	
	@Size(min=7,message = "Su contraseña de almenos 7 caracteres")
	@Column(name = "emp_contrasenia" )	
	 private String contrasenia;
	
	@Column(name = "emp_tipo" )
	 private String tipo;
	
	
	@NotEmpty
	@Column(name="emp_profecion")
	private String profecion;
	
	@Column(name="emp_sel")
	private boolean sel;
	
	
	
public Empleado() {
	// TODO Auto-generated constructor stub
	this.tipo="empleado";
}
/**
 * Constructor del objeto Empleado
 * @param id
 * @param dni
 * @param nTramite
 * @param email
 * @param eCivil
 * @param provincia
 * @param tel
 * @param fnac
 * @param contrasenia
 * @param tipo
 * @param cv
 * @param profecion
 * @param sel
 */



/**
 * @return the profecion
 */
public String getProfecion() {
	return profecion;
}



public Empleado(Long id, Cv cv, Curso curso,
		@Size(min = 7, max = 9, message = "El empleado debe ingresar el dni ej:12000800") String dni,
		@Size(min = 10, max = 13, message = "El Nro. de Tramite debe ser mayor a 1.000.000.000") String nTramite,
		@NotEmpty @Email(message = "Ingrese un e-mail valido") String email,
		@NotEmpty(message = "Su estado civil debe estar completo") String eCivil,
		@NotEmpty(message = "Provincia no puede estar vacio") String provincia,
		@Size(min = 7, message = "Su numero de telefono celular debe ser correcto") String tel,
		@NotNull @Past(message = "Debe ingresar su fecha de nacimiento") LocalDate fnac,
		@Size(min = 7, message = "Su contraseña de almenos 7 caracteres") String contrasenia, String tipo,
		@NotEmpty String profecion, boolean sel) {
	super();
	this.id = id;
	this.cv = cv;
	this.curso = curso;
	this.dni = dni;
	this.nTramite = nTramite;
	this.email = email;
	this.eCivil = eCivil;
	this.provincia = provincia;
	this.tel = tel;
	this.fnac = fnac;
	this.contrasenia = contrasenia;
	this.tipo = tipo;
	this.profecion = profecion;
	this.sel = sel;
}
/**
 * @param profecion the profecion to set
 */
public void setProfecion(String profecion) {
	this.profecion = profecion;
}



public String getProvincia() {
	return provincia;
}
public void setProvincia(String provincia) {
	this.provincia = provincia;
}
/**
 * @return the tipo
 */
public String getTipo() {
	return tipo;
}
/**
 * @param tipo the tipo to set
 */
public void setTipo(String tipo) {
	this.tipo = tipo;
}
/**
 * @param contrasenia the contrasenia to set
 */
public void setContrasenia(String contrasenia) {
	this.contrasenia = contrasenia;
}
public String getDni() {
	return dni;
}
public void setDni(String dni) {
	this.dni = dni;
}
public String getnTramite() {
	return nTramite;
}
public void setnTramite(String nTramite) {
	this.nTramite = nTramite;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String geteCivil() {
	return eCivil;
}
public void seteCivil(String eCivil) {
	this.eCivil = eCivil;
}

public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public LocalDate getFnac() {
	return fnac;
}
public void setFnac(LocalDate fnac) {
	this.fnac = fnac;
}
public String getContrasenia() {
	return contrasenia;
}
public void setContraseña(String contraseña) {
	this.contrasenia = contraseña;
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
public Cv getCv() {
	return cv;
}
public void setCv(Cv cv) {
	this.cv = cv;
}




/**
 * @return the sel
 */
public boolean isSel() {
	return sel;
}




/**
 * @param sel the sel to set
 */
public void setSel(boolean sel) {
	this.sel = sel;
}




/**
 * @return the curso
 */
public Curso getCurso() {
	return curso;
}



/**
 * @param curso the curso to set
 */
public void setCurso(Curso curso) {
	this.curso = curso;
}



@Override
public String toString() {
	return "Empleado [id=" + id + ", cv=" + cv + ", curso=" + curso + ", dni=" + dni + ", nTramite=" + nTramite
			+ ", email=" + email + ", eCivil=" + eCivil + ", provincia=" + provincia + ", tel=" + tel + ", fnac=" + fnac
			+ ", contrasenia=" + contrasenia + ", tipo=" + tipo + ", profecion=" + profecion + ", sel=" + sel + "]";
}







}





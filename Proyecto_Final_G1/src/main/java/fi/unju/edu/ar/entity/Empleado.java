package fi.unju.edu.ar.entity;

import java.time.LocalDate;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

//import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="empleados")
public class Empleado {
	//NOTA HERNAN DEBO AGREGAR UN ATRIBUTO CON EL NOMBRE DEL EMPLEADO
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//REVISAR JOINCOLUMN EN CV.JAVA
	@Column(name = "emp_id")
	private Long id;
	
	//Size permite especificar la cantidad de caracteres que puede tomar un dni
	//
	@Size(min =7,max = 9,message="El empleado debe ingresar el dni ej:12000800")
	@Column(name = "emp_dni" )
	 private String dni;
	
	@Size(min=10 ,max=13,message = "El Nro. de Tramite debe ser mayor a 1.000.000.000")
	@Column(name = "emp_ntramite" )
	 private String nTramite;
	
	@NotEmpty@Email (message = "Ingrese un e-mail valido")
	@Column(name = "emp_email" )
	 private String email;
	
	@NotEmpty(message = "Su estado civil debe estar completo")
	@Column(name = "emp_eCivil" )
	 private String eCivil;
	// CONSULTAR PROVINCIA EN VALIDACION
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
	@OneToOne
	@JoinColumn(name = "emp_cv")
	private Cv cv;
//	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
//	private List<OfertaLab> ofertas;
//	
	
public Empleado() {
	// TODO Auto-generated constructor stub
	this.tipo="empleado";
}
public Empleado(String dni, String nTramite, String email, String eCivil, String provincia, String tel, LocalDate fnac,
		String contrasenia) {
	super();
	this.dni = dni;
	this.nTramite = nTramite;
	this.email = email;
	this.eCivil = eCivil;
	this.provincia = provincia;
	this.tel = tel;
	this.fnac = fnac;
	this.contrasenia = contrasenia;
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
@Override
public String toString() {
	return "Empleado [ dni=" + dni + ", nTramite=" + nTramite + ", email=" + email + ", eCivil=" + eCivil
			+ ", provinica=" + provincia + ", tel=" + tel + ", fnac=" + fnac + ", contrasenia=" + contrasenia
			+ ", tipo=" + tipo + "]";
}



}





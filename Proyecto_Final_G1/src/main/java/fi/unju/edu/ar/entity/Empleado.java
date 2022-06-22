package fi.unju.edu.ar.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="empleados")
public class Empleado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "emp_id")
	@Min(value=1,message = "La ID debe ser mayor a 1")
	//preguntar cuantos caracteres puede tener la id
	private Long id;
	
	@Column(name = "emp_dni" )
	//SE CUENTAN LOS DNI MAYORES QUE 20M y MENORES DE 45M
	@Size(min =20000000,max = 45000000,message = "El empleado debe ser mayor de edad")
	 private String dni;
	@Max(value=1000000000,message = "El Nro. de Tramite debe ser mayor a 1.000.000.000")
	@Column(name = "emp_ntramite" )
	 private int nTramite;
	@Column(name = "emp_email" )
	@NotEmpty @Email (message = "Ingrese un e-mail valido")
	 private String email;
	@NotEmpty(message = "Su estado civil debe estar completo")
	@Column(name = "emp_eCivil" )
	 private String eCivil;
	// CONSULTAR PROVINCIA EN VALIDACION
	@NotEmpty(message = "Debe elegir su provincia")
	@Column(name = "emp_provincia" )
	 private String provincia;
	@Column(name = "emp_telefono" )
	@Min(value=1000000000,message = "Su numero de telefono celular debe ser correcto")
	 private int tel;
	@Column(name = "emp_fechnac")
	@NotNull @Past (message = "Debe ingresar su fecha de nacimiento")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	 private LocalDate fnac;
	@Column(name = "emp_contrasenia" )
	@Min(value=100000000,message = "Su contraseña de almenos 9 caracteres")
	 private String contrasenia;
	@Column(name = "emp_tipo" )
	 private String tipo;
public Empleado() {
	// TODO Auto-generated constructor stub
	this.tipo="empleado";
}
public Empleado(String dni, int nTramite, String email, String eCivil, String provinica, int tel, LocalDate fnac,
		String contrasenia) {
	super();
	this.dni = dni;
	this.nTramite = nTramite;
	this.email = email;
	this.eCivil = eCivil;
	this.provincia = provinica;
	this.tel = tel;
	this.fnac = fnac;
	this.contrasenia = contrasenia;
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
public int getnTramite() {
	return nTramite;
}
public void setnTramite(int nTramite) {
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
public String getProvinica() {
	return provincia;
}
public void setProvinica(String provinica) {
	this.provincia = provinica;
}
public int getTel() {
	return tel;
}
public void setTel(int tel) {
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
@Override
public String toString() {
	return "Empleado [id=" + id + ", dni=" + dni + ", nTramite=" + nTramite + ", email=" + email + ", eCivil=" + eCivil
			+ ", provinica=" + provincia + ", tel=" + tel + ", fnac=" + fnac + ", contrasenia=" + contrasenia
			+ ", tipo=" + tipo + "]";
}


}





package fi.unju.edu.ar.model;

import java.time.LocalDate;

public class Empleado {
	 private int dni;
	 private int nTramite;
	 private String email;
	 private String eCivil;
	 private String provinica;
	 private int tel;
	 private LocalDate fnac;
	 private String contraseña;
public Empleado() {
	// TODO Auto-generated constructor stub
}
public Empleado(int dni, int nTramite, String email, String eCivil, String provinica, int tel, LocalDate fnac,
		String contraseña) {
	super();
	this.dni = dni;
	this.nTramite = nTramite;
	this.email = email;
	this.eCivil = eCivil;
	this.provinica = provinica;
	this.tel = tel;
	this.fnac = fnac;
	this.contraseña = contraseña;
}
public int getDni() {
	return dni;
}
public void setDni(int dni) {
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
	return provinica;
}
public void setProvinica(String provinica) {
	this.provinica = provinica;
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
public String getContraseña() {
	return contraseña;
}
public void setContraseña(String contraseña) {
	this.contraseña = contraseña;
}
@Override
public String toString() {
	return "Empleado [dni=" + dni + ", nTramite=" + nTramite + ", email=" + email + ", eCivil=" + eCivil
			+ ", provinica=" + provinica + ", tel=" + tel + ", fnac=" + fnac + ", contraseña=" + contraseña + "]";
}

}





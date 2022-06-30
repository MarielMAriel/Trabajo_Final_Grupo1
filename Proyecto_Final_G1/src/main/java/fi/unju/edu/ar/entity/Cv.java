package fi.unju.edu.ar.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "cv")
public class Cv {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id;
@OneToOne ( fetch = FetchType.LAZY) 
//REVISAR JOINCOLUMN
@JoinColumn (name ="emp_id")
	private Empleado empleado;


	private String datosId ;//datos de identidad

 @Column (name = "cv_educacion")
	private String educacion;
 @Column (name = "cv_idiomas")
	private String idiomas;
 @Column (name = "cv_conInf")
	private String conInf;//conocimientos informaticos
 @Column (name = "cv_infCompl")
	private String infCompl;//informacion complementaria
 @Column (name = "cv_datosAdi")
	private String datosAdi;//datos adicionales
	


	public Cv() {
		// TODO Auto-generated constructor stub
	}
	public Cv(String datosId, String educacion, String idiomas, String conInf, String infCompl, String datosAdi) {
		super();
		this.datosId = datosId;
		this.educacion = educacion;
		this.idiomas = idiomas;
		this.conInf = conInf;
		this.infCompl = infCompl;
		this.datosAdi = datosAdi;
	}
	

	public String getDatosId() {
		return datosId;
	}
	public void setDatosId(String datosId) {
		this.datosId = datosId;
	}
	public String getEducacion() {
		return educacion;
	}
	public void setEducacion(String educacion) {
		this.educacion = educacion;
	}
	public String getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}
	public String getConInf() {
		return conInf;
	}
	public void setConInf(String conInf) {
		this.conInf = conInf;
	}
	public String getInfCompl() {
		return infCompl;
	}
	public void setInfCompl(String infCompl) {
		this.infCompl = infCompl;
	}
	public String getDatosAdi() {
		return datosAdi;
	}
	public void setDatosAdi(String datosAdi) {
		this.datosAdi = datosAdi;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Cv [datosId=" + datosId + ", educacion=" + educacion + ", idiomas=" + idiomas + ", conInf=" + conInf
				+ ", infCompl=" + infCompl + ", datosAdi=" + datosAdi + "]";
	}

	
}

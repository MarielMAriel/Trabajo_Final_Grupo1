package fi.unju.edu.ar.model;

public class Cv {

	private String datosId ;//datos de identidad
	private String educacion;
	private String idiomas;
	private String conInf;//conocimientos informaticos
	private String infCompl;//informacion complementaria
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
	@Override
	public String toString() {
		return "Cv [datosId=" + datosId + ", educacion=" + educacion + ", idiomas=" + idiomas + ", conInf=" + conInf
				+ ", infCompl=" + infCompl + ", datosAdi=" + datosAdi + "]";
	}
	
}

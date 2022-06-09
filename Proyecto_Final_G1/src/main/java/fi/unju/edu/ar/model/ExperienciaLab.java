package fi.unju.edu.ar.model;

public class ExperienciaLab {

	private String nombreEmp;
	private int inicioAct;//inicio de actividad
	private int finAct;//fin de actividad
	private String labor;
	private String motivoS;//motivo de Salida(razon o motivo por el cual dejo el trabajo)
public ExperienciaLab() {
	// TODO Auto-generated constructor stub
}
public ExperienciaLab(String nombreEmp, int inicioAct, int finAct, String labor, String motivoS) {
	super();
	this.nombreEmp = nombreEmp;
	this.inicioAct = inicioAct;
	this.finAct = finAct;
	this.labor = labor;
	this.motivoS = motivoS;
}
public String getNombreEmp() {
	return nombreEmp;
}
public void setNombreEmp(String nombreEmp) {
	this.nombreEmp = nombreEmp;
}
public int getInicioAct() {
	return inicioAct;
}
public void setInicioAct(int inicioAct) {
	this.inicioAct = inicioAct;
}
public int getFinAct() {
	return finAct;
}
public void setFinAct(int finAct) {
	this.finAct = finAct;
}
public String getLabor() {
	return labor;
}
public void setLabor(String labor) {
	this.labor = labor;
}
public String getMotivoS() {
	return motivoS;
}
public void setMotivoS(String motivoS) {
	this.motivoS = motivoS;
}
@Override
public String toString() {
	return "ExperienciaLab [nombreEmp=" + nombreEmp + ", inicioAct=" + inicioAct + ", finAct=" + finAct + ", labor="
			+ labor + ", motivoS=" + motivoS + "]";
}

	
}

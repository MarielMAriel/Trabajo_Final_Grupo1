package fi.unju.edu.ar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "cv")
public class Cv {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name = "cv_id")
private Long id;

@OneToOne (mappedBy = "cv",fetch = FetchType.LAZY )
private Empleado empleado;

	
	 @Column (name = "cv_nombre")
		private String nombre;	
	 
	 @Column (name = "cv_apellido")
		private String apellido; 
	 
	 @Column (name = "cv_DNI")
		private String dni;
	 
	 @Column (name = "cv_telefono")
		private String telefono;
	 
	 @Column (name = "cv_nacimiento")
		private String nacimiento;
	 
	 @Column (name = "cv_laboral")
		private String laboral;
	 
	 @Column (name = "cv_educacion")
		private String educacion;
	 
	 @Column (name = "cv_idiomas")
		private String idiomas;
	 
	 @Column (name = "cv_ConocimientosInformaticos")
		private String informatica;
	 
	 @Column (name = "cv_InformacionComplementaria")
		private String complementaria;
	 
	 @Column (name = "cv_DatosAdicionales")
		private String adicionales;
	


	public Cv() {
		// TODO Auto-generated constructor stub
	}


	public Cv(Long id, String nombre, String apellido, String dni, String telefono, String nacimiento,
			String laboral, String educacion, String idiomas, String informatica, String complementaria,
			String adicionales) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.nacimiento = nacimiento;
		this.laboral = laboral;
		this.educacion = educacion;
		this.idiomas = idiomas;
		this.informatica = informatica;
		this.complementaria = complementaria;
		this.adicionales = adicionales;
	}

	public Long getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public String getDni() {
		return dni;
	}


	public String getTelefono() {
		return telefono;
	}


	public String getNacimiento() {
		return nacimiento;
	}


	public String getLaboral() {
		return laboral;
	}


	public String getEducacion() {
		return educacion;
	}


	public String getIdiomas() {
		return idiomas;
	}


	public String getInformatica() {
		return informatica;
	}


	public String getComplementaria() {
		return complementaria;
	}


	public String getAdicionales() {
		return adicionales;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}


	public void setLaboral(String laboral) {
		this.laboral = laboral;
	}


	public void setEducacion(String educacion) {
		this.educacion = educacion;
	}


	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}


	public void setInformatica(String informatica) {
		this.informatica = informatica;
	}


	public void setComplementaria(String complementaria) {
		this.complementaria = complementaria;
	}


	public void setAdicionales(String adicionales) {
		this.adicionales = adicionales;
	}


	@Override
	public String toString() {
		return "Cv [id=" + id + ", datosId=" + ", nombre=" + nombre + ", apellido=" + apellido + ", dni="
				+ dni + ", telefono=" + telefono + ", nacimiento=" + nacimiento + ", laboral=" + laboral
				+ ", educacion=" + educacion + ", idiomas=" + idiomas + ", informatica=" + informatica
				+ ", complementaria=" + complementaria + ", adicionales=" + adicionales + "]";
	}

}

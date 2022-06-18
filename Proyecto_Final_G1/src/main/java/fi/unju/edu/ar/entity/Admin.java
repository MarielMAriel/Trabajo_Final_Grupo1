package fi.unju.edu.ar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long id;
	
	@Column(name = "emp_dni" )
	 private int dni;
	@Column(name = "empr_cuit")
	private String cuit;
	@Column(name = "empr_contrasenia")
	private String contrasenia;
	
	public Admin() {
		super();
		
		this.dni =11111111;
		this.cuit = "11111111";
		this.contrasenia = "11111111";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", dni=" + dni + ", cuit=" + cuit + ", contrasenia=" + contrasenia + "]";
	}
	
}

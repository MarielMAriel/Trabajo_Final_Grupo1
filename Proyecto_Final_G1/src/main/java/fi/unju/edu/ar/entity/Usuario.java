package fi.unju.edu.ar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_id")
	private Long id;
	@Column(name="usu_identificador")
	private String identificador;//puede tomar el valor de cuit o dni depenndiendo del tipo de usuario
	@Column(name="usu_tipo")
	private String tipo;
	@Column(name="usu_contrasenia")
	private String contrasenia;
	
	public Usuario() {
		
	}
	 
	
	public Usuario( String identificador, String tipo, String contrasenia) {
		super();
		this.identificador = identificador;
		this.tipo = tipo;
		this.contrasenia = contrasenia;
	}


	/**
	 * @return the key
	 */
	public Long getId() {
		
		return id;
	}


	/**
	 * @param key the key to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the id
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * @param id the id to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador= identificador;
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


	@Override
	public String toString() {
		return "Usuario [key=" + identificador + ", id=" + identificador + ", tipo=" + tipo + ", contrasenia=" + contrasenia + "]";
	}
	
	
	

}

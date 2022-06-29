package fi.unju.edu.ar.entity;

import org.springframework.stereotype.Component;

@Component
public class Buscar {
	String valor;
	
	public Buscar() {
		// TODO Auto-generated constructor stub
	}

	public Buscar(String valor) {
		super();
		this.valor = valor;
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}

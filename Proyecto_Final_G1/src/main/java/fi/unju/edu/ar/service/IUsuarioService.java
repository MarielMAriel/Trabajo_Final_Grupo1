package fi.unju.edu.ar.service;

import fi.unju.edu.ar.entity.Empleado;
import fi.unju.edu.ar.entity.Empresa;
import fi.unju.edu.ar.entity.Usuario;

public interface IUsuarioService {
	public Usuario setearUsuario(Empresa empresa);
	public Usuario setearUsuarioi(Empleado empleado);
	public Usuario getUsuario();
	public void crear (Usuario unUsuario);
}

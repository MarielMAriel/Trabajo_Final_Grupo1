package fi.unju.edu.ar.service;

import fi.unju.edu.ar.entity.Institucion;

public interface InstitucionService {
	public Institucion nuevoInstitucion();
	public void guardar(Institucion institucion);
	public Institucion buscarInstitucion(String cuit);

}

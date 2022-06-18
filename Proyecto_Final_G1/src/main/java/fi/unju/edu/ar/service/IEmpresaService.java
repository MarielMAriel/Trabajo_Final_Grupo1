package fi.unju.edu.ar.service;


import fi.unju.edu.ar.entity.Empresa;

public interface IEmpresaService {
	 public void guardarEmpresa(Empresa empresa);
	 public Empresa getEmpresa();
	 public Empresa buscarEmpresa(String cuit,String contrasenia);
	 public boolean existeEmpresa(String cuit,String contrasenia);
}

package fi.unju.edu.ar.service;


import java.util.List;

import fi.unju.edu.ar.entity.Empleado;
import fi.unju.edu.ar.entity.Empresa;

public interface IEmpresaService {
	 public void guardarEmpresa(Empresa empresa);
	 public Empresa getEmpresa();
	 public void crear (Empresa unaEmpresa);
	 public Empresa findByCuit(String cuit);
	 public List<Empresa>getListaEmpresas();

}

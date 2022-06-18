package fi.unju.edu.ar.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.unju.edu.ar.entity.Empresa;
import fi.unju.edu.ar.repository.IEmpresaDAO;
import fi.unju.edu.ar.service.IEmpresaService;
@Service
public class EmpresaServicelmp implements IEmpresaService{
	@Autowired
	private IEmpresaDAO empresaDaoImp;
	@Override
	public void guardarEmpresa(Empresa empresa) {

		empresaDaoImp.save(empresa);
	}
	@Override
	public Empresa getEmpresa() {
		
		return new Empresa();
	}
	@Override
	public Empresa buscarEmpresa(String cuit, String contrasenia) {
		// TODO Auto-generated method stub
		return empresaDaoImp.findByCuitAndContrasenia(cuit, contrasenia);
	}
	@Override
	public boolean existeEmpresa(String cuit, String contrasenia) {
		
		if(buscarEmpresa(cuit, contrasenia)==null) {
			return false;
		}
		return true;
	}
	

}

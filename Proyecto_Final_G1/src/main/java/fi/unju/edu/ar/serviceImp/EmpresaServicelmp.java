package fi.unju.edu.ar.serviceImp;




import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.unju.edu.ar.entity.Empresa;
import fi.unju.edu.ar.repository.IEmpresaDAO;
import fi.unju.edu.ar.service.IEmpresaService;
@Service
public class EmpresaServicelmp implements IEmpresaService{
	private static final Log LOGGER = LogFactory.getLog(LoginServiceImp.class);

	@Autowired
	private IEmpresaDAO empresaDaoImp;
	@Override
	public void guardarEmpresa(Empresa empresa) {
		LOGGER.info("Se Guardo Empresa en la BD "+empresa);

		empresaDaoImp.save(empresa);
	}
	@Override
	public Empresa getEmpresa() {
		LOGGER.info("Se devuele una instancia de una nueva empresa");

		return new Empresa();
	}
	

	@Override
	public void crear(Empresa unaEmpresa) {
		// TODO Auto-generated method stub
		//String pw = unaEmpresa.getContrasenia();
		//BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder(4);
		//unaEmpresa.setContrasenia(bCryptPasswordEncoder.encode(pw));
		LOGGER.info("Se esta guardando un objeto de tipo empresa e la BD");

		empresaDaoImp.save(unaEmpresa);
	}
	@Override
	public Empresa findByCuit(String cuit) {
		// TODO Auto-generated method stub
		LOGGER.info("Se devuele una lista de empresas segun el cuit " +cuit);

		return empresaDaoImp.findByCuit(cuit);
	}
	@Override
	public List<Empresa> getListaEmpresas() {
		LOGGER.info("Se devuele una lista de empresas registradas en la BD ");

		return empresaDaoImp.obtenerEmpresa();
	}
	
	

}

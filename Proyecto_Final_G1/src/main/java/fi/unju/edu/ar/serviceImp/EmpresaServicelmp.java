package fi.unju.edu.ar.serviceImp;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	public void crear(Empresa unaEmpresa) {
		// TODO Auto-generated method stub
		String pw = unaEmpresa.getContrasenia();
		BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder(4);
		unaEmpresa.setContrasenia(bCryptPasswordEncoder.encode(pw));
		empresaDaoImp.save(unaEmpresa);
	}
	
	

}

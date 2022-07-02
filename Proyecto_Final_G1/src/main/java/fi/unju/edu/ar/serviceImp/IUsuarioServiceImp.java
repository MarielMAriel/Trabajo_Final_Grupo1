package fi.unju.edu.ar.serviceImp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fi.unju.edu.ar.entity.Empleado;
import fi.unju.edu.ar.entity.Empresa;
import fi.unju.edu.ar.entity.Usuario;
import fi.unju.edu.ar.repository.IUsuarioDao;

import fi.unju.edu.ar.service.IUsuarioService;

@Service
public class IUsuarioServiceImp implements IUsuarioService{
	private static final Log LOGGER = LogFactory.getLog(LoginServiceImp.class);

	@Autowired
	private IUsuarioDao usuarioDaoImp;


	@Override
	public Usuario getUsuario() {
		// TODO Auto-generated method stub
		LOGGER.info("Se devuele una instancia de un nuevo Usuario ");

		return  new Usuario();
	}

	@Override
	public void crear(Usuario unUsuario) {
		String pw = unUsuario.getContrasenia();
		BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder(4);
		unUsuario.setContrasenia(bCryptPasswordEncoder.encode(pw));
		LOGGER.info("Se guarda un nuevo Usuario en la BD ");

		usuarioDaoImp.save(unUsuario);
	}

	@Override
	public Usuario setearUsuario(Empresa empresa) {
		Usuario usu = new Usuario();
		usu.setIdentificador(empresa.getCuit());
		usu.setContrasenia(empresa.getContrasenia());
		usu.setTipo(empresa.getTipo());
		LOGGER.info("Se extraen los parametros de empresa para crear un nuevo usuarios)"+ empresa);
		return usu;
		
	}

	@Override
	public Usuario setearUsuarioi(Empleado empleado) {
		Usuario usu = new Usuario();
		usu.setIdentificador(empleado.getDni());
		usu.setContrasenia(empleado.getContrasenia());
		usu.setTipo(empleado.getTipo());
		LOGGER.info("Se extraen los parametros de empleado para crear un nuevo usuarios "+empleado);

		return usu;
	}

}

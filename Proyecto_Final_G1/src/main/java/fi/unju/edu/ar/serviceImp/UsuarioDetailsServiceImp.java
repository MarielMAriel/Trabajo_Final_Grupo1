package fi.unju.edu.ar.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fi.unju.edu.ar.entity.Empresa;
import fi.unju.edu.ar.repository.IEmpresaDAO;

@Service
public class UsuarioDetailsServiceImp implements UserDetailsService {
	private static final Log LOGGER = LogFactory.getLog(UsuarioDetailsServiceImp.class);
	
	@Autowired
	private IEmpresaDAO empresaDao;
	
	@Override
	public UserDetails loadUserByUsername(String cuit) throws UsernameNotFoundException {
		LOGGER.info(cuit);
		//Long.parseLong(cuit)); esto lo parcea para q este para q machee con la bd
		Empresa empleador = empresaDao.findByCuit(cuit);
		LOGGER.info(empleador);
		UserBuilder builder = null;
		if(empleador != null) {
			builder = User.withUsername(cuit);
			builder.disabled(false);
			builder.password(empleador.getContrasenia());
			builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
		}else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		return builder.build();
	}

}
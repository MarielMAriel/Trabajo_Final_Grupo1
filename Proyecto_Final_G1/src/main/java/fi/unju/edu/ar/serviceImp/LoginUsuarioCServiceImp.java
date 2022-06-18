package fi.unju.edu.ar.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.unju.edu.ar.entity.Empleado;
import fi.unju.edu.ar.repository.IUsuarioCRepository;


@Service
public class LoginUsuarioCServiceImp implements UserDetailsService{
//UserDetailsService sirve para la autentificacion del usuario_Interfaz central que carga datos específicos del usuario._Verifica el usuario
	//La interfaz requiere solo un método de solo lectura, lo que simplifica el soporte para nuevas estrategias de acceso a datos.
	
@Autowired
IUsuarioCRepository iUsuarioC;

@Override
public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
	Empleado usuarioCEncontrado = iUsuarioC.findByDni(Long.parseLong(dni)).orElseThrow(()-> new UsernameNotFoundException("Usuario no existe en la BD"));
	
	List<GrantedAuthority> tipos = new ArrayList<>();
	GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioCEncontrado.getTipo()); 
	//creo elemento y le mando de tipo de usuario encontrado
	tipos.add(grantedAuthority);
	
	UserDetails userC = (UserDetails) new User(dni, usuarioCEncontrado.getPassword(),tipos);
	return userC;
}

}

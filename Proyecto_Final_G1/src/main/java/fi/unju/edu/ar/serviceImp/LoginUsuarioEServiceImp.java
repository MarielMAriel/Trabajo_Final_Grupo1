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


import fi.unju.edu.ar.entity.Empresa;
import fi.unju.edu.ar.repository.IUsuarioERepository;

@Service
public class LoginUsuarioEServiceImp {

	//UserDetailsService sirve para la autentificacion del usuario_Interfaz central que carga datos específicos del usuario._Verifica el usuario
		//La interfaz requiere solo un método de solo lectura, lo que simplifica el soporte para nuevas estrategias de acceso a datos.
		
	@Autowired
	IUsuarioERepository iUsuarioE;
	
	/*
	La anotación @Override simplemente se utiliza, para forzar al compilador a comprobar 
	 en tiempo de compilación que estás sobrescribiendo correctamente 
	 un método, y de este modo evitar errores en tiempo de ejecución, 
	 los cuales serían mucho más difíciles de detectar.
	 */
	public UserDetails loadUserByUsername(String cuit) throws UsernameNotFoundException {
		Empresa usuarioEEncontrado = iUsuarioE.findByCuit(Long.parseLong(cuit)).orElseThrow(()-> new UsernameNotFoundException("Usuario no existe en la BD"));
		
		List<GrantedAuthority> tipos = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEEncontrado.getTipo()); 
		//creo elemento y le mando de tipo de usuario encontrado
		tipos.add(grantedAuthority);
		
		UserDetails userE = (UserDetails) new User(cuit, usuarioEEncontrado.getPassword(),tipos);
		return userE;
	}

	}


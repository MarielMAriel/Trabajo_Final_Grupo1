package fi.unju.edu.ar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import fi.unju.edu.ar.serviceImp.LoginServiceImp;

@Configuration
public class WebSecurityConfig {
	
	@Autowired
	private AutenticacionSaccessHandler autenticacion;
	
	String[] resourse = new String[] {
			"/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**","/webjars/**"
	};

	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(resourse).permitAll()
			.antMatchers("/", "/home","/NuevoEmpr","/guardarEmpresa","/NuevoUsu","/guardarEmp","/home").permitAll()
			//anule este punto para poder ir probendo otras funcionalidades
			.anyRequest().authenticated()
			.and()	
		.formLogin()
			.loginPage("/logEmpr").permitAll()
			.successHandler(autenticacion)
			.failureUrl("/logEmpr?error=true")
			.usernameParameter("identificador")
			.passwordParameter("contrasenia")
			.and()
		.logout().permitAll();
		http.headers().frameOptions().sameOrigin();

		return http.build();
	}
	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder=new BCryptPasswordEncoder(4);
		return bCryptPasswordEncoder;
	}
	@Autowired
	LoginServiceImp userDetailsService;
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	
	
}
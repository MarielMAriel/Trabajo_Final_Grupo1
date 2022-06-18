package fi.unju.edu.ar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



import fi.unju.edu.ar.serviceImp.LoginUsuarioCServiceImp;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AutenticacionSuccessHandler autenticacion;
	
	String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**","/webjars/**"
    };
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {//realiza peticion de tipo http
		http
			.authorizeRequests()
				.antMatchers(resources).permitAll()//esta linea nos permite acceder a ciertos recursos con los q estamos trabajando,ej. include si vamos a fragmentar el codigo html thymelife en distintas partes
				.antMatchers("/", "/home").permitAll()//esto es para acceder a los requerimientos slash o slash home
				.anyRequest().authenticated()//los demas requerimientos necesitan autentificacion
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.successHandler(autenticacion)
				.failureUrl("/login?error=true")
				.usernameParameter("dni")
				.passwordParameter("password")				
				.and()
			.logout()
				.permitAll();
				//.logoutSuccessUrl("/login?logout");
		http.csrf().disable();
	}
	BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }
    
    @Autowired
    LoginUsuarioCServiceImp userDetailsService;
    //userDetailsServicevoy a incorporar al usuario ciudadano q voy a cargar en la secion
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}

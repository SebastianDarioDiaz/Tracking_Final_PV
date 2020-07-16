package ar.edu.unju.fi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.fi.service.imp.LoginUsuarioServiceImp;

//import ar.edu.unju.fi.service.LoginUsuarioServiceImp;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AutenticacionSuccessHandler autenticacion;
	
	String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/images/**","/js/**","/layer/**","/webjars/**","/css-form/**","/fonts/**","/form-resources/**","vendor/**,/**"
    };
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers(resources).permitAll()
				.antMatchers("/", "/home","/usuarios/listar","/usuarios/crear").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				//.defaultSuccessUrl("/index")
				.successHandler(autenticacion)
				.failureUrl("/login?error=true")
				.usernameParameter("nombreUsuario")
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
    LoginUsuarioServiceImp userDetailsService;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}

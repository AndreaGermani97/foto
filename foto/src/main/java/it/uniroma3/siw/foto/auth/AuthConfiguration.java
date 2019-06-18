package it.uniroma3.siw.foto.auth;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AuthConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment environment;

	private DataSource dataSource;

	private final static String[] PAGINE_DIPENDENTE = { "/richieste","/richiesta/**","/aggiungiFotografo", "/aggiungiAlbum", "/aggiungiFotografia" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		    .antMatchers(HttpMethod.GET, PAGINE_DIPENDENTE).hasAnyAuthority("DIPENDENTE")
		     .anyRequest().permitAll()

	    .and().formLogin()
	       .loginPage("/login")
	       .usernameParameter("email")
	       .successForwardUrl("/accedi");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(this.buildDatasource())
				.authoritiesByUsernameQuery("SELECT email, ruolo FROM dipendente WHERE email=?")
				.usersByUsernameQuery("SELECT email, password, 1 as enabled FROM dipendente WHERE email=?");
	}

	@Bean
	DataSource buildDatasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(environment.getProperty("spring.datasource.url"));
		dataSource.setUsername(environment.getProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getProperty("spring.datasource.password"));
		return dataSource;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

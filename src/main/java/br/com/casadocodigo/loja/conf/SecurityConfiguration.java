/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.conf;

import br.com.casadocodigo.loja.daos.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author bruno
 */
// @EnableWebSecurity
@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/produtos/form").hasRole("ADMIN")
				.antMatchers("/carrinho/**").permitAll()
				.antMatchers("/pagamento/**").permitAll()
				.antMatchers(HttpMethod.POST, "/produtos").hasRole("ADMIN")
				.antMatchers(HttpMethod.GET, "/produtos").hasRole("ADMIN")
				.antMatchers("/produtos/**").permitAll()
				.antMatchers("/urlMaluca").permitAll()
				//.antMatchers("/resources/**").permitAll()
				.antMatchers("/").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login")
				.permitAll().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioDao).passwordEncoder(new BCryptPasswordEncoder());
	}

}

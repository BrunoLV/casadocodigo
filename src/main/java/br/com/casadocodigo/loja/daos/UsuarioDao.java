/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bruno
 */
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UsuarioDao implements UserDetailsService {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = manager.createQuery("select u from Usuario u where u.login = :login")
				.setParameter("login", login).getResultList();

		if (usuarios.isEmpty()) {
			throw new RuntimeException("Usuário não encontrado.");
		}

		return usuarios.get(0);
	}

	@Transactional
	public void gravar(Usuario usuario) {
		manager.persist(usuario);
	}

}

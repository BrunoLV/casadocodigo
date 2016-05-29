/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author bruno
 */
@Entity
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = -4526712087726628713L;
	
	@Id
	private String name;

	public Role(String name) {
		this.name = name;
	}

	@Override
	public String getAuthority() {
		return name;
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.conf;

import java.util.Locale;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 *
 * @author bruno
 */
public class JsonViewResolver implements ViewResolver {

	@Override
	public View resolveViewName(String string, Locale locale) throws Exception {
		MappingJackson2JsonView resolver = new MappingJackson2JsonView();
		resolver.setPrettyPrint(true);
		return resolver;
	}

}

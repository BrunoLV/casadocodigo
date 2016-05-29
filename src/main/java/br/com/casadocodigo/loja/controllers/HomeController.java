package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.daos.UsuarioDao;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private ProdutoDAO produtoDao;
	
	@Autowired
	private UsuarioDao usuarioDao;

	@RequestMapping("/")
	@Cacheable(value = "produtosHome")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("home");
		List<Produto> produtos = produtoDao.listar();
		model.addObject("produtos", produtos);
		return model;
	}
	
	@RequestMapping("/urlMaluca")
	@ResponseBody
	public String urlMaluca() {
		
		Usuario usuario = new Usuario();
		usuario.setName("admin");
		usuario.setLogin("admin@casadocodigo.com.br");
		usuario.setPassword("$2a$10$lF/cYjbSZpydmXuoZCgaDuB59xTdH/2hADddVen1b1I2bDEb/4LQO");
		usuario.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
		
		usuarioDao.gravar(usuario);
		
		return "Usuaria magico criado";
	}

}

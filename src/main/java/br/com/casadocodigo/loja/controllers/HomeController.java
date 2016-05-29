package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.daos.UsuarioDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private ProdutoDAO produtoDao;
	
	@Autowired
	private UsuarioDAO usuarioDao;

	@RequestMapping("/")
	@Cacheable(value = "produtosHome")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("home");
		List<Produto> produtos = produtoDao.listar();
		model.addObject("produtos", produtos);
		return model;
	}
	
	@RequestMapping("/url-magica-maluca-oajksfbvad6584i57j54f9684nvi658efnoewfmnvowefnoeijn")
	@ResponseBody
	@Transactional
	public String urlMaluca() {
		
		Usuario usuario = new Usuario();
		usuario.setNome("admin");
		usuario.setUsuario("admin@casadocodigo.com.br");
		usuario.setSenha("$2a$10$lF/cYjbSZpydmXuoZCgaDuB59xTdH/2hADddVen1b1I2bDEb/4LQO");
		usuario.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
		
		usuarioDao.gravar(usuario);
		
		return "Usuaria magico criado";
	}

}

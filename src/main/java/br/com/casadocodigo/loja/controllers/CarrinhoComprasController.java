package br.com.casadocodigo.loja.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.CarrinhoItem;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/carrinho")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {

	@Autowired
	private ProdutoDAO produtoDao;

	@Autowired
	private CarrinhoCompras carrinho;

	@RequestMapping("/add")
	public ModelAndView adicionar(Integer produtoId, TipoPreco tipoPreco) {

		ModelAndView model = new ModelAndView("redirect:/carrinho");

		CarrinhoItem item = criaItem(produtoId, tipoPreco);
		carrinho.add(item);

		model.addObject("carrinho", carrinho);

		return model;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		return new ModelAndView("carrinho/itens");
	}

	@RequestMapping(value = "/remover", method = RequestMethod.POST)
	public ModelAndView remover(Integer produtoId, TipoPreco tipoPreco) {
		ModelAndView model = new ModelAndView("redirect:/carrinho");
		carrinho.remover(produtoId, tipoPreco);
		return model;
	}

	private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipoPreco) {
		Produto produto = produtoDao.find(produtoId);
		CarrinhoItem item = new CarrinhoItem(produto, tipoPreco);
		return item;
	}

}

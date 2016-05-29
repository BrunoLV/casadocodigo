package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.loja.validation.ProdutionValidation;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDAO produtoDao;

	@Autowired
	private FileSaver fileSaver;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProdutionValidation());
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form(Produto produto) {
		ModelAndView model = new ModelAndView("produtos/form");
		model.addObject("tipos", TipoPreco.values());
		return model;
	}

	@RequestMapping(method = RequestMethod.POST)
	@CacheEvict(value = "produtosHome", allEntries = true)
	public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return form(produto);
		}
		String path = fileSaver.saveFile("arquivos-sumario", sumario);
		produto.setSumarioPath(path);
		produtoDao.gravar(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
		return new ModelAndView("redirect:produtos");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		List<Produto> produtos = produtoDao.listar();

		ModelAndView model = new ModelAndView("produtos/lista");
		model.addObject("produtos", produtos);
		return model;
	}

	@RequestMapping(value = "/detalhe/{id}", method = RequestMethod.GET)
	public ModelAndView detalhar(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView("produtos/detalhe");
		Produto produto = produtoDao.find(id);
		model.addObject("produto", produto);
		return model;
	}

	/*
	 * @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public Produto detalheJson(@PathVariable("id") Integer id)
	 * { Produto produto = produtoDao.find(id); return produto; }
	 */

}

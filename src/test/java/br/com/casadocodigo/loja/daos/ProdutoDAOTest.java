package br.com.casadocodigo.loja.daos;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.casadocodigo.loja.builders.ProdutoBuilder;
import br.com.casadocodigo.loja.conf.DataSourceConfigurationTest;
import br.com.casadocodigo.loja.conf.JPAConfiguration;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfigurationTest.class, ProdutoDAO.class, JPAConfiguration.class})
@ActiveProfiles("test")
public class ProdutoDAOTest {
	
	@Autowired
	private ProdutoDAO dao;

	@Test @Transactional
	public void deveSomarTodosPrecosDeCadaProdutoPorTipo() {
		List<Produto> impressos = ProdutoBuilder.newProduto(TipoPreco.IMPRESSO, BigDecimal.TEN).more(4).buildAll();
		
		impressos.stream().forEach(dao::gravar);
		
		List<Produto> ebooks = ProdutoBuilder.newProduto(TipoPreco.EBOOK, BigDecimal.TEN).more(4).buildAll();
		
		ebooks.stream().forEach(dao::gravar);
		
		BigDecimal value = dao.somarPrecosPorTipo(TipoPreco.IMPRESSO);
		
		Assert.assertEquals(new BigDecimal(50).setScale(2), value);

	}

}

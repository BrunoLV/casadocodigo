package br.com.casadocodigo.loja.daos;

import javax.servlet.Filter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.casadocodigo.loja.conf.AppWebConfiguration;
import br.com.casadocodigo.loja.conf.DataSourceConfigurationTest;
import br.com.casadocodigo.loja.conf.JPAConfiguration;
import br.com.casadocodigo.loja.conf.SecurityConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { AppWebConfiguration.class, JPAConfiguration.class, SecurityConfiguration.class,
		DataSourceConfigurationTest.class, ProdutoDAO.class })
@ActiveProfiles("test")
public class ProdutoControllerTest {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Autowired
	private UsuarioDao UsuarioDao;

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private Filter springSecurityFilterChain;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).addFilter(springSecurityFilterChain).build();
	}

	@Test
	public void deveListarTodosProdutosNaHome() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("produtos"))
				.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/home.jsp"));
	}

	@Test
	public void somenteAdminDeveAcessarProdutosForm() throws Exception {
		RequestPostProcessor processor = SecurityMockMvcRequestPostProcessors.user("comprador@gmail.com")
				.password("123456").roles("COMPRADOR");
		this.mockMvc.perform(MockMvcRequestBuilders.get("/produtos/form").with(processor))
				.andExpect(MockMvcResultMatchers.status().is(403));
	}

}

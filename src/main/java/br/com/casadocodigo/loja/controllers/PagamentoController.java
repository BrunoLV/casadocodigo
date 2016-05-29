package br.com.casadocodigo.loja.controllers;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.DadosPagamento;
import br.com.casadocodigo.loja.models.Usuario;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	private CarrinhoCompras carrinho;
	
	@Autowired
	private MailSender mailer;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/finalizar", method = RequestMethod.POST)
	public Callable<ModelAndView> finalizar(@AuthenticationPrincipal Usuario usuario, RedirectAttributes attributes) {
		return () -> {
			ModelAndView model = new ModelAndView("redirect:/produtos");

			try {
				String uri = "http://book-payment.herokuapp.com/payment";
				String response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()),
						String.class);
				attributes.addFlashAttribute("sucesso", response);
				
				sendEmailFinalizacaoCompra(usuario);

			} catch (HttpClientErrorException e) {
				e.printStackTrace();
				attributes.addFlashAttribute("falha", "Valor acima do permitido.");
			}
			return model;
		};
	}

	private void sendEmailFinalizacaoCompra(Usuario usuario) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom("compra@casadocodigo.com.br");
		email.setTo(usuario.getUsuario());
		email.setSubject("Nova compra");
		email.setText("Testando aplicação");
		mailer.send(email);
	}

}

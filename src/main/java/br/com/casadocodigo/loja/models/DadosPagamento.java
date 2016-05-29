package br.com.casadocodigo.loja.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class DadosPagamento implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal value;

	public DadosPagamento() {
	}

	public DadosPagamento(BigDecimal value) {
		super();
		this.value = value;
	}

	public BigDecimal getValue() {
		return value;
	}

}

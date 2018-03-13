package br.edu.ufcg.enums;

import br.edu.ufcg.util.Validador;

public enum EstadoAvaliacaoAjuda {
	AVALIADA("avaliada"), NAO_AVALIADA("nao avaliada");

	private String valor;

	EstadoAvaliacaoAjuda(String valor) {
		Validador.parametroInvalido(valor, "Valor nao pode ser nulo ou vazio");
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}

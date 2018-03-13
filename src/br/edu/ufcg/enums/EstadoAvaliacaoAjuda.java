package br.edu.ufcg.enums;

import br.edu.ufcg.util.Validador;

/**
 * Classe Enum que armazena valores para o estado de uma Ajuda. Uma ajuda pode
 * ser já avaliada ou ainda não avaliada.
 * 
 * Projeto de Laboratório - Programação II.
 *
 */

public enum EstadoAvaliacaoAjuda {
	AVALIADA("avaliada"), NAO_AVALIADA("nao avaliada");

	private String valor;

	/**
	 * Muda o Enum para o valor passado.
	 * 
	 * @param valor
	 */
	EstadoAvaliacaoAjuda(String valor) {
		Validador.parametroInvalido(valor, "Valor nao pode ser nulo ou vazio");
		this.valor = valor;
	}

	/**
	 * Retorna o valor do Enum.
	 * 
	 * @return uma String.
	 */
	public String getValor() {
		return valor;
	}
}

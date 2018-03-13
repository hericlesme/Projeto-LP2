package br.edu.ufcg.entities;


public enum EstadoAvaliacaoAjuda {
	AVALIADA("avaliada"), NAO_AVALIADA("nao avaliada");

	private String valor;

	EstadoAvaliacaoAjuda(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}

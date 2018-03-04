package br.edu.ufcg.controllers;


public class Caixa {

	private int caixa;
	private Dados dados;
	
	public Caixa(Dados dados) {
		this.caixa = 0;
		this.dados = dados;
	}
	
	public void doar(String matriculaTutor, int totalCentavos) {
		// Fazer o calculo do quanto fica no sistema e do quanto vai para o aluno.
		this.dados.getTutores().get(this.dados.getAlunos().get(matriculaTutor).getEmail()).receberDoacao(totalCentavos);;
	}
	
	public int totalDinheiroSistema() {
		return this.caixa;
	}
	
}

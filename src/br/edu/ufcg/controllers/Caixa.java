package br.edu.ufcg.controllers;

public class Caixa {

	private int caixa;
	private Dados dados;

	public Caixa(Dados dados) {
		this.caixa = 0;
		this.dados = dados;
	}

	public void doar(String matriculaTutor, int totalCentavos) {
		double taxaTutor = this.dados.getTutores()
		        .get(this.dados.getAlunos().get(matriculaTutor).getEmail())
		        .taxaTutor();

		int totalSistema = (int) Math.floor((1 - taxaTutor) * totalCentavos);
		this.caixa += totalSistema;
		
		this.dados.getTutores()
		        .get(this.dados.getAlunos().get(matriculaTutor).getEmail())
		        .addDinheiroDoacoes(totalCentavos - totalSistema);
	}

	public int totalDinheiroSistema() {
		return this.caixa;
	}

}

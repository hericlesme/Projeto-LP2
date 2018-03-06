package br.edu.ufcg.controllers;

public class Caixa {

	private int caixa;
	private Dados dados;

	public Caixa(Dados dados) {
		this.caixa = 0;
		this.dados = dados;
	}

	public void doar(String matriculaTutor, int totalCentavos) {
		int taxaTutor = this.dados.getTutores()
		        .get(this.dados.getAlunos().get(matriculaTutor).getEmail())
		        .taxaTutor();

		double taxaSistema = (100 - taxaTutor) / 100.0;
		int totalSistema = (int) (taxaSistema * totalCentavos);
		caixa += totalSistema;

		this.dados.getTutores()
		        .get(this.dados.getAlunos().get(matriculaTutor).getEmail())
		        .addDinheiroDoacoes(totalCentavos - totalSistema);
	}

	public int totalDinheiroSistema() {
		return this.caixa;
	}

}

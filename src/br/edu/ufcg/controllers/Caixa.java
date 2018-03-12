package br.edu.ufcg.controllers;

public class Caixa {

	private Dados dados;

	public Caixa(Dados dados) {
		this.dados = dados;
	}

	public void doar(String matriculaTutor, int totalCentavos) {
		int taxaTutor = this.dados.getTutores()
		        .get(this.dados.getAlunos().get(matriculaTutor).getEmail())
		        .taxaTutor();

		double taxaSistema = (100 - taxaTutor) / 100.0;
		int totalSistema = (int) (taxaSistema * totalCentavos);
		this.dados.setCaixa(totalSistema);

		this.dados.getTutores()
		        .get(this.dados.getAlunos().get(matriculaTutor).getEmail())
		        .addDinheiroDoacoes(totalCentavos - totalSistema);
	}

	public int totalDinheiroSistema() {
		return this.dados.getCaixa();
	}

}

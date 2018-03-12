package br.edu.ufcg.controllers;

import br.edu.ufcg.util.Validador;

public class Caixa {

	private int caixa;
	private Dados dados;
	private Validador validador;

	public Caixa(Dados dados) {
		this.caixa = 0;
		this.dados = dados;
		this.validador = new Validador();
	}

	public void doar(String matriculaTutor, int totalCentavos) {
		if (!this.dados.getAlunos().containsKey(matriculaTutor)) {
			validador.tutorNaoEncontrado("Erro na doacao para tutor");
		}
		validador.validaInteiro(totalCentavos,
				"Erro na doacao para tutor: totalCentavos nao pode ser menor que zero");
		int taxaTutor = this.dados.getTutores().get(this.dados.getAlunos().get(matriculaTutor).getEmail())
				.taxaTutor();

		double taxaSistema = (100 - taxaTutor) / 100.0;
		int totalSistema = (int) (taxaSistema * totalCentavos);
		caixa += totalSistema;

		this.dados.getTutores().get(this.dados.getAlunos().get(matriculaTutor).getEmail())
				.addDinheiroDoacoes(totalCentavos - totalSistema);
	}

	public int totalDinheiroSistema() {
		return this.caixa;
	}

}

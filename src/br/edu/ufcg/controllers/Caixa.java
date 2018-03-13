package br.edu.ufcg.controllers;

import br.edu.ufcg.util.Dados;
import br.edu.ufcg.util.Validador;

public class Caixa {

	private Dados dados;

	public Caixa(Dados dados) {
		this.dados = dados;
	}

	public void doar(String matriculaTutor, int totalCentavos) {
		Validador.parametroInvalido(matriculaTutor, "Erro na doacao para tutor: Matricula nao pode ser nula ou vazia");
		if (!this.dados.getAlunos().containsKey(matriculaTutor)) {
			Validador.tutorNaoEncontrado("Erro na doacao para tutor");
		}
		Validador.validaInteiro(totalCentavos,
				"Erro na doacao para tutor: totalCentavos nao pode ser menor que zero");
		int taxaTutor = this.dados.getTutores().get(this.dados.getAlunos().get(matriculaTutor).getEmail())
				.taxaTutor();

		double taxaSistema = (100 - taxaTutor) / 100.0;
		int totalSistema = (int) (taxaSistema * totalCentavos);
		this.dados.setCaixa(totalSistema);

		this.dados.getTutores().get(this.dados.getAlunos().get(matriculaTutor).getEmail())
				.addDinheiroDoacoes(totalCentavos - totalSistema);
	}

	public int totalDinheiroSistema() {
		return this.dados.getCaixa();
	}

}

package br.edu.ufcg.controllers;

import br.edu.ufcg.util.Dados;
import br.edu.ufcg.util.Validador;

/**
 * Classe que representa um controller de transações financeiras no sistema.
 * Possui um atributo Dados que armazena Maps contendo Tutores e Alunos.
 * 
 * Projeto Laboratório de Programação II
 *
 */
public class Caixa {

	private Dados dados;

	/**
	 * Constrói um objeto do tipo Caixa a partir de um objeto Dados.
	 * 
	 * @param dados
	 *                objeto que armazena os Maps de alunos e tutores.
	 */
	public Caixa(Dados dados) {
		this.dados = dados;
	}

	/**
	 * Método para doação de dinheiro a um tutor. Quando alguém decide doar dinheiro
	 * para o tutor, uma parte da doação vai para o caixa do sistema, enquanto a
	 * outra vai para o tutor. A parte do tutor é baseada no seu nivel.
	 * 
	 * @param matriculaTutor
	 *                matricula do tutor para doação.
	 * @param totalCentavos
	 *                total de dinheiro em centavos para doação.
	 */
	public void doar(String matriculaTutor, int totalCentavos) {
		Validador.parametroInvalido(matriculaTutor,
				"Erro na doacao para tutor: Matricula nao pode ser nula ou vazia");
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

	/**
	 * Retorna um inteiro que representa o total de dinheiro que o sistema possui.
	 * 
	 * @return um int.
	 */
	public int totalDinheiroSistema() {
		return this.dados.getCaixa();
	}

}

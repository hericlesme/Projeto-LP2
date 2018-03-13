package br.edu.ufcg.entities;

import br.edu.ufcg.enums.AtributoAjuda;

/**
 * Classe que herda de Ajuda, representando uma Ajuda Online.
 *
 * Projeto Laboratório de Programação II
 */
public class AjudaOnline extends Ajuda {

	private static final long serialVersionUID = 2488526186791710145L;

	/**
	 * Constrói um objeto do tipo AjudaOnline a partir da matricula do aluno que
	 * pediu a ajuda, matricula do tutor que irá ajudar e nome da disciplina a ser
	 * ajudada. Usa o construtor de Ajuda.
	 * 
	 * @param matrAluno
	 *                matricula do aluno.
	 * @param matrTutor
	 *                matricula do tutor.
	 * @param disciplina
	 *                nome da disciplina.
	 */
	public AjudaOnline(String matrAluno, String matrTutor, String disciplina) {
		super(matrAluno, matrTutor, disciplina);
	}

	/**
	 * Retorna uma informação da AjudaOnline passado o nome dessa informação. Lança
	 * exceção caso seja uma informação inválida.
	 * 
	 * @param atributo
	 *                nome da informação.
	 * @return uma String.
	 */
	@Override
	public String getInfo(String atributo) {
		AtributoAjuda atribAjuda;
		try {
			atribAjuda = AtributoAjuda.valueOf(atributo.toUpperCase());
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
		switch (atribAjuda) {

		case DISCIPLINA:
			return this.disciplina;
		case MATR_ALUNO:
			return this.matrAluno;
		case MATR_TUTOR:
			return this.matrTutor;
		default:
			return "";
		}
	}

	/**
	 * Retorna uma String com informações sobre o tutor que irá ajudar. "Tutor -
	 * Matricula, disciplina - Disciplina"
	 * 
	 * @return uma String.
	 */
	public String pegarTutor() {
		return "Tutor - " + this.matrTutor + ", disciplina - " + this.disciplina;
	}
}

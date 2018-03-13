package br.edu.ufcg.entities;

import java.io.Serializable;

import br.edu.ufcg.enums.EstadoAvaliacaoAjuda;
import br.edu.ufcg.exceptions.AlreadyAssessedException;
import br.edu.ufcg.util.Validador;

/**
 * Classe abstrata que representa uma Ajuda no sistema. Uma ajuda tem como
 * atributos o nome da disciplina a ser ajudada, a matricula do aluno que pediu
 * a ajuda, a matricula do tutor que ajudará e o estado da ajuda(Se já foi
 * finalizada ou não).
 * 
 * Projeto Laboratório de Programação II
 *
 */
public abstract class Ajuda implements Serializable {

	private static final long serialVersionUID = 4211669500722290686L;
	protected String disciplina;
	protected String matrAluno;
	protected String matrTutor;
	protected EstadoAvaliacaoAjuda estadoAvaliacao;

	/**
	 * Constrói um objeto do tipo Ajuda a partir da matricula do aluno que pediu a
	 * ajuda, matricula do tutor que irá ajudar e nome da disciplina a ser ajudada.
	 * 
	 * @param matrAluno
	 *                matricula do aluno.
	 * @param matrTutor
	 *                matricula do tutor.
	 * @param disciplina
	 *                nome da disciplina.
	 */
	public Ajuda(String matrAluno, String matrTutor, String disciplina) {
		Validador.parametroInvalido(matrAluno, "Matricula do aluno nao pode ser nula ou vazia");
		Validador.parametroInvalido(matrTutor, "Matricula do tutor nao pode ser nula ou vazia");
		Validador.parametroInvalido(disciplina, "Disciplina nao pode ser nula ou vazia");
		this.matrAluno = matrAluno;
		this.matrTutor = matrTutor;
		this.disciplina = disciplina;
		this.estadoAvaliacao = EstadoAvaliacaoAjuda.NAO_AVALIADA;
	}

	/**
	 * Método abstrato que retorna uma determinada informação da Ajuda, passado o
	 * nome dessa informação.
	 * 
	 * @param atributo
	 *                nome da informação a ser recuperada.
	 * @return uma String.
	 */
	public abstract String getInfo(String atributo);

	/**
	 * Método abstrato que retorna o tutor que irá ajudar.
	 * 
	 * @return uma String.
	 */
	public abstract String pegarTutor();

	/**
	 * Método utilizado para quando a ajuda for avaliada, altera seu estado para
	 * finalizada. Caso a ajuda já tenha sido avaliada, lança uma exceção.
	 */
	public void avaliaAjuda() {
		if (this.estadoAvaliacao.equals(EstadoAvaliacaoAjuda.AVALIADA)) {
			throw new AlreadyAssessedException("Erro na avaliacao de tutor: Ajuda ja avaliada");
		}
		this.estadoAvaliacao = EstadoAvaliacaoAjuda.AVALIADA;
	}

}

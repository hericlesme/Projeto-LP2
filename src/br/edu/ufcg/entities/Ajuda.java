package br.edu.ufcg.entities;

import java.io.Serializable;

import br.edu.ufcg.enums.EstadoAvaliacaoAjuda;
import br.edu.ufcg.exceptions.AlreadyAssessedException;
import br.edu.ufcg.util.Validador;

public abstract class Ajuda implements Serializable {

	private static final long serialVersionUID = 4211669500722290686L;
	protected String disciplina;
	protected String matrAluno;
	protected String matrTutor;
	protected EstadoAvaliacaoAjuda estadoAvaliacao;

	public Ajuda(String matrAluno, String matrTutor, String disciplina) {
		Validador.parametroInvalido(matrAluno, "Matricula do aluno nao pode ser nula ou vazia");
		Validador.parametroInvalido(matrTutor, "Matricula do tutor nao pode ser nula ou vazia");
		Validador.parametroInvalido(disciplina, "Disciplina nao pode ser nula ou vazia");
		this.matrAluno = matrAluno;
		this.matrTutor = matrTutor;
		this.disciplina = disciplina;
		this.estadoAvaliacao = EstadoAvaliacaoAjuda.NAO_AVALIADA;
	}

	public abstract String getInfo(String atributo);

	public abstract String pegarTutor();

	public void avaliaAjuda() {
		if (this.estadoAvaliacao.equals(EstadoAvaliacaoAjuda.AVALIADA)) {
			throw new AlreadyAssessedException("Erro na avaliacao de tutor: Ajuda ja avaliada");
		}
		this.estadoAvaliacao = EstadoAvaliacaoAjuda.AVALIADA;
	}

}

package br.edu.ufcg.entities;

import java.io.Serializable;

import br.edu.ufcg.util.Validador;

public abstract class Ajuda implements Serializable {
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
		this.estadoAvaliacao = EstadoAvaliacaoAjuda.AVALIADA;
	}

}

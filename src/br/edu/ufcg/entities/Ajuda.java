package br.edu.ufcg.entities;

public abstract class Ajuda {
	protected String disciplina;
	protected String matrAluno;
	protected String matrTutor;
	protected int nota;

	public Ajuda(String matrAluno, String disciplina) {
		this.matrAluno = matrAluno;
		this.disciplina = disciplina;
		this.nota = 0;
	}

	public abstract String getInfo(String atributo);

	public void avaliarAjuda(int nota) {
		this.nota = nota;
	}
}

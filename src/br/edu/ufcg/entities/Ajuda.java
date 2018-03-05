package br.edu.ufcg.entities;

public abstract class Ajuda {
	protected String disciplina;
	protected String matrAluno;
	protected String matrTutor;

	public Ajuda(String matrAluno, String matrTutor, String disciplina) {
		this.matrAluno = matrAluno;
		this.matrTutor = matrTutor;
		this.disciplina = disciplina;
	}

	public abstract String getInfo(String atributo);

	public abstract String pegarTutor();
}

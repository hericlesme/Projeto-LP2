package br.edu.ufcg.entities;

public class Aluno {

	private int notaAvaliacao;
	private String matricula;
	private String telefone;
	private int codigoCurso;
	private Tutoria papel;
	private String email;
	private String nome;

	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.codigoCurso = codigoCurso;
		this.matricula = matricula;
		this.telefone = telefone;
		this.notaAvaliacao = 5;
		this.email = email;
		this.nome = nome;
	}

	public void tonarTutor() {

	}

	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + toStringComplemento();
	}

	private String toStringComplemento() {
		if (telefone.trim().isEmpty()) {
			return this.email;
		}
		return this.telefone + " - " + this.email;
	}

	public void setAvaliacao(int nota) {
		this.notaAvaliacao = nota;
	}

	public int getAvaliacao() {
		return this.notaAvaliacao;
	}
}

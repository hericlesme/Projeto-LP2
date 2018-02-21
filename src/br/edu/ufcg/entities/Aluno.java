package br.edu.ufcg.entities;

public class Aluno {
	private String matricula;
	private String nome;
	private int codigoCurso;
	private String telefone;
	private String email;
	private int notaAvaliacao;

	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		nomeInvalido(nome);
		emailInvalido(email);
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoCurso;
		this.telefone = telefone;
		this.email = email;
		this.notaAvaliacao = 5;
	}

	public String toString() {
		if (this.telefone.isEmpty() || this.telefone == null) {
			return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.email;
		}
		return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.telefone + " - "
				+ this.email;
	}

	public void setAvaliacao(int nota) {
		this.notaAvaliacao = nota;
	}

	public int getAvaliacao() {
		return this.notaAvaliacao;
	}

	private void nomeInvalido(String nome) {
		if (nome == null) {
			throw new NullPointerException("Nome nulo");
		}
		if (nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome em branco");
		}
	}

	private void emailInvalido(String email) {
		if (!email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
			throw new IllegalArgumentException("Email invalido");
		}
	}
}

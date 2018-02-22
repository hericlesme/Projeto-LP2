package br.edu.ufcg.entities;

public class Aluno {

	private int notaAvaliacao;
	private String matricula;
	private String telefone;
	private int codigoCurso;
	private String email;
	private String nome;
	private Funcao funcao;

	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.codigoCurso = codigoCurso;
		this.matricula = matricula;
		this.telefone = telefone;
		this.notaAvaliacao = 5;
		this.email = email;
		this.nome = nome;
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

	public void tornarTutor(String disciplina, int proficiencia) {
		this.funcao = new Tutor(disciplina, proficiencia);
	}

	public void cadastrarHorario(String horario, String dia) {
		this.funcao.cadastrarHorario(horario, dia);
	}

	public void cadastrarLocalDeAtendimento(String email, String local) {
		this.funcao.cadastrarLocalDeAtendimento(local);
	}
}

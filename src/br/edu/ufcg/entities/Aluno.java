package br.edu.ufcg.entities;

public class Aluno implements Comparable<Aluno> {

	private int notaAvaliacao;
	private String matricula;
	private String telefone;
	private int codigoCurso;
	private String email;
	private String nome;
	private Funcao funcao;

	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.notaAvaliacao = 5;
		this.matricula = matricula;
		this.telefone = telefone;
		this.codigoCurso = codigoCurso;
		this.email = email;
		this.nome = nome;
		this.funcao = new Nagato();
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

	public String getInfoAluno(String atributo) {
		switch (atributo.toLowerCase()) {
		case "notavaliacao":
			return Integer.toString(this.notaAvaliacao);
		case "matricula":
			return this.matricula;
		case "telefone":
			return this.telefone;
		case "codigocurso":
			return Integer.toString(this.codigoCurso);
		case "email":
			return this.email;
		case "nome":
			return this.nome;
		default:
			return "Atributo invalido";
		}
	}

	@Override
	public int compareTo(Aluno a) {
		return this.email.compareTo(a.getEmail());

	}

	public String getEmail() {
		return this.email;
	}

	public void tornarTutor(String disciplina, int proficiencia) {
		this.funcao = new Tutor(disciplina, proficiencia);
	}

	public void cadastrarHorario(String horario, String dia) {
		this.funcao.cadastrarHorario(horario, dia);
	}

	public void cadastrarLocalDeAtendimento(String local) {
		this.funcao.cadastrarLocalDeAtendimento(local);
	}

	public boolean consultaHorario(String horario, String dia) {
		return this.funcao.consultaHorario(horario, dia);
	}

	public boolean consultaLocal(String local) {
		return this.funcao.consultaLocal(local);
	}

}

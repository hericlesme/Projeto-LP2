package br.edu.ufcg.controllers;

public class Facade {

	QmdSistema sys = new QmdSistema();

	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		sys.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}

	public String recuperaAluno(String matricula) {
		return sys.recuperaAluno(matricula);
	}

	public String listarAlunos() {
		return sys.listarAlunos();
	}

	public String getInfoAluno(String matricula, String atributo) {
		return sys.getInfoAluno(matricula, atributo);
	}

	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		sys.tornarTutor(matricula, disciplina, proficiencia);
	}

	public String recuperaTutor(String matricula) {
		return sys.recuperaTutor(matricula);
	}

	public String listarTutores() {
		return sys.listarTutores();
	}

	public void cadastrarHorario(String email, String horario, String dias) {
		sys.cadastrarHorario(email, horario, dias);
	}

	public void cadastrarLocalDeAtendimento(String email, String local) {
		sys.cadastrarLocalDeAtendimento(email, local);
	}

	public boolean consultaHorario(String email, String horario, String dias) {
		return sys.consultaHorario(email, horario, dias);
	}

	public boolean consultaLocal(String email, String local) {
		return sys.consultaLocal(email,local);
	}

}

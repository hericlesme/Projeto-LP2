package br.edu.ufcg.controllers;

import easyaccept.EasyAccept;

public class Facade {

	QmaSistema sys = new QmaSistema();

	public static void main(String[] args) {
		args = new String[] { "br.edu.ufcg.controllers.Facade", "EasyAccept//us1_test.txt", "EasyAccept//us1_test.txt" };
		EasyAccept.main(args);
	}

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
		return sys.consultaLocal(email, local);
	}

}

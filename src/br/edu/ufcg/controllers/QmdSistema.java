package br.edu.ufcg.controllers;

import java.util.List;
import java.util.Map;

import br.edu.ufcg.entities.Aluno;
import br.edu.ufcg.util.Checks;

public class QmdSistema {
	
	private Checks check = new Checks();
	Map<String, Aluno> alunos;
	private List<String> matriculasDosTutores;
	
	public QmdSistema() {
		
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		// TODO Auto-generated method stub
		
	}

	public String recuperaAluno(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	public String listarAlunos() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getInfoAluno(String matricula, String atributo) {
		// TODO Auto-generated method stub
		return null;
	}

	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		// TODO Auto-generated method stub
		
	}

	public String recuperaTutor(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	public String listarTutores() {
		// TODO Auto-generated method stub
		return null;
	}

	public void cadastrarHorario(String email, String horario, String dias) {
		// TODO Auto-generated method stub
		
	}

	public void cadastrarLocalDeAtendimento(String email, String local) {
		// TODO Auto-generated method stub
		
	}

	public boolean consultaHorario(String email, String horario, String dias) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean consultaLocal(String email, String local) {
		// TODO Auto-generated method stub
		return false;
	}

}

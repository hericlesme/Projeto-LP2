package br.edu.ufcg.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ufcg.entities.Aluno;
import br.edu.ufcg.util.Validador;

public class QmdSistema {

	private Validador validador;
	Map<String, Aluno> alunos;
	private List<String> matriculasDosTutores;

	public QmdSistema() {
		this.validador = new Validador();
		alunos = new HashMap<>();
		matriculasDosTutores = new ArrayList<>();
	}

	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		validador.cadastroInvalido(nome, matricula, codigoCurso, telefone, email);
		
		if (alunos.containsKey(matricula)) {
			validador.matriculaCadastrada();
		}
		
		alunos.put(matricula, new Aluno(nome, matricula, codigoCurso, telefone, email));
	}

	public String recuperaAluno(String matricula) {
		if (!alunos.containsKey(matricula)) {
			validador.alunoInexistente("Erro na busca por aluno");
		}
		// TODO Auto-generated method stub
		return null;
	}

	public String listarAlunos() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getInfoAluno(String matricula, String atributo) {
		if (!alunos.containsKey(matricula)) {
			validador.alunoInexistente("Erro na obtencao de informacao de aluno");
		}
		
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

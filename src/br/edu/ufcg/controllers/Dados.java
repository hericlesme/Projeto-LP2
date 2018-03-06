package br.edu.ufcg.controllers;

import java.util.HashMap;
import java.util.Map;

import br.edu.ufcg.entities.Aluno;
import br.edu.ufcg.entities.Tutor;

public class Dados {

	private Map<String, Aluno> alunos;
	private Map<String, Tutor> tutores;

	public Dados() {
		this.alunos = new HashMap<String, Aluno>();
		this.tutores = new HashMap<String, Tutor>();
	}

	public Map<String, Aluno> getAlunos() {
		return this.alunos;
	}

	public Map<String, Tutor> getTutores() {
		return this.tutores;
	}

	public void adicionaAluno(String matricula, Aluno aluno) {
		this.alunos.put(matricula, aluno);
	}

	public void adicionaTutor(String email, Tutor tutor) {
		this.tutores.put(email, tutor);
	}
}

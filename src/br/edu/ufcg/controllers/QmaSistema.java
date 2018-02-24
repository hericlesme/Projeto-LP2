package br.edu.ufcg.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ufcg.entities.Aluno;
import br.edu.ufcg.util.Validador;

public class QmaSistema {

	private Validador validador;
	private Map<String, Aluno> alunos;
	private Map<String,String> tutores;

	public QmaSistema() {
		this.validador = new Validador();
		this.alunos = new HashMap<String,Aluno>();
		this.tutores = new HashMap<String,String>();
	}

	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.validador.cadastroInvalido(nome, matricula, codigoCurso, telefone, email);
		
		if (alunos.containsKey(matricula)) {
			validador.matriculaCadastrada();
		}
		
		this.alunos.put(matricula, new Aluno(nome, matricula, codigoCurso, telefone, email));
	}

	public String recuperaAluno(String matricula) {
		if (!alunos.containsKey(matricula)) {
			validador.alunoInexistente("Erro na busca por aluno");
		}
		return this.alunos.get(matricula).toString();
	}

	public String listarAlunos() {
		String out = new String();
		List<Aluno> alunosOrdenados = new ArrayList<Aluno>(alunos.values());
		Collections.sort(alunosOrdenados);
		for (Aluno aluno : alunosOrdenados) {
			out += aluno.toString() + "," + System.lineSeparator();
		}
		return out;
	}

	public String getInfoAluno(String matricula, String atributo) {
		if (!alunos.containsKey(matricula)) {
			validador.alunoInexistente("Erro na obtencao de informacao de aluno");
		}
		return this.alunos.get(matricula).getInfoAluno(atributo);
	}

	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		this.alunos.get(matricula).tornarTutor(disciplina, proficiencia);
		this.tutores.put(this.alunos.get(matricula).getEmail(), matricula);
	}

	public String recuperaTutor(String matricula) {
		if (!tutores.containsValue(matricula)) {
			//Throw a exception here,something like "This student isn't a tutor".
		}
		return this.alunos.get(matricula).toString();
		
	}

	public String listarTutores() {
		String out = new String();
		List<Aluno> alunosOrdenados = new ArrayList<Aluno>(alunos.values());
		Collections.sort(alunosOrdenados);
		for (Aluno aluno : alunosOrdenados) {
			if (this.tutores.containsKey(aluno.getEmail())) {
				out += aluno.toString() + "," + System.lineSeparator();
			}
		}
		return out;
	}

	public void cadastrarHorario(String email, String horario, String dias) {
		if (!tutores.containsKey(email)) {
			//Throw a exception, come on ya know what to do.
		}
		this.alunos.get(this.tutores.get(email)).cadastrarHorario(horario, dias);
	}

	public void cadastrarLocalDeAtendimento(String email, String local) {
		if (!tutores.containsKey(email)) {
			//Badabom badabam, ur pussy smells like ham.
		}
		this.alunos.get(this.tutores.get(email)).cadastrarLocalDeAtendimento(local);

	}

	public boolean consultaHorario(String email, String horario, String dias) {
		if (!tutores.containsKey(email)) {
			// Skidaddle skidoddle, ur dick is now a noodle.
		}
		return this.alunos.get(this.tutores.get(email)).consultaHorario(horario, dias);
	}

	public boolean consultaLocal(String email, String local) {
		if (!tutores.containsKey(email)) {
			// Roses are red
			//violets are blue
			// the comment is in english
			// so why aren't you?
		}
		return this.alunos.get(this.tutores.get(email)).consultaLocal(local);
	}

}

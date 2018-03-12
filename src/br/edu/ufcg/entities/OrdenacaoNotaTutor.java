package br.edu.ufcg.entities;

import java.util.Comparator;
import java.util.Map;

public class OrdenacaoNotaTutor implements Comparator<Tutor> {
	private Map<String, Aluno> alunos;

	public OrdenacaoNotaTutor(Map<String, Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public int compare(Tutor t1, Tutor t2) {
		if (t1.compareTo(t2) == 0) {
			return alunos.get(t1.getMatricula()).getId()
			        - alunos.get(t2.getMatricula()).getId();
		} else {
			return t1.compareTo(t2);
		}
	}

}

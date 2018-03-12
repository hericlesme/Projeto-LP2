package br.edu.ufcg.entities;

import java.util.Comparator;

public class OrdenacaoEmailAluno implements Comparator<Aluno> {

	@Override
	public int compare(Aluno a1, Aluno a2) {
		int compare = a1.getEmail().compareTo(a2.getEmail());

		if (compare == 0) {
			return a1.getMatricula().compareTo(a2.getMatricula());
		}
		return compare;
	}

}

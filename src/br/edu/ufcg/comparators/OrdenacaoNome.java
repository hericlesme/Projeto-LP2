package br.edu.ufcg.comparators;

import java.util.Comparator;

import br.edu.ufcg.entities.Aluno;

public class OrdenacaoNome implements Comparator<Aluno> {

	@Override
	public int compare(Aluno a1, Aluno a2) {
		int compare = a1.getNome().compareTo(a2.getNome());
		if (compare == 0) {
			return a1.getMatricula().compareTo(a2.getMatricula());
		}
		return compare;
	}
}

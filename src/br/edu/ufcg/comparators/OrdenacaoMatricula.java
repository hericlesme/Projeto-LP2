package br.edu.ufcg.comparators;

import java.util.Comparator;

import br.edu.ufcg.entities.Aluno;

public class OrdenacaoMatricula implements Comparator<Aluno> {

	@Override
	public int compare(Aluno a1, Aluno a2) {
		return a1.getMatricula().compareTo(a2.getMatricula());

	}

}

package br.edu.ufcg.entities;

import java.util.Comparator;

public class OrdenacaoMatricula implements Comparator<Aluno> {

	@Override
	public int compare(Aluno a1, Aluno a2) {
		return a1.getMatricula().compareTo(a2.getMatricula());

	}

}

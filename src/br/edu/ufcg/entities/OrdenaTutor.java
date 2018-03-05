package br.edu.ufcg.entities;

import java.util.Comparator;

import br.edu.ufcg.controllers.Dados;

public class OrdenaTutor implements Comparator<Tutor> {
	private Dados dados;

	public OrdenaTutor(Dados dados) {
		this.dados = dados;
	}

	@Override
	public int compare(Tutor t1, Tutor t2) {
		if (t2.compareTo(t1) == 0) {
			String m2 = t2.getMatricula();
			String m1 = t1.getMatricula();
			return dados.getAlunos().get(m1).getId()
			        - dados.getAlunos().get(m2).getId();

		} else {
			return t1.compareTo(t2);
		}
	}

}

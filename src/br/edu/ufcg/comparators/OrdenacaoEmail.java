package br.edu.ufcg.comparators;

import java.util.Comparator;

import br.edu.ufcg.entities.Aluno;

/**
 * Classe utilizada para comparação de dois objetos do tipo Aluno. Implementa
 * Comparator.
 * 
 * Projeto Laboratório de Programação II.
 *
 */
public class OrdenacaoEmail implements Comparator<Aluno> {
	/**
	 * Compara dois objetos Aluno a partir do email do aluno, segue a ordenação
	 * lexicográfica. Caso os emails sejam iguais, compara a partir da matricula.
	 * 
	 * @param a1
	 *                objeto Aluno1
	 * @param a2
	 *                objeto Aluno2
	 * @return um int.
	 */
	@Override
	public int compare(Aluno a1, Aluno a2) {
		int compare = a1.getEmail().compareTo(a2.getEmail());

		if (compare == 0) {
			return a1.getMatricula().compareTo(a2.getMatricula());
		}
		return compare;
	}

}

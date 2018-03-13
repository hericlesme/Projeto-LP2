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
public class OrdenacaoMatricula implements Comparator<Aluno> {
	/**
	 * Compara dois objetos Aluno a partir da matricula do aluno, segue a ordenação
	 * lexicográfica.
	 * 
	 * @param a1
	 *                objeto Aluno1
	 * @param a2
	 *                objeto Aluno2
	 * @return um int.
	 */
	@Override
	public int compare(Aluno a1, Aluno a2) {
		return a1.getMatricula().compareTo(a2.getMatricula());

	}

}

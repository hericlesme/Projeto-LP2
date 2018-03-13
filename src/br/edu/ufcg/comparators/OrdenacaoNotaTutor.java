package br.edu.ufcg.comparators;

import java.util.Comparator;
import java.util.Map;

import br.edu.ufcg.entities.Aluno;
import br.edu.ufcg.entities.Tutor;

/**
 * Classe utilizada para comparação de dois objetos do tipo Tutor. Implementa
 * Comparator. Recebe um Map contendo os Alunos do sistema para poder acessar
 * sua ordem de cadastro.
 * 
 * Projeto Laboratório de Programação II.
 *
 */
public class OrdenacaoNotaTutor implements Comparator<Tutor> {
	private Map<String, Aluno> alunos;

	/**
	 * Constrói a classe a partir de um map com Alunos.
	 * 
	 * @param alunos
	 *                Map email-aluno.
	 */
	public OrdenacaoNotaTutor(Map<String, Aluno> alunos) {
		this.alunos = alunos;
	}

	/**
	 * Compara dois objetos Tutor a partir da sua nota. Caso a nota seja igual,
	 * utiliza da ordem de cadastro como Aluno no sistema.
	 * 
	 * @param t1
	 *                objeto Tutor1
	 * @param t2
	 *                objeto Tutor2
	 * @return um int.
	 */
	@Override
	public int compare(Tutor t1, Tutor t2) {
		if (t1.compareTo(t2) == 0) {
			return alunos.get(t1.getMatricula()).getId() - alunos.get(t2.getMatricula()).getId();
		} else {
			return t1.compareTo(t2);
		}
	}

}

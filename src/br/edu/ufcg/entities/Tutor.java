package br.edu.ufcg.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe implementa Funcao. Define uma estratégia expecifica de Funcao.
 * 
 * Projeto de Laboratório - Programação II
 * 
 * @author Rafael da Silva Pereira.
 */
public class Tutor implements Funcao {

	private String disciplina;
	private int proficiencia;
	private int notaTutor;
	private List<String> diasDisponiveis;
	private List<String> locaisDisponiveis;
	private int quantidadeEmDinheiro;

	/**
	 * Inicializa um objeto da classe Tutor.
	 * 
	 * @param disciplina
	 *            a disciplina que o Tutor vai ensinar.
	 * @param proficiencia
	 *            um numero entre um e cinco indicando o quão habil na disciplica o
	 *            Tutor se considera.
	 */
	public Tutor(String disciplina, int proficiencia) {
		this.disciplina = disciplina;
		this.proficiencia = proficiencia;
		this.notaTutor = 4;
		this.diasDisponiveis = new ArrayList<>();
		this.locaisDisponiveis = new ArrayList<>();
		this.quantidadeEmDinheiro = 0;
	}

	/**
	 * O Tutor cadastra um novo horario de atendimento.
	 * 
	 * @param horario
	 *            indica em qual horario acontecera o atendimento.
	 * @param dia
	 *            indica em qual dia acontecera o atendimento.
	 */

	@Override
	public void cadastrarHorario(String horario, String dia) {
		this.diasDisponiveis.add(String.format("%s, %s", dia, horario)); /* Sugeito a alterações */
	}

	/**
	 * O Tutor cadastra um local onde realizará o atendimento.
	 * 
	 * @param local:
	 *            indica o local onde sera o atendimento.
	 */
	@Override
	public void cadastrarLocalDeAtendimento(String local) {
		this.locaisDisponiveis.add(local);
	}

	/**
	 * Consulta se o horario de atendimento ja foi alocado.
	 * 
	 * @param horario:
	 *            indica em qual horario em que possivelmente acontecera o
	 *            atendimento.
	 * @param dia:
	 *            indica em qual dia em que possivelmente acontecera o atendimento.
	 * @return
	 *         <p>
	 *         true - se o horario ja tiver sido cadastrado;
	 *         </p>
	 *         <p>
	 *         false - se o horario nao tiver sido cadastrado.
	 *         </p>
	 */
	@Override
	public boolean consultaHorario(String horario, String dia) {

		/*
		 * Está verificação está sugeita a variações dependendo dos testes de aceitação.
		 */
		if (!this.diasDisponiveis.contains(String.format("%s, %s", dia, horario))) {
			return false;
		}
		return true;
	}

	/**
	 * Consulta se o local de atendimento ja foi alocado.
	 * 
	 * @param local
	 *            onde deve ter sido alocado o local de atendimento.
	 * @return
	 *         <p>
	 *         true - se o local ja tiver sido cadastrado;
	 *         </p>
	 *         <p>
	 *         false - se o local nao tiver sido cadastrado.
	 *         </p>
	 */
	@Override
	public boolean consultaLocal(String local) {
		if (!this.locaisDisponiveis.contains(local)) {
			return false;
		}
		return true;
	}

}

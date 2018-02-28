package br.edu.ufcg.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe que implementa Funcao. Define os métodos para a função
 * Tutor. Um tutor é um aluno que pode dar aulas sobre alguma
 * disciplina especifica. A classe tem como atributos um mapa que liga
 * o nome da disciplina ao objeto disciplina, a nota do tutor, os dias
 * e locais disponíveis para atendimento e o dinheiro recebido.
 * 
 * Projeto de Laboratório - Programação II
 * 
 */
public class Tutor implements Funcao {

	private int notaTutor;
	private int quantidadeEmDinheiro;
	private Map<String, Disciplina> disciplinas;
	private List<String> diasDisponiveis;
	private List<String> locaisDisponiveis;

	/**
	 * Inicializa um objeto da classe Tutor.
	 * 
	 * @param disciplina
	 *            a disciplina que o Tutor vai ensinar.
	 * @param proficiencia
	 *            um numero entre um e cinco indicando o quão habil na
	 *            disciplina o Tutor se considera.
	 */
	public Tutor(String disciplina, int proficiencia) {
		this.locaisDisponiveis = new ArrayList<>();
		this.diasDisponiveis = new ArrayList<>();
		this.disciplinas = new HashMap<>();
		adicionaDisciplina(disciplina, proficiencia);
		this.quantidadeEmDinheiro = 0;
		this.notaTutor = 4;
	}

	/**
	 * Adiciona um objeto disciplina no mapa disciplinas que liga o nome
	 * da disciplina ao objeto.
	 * 
	 * @param disciplina
	 *            o nome da disciplina.
	 * @param proficiencia
	 *            a proficiencia na disciplina.
	 */
	@Override
	public void adicionaDisciplina(String disciplina, int proficiencia) {
		this.disciplinas.put(disciplina,
		        new Disciplina(disciplina, proficiencia));
	}

	/**
	 * Retorna um booleano dizendo se a disciplina com o nome dado já
	 * existe no map de disciplinas do Tutor.
	 * 
	 * @return um boolean.
	 */
	@Override
	public boolean containsDisciplina(String disciplina) {
		return disciplinas.containsKey(disciplina);
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
		this.diasDisponiveis.add(String.format("%s, %s", dia,
		        horario)); /* Sugeito a alterações */
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
	 *            indica em qual dia em que possivelmente acontecera o
	 *            atendimento.
	 * @return true - se o horario ja tiver sido cadastrado; false - se o
	 *         horario nao tiver sido cadastrado.
	 */
	@Override
	public boolean consultaHorario(String horario, String dia) {
		return this.diasDisponiveis
		        .contains(String.format("%s, %s", dia, horario));
	}

	/**
	 * Consulta se o local de atendimento ja foi alocado.
	 * 
	 * @param local
	 *            onde deve ter sido alocado o local de atendimento.
	 * @return true - se o local ja tiver sido cadastrado; false - se o
	 *         local nao tiver sido cadastrado.
	 */
	@Override
	public boolean consultaLocal(String local) {
		return this.locaisDisponiveis.contains(local);
	}

}

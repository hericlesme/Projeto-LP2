package br.edu.ufcg.entities;

/**
 * 
 * Interface que representa a função de um Aluno. Classes que a implementam
 * definem como seus métodos funcionam.
 * 
 * Projeto de Laboratório - Programação II
 * 
 */
public interface Funcao {

	/**
	 * Cadastra em um tutor um novo horario de atendimento.
	 * 
	 * @param horario
	 *            indica em qual horario acontecera o atendimento.
	 * @param dia
	 *            indica em qual dia acontecera o atendimento.
	 */
	public void cadastrarHorario(String horario, String dia) throws IllegalThreadStateException;

	/**
	 * Verifica a existência de uma Disciplina agregada ao tutor.
	 * 
	 * @param disciplina
	 *            a disciplina a ser verificada.
	 * @return um valor booleano indicando a existência da disciplina.
	 */
	public boolean containsDisciplina(String disciplina) throws IllegalThreadStateException;

	/**
	 * Cadastra em um tutor um novo local de atendimento.
	 * 
	 * @param local:
	 *            indica o local onde sera o atendimento.
	 */
	public void cadastrarLocalDeAtendimento(String local) throws IllegalThreadStateException;

	/**
	 * Verifica se o horario de atendimento foi cadastrado para o tutor.
	 * 
	 * @param horario:
	 *            indica em qual horario em que possivelmente acontecera o
	 *            atendimento.
	 * @param dia:
	 *            indica em qual dia em que possivelmente acontecera o atendimento.
	 */
	public boolean consultaHorario(String horario, String dia) throws IllegalThreadStateException;

	/**
	 * Verifica se o local de atendimento foi cadastrado pelo Tutor.
	 * 
	 * @param local:
	 *            indica o local onde deve ser o atendimento.
	 */
	public boolean consultaLocal(String local) throws IllegalThreadStateException;

}

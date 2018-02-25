package br.edu.ufcg.entities;

/**
 * 
 * Interface Funcao permite as classes que se compor com esta realize operações
 * como o cadastro e verificacao, de horarios e locais.
 * 
 * Projeto de Laboratório - Programação II
 * 
 * @author Rafael da Silva Pereira.
 */
public interface Funcao {

	/**
	 * Cadastra em um tutor um novo horario de atendimento.
	 * 
	 * @param horario
	 *            indica em qual horario acontecera o atendimento.
	 * @param dia
	 *            indica em qual dia acontecera o atendimento.
	 * @throws IllegalThreadStateException:
	 *             caso a funcao desse aluno nao seja Tutor.
	 */
	public void cadastrarHorario(String horario, String dia) throws IllegalThreadStateException;

	/**
	 * Cadastra em um tutor um novo local de atendimento.
	 * 
	 * @param local:
	 *            indica o local onde sera o atendimento.
	 * @throws IllegalThreadStateException:
	 *             caso a funcao desse aluno nao seja Tutor.
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
	 * @throws IllegalThreadStateException:
	 *             caso a funcao desse aluno nao seja Tutor.
	 */
	public boolean consultaHorario(String horario, String dia) throws IllegalThreadStateException;

	/**
	 * Verifica se o local de atendimento foi cadastrado pelo Tutor.
	 * 
	 * @param local:
	 *            indica o local onde deve ser o atendimento.
	 * @throws IllegalThreadStateException:
	 *             caso a funcao desse aluno nao seja Tutor.
	 */
	public boolean consultaLocal(String local) throws IllegalThreadStateException;

}

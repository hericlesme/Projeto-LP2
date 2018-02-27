package br.edu.ufcg.entities;

/**
 * Classe que representa um Tutelado, ou seja, um aluno disposto a aprender com
 * um tutor. Essa classe funciona para lançar exceções caso um aluno tente
 * utilizar métodos que só um tutor tem acesso.
 * 
 * Projeto de Laboratório - Programação II
 * 
 */
public class Tutelado implements Funcao {
	/**
	 * Lança uma exceção do tipo IllegalThreadStateException caso um Aluno com essa
	 * função tente utilizar um método apenas permitido ao tutor.
	 */
	@Override
	public void cadastrarHorario(String horario, String dia) {
		throw new IllegalThreadStateException("Chamada ao metodo invalida, este aluno não é tutor.");
	}

	/**
	 * Lança uma exceção do tipo IllegalThreadStateException caso um Aluno com essa
	 * função tente utilizar um método apenas permitido ao tutor.
	 */
	@Override
	public void cadastrarLocalDeAtendimento(String local) {
		throw new IllegalThreadStateException("Chamada ao metodo invalida, este aluno não é tutor.");
	}

	/**
	 * Lança uma exceção do tipo IllegalThreadStateException caso um Aluno com essa
	 * função tente utilizar um método apenas permitido ao tutor.
	 */
	@Override
	public boolean consultaHorario(String horario, String dia) {
		throw new IllegalThreadStateException("Chamada ao metodo invalida, este aluno não é tutor.");
	}

	/**
	 * Lança uma exceção do tipo IllegalThreadStateException caso um Aluno com essa
	 * função tente utilizar um método apenas permitido ao tutor.
	 */
	@Override
	public boolean consultaLocal(String local) {
		throw new IllegalThreadStateException("Chamada ao metodo invalida, este aluno não é tutor.");
	}

	/**
	 * Lança uma exceção do tipo IllegalThreadStateException caso um Aluno com essa
	 * função tente utilizar um método apenas permitido ao tutor.
	 */
	@Override
	public void adicionaDisciplina(String disciplina, int proficiencia) {
		throw new IllegalThreadStateException("Chamada ao metodo invalida, este aluno não é tutor.");
	}

	@Override
	public boolean containsDisciplina(String disciplina) throws IllegalThreadStateException {
		throw new IllegalThreadStateException("Chamada ao metodo invalida, este aluno não é tutor.");
	}

}

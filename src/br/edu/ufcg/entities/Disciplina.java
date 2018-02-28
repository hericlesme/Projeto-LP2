package br.edu.ufcg.entities;

/**
 * Classe que representa uma disciplina, armazenada por um Aluno
 * Tutor. Uma disciplina armazena seu nome e a proficiencia que o
 * tutor tem nela.
 * 
 * Projeto de Laboratório - Programação II.
 *
 */
public class Disciplina {

	private int proficiencia;
	private String nome;

	/**
	 * Constroi o objeto disciplina passado seu nome e a proficiencia do
	 * tutor.
	 * 
	 * @param nome
	 *            nome da disciplina.
	 * @param proficiencia
	 *            proficiencia do tutor na disciplina.
	 */
	public Disciplina(String nome, int proficiencia) {
		this.nome = nome;
		this.proficiencia = proficiencia;
	}

	/**
	 * Retorna o nome da disciplina.
	 * 
	 * @return uma String.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Retorna a proficiencia na disciplina.
	 * 
	 * @return um int.
	 */
	public int getProficiencia() {
		return this.proficiencia;
	}

}

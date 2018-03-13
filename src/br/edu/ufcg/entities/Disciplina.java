package br.edu.ufcg.entities;

import java.io.Serializable;

import br.edu.ufcg.util.Validador;

/**
 * Classe que representa uma disciplina, armazenada por um Tutor. Uma disciplina
 * armazena seu nome e a proficiencia que o tutor tem nela.
 * 
 * Projeto de Laboratório - Programação II.
 *
 */
public class Disciplina implements Serializable {

	private static final long serialVersionUID = -6293692519340815120L;
	private int proficiencia;
	private String nome;

	/**
	 * Constroi o objeto disciplina passado seu nome e a proficiencia do tutor.
	 * 
	 * @param nome
	 *                nome da disciplina.
	 * @param proficiencia
	 *                proficiencia do tutor na disciplina.
	 */
	public Disciplina(String nome, int proficiencia) {
		Validador.parametroInvalido(nome, "Nome da disciplina nao pode ser vazia ou nula");
		Validador.proficienciaInvalida(proficiencia, "Erro");
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

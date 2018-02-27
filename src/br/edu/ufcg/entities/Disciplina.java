package br.edu.ufcg.entities;

public class Disciplina {

	private int proficiencia;
	private String nome;

	public Disciplina(String nome, int proficiencia) {
		this.nome = nome;
		this.proficiencia = proficiencia;
	}

	public String getNome() {
		return this.nome;
	}

	public int getProficiencia() {
		return this.proficiencia;
	}

}

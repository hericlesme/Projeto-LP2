package br.edu.ufcg.entities;

import java.util.ArrayList;
import java.util.List;

public class Tutor implements Funcao {

	private String disciplina;
	private int proficiencia;
	private int notaTutor;
	private List<String> diasDisponiveis;
	private List<String> locaisDisponiveis;
	private int quantidadeEmDinheiro;

	public Tutor(String disciplina, int proficiencia) {
		this.disciplina = disciplina;
		this.proficiencia = proficiencia;
		this.notaTutor = 4;
		this.diasDisponiveis = new ArrayList<>();
		this.locaisDisponiveis = new ArrayList<>();
		this.quantidadeEmDinheiro = 0;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public int getProeficiencia() {
		return this.proficiencia;
	}

	public int getNovaAvaliacao() {
		return this.notaTutor;
	}

	public List<String> getDiasDisponiveis() {
		return this.diasDisponiveis;
	}

	public List<String> getLocaisDisponiveis() {
		return this.locaisDisponiveis;
	}

	public int getQuantidadeEmDinheiro() {
		return quantidadeEmDinheiro;
	}

	@Override
	public void cadastrarHorario(String horario, String dia) {
		this.diasDisponiveis.add(String.format("%s, %s", dia, horario));
	}

	@Override
	public void cadastrarLocalDeAtendimento(String local) {
		this.locaisDisponiveis.add(local);
	}

	@Override
	public boolean consultaHorario(String horario, String dia) {
		if (!this.diasDisponiveis.contains(String.format("%s, %s", dia, horario))) {
			return false;
		}
		return true;
	}

	@Override
	public boolean consultaLocal(String local) {
		if (!this.locaisDisponiveis.contains(local)) {
			return false;
		}
		return true;
	}
}

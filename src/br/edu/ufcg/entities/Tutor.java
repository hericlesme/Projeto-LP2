package br.edu.ufcg.entities;

import java.util.List;

public class Tutor implements Funcao {

	private String disciplina;
	private int proeficiencia;
	private int novaAvaliacao;
	private List<String> diasDisponiveis;
	private List<String> locaisDisponiveis;
	private int quantidadeEmDinheiro;

	public Tutor() {
		// TODO Auto-generated constructor stub
	}

	public String getDisciplina() {
		return disciplina;
	}

	public int getProeficiencia() {
		return this.proeficiencia;
	}

	public int getNovaAvaliacao() {
		return this.novaAvaliacao;
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

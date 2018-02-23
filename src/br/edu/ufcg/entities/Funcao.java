package br.edu.ufcg.entities;

public interface Funcao {
	public void cadastrarHorario(String horario, String dia);

	public void cadastrarLocalDeAtendimento(String local);

	public boolean consultaHorario(String horario, String dia);

	public boolean consultaLocal(String local);

}

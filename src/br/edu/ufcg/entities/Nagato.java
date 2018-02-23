package br.edu.ufcg.entities;


public class Nagato implements Funcao {

	@Override
	public void cadastrarHorario(String horario, String dia) {
		throw new IllegalThreadStateException("Chamada ao metodo invalida, o este aluno não é monitor.");
	}

	@Override
	public void cadastrarLocalDeAtendimento(String local) {
		throw new IllegalThreadStateException("Chamada ao metodo invalida, o este aluno não é monitor.");
	}

	@Override
	public boolean consultaHorario(String horario, String dia) {
		throw new IllegalThreadStateException("Chamada ao metodo invalida, o este aluno não é monitor.");
	}

	@Override
	public boolean consultaLocal(String local) {
		throw new IllegalThreadStateException("Chamada ao metodo invalida, o este aluno não é monitor."); 
	}

}

package br.edu.ufcg.util;

public class Validador {

	public void cadastroInvalido(String nome, String email, String telefone) {
		nomeInvalido(nome, "Erro no cadastro de aluno");
		emailInvalido(email, "Erro no cadastro de aluno");
		telefoneNulo(telefone, "Erro no cadastro de aluno");
	}

	private void telefoneNulo(String telefone, String msg) {
		if (telefone == null) {
			throw new NullPointerException(msg + ": Telefone nao pode ser nulo");
		}
	}
	
	private void nomeInvalido(String nome, String msg) {
		if (nome == null) {
			throw new NullPointerException(msg + ": Nome nao pode ser vazio ou nulo");
		}
		if (nome.trim().isEmpty()) {
			throw new IllegalArgumentException(msg + ": Nome nao pode ser vazio ou nulo");
		}
	}

	private void emailInvalido(String email, String msg) {
		if (!email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
			throw new IllegalArgumentException(msg + ": Email invalido");
		}
	}
}

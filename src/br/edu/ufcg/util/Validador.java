package br.edu.ufcg.util;

/**
 * 
 * Classe de Validação do Sistema
 * 
 * Projeto de Laboratório - Programação II
 * 
 * @author Rafael da Silva Pereira - 117110921
 * @author Eduardo Macedo Cavalcanti Freitas
 * @author Henrique Castro Arriel
 * @author Héricles Emanuel Gomes da Silva - 117110647
 *
 */
public class Validador {
	/**
	 * Realiza a validação do cadastro de um aluno no sistema.
	 * 
	 * @param nome
	 *            o nome do aluno.
	 * @param matricula
	 *            a matrícula do aluno.
	 * @param codigoCurso
	 *            o código do curso do aluno.
	 * @param telefone
	 *            o telefone do aluno.
	 * @param email
	 *            o email do aluno.
	 */
	public void cadastroInvalido(String nome, String matricula, int codigoCurso, String telefone, String email) {
		nomeInvalido(nome, "Erro no cadastro de aluno");
		matriculaInvalida(matricula, "Erro no cadastro de aluno");
		emailInvalido(email, "Erro no cadastro de aluno");
		telefoneNulo(telefone, "Erro no cadastro de aluno");
		validaInteiro(codigoCurso, "Erro no cadastro de aluno");
	}

	/**
	 * Método privado que realiza a verificação da validade da matrícula, e lança
	 * uma exceção, caso seja inválida.
	 * 
	 * @param matricula
	 *            a matrícula do aluno.
	 * @param msg
	 *            a mensagem a ser exibida na exceção.
	 */
	private void matriculaInvalida(String matricula, String msg) {
		if (matricula == null) {
			throw new NullPointerException(msg + ": matricula nao pode ser vazia ou nula");
		}
		if (matricula.trim().isEmpty()) {
			throw new IllegalArgumentException(msg + ": matricula nao pode ser vazio ou nula");
		}
	}

	/**
	 * Método privado que realiza a verificação da validade do telefone, e lança uma
	 * exceção, caso seja inválido.
	 * 
	 * @param telefone
	 *            o telefone do aluno.
	 * @param msg
	 *            a mensagem a ser exibida na exceção.
	 */
	private void telefoneNulo(String telefone, String msg) {
		if (telefone == null) {
			throw new NullPointerException(msg + ": Telefone nao pode ser nulo");
		}
	}

	/**
	 * Método privado que realiza a verificação da validade do nome, e lança uma
	 * exceção, caso seja inválido.
	 * 
	 * @param nome
	 *            o nome do aluno.
	 * @param msg
	 *            a mensagem a ser exibida na exceção.
	 */
	private void nomeInvalido(String nome, String msg) {
		if (nome == null) {
			throw new NullPointerException(msg + ": Nome nao pode ser vazio ou nulo");
		}
		if (nome.trim().isEmpty()) {
			throw new IllegalArgumentException(msg + ": Nome nao pode ser vazio ou nulo");
		}
	}

	/**
	 * Método privado que realiza a verificação da validade do email, e lança uma
	 * exceção, caso seja inválido.
	 * 
	 * @param email
	 *            o email do aluno.
	 * @param msg
	 *            a mensagem a ser exibida na exceção.
	 */
	private void emailInvalido(String email, String msg) {
		if (!email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
			throw new IllegalArgumentException(msg + ": Email invalido");
		}
	}

	/**
	 * Método privado que realiza a verificação da validade de inteiros, e lança uma
	 * exceção, caso sejam inválidos.
	 * 
	 * @param inteiro
	 *            o inteiro a ser validado.
	 * @param msg
	 *            a mensagem a ser exibida na exceção.
	 */
	private void validaInteiro(int inteiro, String msg) {
		if (inteiro <= 0) {
			throw new IllegalArgumentException(msg + " : numero invalido");
		}
	}

	/**
	 * Lança uma exceção sob tentativa de cadastro de aluno com matrícula já
	 * cadastrada.
	 */
	public void matriculaCadastrada() {
		throw new IllegalArgumentException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");

	}

	/**
	 * Lança uma exceção sob tentativa de acesso de aluno não cadastrado.
	 * 
	 * @param msg
	 *            a mensagem a ser exibida na exceção.
	 */
	public void alunoInexistente(String msg) {
		throw new IllegalArgumentException(msg + ": Aluno nao encontrado");

	}
}
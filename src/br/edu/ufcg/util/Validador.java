package br.edu.ufcg.util;

/**
 * 
 * Classe de Validação do Sistema
 * 
 * Projeto de Laboratório - Programação II
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
	 * Método que realiza a verificação da validade da matrícula, e lança
	 * uma exceção, caso seja inválida.
	 * 
	 * @param matricula
	 *            a matrícula do aluno.
	 * @param mensagem
	 *            a mensagem a ser exibida na exceção.
	 */
	public void matriculaInvalida(String matricula, String mensagem) {
		if (matricula == null) {
			throw new NullPointerException(mensagem + ": matricula nao pode ser vazia ou nula");
		}
		if (matricula.trim().isEmpty()) {
			throw new IllegalArgumentException(mensagem + ": matricula nao pode ser vazio ou nula");
		}
	}

	/**
	 * Método privado que realiza a verificação da validade do telefone, e lança uma
	 * exceção, caso seja inválido.
	 * 
	 * @param telefone
	 *            o telefone do aluno.
	 * @param mensagem
	 *            a mensagem a ser exibida na exceção.
	 */
	private void telefoneNulo(String telefone, String mensagem) {
		if (telefone == null) {
			throw new NullPointerException(mensagem + ": Telefone nao pode ser nulo");
		}
	}

	/**
	 * Método privado que realiza a verificação da validade do nome, e lança uma
	 * exceção, caso seja inválido.
	 * 
	 * @param nome
	 *            o nome do aluno.
	 * @param mensagem
	 *            a mensagem a ser exibida na exceção.
	 */
	private void nomeInvalido(String nome, String mensagem) {
		if (nome == null) {
			throw new NullPointerException(mensagem + ": Nome nao pode ser vazio ou nulo");
		}
		if (nome.trim().isEmpty()) {
			throw new IllegalArgumentException(mensagem + ": Nome nao pode ser vazio ou nulo");
		}
	}

	/**
	 * Método que realiza a verificação da validade do email, e lança uma
	 * exceção, caso seja inválido.
	 * 
	 * @param email
	 *            o email do aluno.
	 * @param mensagem
	 *            a mensagem a ser exibida na exceção.
	 */
	public void emailInvalido(String email, String mensagem) {
		if (email == null) {
			throw new NullPointerException(mensagem + ": email nao pode ser nulo");
		}

		if (email.trim().equals("")) {
			throw new IllegalArgumentException(mensagem + ": email nao pode ser vazio ou em branco");
		}

		if (!email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
			throw new IllegalArgumentException(mensagem + ": Email invalido");
		}

	}

	/**
	 * Método privado que realiza a verificação da validade de inteiros, e lança uma
	 * exceção, caso sejam inválidos.
	 * 
	 * @param inteiro
	 *            o inteiro a ser validado.
	 * @param mensagem
	 *            a mensagem a ser exibida na exceção.
	 */
	private void validaInteiro(int inteiro, String mensagem) {
		if (inteiro <= 0) {
			throw new IllegalArgumentException(mensagem + " : numero invalido");
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
	 * @param mensagem
	 *            a mensagem a ser exibida na exceção.
	 */
	public void alunoInexistente(String mensagem) {
		throw new IllegalArgumentException(mensagem + ": Aluno nao encontrado");

	}

	/**
	 * Lança uma exceção quando o tutor não é encontrado.
	 * 
	 * @param mensagem
	 *            a mensagem a ser exibida na exceção.
	 */
	public void tutorNaoEncontrado(String mensagem) {
		throw new IllegalArgumentException(mensagem + ": Tutor nao encontrado");

	}

	/**
	 * Lança uma exceção quando o tutor não está cadastrado.
	 * 
	 * @param mensagem
	 *            a mensagem a ser exibida na exceção.
	 */
	public void tutorNaoCadastrado(String mensagem) {
		throw new IllegalArgumentException(mensagem + ": tutor nao cadastrado");
	}

	/**
	 * Verifica se o horário passado é inválido, caso seja, lança uma exceção.
	 * 
	 * @param horario
	 *            horario a ser checado.
	 * @param mensagem
	 *            mensagem a ser exibida na exceção.
	 */
	public void horarioInvalido(String horario, String mensagem) {
		if (horario == null) {
			throw new NullPointerException(mensagem + ": horario nao pode ser nulo");
		}

		if (horario.trim().equals("")) {
			throw new IllegalArgumentException(mensagem + ": horario nao pode ser vazio ou em branco");
		}
	}

	/**
	 * Verifica se o dia passado é inválido, caso seja, lança uma exceção.
	 * 
	 * @param dia
	 *            dia a ser checado.
	 * @param mensagem
	 *            mensagem a ser exibida na exceção
	 */
	public void diaInvalido(String dia, String mensagem) {
		if (dia == null) {
			throw new NullPointerException(mensagem + ": dia nao pode ser nulo");
		}

		if (dia.trim().equals("")) {
			throw new IllegalArgumentException(mensagem + ": dia nao pode ser vazio ou em branco");
		}
	}

	/**
	 * Verifica se o local passo é inválido, caso seja, lança uma exceção.
	 * 
	 * @param local
	 *            local a ser checado.
	 * @param mensagem
	 *            mensagem a ser exibida na exceção.
	 */
	public void localInvalido(String local, String mensagem) {
		if (local == null) {
			throw new NullPointerException(mensagem + ": local nao pode ser nulo");
		}

		if (local.trim().equals("")) {
			throw new IllegalArgumentException(mensagem + ": local nao pode ser vazio ou em branco");
		}
	}

	/**
	 * Método utilizado para quando se tenta cadastrar um tutor que já ensina essa
	 * disciplina.
	 * 
	 * @param mensagem
	 *            mensagem a ser exibida na exceção.
	 */
	public void tornarTutorInvalido(String mensagem) {
		throw new IllegalArgumentException(mensagem + ": Ja eh tutor dessa disciplina");
	}

	/**
	 * Método utilizado para checar se a proficiencia passada é inválida, caso seja,
	 * lança uma exceção.
	 * 
	 * @param proficiencia
	 *            proficiencia a ser checada.
	 * @param mensagem
	 *            mensagem a ser exibida na exceção.
	 */
	public void proficienciaInvalida(int proficiencia, String mensagem) {
		if (proficiencia <= 0 || proficiencia > 5) {
			throw new IllegalArgumentException(mensagem + ": Proficiencia invalida");
		}
	}

	/**
	 * Método utilizado para checar se uma disciplina passada é invalida, caso seja,
	 * lança uma exceção.
	 * 
	 * @param disciplina
	 *            disciplina a ser checada.
	 * @param mensagem
	 *            mensagem a ser exibida na exceção.
	 */
	public void disciplinaInvalida(String disciplina, String mensagem) {
		if (disciplina == null) {
			throw new NullPointerException(mensagem + ": disciplina nao pode ser nula");
		}
		if (disciplina.trim().isEmpty()) {
			throw new IllegalArgumentException(mensagem + ": Disciplina nao pode ser vazio ou em branco");
		}
	}
}
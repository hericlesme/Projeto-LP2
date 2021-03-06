package br.edu.ufcg.entities;

import java.io.Serializable;

import br.edu.ufcg.enums.AtributoAluno;
import br.edu.ufcg.util.Validador;

/**
 * Representação de um aluno no sistema. Todo aluno possui uma nota de
 * avaliação, uma matrícula que o identifica, o codigo do seu curso, email,
 * nome, opcionalmente um telefone e um id.
 * 
 * Projeto de Laboratório - Programação II.
 *
 */
public class Aluno implements Serializable {

	private static final long serialVersionUID = -2224719137869667646L;
	private int notaAvaliacao;
	private String matricula;
	private String telefone;
	private int codigoCurso;
	private String email;
	private String nome;
	private int id;

	/**
	 * Constrói um aluno inicializando seus atributos. A nota de avaliação por
	 * padrão começa em 5. Uma String vazia é dada quando o telefone não é passado.
	 * 
	 * @param nome
	 *                nome do aluno.
	 * @param matricula
	 *                matrícula do aluno.
	 * @param codigoCurso
	 *                codigo do curso.
	 * @param telefone
	 *                telefone do aluno.
	 * @param email
	 *                email do aluno.
	 */
	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email, int id) {
		Validador.cadastroInvalido(nome, matricula, codigoCurso, telefone, email);
		this.notaAvaliacao = 5;
		this.matricula = matricula;
		this.telefone = telefone;
		this.codigoCurso = codigoCurso;
		this.email = email;
		this.nome = nome;
		this.id = id;
	}

	/**
	 * Retorna uma String com algumas informações do Aluno. Com telefone, caso tenha
	 * sido passado, ou sem. Segue o formato: 1. "Matricula - Nome - Código do Curso
	 * - Email" 2. "Matricula - Nome - Código do Curso - Telefone - Email"
	 * 
	 * @return uma String.
	 */
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + toStringComplemento();
	}

	/**
	 * Método utilizado para decidir qual vai ser o complemento do toString, tendo
	 * telefone ou não.
	 * 
	 * @return uma String.
	 */
	private String toStringComplemento() {
		if (telefone.trim().isEmpty()) {
			return this.email;
		}
		return this.telefone + " - " + this.email;
	}

	/**
	 * Retorna uma String com uma informação do aluno. Lança uma exceção caso seja
	 * um atributo não existente.
	 * 
	 * @param atributo
	 *                informação a ser mostrada.
	 * @return uma String.
	 */
	public String getInfoAluno(String atributo) {
		AtributoAluno atrib;
		try {
			atrib = (AtributoAluno.valueOf(atributo.toUpperCase()));
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
		switch (atrib) {

		case NOTA_AVALIACAO:
			return Integer.toString(this.notaAvaliacao);
		case MATRICULA:
			return this.matricula;
		case TELEFONE:
			return this.telefone;
		case CODIGO_CURSO:
			return Integer.toString(this.codigoCurso);
		case EMAIL:
			return this.email;
		case NOME:
			return this.nome;
		default:
			return "";
		}
	}

	/**
	 * Retorna o nome do Aluno.
	 * 
	 * @return uma String.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Retorna o email do Aluno.
	 * 
	 * @return uma String.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Retorna um int que representa o hashCode do objeto Aluno.
	 * 
	 * @return um int.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Retorna um boolean que diz se esse objeto é igual a outro. Caso seja igual,
	 * retorna true, caso não, false. Leva em consideração a matrícula do aluno.
	 * 
	 * @return um boolean.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/**
	 * Retorna o id do aluno.
	 * 
	 * @return um int.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Retorna a matricula do aluno.
	 * 
	 * @return uma String.
	 */
	public String getMatricula() {
		return this.matricula;
	}

}

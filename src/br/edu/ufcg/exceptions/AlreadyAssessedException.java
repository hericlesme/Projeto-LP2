package br.edu.ufcg.exceptions;

/**
 * Classe que lança uma exceção. Herda de RuntimeException. É lançada quando uma
 * Ajuda ja foi avaliada.
 * 
 * Projeto de Laboratório - Programação II.
 *
 */

public class AlreadyAssessedException extends RuntimeException {

	private static final long serialVersionUID = 5752752996459804914L;

	/**
	 * Lança uma exceção com mensagem a ser exibida.
	 * 
	 * @param s
	 *                mensagem exibida.
	 */
	public AlreadyAssessedException(String s) {
		super(s);
	}

	/**
	 * Lança uma exceção sem mensagem.
	 */
	public AlreadyAssessedException() {
		super();
	}
}

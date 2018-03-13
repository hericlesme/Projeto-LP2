package br.edu.ufcg.exceptions;

public class AlreadyAssessedException extends RuntimeException {

	private static final long serialVersionUID = 5752752996459804914L;

	public AlreadyAssessedException(String s) {
		super(s);
	}

	public AlreadyAssessedException() {
		super();
	}
}

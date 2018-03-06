package br.edu.ufcg.entities;

public class AjudaOnline extends Ajuda {

	public AjudaOnline(String matrAluno, String matrTutor, String disciplina) {
		super(matrAluno, matrTutor, disciplina);
	}

	@Override
	public String getInfo(String atributo) {
		try {
			switch (AtributoAjuda.valueOf(atributo.toUpperCase())) {

			case DISCIPLINA:
				return this.disciplina;
			case MATR_ALUNO:
				return this.matrAluno;
			case MATR_TUTOR:
				return this.matrTutor;
			default:
				return null;
			}
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}

	public String pegarTutor() {
		return "Tutor - " + this.matrTutor + ", disciplina - "
		        + this.disciplina;
	}
}

package br.edu.ufcg.entities;

public class AjudaOnline extends Ajuda {

	public AjudaOnline(String matrAluno, String matrTutor, String disciplina) {
		super(matrAluno, matrTutor, disciplina);
	}

	@Override
	public String getInfo(String atributo) {
		AtributoAjuda atribAjuda;
		try {
			atribAjuda = AtributoAjuda.valueOf(atributo.toUpperCase());
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
		switch (atribAjuda) {

		case DISCIPLINA:
			return this.disciplina;
		case MATR_ALUNO:
			return this.matrAluno;
		case MATR_TUTOR:
			return this.matrTutor;
		default:
			return "";
		}
	}

	public String pegarTutor() {
		return "Tutor - " + this.matrTutor + ", disciplina - "
		        + this.disciplina;
	}
}

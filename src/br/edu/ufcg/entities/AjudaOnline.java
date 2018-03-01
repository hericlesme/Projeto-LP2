package br.edu.ufcg.entities;

public class AjudaOnline extends Ajuda {

	public AjudaOnline(String matrAluno, String disciplina) {
		super(matrAluno, disciplina);
	}

	@Override
	public String getInfo(String atributo) {
		switch (InfoTutor.valueOf(atributo.toUpperCase())) {
		case DISCIPLINA:
			return this.disciplina;
		case MATR_ALUNO:
			return this.matrAluno;
		default:
			throw new IllegalArgumentException("Atributo invalido");
		}
	}
}

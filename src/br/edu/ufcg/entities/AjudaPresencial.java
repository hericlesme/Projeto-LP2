package br.edu.ufcg.entities;

public class AjudaPresencial extends Ajuda {

	private String localInteresse;
	private String horario;

	public AjudaPresencial(String matrAluno, String disciplina, String horario,
	        String localInteresse) {

		super(matrAluno, disciplina);
		this.localInteresse = localInteresse;
		this.horario = horario;
	}

	@Override
	public String getInfo(String atributo) {
		switch (InfoTutor.valueOf(atributo.toUpperCase())) {
		case DISCIPLINA:
			return this.disciplina;
		case MATR_ALUNO:
			return this.matrAluno;
		case LOCAL:
			return this.localInteresse;
		case MATR_TUTOR:
			return this.matrTutor;
		case HORARIO:
			return this.horario;
		default:
			throw new IllegalArgumentException("nao man");
		}
	}

}

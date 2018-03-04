package br.edu.ufcg.entities;

public class AjudaPresencial extends Ajuda {

	private String localInteresse;
	private String horario;
	private String dia;

	public AjudaPresencial(String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
		super(matrAluno, disciplina);
		this.localInteresse = localInteresse;
		this.horario = horario;
		this.disciplina = dia;
	}

	@Override
	public String getInfo(String atributo) {
		switch (AtributoAjuda.valueOf(atributo.toUpperCase())) {
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
		case DIA:
			return this.dia;
		default:
			throw new IllegalArgumentException("nao man");
		}
	}

}

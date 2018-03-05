package br.edu.ufcg.entities;

public class AjudaPresencial extends Ajuda {

	private String localInteresse;
	private String horario;
	private String dia;

	public AjudaPresencial(String matrAluno, String matrTutor,
	        String disciplina, String horario, String dia,
	        String localInteresse) {
		super(matrAluno, matrTutor, disciplina);
		this.localInteresse = localInteresse;
		this.horario = horario;
		this.dia = dia;
	}

	@Override
	public String getInfo(String atributo) {
		switch (AtributoAjuda.valueOf(atributo.toUpperCase())) {
		case DISCIPLINA:
			return this.disciplina;
		case MATR_ALUNO:
			return this.matrAluno;
		case LOCALINTERESSE:
			return this.localInteresse;
		case MATR_TUTOR:
			return this.matrTutor;
		case HORARIO:
			return this.horario;
		case DIA:
			return this.dia;
		default:
			throw new IllegalArgumentException("Atributo invalido");
		}
	}

	public String pegarTutor() {
		return "Tutor - " + this.matrTutor + ", horario - " + this.horario
		        + ", dia - " + this.dia + ", local - " + this.localInteresse
		        + ", disciplina - " + this.disciplina;
	}
}

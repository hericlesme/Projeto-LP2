package br.edu.ufcg.entities;

import br.edu.ufcg.util.Validador;

public class AjudaPresencial extends Ajuda {

	private String localInteresse;
	private String horario;
	private String dia;

	public AjudaPresencial(String matrAluno, String matrTutor, String disciplina, String horario, String dia,
			String localInteresse) {
		super(matrAluno, matrTutor, disciplina);
		Validador.parametroInvalido(horario, "Horario nao pode ser nulo ou vazio");
		Validador.parametroInvalido(dia, "Dia nao pode ser nulo ou vazio");
		Validador.parametroInvalido(localInteresse, "Local de interesse nao pode ser nulo ou vazio");
		this.localInteresse = localInteresse;
		this.horario = horario;
		this.dia = dia;
	}

	@Override
	public String getInfo(String atributo) {
		AtributoAjuda atribAjuda;
		try {
			atribAjuda = AtributoAjuda.valueOf(atributo.toUpperCase());
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
		switch (atribAjuda) {
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
			return null;
		}
	}

	public String pegarTutor() {
		return "Tutor - " + this.matrTutor + ", horario - " + this.horario + ", dia - " + this.dia
				+ ", local - " + this.localInteresse + ", disciplina - " + this.disciplina;
	}
}

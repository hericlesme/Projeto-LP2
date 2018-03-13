package br.edu.ufcg.entities;

import br.edu.ufcg.enums.AtributoAjuda;
import br.edu.ufcg.util.Validador;

/**
 * Classe que herda de Ajuda, representando uma Ajuda Presencial. Tem como
 * atributos, além dos atributos de Ajuda, o local para encontro, horario e dia.
 * 
 * Projeto Laboratório de Programação II
 */
public class AjudaPresencial extends Ajuda {

	private static final long serialVersionUID = -1602649212813693007L;
	private String localInteresse;
	private String horario;
	private String dia;

	/**
	 * Constrói um objeto do tipo AjudaPresencial a partir da matricula do aluno que
	 * pediu a ajuda, matricula do tutor que irá ajudar, nome da disciplina a ser
	 * ajudada, horário, dia e local para encontro. Utiliza do construtor de Ajuda
	 * para os três primeiros atributos.
	 * 
	 * @param matrAluno
	 *                matricula do aluno.
	 * @param matrTutor
	 *                matricula do tutor.
	 * @param disciplina
	 *                nome da disciplina.
	 * @param horario
	 *                horario de encontro.
	 * @param dia
	 *                dia de encontro.
	 * @param localInteresse
	 *                local de encontro.
	 */
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

	/**
	 * Retorna uma informação da AjudaPresencial passado o nome dessa informação.
	 * Lança exceção caso seja uma informação inválida.
	 * 
	 * @param atributo
	 *                nome da informação.
	 * @return uma String.
	 */
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

	/**
	 * Retorna uma String com informações sobre o tutor que irá ajudar. "Tutor -
	 * Matricula, horario - Horario, dia - Dia, local - Local, disciplina -
	 * Disciplina"
	 * 
	 * @return uma String.
	 */
	public String pegarTutor() {
		return "Tutor - " + this.matrTutor + ", horario - " + this.horario + ", dia - " + this.dia
				+ ", local - " + this.localInteresse + ", disciplina - " + this.disciplina;
	}
}

package br.edu.ufcg.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.ufcg.comparators.OrdenacaoNotaTutor;
import br.edu.ufcg.entities.Ajuda;
import br.edu.ufcg.entities.AjudaOnline;
import br.edu.ufcg.entities.AjudaPresencial;
import br.edu.ufcg.entities.Tutor;
import br.edu.ufcg.util.Dados;
import br.edu.ufcg.util.Validador;

/**
 * 
 * Classe de controladora de Ajuda no Sistema.
 * 
 * Projeto de Laboratório - Programação II
 *
 */
public class AjudaController {

	private Dados dados;

	/**
	 * Inicializa um objeto da classe AjudaController.
	 * 
	 * @param dados:
	 *                objeto que armazena os dados do sistema.
	 */
	public AjudaController(Dados dados) {
		this.dados = dados;
	}

	/**
	 * Cria uma AjudaPresencial adicionando-a em uma coleção de Ajudas.
	 * 
	 * @param matrAluno:
	 *                indica o nome do aluno.
	 * @param disciplina:
	 *                indica a disciplina em que deseja-se obter ajuda.
	 * @param horario:
	 *                indica o horario desejado para o atendimento da
	 *                ajudaPresencial.
	 * @param dia:
	 *                indica o dia desejado para o atendimento da ajudaPresencial.
	 * @param localInteresse:
	 *                indica a localidade desejada para o atendimento da
	 *                ajudaPresencial.
	 * @return: um inteiro indicando o indentificador da ajudaPresencial
	 */
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse) {

		Validador.ajudaPresencialInvalida(matrAluno, disciplina, horario, dia, localInteresse);

		String matrTutor = escolherTutorPresencial(horario, dia, localInteresse, disciplina);

		return this.dados.adicionaAjuda(
				new AjudaPresencial(matrAluno, matrTutor, disciplina, horario, dia, localInteresse));
	}

	/**
	 * Cria uma AjudaOnline adicionando-a em uma coleção de Ajudas.
	 * 
	 * @param matrAluno:
	 *                Indica o nome do aluno.
	 * @param disciplina:
	 *                Indica a disciplina em que deseja-se obter ajuda.
	 * @return: um inteiro indicando o indentificador da ajudaOnline.
	 */
	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		Validador.ajudaOnlineInvalida(matrAluno, disciplina);

		String matrTutor = escolherTutorOnline(disciplina);
		return this.dados.adicionaAjuda(new AjudaOnline(matrAluno, matrTutor, disciplina));
	}

	/**
	 * Captura informações sobre o Tutor que prestou a Ajuda.
	 * 
	 * @param idAjuda:
	 *                o seu indentificador na coleção de Ajudas.
	 * @return: O retorno polimorfico é definido nas classe filhas de Ajuda, podendo
	 *          então variar seu comportamento, contém informações sobre o Tutor que
	 *          prestou a Ajuda.
	 * 
	 */
	public String pegarTutor(int idAjuda) {
		String mensagemPadrao = "Erro ao tentar recuperar tutor ";

		Validador.validaInteiro(idAjuda, mensagemPadrao + ": id nao pode menor que zero ");
		Validador.idInvalido(idAjuda, this.dados.getAjudas().size(), mensagemPadrao + ": id nao encontrado ");

		return this.dados.getAjudas().get(idAjuda - 1).pegarTutor();
	}

	/**
	 * Apresenta uma informação sobre a Ajuda.
	 * 
	 * @param idAjuda:
	 *                o indentificador da Ajuda em uma coleção de Ajudas
	 * @param atributo:
	 *                um apecto da Ajuda que deseja-se obter-se uma informação.
	 * @return: uma String contendo uma informação expecifica sobre a ajuda que
	 *          deseja-se obter essa informação.
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		String mensagemPadrao = "Erro ao tentar recuperar info da ajuda ";

		Validador.validaInteiro(idAjuda, mensagemPadrao + ": id nao pode menor que zero ");
		Validador.idInvalido(idAjuda, this.dados.getAjudas().size(), mensagemPadrao + ": id nao encontrado ");
		Validador.parametroInvalido(atributo, mensagemPadrao + ": atributo nao pode ser vazio ou em branco");

		return this.dados.getAjudas().get(idAjuda - 1).getInfo(atributo);
	}

	/**
	 * Avalia um tutor apartir de uma Ajuda prestada.
	 * 
	 * @param idAjuda:
	 *                o indentificador da Ajuda em uma coleção de Ajudas
	 * @param nota:
	 *                um inteiro entre 0 - 5.
	 * @return: uma classificação para o Tutor, pode variar entre "Aprendiz",
	 *          "Tutor" e "Top".
	 */
	public String avaliarTutor(int idAjuda, int nota) {
		String mensagemPadrao = "Erro na avaliacao de tutor";

		Validador.notaInvalida(nota, mensagemPadrao);
		Validador.validaInteiro(idAjuda, mensagemPadrao + ": id nao pode menor que zero ");
		Validador.idInvalido(idAjuda, this.dados.getAjudas().size(), mensagemPadrao + ": id nao encontrado ");

		Ajuda ajuda = this.dados.getAjudas().get(idAjuda - 1);
		String matricula = ajuda.getInfo("matr_tutor");

		ajuda.avaliaAjuda();
		return this.dados.getTutores().get(this.dados.getAlunos().get(matricula).getEmail()).avaliarTutor(nota);

	}

	/**
	 * Apartir dos paramatros seleciona um Tutor e retorna sua matricula.
	 * 
	 * @param horario:
	 *                indica o horario desejado para o atendimento da
	 *                ajudaPresencial.
	 * @param dia:
	 *                indica o dia desejado para o atendimento da ajudaPresencial.
	 * @param matrAluno:
	 *                indica o nome do aluno.
	 * @param disciplina:
	 *                indica a disciplina em que deseja-se obter ajuda.
	 * @return uma String contendo a matricula do Tutor.
	 */
	private String escolherTutorPresencial(String horario, String dia, String local, String disciplina) {

		ArrayList<Tutor> temp = new ArrayList<Tutor>();

		for (Tutor t : this.dados.getTutores().values()) {
			if (t.consultaHorario(horario, dia) && t.consultaLocal(local)
					&& t.containsDisciplina(disciplina)) {
				temp.add(t);
			}
		}
		return selecionaTutorOrdenado(temp);
	}

	/**
	 * Apartir dos paramatros seleciona um Tutor e retorna sua matricula.
	 * 
	 * @param disciplina:
	 *                indica a disciplina em que deseja-se obter ajuda.
	 * @return uma String contendo a matricula do Tutor.
	 */
	private String escolherTutorOnline(String disciplina) {

		ArrayList<Tutor> temp = new ArrayList<Tutor>();

		for (Tutor t : this.dados.getTutores().values()) {
			if (t.containsDisciplina(disciplina)) {
				temp.add(t);
			}
		}
		return selecionaTutorOrdenado(temp);
	}

	/**
	 * Ordena um coleção apartir de um comparator, e retorna a matricula do primeiro
	 * Tutor dessa coleção ordenada.
	 * 
	 * @param list:
	 *                a lista que deseja-se ordenar
	 * @return String - a matricula do Tutor.
	 */
	private String selecionaTutorOrdenado(List<Tutor> list) {
		Collections.sort(list, new OrdenacaoNotaTutor(dados.getAlunos()));

		return list.get(0).getMatricula();
	}
}
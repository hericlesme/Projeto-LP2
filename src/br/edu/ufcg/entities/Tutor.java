package br.edu.ufcg.entities;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ufcg.util.Validador;

/**
 * Classe que representa um Tutor no sistema. Tem como atributos o dinheiro
 * recebido por doações, sua nota como tutor, um Map com as disciplinas que ele
 * pode lecionar, uma List com os dias e horários disponíveis para atendimento,
 * assim como uma List para os locais disponíveis. Também armazena sua matricula
 * como Aluno.
 * 
 * Projeto de Laboratório - Programação II
 * 
 */
public class Tutor implements Comparable<Tutor>, Serializable {

	private static final long serialVersionUID = -7438899114768956566L;
	private int dinheiroDoacoes;
	private double notaTutor;
	private Map<String, Disciplina> disciplinas;
	private List<String> diasDisponiveis;
	private List<String> locaisDisponiveis;
	private String matricula;

	/**
	 * Inicializa um objeto da classe Tutor. Sua nota inicia como 4.
	 * 
	 * @param disciplina
	 *                a disciplina que o Tutor vai ensinar.
	 * @param proficiencia
	 *                um numero entre um e cinco indicando o quão habil na
	 *                disciplina o Tutor se considera.
	 * @param matricula
	 *                a matricula como Aluno.
	 */
	public Tutor(String disciplina, int proficiencia, String matricula) {
		Validador.parametroInvalido(matricula, "Matricula nao pode ser nula ou vazia");
		this.locaisDisponiveis = new ArrayList<>();
		this.diasDisponiveis = new ArrayList<>();
		this.disciplinas = new HashMap<>();
		adicionaDisciplina(disciplina, proficiencia);
		this.dinheiroDoacoes = 0;
		this.notaTutor = 4;
		this.matricula = matricula;

	}

	/**
	 * Adiciona um objeto disciplina no mapa disciplinas que liga o nome da
	 * disciplina ao objeto.
	 * 
	 * @param disciplina
	 *                o nome da disciplina.
	 * @param proficiencia
	 *                a proficiencia na disciplina.
	 */
	public void adicionaDisciplina(String disciplina, int proficiencia) {
		this.disciplinas.put(disciplina, new Disciplina(disciplina, proficiencia));
	}

	/**
	 * Retorna um booleano dizendo se a disciplina com o nome dado já existe no map
	 * de disciplinas do Tutor.
	 * 
	 * @return um boolean.
	 */
	public boolean containsDisciplina(String disciplina) {
		return disciplinas.containsKey(disciplina);
	}

	/**
	 * O Tutor cadastra um novo horario de atendimento.
	 * 
	 * @param horario
	 *                indica em qual horario acontecera o atendimento.
	 * @param dia
	 *                indica em qual dia acontecera o atendimento.
	 */

	public void cadastrarHorario(String horario, String dia) {
		this.diasDisponiveis.add(String.format("%s, %s", dia, horario));
	}

	/**
	 * O Tutor cadastra um local onde realizará o atendimento.
	 * 
	 * @param local:
	 *                indica o local onde sera o atendimento.
	 */
	public void cadastrarLocalDeAtendimento(String local) {
		this.locaisDisponiveis.add(local);
	}

	/**
	 * Consulta se o horario de atendimento ja foi alocado.
	 * 
	 * @param horario:
	 *                indica em qual horario em que possivelmente acontecera o
	 *                atendimento.
	 * @param dia:
	 *                indica em qual dia em que possivelmente acontecera o
	 *                atendimento.
	 * @return true - se o horario ja tiver sido cadastrado; false - se o horario
	 *         nao tiver sido cadastrado.
	 */
	public boolean consultaHorario(String horario, String dia) {
		return this.diasDisponiveis.contains(String.format("%s, %s", dia, horario));
	}

	/**
	 * Consulta se o local de atendimento ja foi alocado.
	 * 
	 * @param local
	 *                onde deve ter sido alocado o local de atendimento.
	 * @return true - se o local ja tiver sido cadastrado; false - se o local nao
	 *         tiver sido cadastrado.
	 */
	public boolean consultaLocal(String local) {
		return this.locaisDisponiveis.contains(local);
	}

	/**
	 * Avalia o Tutor dando uma nota. O cálculo é feito com a nota atual e com a
	 * nota recebida. Altera a nota do Tutor.
	 * 
	 * @param nota
	 *                nota recebida.
	 * @return uma String com o nível do tutor após a nota.
	 */
	public String avaliarTutor(int nota) {
		this.notaTutor = ((this.notaTutor * 5) + nota) / 6;
		return this.determinaNivel();
	}

	/**
	 * Determina o nível do Tutor. Caso sua nota seja acima de 4.5, é "TOP", acima
	 * de 3 e abaixo ou igual a 4.5 é "Tutor", abaixo ou igual a 3 é "Aprendiz".
	 * 
	 * @return uma String.
	 */
	private String determinaNivel() {
		String nivel = "";
		if (this.notaTutor > 4.5) {
			nivel = "TOP";
		} else if (this.notaTutor > 3.0 && this.notaTutor <= 4.5) {
			nivel = "Tutor";
		} else if (this.notaTutor > 0 && this.notaTutor <= 3.0) {
			nivel = "Aprendiz";
		}
		return nivel;

	}

	/**
	 * Pega a nota do Tutor formatada para duas casas decimais.
	 * 
	 * @return uma String.
	 */
	public String pegarNota() {
		DecimalFormat df = new DecimalFormat("#0.00");
		return df.format(this.notaTutor);
	}

	/**
	 * Pega o nível do Tutor.
	 * 
	 * @return uma String.
	 */
	public String pegarNivel() {
		return this.determinaNivel();
	}

	/**
	 * adiciona dinheiro ao Tutor. É adicionado a quantidade passada.
	 * 
	 * @param dinheiroDoacoes
	 *                dinheiro em moedas a ser dado para o tutor.
	 */
	public void addDinheiroDoacoes(int dinheiroDoacoes) {
		this.dinheiroDoacoes += dinheiroDoacoes;
	}

	/**
	 * Retorna a matricula como Aluno do Tutor.
	 * 
	 * @return uma String.
	 */
	public String getMatricula() {
		return this.matricula;
	}

	/**
	 * Retorna o dinheiro do Tutor.
	 * 
	 * @return um int.
	 */
	public int getDinheiro() {
		return this.dinheiroDoacoes;
	}

	/**
	 * Determina a taxa do dinheiro da doação que o tutor receberá. Dependendo do
	 * seu nível, a taxa aumenta ou diminui. Para tutores "TOP", é 90% (+ 1% por
	 * décimo acima de 4.5). Para tutores "Tutor", é 80%. Para tutores "Aprendiz" é
	 * 40% (- 1% por décimo abaixo de 3.0).
	 * 
	 * @return um int que seria a porcentagem de quanto o tutor deve receber.
	 */
	public int taxaTutor() {
		if (this.determinaNivel().equals("TOP")) {
			return (int) (90 + (this.notaTutor * 10) - 45);
		}
		if (this.determinaNivel().equals("Tutor")) {
			return 80;
		} else {
			return (int) (40 + (this.notaTutor * 10) - 30);
		}
	}

	/**
	 * Compara o próprio Tutor com outro Tutor a partir da sua nota.
	 */
	@Override
	public int compareTo(Tutor o) {
		if (this.notaTutor - o.notaTutor < 0) {
			return -1;
		}
		if (this.notaTutor - o.notaTutor > 0) {
			return 1;
		}
		return 0;
	}

}

package br.edu.ufcg.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.edu.ufcg.comparators.OrdenacaoEmail;
import br.edu.ufcg.comparators.OrdenacaoMatricula;
import br.edu.ufcg.comparators.OrdenacaoNome;
import br.edu.ufcg.entities.Aluno;
import br.edu.ufcg.entities.Tutor;
import br.edu.ufcg.enums.AtributoOrdem;
import br.edu.ufcg.util.Dados;
import br.edu.ufcg.util.Validador;

/**
 * Classe que representa um controller de Tutores. Possui como atributos um
 * objeeto do tipo Dados que armazena um Map de String-Tutor e um Comparator
 * para alterar a forma da listagem de tutores.
 * 
 * Projeto Laboratório de Programação II
 *
 */
public class TutorController {
	private Dados dados;
	private Comparator<Aluno> comparator;

	/**
	 * Constrói um objeto TutorController a partir de dados que armazena um Map que
	 * contém tutores. A forma de ordenação começa por nome.
	 * 
	 * @param dados
	 *                objeto que possui Map de tutores.
	 */
	public TutorController(Dados dados) {
		this.dados = dados;
		this.comparator = new OrdenacaoNome();
	}

	/**
	 * Cadastra um Aluno como Tutor, adicionando ao mapa de Tutores.
	 * 
	 * @param matricula
	 *                String da matricula do aluno.
	 * @param disciplina
	 *                String da disciplina em que o tutor pode ajudar.
	 * @param proficiencia
	 *                int que representa a proeficiência do tutor na disciplina,
	 *                varia de 1 a 5.
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		Validador.disciplinaInvalida(disciplina, "Erro na definicao de papel");
		if (!this.dados.getAlunos().containsKey(matricula)) {
			Validador.tutorNaoEncontrado("Erro na definicao de papel");
		}

		Validador.proficienciaInvalida(proficiencia, "Erro na definicao de papel");
		if (!this.dados.getTutores().containsKey(this.dados.getAlunos().get(matricula).getEmail())) {
			this.dados.adicionaTutor(this.dados.getAlunos().get(matricula).getEmail(),
					new Tutor(disciplina, proficiencia, matricula));

		} else {

			if (this.dados.getTutores().get(this.dados.getAlunos().get(matricula).getEmail())
					.containsDisciplina(disciplina)) {
				Validador.tornarTutorInvalido("Erro na definicao de papel");
			}
			this.dados.getTutores().get(this.dados.getAlunos().get(matricula).getEmail())
					.adicionaDisciplina(disciplina, proficiencia);
		}
	}

	/**
	 * Recupera um tutor a partir da sua matricula.
	 * 
	 * @param matricula
	 *                String da matricula do tutor
	 * 
	 * @return o toString do tutor.
	 */
	public String recuperaTutor(String matricula) {
		if (!dados.getAlunos().containsKey(matricula)) {
			Validador.tutorNaoEncontrado("Erro na busca por tutor");
		}
		return this.dados.getAlunos().get(matricula).toString();
	}

	/**
	 * Recebe um objeto Stream de Aluno, e realiza o mapeamento encadeado do
	 * toString do aluno, adicionando a String ", " a cada iteração.
	 * 
	 * @param alunos
	 *                Stream de alunos.
	 * @return uma String contendo o toString encadeado dos alunos.
	 */
	private String mapToString(Stream<Aluno> alunos) {
		return alunos.map(Aluno::toString).collect(Collectors.joining(", "));
	}

	/**
	 * Lista os tutores a partir da toString de Aluno dos mesmos.
	 * 
	 * @return uma String.
	 */
	public String listarTutores() {
		List<Aluno> alunosOrdenados = new ArrayList<Aluno>(dados.getAlunos().values());
		Collections.sort(alunosOrdenados, comparator);
		return mapToString(alunosOrdenados.stream()
				.filter(aluno -> dados.getTutores().containsKey(aluno.getEmail())));
	}

	/**
	 * Configura a ordem da listagem de tutores passado o tipo da ordenação. A ordem
	 * pode ser por nome, matricula ou email. Segue a ordenação lexicográfica.
	 * 
	 * @param atributo
	 *                tipo da ordenação.
	 */
	public void configurarOrdem(String atributo) {
		AtributoOrdem atrib;
		try {
			atrib = (AtributoOrdem.valueOf(atributo.toUpperCase()));
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
		switch (atrib) {
		case NOME:
			this.comparator = new OrdenacaoNome();
			break;
		case EMAIL:
			this.comparator = new OrdenacaoEmail();
			break;
		case MATRICULA:
			this.comparator = new OrdenacaoMatricula();
			break;

		default:
			break;
		}

	}

	/**
	 * Cadastra o dia e horário de atendimento de um tutor.
	 * 
	 * @param email
	 *                String do email do tutor.
	 * @param horario
	 *                String do horario de atendimento do tutor.
	 * @param dia
	 *                String do dia do atendimento do tutor.
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		Validador.emailInvalido(email, "Erro no cadastrar horario");
		Validador.horarioInvalido(horario, "Erro no cadastrar horario");
		Validador.diaInvalido(dia, "Erro no cadastrar horario");

		if (!dados.getTutores().containsKey(email)) {
			Validador.tutorNaoCadastrado("Erro no cadastrar horario");
		}

		this.dados.getTutores().get(email).cadastrarHorario(horario, dia);
	}

	/**
	 * Cadastra um local de atendimento de um tutor.
	 * 
	 * @param email
	 *                String do email do tutor.
	 * @param local
	 *                String do local do atendimento do tutor.
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		Validador.emailInvalido(email, "Erro no cadastrar local de atendimento");
		Validador.localInvalido(local, "Erro no cadastrar local de atendimento: local");

		if (!dados.getTutores().containsKey(email)) {
			Validador.tutorNaoCadastrado("Erro no cadastrar local de atendimento");
		}

		this.dados.getTutores().get(email).cadastrarLocalDeAtendimento(local);

	}

	/**
	 * Consulta do horario de atendimento do tutor.
	 * 
	 * @param email
	 *                String do email do tutor.
	 * @param horario
	 *                String do horario de atendimento do tutor.
	 * @param dia
	 *                String do dia do atendimento do tutor.
	 * 
	 * @return um boolean que indica se o dia e o horário passados fazem parte do
	 *         atendimento de um tutor.
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		Validador.emailInvalido(email, "Erro na consulta de horario");
		Validador.diaInvalido(dia, "Erro na consulta de horario");
		Validador.horarioInvalido(horario, "Erro na consulta de horario");

		if (!dados.getTutores().containsKey(email)) {
			return false;
		}

		return this.dados.getTutores().get(email).consultaHorario(horario, dia);
	}

	/**
	 * Consulta do local de atendimento do tutor.
	 * 
	 * @param email
	 *                String do email do tutor.
	 * @param local
	 *                String do local do atendimento do tutor.
	 * 
	 * @return um boolean que indica se o local passado é o local de atendimento do
	 *         tutor.
	 */
	public boolean consultaLocal(String email, String local) {
		Validador.emailInvalido(email, "Erro na consulta de local");
		Validador.localInvalido(local, "Erro na consulta de local");

		if (!dados.getTutores().containsKey(email)) {
			return false;
		}
		return this.dados.getTutores().get(email).consultaLocal(local);
	}

	/**
	 * Pega a nota de um tutor, retornando uma String formatada para duas casas
	 * decimais.
	 * 
	 * @param matriculaTutor
	 *                matrícula do tutor para recuperar a nota.
	 * @return uma String.
	 */
	public String pegarNota(String matriculaTutor) {
		return this.dados.getTutores().get(this.dados.getAlunos().get(matriculaTutor).getEmail()).pegarNota();
	}

	/**
	 * Pega o nível de um tutor a partir de sua matrícula.
	 * 
	 * @param matriculaTutor
	 *                matrícula do tutor para recuperar o nível.
	 * @return
	 */
	public String pegarNivel(String matriculaTutor) {
		return this.dados.getTutores().get(this.dados.getAlunos().get(matriculaTutor).getEmail()).pegarNivel();
	}

	/**
	 * Pega o total de dinheiro que um tutor recebeu a partir das doações.
	 * 
	 * @param emailTutor
	 *                email do tutor para recuperar a quantidade de dinheiro.
	 * @return um int.
	 */
	public int totalDinheiroTutor(String emailTutor) {
		Validador.atributoInvalido(emailTutor, "Erro na consulta de total de dinheiro do tutor: emailTutor");

		if (!dados.getTutores().containsKey(emailTutor)) {
			Validador.tutorNaoEncontrado("Erro na consulta de total de dinheiro do tutor");
		}
		return this.dados.getTutores().get(emailTutor).getDinheiro();
	}

}

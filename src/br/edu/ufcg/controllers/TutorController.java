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

public class TutorController {
	private Dados dados;
	private Comparator<Aluno> comparator;

	public TutorController(Dados dados) {
		this.dados = dados;
		this.comparator = new OrdenacaoNome();
	}

	/**
	 * Torna um aluno em um tutor.
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
	 * Faz a listagem dos tutores.
	 * 
	 * @return o toSTring dos tutores.
	 */

	private String mapToString(Stream<Aluno> alunos) {
		return alunos.map(Aluno::toString).collect(Collectors.joining(", "));
	}

	public String listarTutores() {
		List<Aluno> alunosOrdenados = new ArrayList<Aluno>(dados.getAlunos().values());
		Collections.sort(alunosOrdenados, comparator);
		return mapToString(alunosOrdenados.stream()
				.filter(aluno -> dados.getTutores().containsKey(aluno.getEmail())));
	}

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

	public String pegarNota(String matriculaTutor) {
		return this.dados.getTutores().get(this.dados.getAlunos().get(matriculaTutor).getEmail()).pegarNota();
	}

	public String pegarNivel(String matriculaTutor) {
		return this.dados.getTutores().get(this.dados.getAlunos().get(matriculaTutor).getEmail()).pegarNivel();
	}

	public int totalDinheiroTutor(String emailTutor) {
		Validador.atributoInvalido(emailTutor, "Erro na consulta de total de dinheiro do tutor: emailTutor");

		if (!dados.getTutores().containsKey(emailTutor)) {
			Validador.tutorNaoEncontrado("Erro na consulta de total de dinheiro do tutor");
		}
		return this.dados.getTutores().get(emailTutor).getDinheiro();
	}

}

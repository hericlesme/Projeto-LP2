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
import br.edu.ufcg.enums.AtributoOrdem;
import br.edu.ufcg.util.Dados;
import br.edu.ufcg.util.Validador;

/**
 * Classe que representa o sistema Quem Me Ajuda.
 * 
 * Projeto Laboratório de Programação II
 */
public class AlunoController {

	private Dados dados;
	private int id;
	private Comparator<Aluno> comparator;

	public AlunoController(Dados dados) {
		this.dados = dados;
		this.id = 1;
		this.comparator = new OrdenacaoNome();
	}

	/**
	 * Cadastra um aluno a partir do nome,matricula,curso,email e telefone,sendo o
	 * último opcional.
	 * 
	 * @param nome
	 *                String que representa o nome do aluno
	 * @param matricula
	 *                String que representa a matricula do aluno
	 * @param codigoCurso
	 *                Inteiro que representa o codigo do curso do aluno
	 * @param telefone
	 *                String que representa o telefone do aluno
	 * @param email
	 *                String que representa o email do aluno
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		Validador.cadastroInvalido(nome, matricula, codigoCurso, telefone, email);
		if (dados.getAlunos().containsKey(matricula)) {
			Validador.matriculaCadastrada();
		}

		this.dados.adicionaAluno(matricula, new Aluno(nome, matricula, codigoCurso, telefone, email, this.id));
		this.id++;
	}

	/**
	 * Recupera um aluno a partir da sua matricula.
	 * 
	 * @param matricula
	 *                String que representa a matricula do aluno.
	 * 
	 * @return O toString do aluno.
	 */
	public String recuperaAluno(String matricula) {
		Validador.matriculaInvalida(matricula, "Erro na busca por aluno");
		if (!dados.getAlunos().containsKey(matricula)) {
			Validador.alunoInexistente("Erro na busca por aluno");
		}
		return this.dados.getAlunos().get(matricula).toString();
	}

	/**
	 * Faz a listagem de todos os alunos cadastrados no sistema.
	 * 
	 * @return O toString de todos os alunos
	 */
	public String listarAlunos() {
		List<Aluno> alunosOrdenados = new ArrayList<Aluno>(dados.getAlunos().values());
		Collections.sort(alunosOrdenados, comparator);

		return mapToString(alunosOrdenados.stream());
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
	 * Recupera um dos atributos de um aluno a partir da sua matricula.
	 * 
	 * @param matricula
	 *                String da matricula do aluno.
	 * @param atributo
	 *                String nome do atributo.
	 * 
	 * @return uma String que representa o atributo em questão.
	 */
	public String getInfoAluno(String matricula, String atributo) {
		Validador.atributoInvalido(atributo, "Erro na obtencao de informacao de aluno");
		Validador.matriculaInvalida(matricula, "Erro na obtencao de informacao de aluno");
		if (!dados.getAlunos().containsKey(matricula)) {
			Validador.alunoInexistente("Erro na obtencao de informacao de aluno");
		}
		return this.dados.getAlunos().get(matricula).getInfoAluno(atributo);
	}

}
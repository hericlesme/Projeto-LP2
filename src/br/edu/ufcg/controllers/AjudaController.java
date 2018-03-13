package br.edu.ufcg.controllers;

import java.util.ArrayList;
import java.util.Collections;

import br.edu.ufcg.entities.AjudaOnline;
import br.edu.ufcg.entities.AjudaPresencial;
import br.edu.ufcg.entities.OrdenacaoNotaTutor;
import br.edu.ufcg.entities.Tutor;
import br.edu.ufcg.util.Validador;

public class AjudaController {

	private Dados dados;

	public AjudaController(Dados dados) {
		this.dados = dados;
	}

	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse) {

		Validador.ajudaPresencialInvalida(matrAluno, disciplina, horario, dia, localInteresse);

		String matrTutor = escolherTutorPresencial(horario, dia, localInteresse, disciplina);

		return this.dados.adicionaAjuda(
				new AjudaPresencial(matrAluno, matrTutor, disciplina, horario, dia, localInteresse));
	}

	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		Validador.ajudaOnlineInvalida(matrAluno, disciplina);

		String matrTutor = escolherTutorOnline(disciplina);
		return this.dados.adicionaAjuda(new AjudaOnline(matrAluno, matrTutor, disciplina));
	}

	public String pegarTutor(int idAjuda) {
		String mensagemPadrao = "Erro ao tentar recuperar tutor ";

		Validador.validaInteiro(idAjuda, mensagemPadrao + ": id nao pode menor que zero ");
		Validador.idInvalido(idAjuda, this.dados.getAjudas().size(), mensagemPadrao + ": id nao encontrado ");

		return this.dados.getAjudas().get(idAjuda - 1).pegarTutor();
	}

	public String getInfoAjuda(int idAjuda, String atributo) {
		String mensagemPadrao = "Erro ao tentar recuperar info da ajuda ";

		Validador.validaInteiro(idAjuda, mensagemPadrao + ": id nao pode menor que zero ");
		Validador.idInvalido(idAjuda, this.dados.getAjudas().size(), mensagemPadrao + ": id nao encontrado ");
		Validador.parametroInvalido(atributo, mensagemPadrao + ": atributo nao pode ser vazio ou em branco");

		return this.dados.getAjudas().get(idAjuda - 1).getInfo(atributo);
	}

	public String avaliarTutor(int idAjuda, int nota) {
		String mensagemPadrao = "Erro na avaliacao de tutor";

		Validador.notaInvalida(nota, mensagemPadrao);
		Validador.validaInteiro(idAjuda, mensagemPadrao + ": id nao pode menor que zero ");
		Validador.idInvalido(idAjuda, this.dados.getAjudas().size(), mensagemPadrao + ": id nao encontrado ");

		String matricula = this.dados.getAjudas().get(idAjuda - 1).getInfo("matr_tutor");

		return this.dados.getTutores().get(this.dados.getAlunos().get(matricula).getEmail()).avaliarTutor(nota);

	}

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

	private String escolherTutorOnline(String disciplina) {

		ArrayList<Tutor> temp = new ArrayList<Tutor>();

		for (Tutor t : this.dados.getTutores().values()) {
			if (t.containsDisciplina(disciplina)) {
				temp.add(t);
			}
		}
		return selecionaTutorOrdenado(temp);
	}

	private String selecionaTutorOrdenado(ArrayList<Tutor> list) {
		Collections.sort(list, new OrdenacaoNotaTutor(dados.getAlunos()));

		return list.get(0).getMatricula();
	}
}
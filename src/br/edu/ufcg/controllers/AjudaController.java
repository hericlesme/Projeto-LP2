package br.edu.ufcg.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.ufcg.entities.Ajuda;
import br.edu.ufcg.entities.AjudaPresencial;
import br.edu.ufcg.entities.OrdenaTutor;
import br.edu.ufcg.entities.Tutor;
import br.edu.ufcg.util.Validador;
import br.edu.ufcg.entities.AjudaOnline;

public class AjudaController {

	private List<Ajuda> ajudas;
	private Dados dados;
	private Validador validador;

	public AjudaController(Dados dados) {
		this.validador = new Validador();
		this.ajudas = new ArrayList<Ajuda>();
		this.dados = dados;
	}

	public int pedirAjudaPresencial(String matrAluno, String disciplina,
	        String horario, String dia, String localInteresse) {

		validador.ajudaPresencialInvalida(matrAluno, disciplina, horario, dia,
		        localInteresse);

		String matrTutor = escolherTutorPresencial(horario, dia, localInteresse,
		        disciplina);

		this.ajudas.add(new AjudaPresencial(matrAluno, matrTutor, disciplina,
		        horario, dia, localInteresse));

		return this.ajudas.size();
	}

	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		validador.ajudaOnlineInvalida(matrAluno, disciplina);
		String matrTutor = escolherTutorOnline(disciplina);
		this.ajudas.add(new AjudaOnline(matrAluno, matrTutor, disciplina));
		return this.ajudas.size();
	}

	public String pegarTutor(int idAjuda) {
		validador.validaInteiro(idAjuda,
		        "Erro ao tentar recuperar tutor : id nao pode menor que zero ");
		validador.idInvalido(idAjuda, ajudas.size(),
		        "Erro ao tentar recuperar tutor : id nao encontrado ");
		return this.ajudas.get(idAjuda - 1).pegarTutor();
	}

	public String getInfoAjuda(int idAjuda, String atributo) {
		validador.validaInteiro(idAjuda,
		        "Erro ao tentar recuperar info da ajuda : id nao pode menor que zero ");
		validador.idInvalido(idAjuda, ajudas.size(),
		        "Erro ao tentar recuperar info da ajuda : id nao encontrado ");
		validador.parametroInvalido(atributo,
		        "Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		return this.ajudas.get(idAjuda - 1).getInfo(atributo);
	}

	public String avaliarTutor(int idAjuda, int nota) {
		validador.notaInvalida(nota, "Erro na avaliacao de tutor");
		validador.validaInteiro(idAjuda,
		        "Erro na avaliacao de tutor: id nao pode menor que zero ");
		validador.idInvalido(idAjuda, ajudas.size(),
		        "Erro na avaliacao de tutor: id nao encontrado ");
		String matricula = this.ajudas.get(idAjuda - 1).getInfo("matr_tutor");
		return this.dados.getTutores()
		        .get(this.dados.getAlunos().get(matricula).getEmail())
		        .avaliarTutor(nota);

	}

	private String escolherTutorPresencial(String horario, String dia,
	        String local, String disciplina) {

		ArrayList<Tutor> temp = new ArrayList<Tutor>();

		for (Tutor t : this.dados.getTutores().values()) {
			if (t.consultaHorario(horario, dia) && t.consultaLocal(local)
			        && t.containsDisciplina(disciplina)) {
				temp.add(t);
			}
		}

		return selecionaTutorOrdenado(temp);

	}

	private String selecionaTutorOrdenado(ArrayList<Tutor> list) {
		Collections.sort(list, new OrdenaTutor(dados.getAlunos()));

		return list.get(0).getMatricula();
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
}
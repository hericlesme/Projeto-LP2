package br.edu.ufcg.controllers;

import br.edu.ufcg.entities.Tutor;
import java.util.HashMap;
import java.util.Map;

//TODO Controller e implementação, esboço pronto.
public class TutorController {
	private Map<String, Tutor> tutores;

	public TutorController() {
		this.tutores = new HashMap<>();
	}

	public void tornarTutor() {
		// TODO Params + Alocar Aluno em tutor.
	}

	public String recuperaTutor() {
		// TODO Método toString no Aluno em tutor.
		return null;
	}

	public String listaTutores() {
		// TODO Stream de tutores, no filter.
		return null;
	}

	public void cadastrarHorario() {
		// TODO Cadastro de horario no tutor.
	}

	public String cadastrarLocalDeAtendimento() {
		// TODO Cadastro de local no tutor.
		return null;
	}

	public String consultaHorario() {
		// TODO Consulta de horario no tutor.
		return null;
	}

	public String consultaLocalDeAtendimento() {
		// TODO Consulta de local no tutor.
		return null;
	}

	public int totalDinheiroTutor(String emaiTutor) {
		// TODO Caixa do tutor.
		return 0;
	}

	public void doar(String matriculaTutor, int totalCentavos) {
		// TODO doação para o tutor.
	}

	public int totalDinheiroSistema() {
		// TODO caixa do sistema, e decidir onde fica.
		return 0;
	}
}

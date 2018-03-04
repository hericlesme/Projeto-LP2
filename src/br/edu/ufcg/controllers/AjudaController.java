package br.edu.ufcg.controllers;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.entities.Ajuda;
import br.edu.ufcg.entities.AjudaPresencial;
import br.edu.ufcg.entities.AjudaOnline;

public class AjudaController {
	
	private List<Ajuda> ajudas;
	
	public AjudaController() {
		this.ajudas = new ArrayList<Ajuda>();
	}
	
	public int pedirAjudaPresencial (String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
		// Escolher tutor
		this.ajudas.add(new AjudaPresencial(matrAluno,disciplina,horario,dia,localInteresse));
		return this.ajudas.size();
	}
	
	public int pedirAjudaOnline (String matrAluno, String disciplina) {
		// Escolher tutor 
		this.ajudas.add(new AjudaOnline(matrAluno,disciplina));
		return this.ajudas.size();
	}
	
	public String pegarTutor(int idAjuda) {
		return "";
	}
	
	public String getInfoAjuda(int idAjuda, String atributo) {
		return this.ajudas.get(idAjuda).getInfo(atributo);
	}

	public String avaliarTutor (int idAjuda, int nota) {
		this.ajudas.get(idAjuda).avaliarAjuda(nota);
		return "";
	}
	
}

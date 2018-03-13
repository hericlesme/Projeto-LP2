package br.edu.ufcg.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ufcg.entities.Ajuda;
import br.edu.ufcg.entities.Aluno;
import br.edu.ufcg.entities.Tutor;

public class Dados {

	private Map<String, Aluno> alunos;
	private Map<String, Tutor> tutores;
	private List<Ajuda> ajudas;
	private int caixa;
	private File alunosF;
	private File tutoresF;
	private File ajudasF;
	private File caixaF;
	private FileOutputStream fos;
	private FileInputStream fis;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	public Dados() {
		this.alunosF = new File("alunos.txt");
		this.tutoresF = new File("tutores.txt");
		this.ajudasF = new File("ajudas.txt");
		this.caixaF = new File("caixa.txt");
		this.limpar();
	}

	public Map<String, Aluno> getAlunos() {
		return this.alunos;
	}

	public Map<String, Tutor> getTutores() {
		return this.tutores;
	}
	
	public List<Ajuda> getAjudas() {
		return this.ajudas;
	}
	
	public int getCaixa() {
		return this.caixa;
	}

	public void adicionaAluno(String matricula, Aluno aluno) {
		this.alunos.put(matricula, aluno);
	}

	public void adicionaTutor(String email, Tutor tutor) {
		this.tutores.put(email, tutor);
	}
	
	public int adicionaAjuda(Ajuda ajuda) {
		this.ajudas.add(ajuda);
		return this.ajudas.size();
	}
	
	public void setCaixa(int totalCentavos) {
		this.caixa += totalCentavos;
	}
	
	public void salvar() {
		this.salvarAlunos();
		this.salvarTutores();
		this.salvarAjudas();
		this.salvarCaixa();
	}
	
	private void salvarAlunos() {
		try {
			
			this.fos = new FileOutputStream(this.alunosF);
			this.oos = new ObjectOutputStream(this.fos);
			oos.writeObject(this.alunos);
		} catch (IOException ioe) {
			System.err.println("Erro no salvamento de alunos");
		}
	}
	
	private void salvarTutores() {
		try {
			
			this.fos = new FileOutputStream(this.tutoresF);
			this.oos = new ObjectOutputStream(this.fos);
			oos.writeObject(this.tutores);
		} catch (IOException ioe) {
			System.err.println("Erro no salvamento de tutores");
		}
	}
	
	private void salvarAjudas() {
		try {
			
			this.fos = new FileOutputStream(this.ajudasF);
			this.oos = new ObjectOutputStream(this.fos);
			oos.writeObject(this.ajudas);
		} catch (IOException ioe) {
			System.err.println("Erro no salvamento de ajudas");
		}
	}
	
	private void salvarCaixa() {
		try {
			
			this.fos = new FileOutputStream(this.caixaF);
			this.oos = new ObjectOutputStream(this.fos);
			oos.writeObject(this.caixa);
		} catch (IOException ioe) {
			System.err.println("Erro no salvamento do caixa");
		}
	}
	
	public void carregar() throws ClassNotFoundException, IOException {
		this.carregarAlunos();
		this.carregarTutores();
		this.carregarAjudas();
		this.carregarCaixa();
	}
	
	public void limpar() {
		this.alunos = new HashMap<String, Aluno>();
		this.tutores = new HashMap<String, Tutor>();
		this.ajudas = new ArrayList<Ajuda>();
		this.caixa = 0;
	}
	
	private Object carregarObjeto(File file) throws ClassNotFoundException, IOException {
		Object object;
		try{
			this.fis = new FileInputStream(file);
			this.ois = new ObjectInputStream(fis);
			object = ois.readObject();
		} catch (IOException ioe) {
			System.err.println("Erro na leitura do arquivo, " + file);
			throw new IOException();
			
		}
		return object;
		
	}
	
	@SuppressWarnings("unchecked")
	private void carregarAlunos() throws ClassNotFoundException, IOException {
		this.alunos = (HashMap<String, Aluno>) (this.carregarObjeto(alunosF));
	}
	
	@SuppressWarnings("unchecked")
	private void carregarTutores() throws ClassNotFoundException, IOException {
		this.tutores = (HashMap<String, Tutor>) (this.carregarObjeto(tutoresF));
	}
	
	@SuppressWarnings("unchecked")
	private void carregarAjudas() throws ClassNotFoundException, IOException {
		this.ajudas = (ArrayList<Ajuda>) (this.carregarObjeto(ajudasF));
	}
	
	private void carregarCaixa() throws ClassNotFoundException, IOException {
		this.caixa = (int) (this.carregarObjeto(caixaF));
	}
	
	
	
}

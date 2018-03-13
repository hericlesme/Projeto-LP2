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

/**
 * 
 * Classe de Dados do Sistema.
 * carrega, salva e armazena os atributos base (entidades) do sistema.
 * 
 * Projeto de Laboratório - Programação II
 *
 */
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

	/**
	 * Inicializa, os objetos File para, armazenar e carregar os atributos de dados.
	 */
	public Dados() {
		this.alunosF = new File("alunos.txt");
		this.tutoresF = new File("tutores.txt");
		this.ajudasF = new File("ajudas.txt");
		this.caixaF = new File("caixa.txt");
		this.limpar();
	}

	/**
	 * Retorna um Map de alunos.
	 * 
	 * @return: um Map de <String, Aluno>.
	 */
	public Map<String, Aluno> getAlunos() {
		return this.alunos;
	}

	/**
	 * Retorna um Map de tutores.
	 * 
	 * @return: um Map de <String, Aluno>.
	 */
	public Map<String, Tutor> getTutores() {
		return this.tutores;
	}

	/**
	 * Retorna uma List de Ajudas.
	 * 
	 * @return: um List de Ajudas.
	 */
	public List<Ajuda> getAjudas() {
		return this.ajudas;
	}

	/**
	 * Retorna a caixa.
	 * 
	 * @return caixa.
	 */
	public int getCaixa() {
		return this.caixa;
	}

	/**
	 * Adiciona um Aluno no Map de alunos.
	 * 
	 * @param matricula:
	 *                o identificador do aluno no Map.
	 * @param aluno:
	 *                objeto da classe Aluno.
	 */
	public void adicionaAluno(String matricula, Aluno aluno) {
		this.alunos.put(matricula, aluno);
	}

	/**
	 * Adiciona um Tutor no Map de tutores.
	 * 
	 * @param matricula:
	 *                o identificador do tutor no Map.
	 * @param tutor:
	 *                objeto da classe Tutor.
	 */
	public void adicionaTutor(String email, Tutor tutor) {
		this.tutores.put(email, tutor);
	}

	/**
	 * Adiciona uma Ajuda na List de ajudas.
	 * 
	 * @param ajuda:
	 *                objeto da classe Ajuda.
	 * @return um inteiro indicando o tamanho da lista.
	 */
	public int adicionaAjuda(Ajuda ajuda) {
		this.ajudas.add(ajuda);
		return this.ajudas.size();
	}

	/**
	 * Confirgura a quantidade de centavos do caixa.
	 * 
	 * @param totalCentavos:
	 *                a quantidade que deseja-se incrementar.
	 */
	public void setCaixa(int totalCentavos) {
		this.caixa += totalCentavos;
	}

	/**
	 * Tenta salvar em arquivo o objeto da class Dados.
	 */
	public void salvar() {
		this.salvarAlunos();
		this.salvarTutores();
		this.salvarAjudas();
		this.salvarCaixa();
	}

	/**
	 * Tenta salvar em arquivo o Map de alunos da classe.
	 */
	private void salvarAlunos() {
		try {

			this.fos = new FileOutputStream(this.alunosF);
			this.oos = new ObjectOutputStream(this.fos);
			oos.writeObject(this.alunos);
		} catch (IOException ioe) {
			System.err.println("Erro no salvamento de alunos");
		}
	}

	/**
	 * Tenta salvar em arquivo o Map de tutores da classe.
	 */
	private void salvarTutores() {
		try {

			this.fos = new FileOutputStream(this.tutoresF);
			this.oos = new ObjectOutputStream(this.fos);
			oos.writeObject(this.tutores);
		} catch (IOException ioe) {
			System.err.println("Erro no salvamento de tutores");
		}
	}

	/**
	 * Tenta salvar em arquivo a lista de ajudas da classe.
	 */
	private void salvarAjudas() {
		try {

			this.fos = new FileOutputStream(this.ajudasF);
			this.oos = new ObjectOutputStream(this.fos);
			oos.writeObject(this.ajudas);
		} catch (IOException ioe) {
			System.err.println("Erro no salvamento de ajudas");
		}
	}

	/**
	 * Tenta salvar em arquivo o caixa da classe.
	 */
	private void salvarCaixa() {
		try {

			this.fos = new FileOutputStream(this.caixaF);
			this.oos = new ObjectOutputStream(this.fos);
			oos.writeObject(this.caixa);
		} catch (IOException ioe) {
			System.err.println("Erro no salvamento do caixa");
		}
	}

	/**
	 * Tentar carregar os atributos da classe Dados.
	 * 
	 * @throws ClassNotFoundException:
	 *                 Caso a classe do arquivo não exista.
	 * @throws IOException:
	 *                 caso o objeto não exista ou o carregamento seja interrompido.
	 */
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

	/**
	 * Carrega um objeto de um arquivo.
	 * 
	 * @param file:
	 *                o arquivo de onde se deseja carregar o objeto.
	 * @return Object - o que está presente no arquivo.
	 * @throws ClassNotFoundException:
	 *                 caso a classe do arquivo não exista
	 * @throws IOException:
	 *                 caso o objeto não exista ou o carregamento seja interrompido.
	 */
	private Object carregarObjeto(File file) throws ClassNotFoundException, IOException {
		Object object;
		try {
			this.fis = new FileInputStream(file);
			this.ois = new ObjectInputStream(fis);
			object = ois.readObject();
		} catch (IOException ioe) {
			System.err.println("Erro na leitura do arquivo, " + file);
			throw new IOException();

		}
		return object;

	}

	/**
	 * Tenta carregar o objeto da classe Aluno apartir de um arquivo.
	 * 
	 * @throws ClassNotFoundException:
	 *                 Caso a classe do arquivo não exista.
	 * @throws IOException:
	 *                 caso o objeto não exista ou o carregamento seja interrompido.
	 */
	@SuppressWarnings("unchecked")
	private void carregarAlunos() throws ClassNotFoundException, IOException {
		this.alunos = (HashMap<String, Aluno>) (this.carregarObjeto(alunosF));
	}

	/**
	 * Tenta carregar o objeto da classe Tutor apartir de um arquivo.
	 * 
	 * @throws ClassNotFoundException:
	 *                 Caso a classe do arquivo não exista.
	 * @throws IOException:
	 *                 caso o objeto não exista ou o carregamento seja interrompido.
	 */
	@SuppressWarnings("unchecked")
	private void carregarTutores() throws ClassNotFoundException, IOException {
		this.tutores = (HashMap<String, Tutor>) (this.carregarObjeto(tutoresF));
	}

	/**
	 * Tenta carregar o Ajuda da classe aluno apartir de um arquivo.
	 * 
	 * @throws ClassNotFoundException:
	 *                 Caso a classe do arquivo não exista.
	 * @throws IOException:
	 *                 caso o objeto não exista ou o carregamento seja interrompido.
	 */
	@SuppressWarnings("unchecked")
	private void carregarAjudas() throws ClassNotFoundException, IOException {
		this.ajudas = (ArrayList<Ajuda>) (this.carregarObjeto(ajudasF));
	}

	/**
	 * Tenta carregar o inteiro que seria igual ao valor do caixa aluno apartir de
	 * um arquivo.
	 * 
	 * @throws ClassNotFoundException:
	 *                 Caso a classe do arquivo não exista.
	 * @throws IOException:
	 *                 caso o objeto não exista ou o carregamento seja interrompido.
	 */
	private void carregarCaixa() throws ClassNotFoundException, IOException {
		this.caixa = (int) (this.carregarObjeto(caixaF));
	}

}

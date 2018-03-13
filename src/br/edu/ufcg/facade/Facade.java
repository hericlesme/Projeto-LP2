package br.edu.ufcg.facade;

import java.io.IOException;

import br.edu.ufcg.controllers.AjudaController;
import br.edu.ufcg.controllers.AlunoController;
import br.edu.ufcg.controllers.Caixa;
import br.edu.ufcg.controllers.Dados;
import br.edu.ufcg.controllers.TutorController;
import easyaccept.EasyAccept;

/**
 * Classe Facade. Delega os métodos do controller QmaSistema.
 *
 */
public class Facade {
	/**
	 * Inicializa um objeto da classe QmaSistema, controller do sistema Quem Me
	 * Ajuda.
	 */
	private Caixa caixa;
	private AjudaController ajuda;
	private AlunoController alunoC;
	private TutorController tutorC;
	private Dados dados;

	public Facade() {
		dados = new Dados();
		this.alunoC = new AlunoController(dados);
		this.tutorC = new TutorController(dados);
		this.caixa = new Caixa(dados);
		this.ajuda = new AjudaController(dados);

	}

	/**
	 * Testes EasyAccept.
	 * 
	 * @param args
	 *                array de testes.
	 */
	public static void main(String[] args) {
		args = new String[] { "br.edu.ufcg.facade.Facade", "EasyAccept//us1_test.txt",
				"EasyAccept//us2_test.txt", "EasyAccept//us3_test.txt", "EasyAccept//us4_test.txt",
				"EasyAccept//us5_test.txt", "EasyAccept//us6_test.txt" };
		EasyAccept.main(args);
	}

	/**
	 * Chama o método cadastrarAluno de QmaSistema, cadastrando um aluno no sistema.
	 * 
	 * @param nome
	 *                nome do aluno.
	 * @param matricula
	 *                matricula do aluno.
	 * @param codigoCurso
	 *                codigo do curso.
	 * @param telefone
	 *                telefone do aluno.
	 * @param email
	 *                email do aluno.
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		alunoC.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}

	/**
	 * Chama o método recuperaAluno de QmaSistema, mostrando a representação do
	 * aluno a partir de sua matrícula.
	 * 
	 * @param matricula
	 *                matrícula do aluno a ser mostrado.
	 * @return uma String.
	 */
	public String recuperaAluno(String matricula) {
		return alunoC.recuperaAluno(matricula);
	}

	/**
	 * Chama o método listarAlunos de QmaSistema, mostrando todos os alunos
	 * cadastrados.
	 * 
	 * @return uma String.
	 */
	public String listarAlunos() {
		return alunoC.listarAlunos();
	}

	/**
	 * Chama o método getInfoAluno de QmaSistema, mostrando o atributo passado como
	 * parâmetro do aluno.
	 * 
	 * @param matricula
	 *                a matrícula do aluno.
	 * @param atributo
	 *                informação a ser recuperada.
	 * @return uma String.
	 */
	public String getInfoAluno(String matricula, String atributo) {
		return alunoC.getInfoAluno(matricula, atributo);
	}

	/**
	 * Chama o método tornarTutor de QmaSistema, tornando um Aluno cadastrado um
	 * Tutor.
	 * 
	 * @param matricula
	 *                matrícula do aluno.
	 * @param disciplina
	 *                disciplina que pode ensinar.
	 * @param proficiencia
	 *                proficiência na disciplina.
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		tutorC.tornarTutor(matricula, disciplina, proficiencia);
	}

	/**
	 * Chama o método recuperaTutor de QmaSistema, mostrando a representação do
	 * Aluno tutor.
	 * 
	 * @param matricula
	 *                matrícula do Aluno a ser mostrado.
	 * @return uma String.
	 */
	public String recuperaTutor(String matricula) {
		return tutorC.recuperaTutor(matricula);
	}

	/**
	 * Chama o método listarTutores de QmaSistema, mostrando todos os Alunos que são
	 * tutores.
	 * 
	 * @return uma String.
	 */
	public String listarTutores() {
		return tutorC.listarTutores();
	}

	/**
	 * Chama o método cadastrarHorario de QmaSistema, cadastrando um horário de
	 * atendimento para o tutor.
	 * 
	 * @param email
	 *                email do tutor.
	 * @param horario
	 *                horário a ser cadastrado.
	 * @param dia
	 *                dia referente ao horário.
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		tutorC.cadastrarHorario(email, horario, dia);
	}

	/**
	 * Chama o método cadastrarLocalDeAtendimento de QmaSistema, cadastrando um
	 * local disponível para atendimento do tutor.
	 * 
	 * @param email
	 *                email do tutor.
	 * @param local
	 *                local a ser cadastrado.
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		tutorC.cadastrarLocalDeAtendimento(email, local);
	}

	/**
	 * Chama o método consultaHorario de QmaSistema, consultando se o tutor tem
	 * determinado horário disponível para atendimento.
	 * 
	 * @param email
	 *                email do tutor
	 * @param horario
	 *                horário a ser consultado.
	 * @param dia
	 *                dia a ser consultado.
	 * @return um boolean.
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		return tutorC.consultaHorario(email, horario, dia);
	}

	/**
	 * Chama o método consultaLocal de QmaSistema, consultando se o tutor tem
	 * determinado local disponível para atendimento.
	 * 
	 * @param email
	 *                email do tutor.
	 * @param local
	 *                local a ser consultado.
	 * @return um boolean.
	 */
	public boolean consultaLocal(String email, String local) {
		return tutorC.consultaLocal(email, local);
	}

	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse) {
		return this.ajuda.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
	}

	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		return this.ajuda.pedirAjudaOnline(matrAluno, disciplina);
	}

	public String pegarTutor(int idAjuda) {
		return this.ajuda.pegarTutor(idAjuda);
	}

	public String getInfoAjuda(int idAjuda, String atributo) {
		return this.ajuda.getInfoAjuda(idAjuda, atributo);
	}

	public String avaliarTutor(int idAjuda, int nota) {
		return this.ajuda.avaliarTutor(idAjuda, nota);
	}

	public String pegarNota(String matriculaTutor) {
		return this.tutorC.pegarNota(matriculaTutor);
	}

	public String pegarNivel(String matriculaTutor) {
		return this.tutorC.pegarNivel(matriculaTutor);
	}

	public void doar(String matriculaTutor, int totalCentavos) {
		this.caixa.doar(matriculaTutor, totalCentavos);
	}

	public int totalDinheiroTutor(String emailTutor) {
		return this.tutorC.totalDinheiroTutor(emailTutor);
	}

	public int totalDinheiroSistema() {
		return this.caixa.totalDinheiroSistema();
	}

	public void configurarOrdem(String atributo) {
		this.alunoC.configurarOrdem(atributo);
		this.tutorC.configurarOrdem(atributo);
	}

	public void salvar() {
		this.dados.salvar();
	}

	public void carregar() throws ClassNotFoundException, IOException {
		this.dados.carregar();
	}

	public void limpar() {
		this.dados.limpar();
	}
}

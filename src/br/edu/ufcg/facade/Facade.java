package br.edu.ufcg.facade;

import java.io.IOException;

import br.edu.ufcg.controllers.AjudaController;
import br.edu.ufcg.controllers.AlunoController;
import br.edu.ufcg.controllers.Caixa;
import br.edu.ufcg.controllers.TutorController;
import br.edu.ufcg.util.Dados;
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
		args = new String[] { "br.edu.ufcg.facade.Facade", "testes/EasyAccept//us1_test.txt",
				"testes/EasyAccept//us2_test.txt", "testes/EasyAccept//us3_test.txt",
				"testes/EasyAccept//us4_test.txt", "testes/EasyAccept//us5_test.txt",
				"testes/EasyAccept//us6_test.txt" };
		EasyAccept.main(args);
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
		alunoC.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
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
		return alunoC.recuperaAluno(matricula);
	}

	/**
	 * Faz a listagem de todos os alunos cadastrados no sistema.
	 * 
	 * @return O toString de todos os alunos
	 */
	public String listarAlunos() {
		return alunoC.listarAlunos();
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
		return alunoC.getInfoAluno(matricula, atributo);
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

	/**
	 * Cria uma AjudaPresencial adicionando-a em uma coleção de Ajudas.
	 * 
	 * @param matrAluno:
	 *                indica o nome do aluno.
	 * @param disciplina:
	 *                indica a disciplina em que deseja-se obter ajuda.
	 * @param horario:
	 *                indica o horario desejado para o atendimento da
	 *                ajudaPresencial.
	 * @param dia:
	 *                indica o dia desejado para o atendimento da ajudaPresencial.
	 * @param localInteresse:
	 *                indica a localidade desejada para o atendimento da
	 *                ajudaPresencial.
	 * @return: um inteiro indicando o indentificador da ajudaPresencial
	 */
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse) {
		return this.ajuda.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
	}

	/**
	 * Cria uma AjudaOnline adicionando-a em uma coleção de Ajudas.
	 * 
	 * @param matrAluno:
	 *                Indica o nome do aluno.
	 * @param disciplina:
	 *                Indica a disciplina em que deseja-se obter ajuda.
	 * @return: um inteiro indicando o indentificador da ajudaOnline.
	 */
	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		return this.ajuda.pedirAjudaOnline(matrAluno, disciplina);
	}

	/**
	 * Captura informações sobre o Tutor que prestou a Ajuda.
	 * 
	 * @param idAjuda:
	 *                o seu indentificador na coleção de Ajudas.
	 * @return: O retorno polimorfico é definido nas classe filhas de Ajuda, podendo
	 *          então variar seu comportamento, contém informações sobre o Tutor que
	 *          prestou a Ajuda.
	 * 
	 */
	public String pegarTutor(int idAjuda) {
		return this.ajuda.pegarTutor(idAjuda);
	}

	/**
	 * Apresenta uma informação sobre a Ajuda.
	 * 
	 * @param idAjuda:
	 *                o indentificador da Ajuda em uma coleção de Ajudas
	 * @param atributo:
	 *                um apecto da Ajuda que deseja-se obter-se uma informação.
	 * @return: uma String contendo uma informação expecifica sobre a ajuda que
	 *          deseja-se obter essa informação.
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		return this.ajuda.getInfoAjuda(idAjuda, atributo);
	}

	/**
	 * Avalia um tutor apartir de uma Ajuda prestada.
	 * 
	 * @param idAjuda:
	 *                o indentificador da Ajuda em uma coleção de Ajudas
	 * @param nota:
	 *                um inteiro entre 0 - 5.
	 * @return: uma classificação para o Tutor, pode variar entre "Aprendiz",
	 *          "Tutor" e "Top".
	 */
	public String avaliarTutor(int idAjuda, int nota) {
		return this.ajuda.avaliarTutor(idAjuda, nota);
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
		return this.tutorC.pegarNota(matriculaTutor);
	}

	/**
	 * Pega o nível de um tutor a partir de sua matrícula.
	 * 
	 * @param matriculaTutor
	 *                matrícula do tutor para recuperar o nível.
	 * @return
	 */
	public String pegarNivel(String matriculaTutor) {
		return this.tutorC.pegarNivel(matriculaTutor);
	}

	/**
	 * Método para doação de dinheiro a um tutor. Quando alguém decide doar dinheiro
	 * para o tutor, uma parte da doação vai para o caixa do sistema, enquanto a
	 * outra vai para o tutor. A parte do tutor é baseada no seu nivel.
	 * 
	 * @param matriculaTutor
	 *                matricula do tutor para doação.
	 * @param totalCentavos
	 *                total de dinheiro em centavos para doação.
	 */
	public void doar(String matriculaTutor, int totalCentavos) {
		this.caixa.doar(matriculaTutor, totalCentavos);
	}

	/**
	 * Pega o total de dinheiro que um tutor recebeu a partir das doações.
	 * 
	 * @param emailTutor
	 *                email do tutor para recuperar a quantidade de dinheiro.
	 * @return um int.
	 */
	public int totalDinheiroTutor(String emailTutor) {
		return this.tutorC.totalDinheiroTutor(emailTutor);
	}

	/**
	 * Retorna um inteiro que representa o total de dinheiro que o sistema possui.
	 * 
	 * @return um inteiro indicando o total de dinheiro..
	 */
	public int totalDinheiroSistema() {
		return this.caixa.totalDinheiroSistema();
	}
	/**
	 * Configura a ordem da listagem de alunos passado o tipo da ordenação. A ordem
	 * pode ser por nome, matricula ou email. Segue a ordenação lexicográfica.
	 * 
	 * @param atributo
	 *                tipo da ordenação.
	 */
	public void configurarOrdem(String atributo) {
		this.alunoC.configurarOrdem(atributo);
		this.tutorC.configurarOrdem(atributo);
	}

	/**
	 * Tenta salvar em arquivo o objeto da class Dados.
	 */
	public void salvar() {
		this.dados.salvar();
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
		this.dados.carregar();
	}
	/**
	 * Limpa os atributos da classe, isto é deixa-lhes composto apenas de seu
	 * elemento neutro.
	 */
	public void limpar() {
		this.dados.limpar();
	}
}

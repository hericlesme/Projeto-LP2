package UnityTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.controllers.TutorController;
import br.edu.ufcg.entities.Aluno;
import br.edu.ufcg.util.Dados;

/**
 * Classe de teste de TutorController.
 * 
 * Projeto Laboratório de Programação II
 */
public class TutorControllerTest {

	private TutorController tutorC, outroTutorC;
	private Dados dados = new Dados();

	/**
	 * adiciona um Aluno no objeto dados .
	 * 
	 * @param nome
	 *                nome do aluno.
	 * @param matricula
	 *                matrícula do aluno.
	 * @param codigoCurso
	 *                codigo do curso.
	 * @param telefone
	 *                telefone do aluno.
	 * @param email
	 *                email do aluno.
	 * 
	 */
	private void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {

		dados.adicionaAluno(matricula, new Aluno(nome, matricula, codigoCurso, telefone, email,
				geraIdAleatorio(nome, matricula, codigoCurso)));

	}

	/**
	 * Gera um id com o pseudo-aleatorio para auxiliar durantes os testes
	 * 
	 * @param nome;
	 * @param matricula;
	 * @param codigoCurso;
	 * @return o id gera pseudo-aleatoriamente
	 */
	private int geraIdAleatorio(String nome, String matricula, int codigoCurso) {
		int id = ((nome.hashCode() * matricula.hashCode() * codigoCurso)
				- (nome.hashCode() + matricula.hashCode() + codigoCurso)) % 31;
		return id;
	}

	/**
	 * Instancia o objeto TutorController.
	 */
	@Before
	public void inicializaTutorController() {
		tutorC = new TutorController(dados);
	}

	/**
	 * Demonstra que o construtor criação do objeto TutorController.
	 */
	@Test
	public void testTutorController() {
		assertTrue(outroTutorC == null); /* Antes da criação o objeto é nulo */
		outroTutorC = new TutorController(new Dados());
		assertFalse(outroTutorC == null); /* Depois da criação já não é um objeto de valor nulo */
	}

	/**
	 * Teste mostra que a criação de um tutor altera o numero de tutores
	 * existentes.
	 */
	@Test
	public void testTornarTutor() {
		this.cadastrarAluno("Hemi", "564", 12516, "", "hemists@monitor.ia");
		tutorC.tornarTutor("564", "EDA", 1);
		assertTrue(dados.getTutores().size() == 1);
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta tornar tutor
	 * através de uma matricula não cadastrada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTornarTutorAlunoInexistente() {
		tutorC.tornarTutor("2020220", "LP2", 10);
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta tornar tutor
	 * passando como parametro matricula uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTornarTutorMatriculaVazia() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("", "aah", 2);
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta tornar tutor
	 * passando como parametro disciplina uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTornarTutorDisciplinaVazia() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "", 2);
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta tornar tutor
	 * passando como parametro matricula um null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTornarTutorMatriculaNula() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor(null, "aah", 2);
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta tornar tutor
	 * passando como parametro disciplina um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testTornarTutorDisciplinaNula() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");

		tutorC.tornarTutor("2121", null, 2);
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta cadatrar um tutor
	 * com proeficiencia menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTornarTutorProficienciaInvalida() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");

		tutorC.tornarTutor("2121", "aah", -1);
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta cadatrar um tutor
	 * com proeficiencia maior que seis.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTornarTutorProficienciaInvalida2() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");

		tutorC.tornarTutor("2121", "aah", 6);
	}

	/**
	 * Cadastra um aluno, e então torna-lhe tutor. Em seguida Teste verifica se o metodo
	 * recuperaTutor, retorna a representação do aluno correto.
	 */
	@Test
	public void testRecuperaTutor() {
		this.cadastrarAluno("Gauds", "1234", 1456, "", "gauds@dsc.top");
		tutorC.tornarTutor("1234", "APLP", 5);
		assertEquals("1234 - Gauds - 1456 - gauds@dsc.top", tutorC.recuperaTutor("1234"));
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta recuperarTutor
	 * passando um null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRecuperaTutorNulo() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.recuperaTutor(null);
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta usar o metodo
	 * recuperaTutor em um aluno que não é tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRecuperaTutorInexistente() {
		tutorC.recuperaTutor("2121");

	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta recuperarTutor
	 * passando uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRecuperaTutorVazio() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.recuperaTutor("");

	}

	/**
	 * Cadastra dois aluno, em seguida os torna tutores, e então Teste verifica se o
	 * metodos listarTutores, retorna a representação adequada isto é: a toString do
	 * primeiro tutor e a toString do segundo tutor separadas por uma virgula e
	 * espaço.
	 */
	@Test
	public void testListarTutores() {
		this.cadastrarAluno("Gauds", "1234", 1456, "", "gauds@dsc.top");
		this.cadastrarAluno("Livia", "1235", 1456, "", "livia@dsc.top");

		tutorC.tornarTutor("1234", "P2", 5);
		tutorC.tornarTutor("1235", "P2", 4);

		assertEquals("1234 - Gauds - 1456 - gauds@dsc.top, 1235 - Livia - 1456 - livia@dsc.top",
				tutorC.listarTutores());
	}

	/**
	 * Cadastra um aluno, e então torna-lhe tutor. em seguida Teste verifica o metodo
	 * cadastrarHorario.
	 */
	@Test
	public void testCadastrarHorario() {
		this.cadastrarAluno("Anne amorzinho", "4321", 1456, "", "anne@mor.zinho");
		tutorC.tornarTutor("4321", "LP2", 5);
		tutorC.cadastrarHorario("anne@mor.zinho", "18:00", "seg");
		assertTrue(tutorC.consultaHorario("anne@mor.zinho", "18:00", "seg"));
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta usar o metodo
	 * cadastrarHorario em um aluno que não é tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioTutelado() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.cadastrarHorario("HAHA@OTAKU.COM", "15:16", "DOMINGAO DO FAUSTAO");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta cadastrarHorario
	 * passando o parametro email como uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioEmailVazio() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarHorario("", "21:21", "hoje");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta cadastrarHorario
	 * passando o parametro email como um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastrarHorarioEmailNulo() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarHorario(null, "21:21", "hoje");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta cadastrarHorario e
	 * é passado no parametro hora uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioHoraVazia() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarHorario("HAHA@OTAKU.COM", "", "hoje");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta cadastrarHorario e
	 * é passado no parametro hora um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastrarHorarioHoraNula() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarHorario("HAHA@OTAKU.COM", null, "hoje");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta cadastrarHorario e
	 * é passado no parametro Dia é uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioDiaVazio() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarHorario("HAHA@OTAKU.COM", "21:21", "");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta cadastrarHorario e
	 * é passado no parametro dia um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastrarHorarioDiaNulo() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarHorario("HAHA@OTAKU.COM", "21:21", null);
	}

	/**
	 * Cadastra um aluno, e então torna-lhe tutor. Em seguida Teste verifica o metodo
	 * cadastrarLocalDeAtendimento.
	 */
	@Test
	public void testCadastrarLocalDeAtendimento() {
		this.cadastrarAluno("Anne amorzinho", "4321", 1456, "", "anne@mor.zinho");
		tutorC.tornarTutor("4321", "LP2", 5);
		tutorC.cadastrarLocalDeAtendimento("anne@mor.zinho", "la no lab ne");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando o metodo
	 * cadastrarLocalDeAtendimento é passado com o parametro email como uma string
	 * vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarLocalEmailVazio() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarLocalDeAtendimento("", "la");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando o metodo
	 * cadastrarLocalDeAtendimento é passado com o parametro email como um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastrarLocalEmailNulo() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarLocalDeAtendimento(null, "la");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando o metodo
	 * cadastrarLocalDeAtendimento é passado com o parametro local como uma string
	 * vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarLocalVazio() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarLocalDeAtendimento("HAHA@OTAKU.COM", "");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando o metodo
	 * cadastrarLocalDeAtendimento é passado com o parametro local com um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastrarLocalNulo() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarLocalDeAtendimento("HAHA@OTAKU.COM", null);
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta usar o metodo
	 * cadastrarLocalDeAtendimento em um aluno que não é tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarLocalDeAtendimentoTutelado() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.cadastrarLocalDeAtendimento("HAHA@OTAKU.COM", "na sua casa ;)");
	}

	/**
	 * Cadastra um aluno, e então torna-lhe tutor. Em seguida cadastra um horario de
	 * atendimento, então Teste verifica se o metodo "consultaHorario" retorna o valor
	 * true em caso do horario estar cadastrado, e false em caso contrario.
	 */
	@Test
	public void testConsultaHorario() {
		this.cadastrarAluno("Anne amorzinho", "4321", 1456, "", "anne@mor.zinho");
		tutorC.tornarTutor("4321", "LP2", 5);

		tutorC.cadastrarHorario("anne@mor.zinho", "18:00", "seg");
		assertTrue(tutorC.consultaHorario("anne@mor.zinho", "18:00", "seg"));
		assertFalse(tutorC.consultaHorario("anne@mor.zinho", "15:00", "seg"));

	}

	/**
	 * Teste verifica se retorna false quando se tenta usar o metodo consultaHorario em um
	 * aluno que não é tutor.
	 */

	public void testConsultaHorarioTutelado() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		assertFalse(tutorC.consultaHorario("HAHA@OTAKU.COM", "321:12", "sabado-feira"));
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta consultarHorario e
	 * se passa um parametro email igual a uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioEmailVazio() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarHorario("HAHA@OTAKU.COM", "21:21", "amanha");
		tutorC.consultaHorario("", "21:21", "amanha");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta consultarHorario e
	 * se passa um parametro email igual a um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testConsultahorarioEmailnulo() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarHorario("HAHA@OTAKU.COM", "21:21", "amanha");
		tutorC.consultaHorario(null, "21:21", "amanha");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta consultarHorario e
	 * se passa um parametro horario igual a uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioVazio() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarHorario("HAHA@OTAKU.COM", "21:21", "amanha");
		tutorC.consultaHorario("HAHA@OTAKU.COM", "", "amanha");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta consultarHorario e
	 * se passa um parametro horario igual a um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testConsultaHorarioNulo() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarHorario("HAHA@OTAKU.COM", "21:21", "amanha");
		tutorC.consultaHorario("HAHA@OTAKU.COM", null, "amanha");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioDiaVazio() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarHorario("HAHA@OTAKU.COM", "21:21", "amanha");
		tutorC.consultaHorario("HAHA@OTAKU.COM", "21:21", "");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta consultarHorario e
	 * se passa um parametro dia igual a um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testConsultaHorarioDiaNulo() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarHorario("HAHA@OTAKU.COM", "21:21", "amanha");
		tutorC.consultaHorario("HAHA@OTAKU.COM", "21:21", null);
	}

	/**
	 * Cadastra um aluno, e então torna-lhe tutor. Em seguida cadastra um local de
	 * atendimento, então Teste verifica se o metodo "consultaLocal" retorna o valor true
	 * em caso do local estar cadastrado, e false em caso contrario.
	 */
	@Test
	public void testConsultaLocal() {
		this.cadastrarAluno("Anne amorzinho", "4321", 1456, "", "anne@mor.zinho");
		tutorC.tornarTutor("4321", "LP2", 5);
		tutorC.cadastrarLocalDeAtendimento("anne@mor.zinho", "lcchouse");
		assertTrue(tutorC.consultaLocal("anne@mor.zinho", "lcchouse"));
		assertFalse(tutorC.consultaLocal("anne@mor.zinho", "lugar nenhum"));
	}

	/**
	 * Teste verifica se retorna false quando se tenta usar o metodo consultaLocal em um
	 * aluno que não é tutor.
	 */
	public void testConsultaLocalTutelado() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		assertFalse(tutorC.consultaLocal("HAHA@OTAKU.COM", "pode ser na minha tambem hahaha. wink"));
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta consultarLocal
	 * passando o parametro email como uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaLocalEmailVazio() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarLocalDeAtendimento("HAHA@OTAKU.COM", "la");
		tutorC.consultaLocal("", "la");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta consultarLocal
	 * passando o parametro email como um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testConsultaLocalEmailNulo() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarLocalDeAtendimento("HAHA@OTAKU.COM", "la");
		tutorC.consultaLocal(null, "la");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta consultarLocal
	 * passando o parametro local como uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaLocalVazio() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarLocalDeAtendimento("HAHA@OTAKU.COM", "la");
		tutorC.consultaLocal("HAHA@OTAKU.COM", "");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta consultarLocal
	 * passando o parametro local como um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testConsultaLocalNulo() {
		this.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		tutorC.tornarTutor("2121", "aah", 5);
		tutorC.cadastrarLocalDeAtendimento("HAHA@OTAKU.COM", "la");
		tutorC.consultaLocal("HAHA@OTAKU.COM", null);
	}

	@Test
	public void testPegarNota() {
	}

	@Test
	public void testPegarNivel() {
	}

	@Test
	public void testTotalDinheiroTutor() {
	}

}

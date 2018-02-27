package br.edu.ufcg.UnityTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.controllers.QmaSistema;

public class QmaSistemaTest {
	QmaSistema sys, outroSys; /* Variavel do QmaSistema */

	/**
	 * Inicializa a variavel sys.
	 */
	@Before
	public void testInicializaSistema() {
		sys = new QmaSistema();
	}

	/**
	 * Testa o construtor de QmaSistema.
	 */
	@Test
	public void testQmaSistema() {
		assertTrue(outroSys == null);
		outroSys = new QmaSistema();
		assertFalse(outroSys == null);

	}

	/**
	 * Cria um aluno, e o cadastra no sistema. - Verifica se a criação é dada com
	 * sucesso através do metodo "recuperaAluno".
	 */
	@Test
	public void testCadastrarAluno() {
		sys.cadastrarAluno("faela <3", "123451234", 54321, "40028922", "faela@rafa.pocutom");
		assertEquals("123451234 - faela <3 - 54321 - 40028922 - faela@rafa.pocutom", sys.recuperaAluno("123451234"));
	}

	/**
	 * Mostra o uso correto metodo "recuperaAluno" quando o aluno cadastrado possui
	 * um numero de telefone.
	 */
	@Test
	public void testRecuperaAlunoComTelefone() {
		sys.cadastrarAluno("Fulano", "123", 1456, "88621845", "fulanim@umdois.tres");
		assertEquals("123 - Fulano - 1456 - 88621845 - fulanim@umdois.tres", sys.recuperaAluno("123"));
	}

	/**
	 * Mostra o funcionamento do metodo "recuperaAluno" quando o aluno cadastrado
	 * não possui um numero de telefone.
	 */
	@Test
	public void testRecuperaAlunoSemTelefone() {
		sys.cadastrarAluno("Beltrano", "124", 1456, "", "beltranin@umdois.tres");
		assertEquals("124 - Beltrano - 1456 - beltranin@umdois.tres", sys.recuperaAluno("124"));
	}

	/**
	 * Mostra o funcionamento do metodo "listarAlunos" quando não há alunos.
	 */
	@Test
	public void testListarAlunosSemAlunos() {
		assertEquals("", sys.listarAlunos());
	}

	/**
	 * Mostra o funcionamento do metodo "listarAlunos" quando há alunos um ou mais
	 * alunos.
	 */
	@Test
	public void testListarAlunos() {
		sys.cadastrarAluno("hulk", "1", 12, "", "hulk@avenger.com");
		assertEquals("1 - hulk - 12 - hulk@avenger.com", sys.listarAlunos());

		sys.cadastrarAluno("stark", "2", 12, "40028922", "stark@avenger.com");
		assertEquals("1 - hulk - 12 - hulk@avenger.com, 2 - stark - 12 - 40028922 - stark@avenger.com",
				sys.listarAlunos());
	}

	/**
	 * Testa o método getInfo com nota por parâmetro.
	 */
	@Test
	public void testGetInfoAlunoNota() {
		sys.cadastrarAluno("Fulano", "123", 1456, "88621845", "fulanim@umdois.tres");
		assertEquals("5", sys.getInfoAluno("123", "notaavaliacao"));
	}

	/**
	 * Testa o método getInfo com matrícula por parâmetro.
	 */
	@Test
	public void testGetInfoAlunoMatricula() {
		sys.cadastrarAluno("Fulano", "123", 1456, "88621845", "fulanim@umdois.tres");
		assertEquals("123", sys.getInfoAluno("123", "matricula"));
	}

	/**
	 * Testa o método getInfo com telefone por parâmetro.
	 */
	@Test
	public void testGetInfoAlunoTelefone() {
		sys.cadastrarAluno("Fulano", "123", 1456, "88621845", "fulanim@umdois.tres");
		assertEquals("88621845", sys.getInfoAluno("123", "telefone"));

	}

	/**
	 * Testa o método getInfo com código do Curso por parâmetro.
	 */
	@Test
	public void testGetInfoAlunoCodigoCurso() {
		sys.cadastrarAluno("Fulano", "123", 1456, "88621845", "fulanim@umdois.tres");
		assertEquals("1456", sys.getInfoAluno("123", "codigocurso"));
	}

	/**
	 * Testa o método getInfo com nome por parâmetro.
	 */
	@Test
	public void testGetInfoAlunoNome() {
		sys.cadastrarAluno("Fulano", "123", 1456, "88621845", "fulanim@umdois.tres");
		assertEquals("Fulano", sys.getInfoAluno("123", "nome"));
	}

	/**
	 * Testa o método tornarTutor.
	 */
	@Test
	public void testTornarTutor() {
		sys.cadastrarAluno("Hemi", "564", 12516, "", "hemists@monitor.ia");
		sys.tornarTutor("564", "EDA", 1);
		assertFalse(sys.consultaLocal("hemists@monitor.ia", "Lá na esquina"));
	}

	/**
	 * Cadastra um aluno, e então torna-lhe tutor. Em seguida verifica se o metodo
	 * recuperaTutor, retorna a representação do aluno correto.
	 */
	@Test
	public void testRecuperaTutor() {
		sys.cadastrarAluno("Gauds", "1234", 1456, "", "gauds@dsc.top");
		sys.tornarTutor("1234", "APLP", 5);
		assertEquals("1234 - Gauds - 1456 - gauds@dsc.top", sys.recuperaTutor("1234"));
	}

	/**
	 * Cadastra dois aluno, em seguida os torna tutores, e então verifica se o
	 * metodos listarTutores, retorna a representação adequada isto é: a toString do
	 * primeiro tutor e a toString do segundo tutor separadas por uma virgula e
	 * espaço.
	 */
	@Test
	public void testListarTutores() {
		sys.cadastrarAluno("Gauds", "1234", 1456, "", "gauds@dsc.top");
		sys.cadastrarAluno("Livia", "1235", 1456, "", "livia@dsc.top");

		sys.tornarTutor("1234", "P2", 5);
		sys.tornarTutor("1235", "P2", 4);

		assertEquals("1234 - Gauds - 1456 - gauds@dsc.top, 1235 - Livia - 1456 - livia@dsc.top", sys.listarTutores());
	}

	/**
	 * Cadastra um aluno, e então torna-lhe tutor. em seguida verifica o metodo
	 * cadastrarHorario.
	 */
	@Test
	public void testCadastrarHorario() {
		sys.cadastrarAluno("Anne amorzinho", "4321", 1456, "", "anne@mor.zinho");
		sys.tornarTutor("4321", "LP2", 5);
		sys.cadastrarHorario("anne@mor.zinho", "18:00", "seg");
		assertTrue(sys.consultaHorario("anne@mor.zinho", "18:00", "seg"));
	}

	/**
	 * Cadastra um aluno, e então torna-lhe tutor. Em seguida verifica o metodo
	 * cadastrarLocalDeAtendimento.
	 */
	@Test
	public void testCadastrarLocalDeAtendimento() {
		sys.cadastrarAluno("Anne amorzinho", "4321", 1456, "", "anne@mor.zinho");
		sys.tornarTutor("4321", "LP2", 5);
		sys.cadastrarLocalDeAtendimento("anne@mor.zinho", "la no lab ne");
	}

	/**
	 * Cadastra um aluno, e então torna-lhe tutor. Em seguida cadastra um horario de
	 * atendimento, então verifica se o metodo "consultaHorario" retorna o valor
	 * true em caso do horario estar cadastrado, e false em caso contrario.
	 */
	@Test
	public void testConsultaHorario() {
		sys.cadastrarAluno("Anne amorzinho", "4321", 1456, "", "anne@mor.zinho");
		sys.tornarTutor("4321", "LP2", 5);

		sys.cadastrarHorario("anne@mor.zinho", "18:00", "seg");
		assertTrue(sys.consultaHorario("anne@mor.zinho", "18:00", "seg"));
		assertFalse(sys.consultaHorario("anne@mor.zinho", "15:00", "seg"));

	}

	/**
	 * Cadastra um aluno, e então torna-lhe tutor. Em seguida cadastra um local de
	 * atendimento, então verifica se o metodo "consultaLocal" retorna o valor true
	 * em caso do local estar cadastrado, e false em caso contrario.
	 */
	@Test
	public void testConsultaLocal() {
		sys.cadastrarAluno("Anne amorzinho", "4321", 1456, "", "anne@mor.zinho");
		sys.tornarTutor("4321", "LP2", 5);
		sys.cadastrarLocalDeAtendimento("anne@mor.zinho", "lcchouse");
		assertTrue(sys.consultaLocal("anne@mor.zinho", "lcchouse"));
		assertFalse(sys.consultaLocal("anne@mor.zinho", "lugar nenhum"));
	}

	/**
	 * Verifica se retorna false quando se tenta usar o metodo consultaHorario em um
	 * aluno que não é tutor.
	 */

	public void testConsultaHorarioTutelado() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		assertFalse(sys.consultaHorario("HAHA@OTAKU.COM", "321:12", "sabado-feira"));
	}

	/**
	 * Verifica se retorna false quando se tenta usar o metodo consultaLocal em um
	 * aluno que não é tutor.
	 */
	public void testConsultaLocalTutelado() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		assertFalse(sys.consultaLocal("HAHA@OTAKU.COM", "pode ser na minha tambem hahaha. wink"));
	}

	/**
	 * Verifica {@link NullPointerException} quando é passado para criação de um
	 * aluno o parametro nome: como um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraAlunoNomeNulo() {
		sys.cadastrarAluno(null, "16516", 1645, "", "huasi@sijjk.com");
	}

	/**
	 * Verifica {@link NullPointerException} quando é passado para criação de um
	 * aluno o parametro matricula: como um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraAlunoMatriculaNula() {
		sys.cadastrarAluno("Issue", null, 1645, "", "huasi@sijjk.com");
	}

	/**
	 * Verifica {@link NullPointerException} quando é passado para criação de um
	 * aluno o parametro telefone: como um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraAlunoTelefoneNulo() {
		sys.cadastrarAluno("Issue", "156165", 1645, null, "huasi@sijjk.com");
	}

	/**
	 * Verifica {@link NullPointerException} quando é passado para criação de um
	 * aluno o parametro email: como um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraAlunoEmailNulo() {
		sys.cadastrarAluno("Issue", "156165", 1645, "", null);
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando é passado para criação de um
	 * aluno o parametro nome: como uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoNomeVazio() {
		sys.cadastrarAluno("", "156165", 1645, "", "eae@men.kk");
		sys.cadastrarAluno("   ", "156165", 1645, "", "eae@men.kk");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando é passado para criação de um
	 * aluno o parametro matricula: como uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoMatriculaVazia() {
		sys.cadastrarAluno("FruFru", "", 1645, "", "fru@fru.kk");
		sys.cadastrarAluno("FruFru", "   ", 1645, "", "fru@fru.kk");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando é passado para criação de um
	 * aluno o parametro email: como uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoEmailVazio() {
		sys.cadastrarAluno("FruFru", "1453", 1645, "", "");
		sys.cadastrarAluno("FruFru", "1453", 1645, "", "    ");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando é passado para criação de um
	 * aluno o parametro o codigo: com um numero menor ou igual a zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoCodigoCursoInvalido() {
		sys.cadastrarAluno("FruFru", "1453", 0, "", "hello@com.br");
		sys.cadastrarAluno("FruFru", "1453", -1, "", "hello@com.br");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta recuperar um aluno
	 * não cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRecuperaAlunoInexistente() {
		sys.recuperaAluno("213212");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta capturar
	 * informações de um aluno não cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAlunoInexistente() {
		sys.getInfoAluno("2121", "matricula");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta capturar
	 * informações de um aluno com informações compostas por um string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoInexistente() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.getInfoAluno("2121", "altura");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta tornar tutor
	 * através de uma matricula não cadastrada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTornarTutorAlunoInexistente() {
		sys.tornarTutor("2020220", "LP2", 10);
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta usar o metodo
	 * recuperaTutor em um aluno que não é tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRecuperaTutorInexistente() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.recuperaTutor("2121");

	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta usar o metodo
	 * cadastrarHorario em um aluno que não é tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioTutelado() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.cadastrarHorario("HAHA@OTAKU.COM", "15:16", "DOMINGAO DO FAUSTAO");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta usar o metodo
	 * cadastrarLocalDeAtendimento em um aluno que não é tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarLocalDeAtendimentoTutelado() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.cadastrarLocalDeAtendimento("HAHA@OTAKU.COM", "na sua casa ;)");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta recuperarAluno
	 * passando uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRecuperaAlunoVazio() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.recuperaAluno("");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta recuperarAluno
	 * passando um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testRecuperaAlunoNulo() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.recuperaAluno(null);
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta usar o metodo
	 * getInfo passando o parametro matricula igual a uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGeInfoAlunoMatriculaVazia() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.getInfoAluno("", "matricula");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta usar o metodo
	 * getInfo passando o parametro matricula igual a um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testGetInfoAlunoMatriculaNula() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.getInfoAluno(null, "matricula");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta usar o metodo
	 * getInfo passando o parametro atributo igual a uma string vazia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAlunoAtributoVazio() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.getInfoAluno("2121", "");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta usar o metodo
	 * getInfo passando o parametro atributo igual a um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testGetInfoAlunoAtributoNulo() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.getInfoAluno("2121", null);
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta tornar tutor
	 * passando como parametro matricula uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTornarTutorMatriculaVazia() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("", "aah", 2);
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta tornar tutor
	 * passando como parametro disciplina uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTornarTutorDisciplinaVazia() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "", 2);
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta tornar tutor
	 * passando como parametro matricula um null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTornarTutorMatriculaNula() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor(null, "aah", 2);
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta tornar tutor
	 * passando como parametro disciplina um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testTornarTutorDisciplinaNula() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", null, 2);
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta cadatrar um tutor
	 * com proeficiencia menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTornarTutorProficienciaInvalida() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", -1);
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta cadatrar um tutor
	 * com proeficiencia maior que seis.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTornarTutorProficienciaInvalida2() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 6);
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta recuperarTutor
	 * passando uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRecuperaTutorVazio() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.recuperaTutor("");

	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta recuperarTutor
	 * passando um null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRecuperaTutorNulo() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.recuperaTutor(null);
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta cadastrarHorario
	 * passando o parametro email como uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioEmailVazio() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarHorario("", "21:21", "hoje");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta cadastrarHorario
	 * passando o parametro email como um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastrarHorarioEmailNulo() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarHorario(null, "21:21", "hoje");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta cadastrarHorario e
	 * é passado no parametro hora uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioHoraVazia() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarHorario("HAHA@OTAKU.COM", "", "hoje");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta cadastrarHorario e
	 * é passado no parametro hora um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastrarHorarioHoraNula() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarHorario("HAHA@OTAKU.COM", null, "hoje");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta cadastrarHorario e
	 * é passado no parametro Dia é uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioDiaVazio() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarHorario("HAHA@OTAKU.COM", "21:21", "");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta cadastrarHorario e
	 * é passado no parametro dia um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastrarHorarioDiaNulo() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarHorario("HAHA@OTAKU.COM", "21:21", null);
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando o metodo
	 * cadastrarLocalDeAtendimento é passado com o parametro email como uma string
	 * vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarLocalEmailVazio() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarLocalDeAtendimento("", "la");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando o metodo
	 * cadastrarLocalDeAtendimento é passado com o parametro email como um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastrarLocalEmailNulo() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarLocalDeAtendimento(null, "la");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando o metodo
	 * cadastrarLocalDeAtendimento é passado com o parametro local como uma string
	 * vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarLocalVazio() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarLocalDeAtendimento("HAHA@OTAKU.COM", "");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando o metodo
	 * cadastrarLocalDeAtendimento é passado com o parametro local com um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastrarLocalNulo() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarLocalDeAtendimento("HAHA@OTAKU.COM", null);
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta consultarHorario e
	 * se passa um parametro email igual a uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioEmailVazio() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarHorario("HAHA@OTAKU.COM", "21:21", "amanha");
		sys.consultaHorario("", "21:21", "amanha");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta consultarHorario e
	 * se passa um parametro email igual a um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testConsultahorarioEmailnulo() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarHorario("HAHA@OTAKU.COM", "21:21", "amanha");
		sys.consultaHorario(null, "21:21", "amanha");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta consultarHorario e
	 * se passa um parametro horario igual a uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioVazio() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarHorario("HAHA@OTAKU.COM", "21:21", "amanha");
		sys.consultaHorario("HAHA@OTAKU.COM", "", "amanha");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta consultarHorario e
	 * se passa um parametro horario igual a um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testConsultaHorarioNulo() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarHorario("HAHA@OTAKU.COM", "21:21", "amanha");
		sys.consultaHorario("HAHA@OTAKU.COM", null, "amanha");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta consultarHorario e
	 * se passa um parametro dia igual a uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioDiaVazio() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarHorario("HAHA@OTAKU.COM", "21:21", "amanha");
		sys.consultaHorario("HAHA@OTAKU.COM", "21:21", "");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta consultarHorario e
	 * se passa um parametro dia igual a um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testConsultaHorarioDiaNulo() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarHorario("HAHA@OTAKU.COM", "21:21", "amanha");
		sys.consultaHorario("HAHA@OTAKU.COM", "21:21", null);
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta consultarLocal
	 * passando o parametro email como uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaLocalEmailVazio() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarLocalDeAtendimento("HAHA@OTAKU.COM", "la");
		sys.consultaLocal("", "la");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta consultarLocal
	 * passando o parametro email como um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testConsultaLocalEmailNulo() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarLocalDeAtendimento("HAHA@OTAKU.COM", "la");
		sys.consultaLocal(null, "la");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta consultarLocal
	 * passando o parametro local como uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaLocalVazio() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarLocalDeAtendimento("HAHA@OTAKU.COM", "la");
		sys.consultaLocal("HAHA@OTAKU.COM", "");
	}

	/**
	 * Verifica {@link IllegalArgumentException} quando se tenta consultarLocal
	 * passando o parametro local como um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testConsultaLocalNulo() {
		sys.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		sys.tornarTutor("2121", "aah", 5);
		sys.cadastrarLocalDeAtendimento("HAHA@OTAKU.COM", "la");
		sys.consultaLocal("HAHA@OTAKU.COM", null);
	}

}
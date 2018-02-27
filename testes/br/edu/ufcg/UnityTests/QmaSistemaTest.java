package br.edu.ufcg.UnityTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.controllers.QmaSistema;

public class QmaSistemaTest {
	QmaSistema sys, outroSys;

	@Before
	public void testInicializaSistema() {
		sys = new QmaSistema();
	}

	@Test
	public void testQmaSistema() {
		assertTrue(outroSys == null);
		outroSys = new QmaSistema();
		assertFalse(outroSys == null);

	}

	@Test
	public void testCadastrarAluno() {
		sys.cadastrarAluno("faela <3", "123451234", 54321, "40028922", "faela@rafa.pocutom");
		assertEquals("123451234 - faela <3 - 54321 - 40028922 - faela@rafa.pocutom", sys.recuperaAluno("123451234"));
	}

	@Test
	public void testRecuperaAlunoComTelefone() {
		sys.cadastrarAluno("Fulano", "123", 1456, "88621845", "fulanim@umdois.tres");
		assertEquals("123 - Fulano - 1456 - 88621845 - fulanim@umdois.tres", sys.recuperaAluno("123"));
	}

	@Test
	public void testRecuperaAlunoSemTelefone() {
		sys.cadastrarAluno("Beltrano", "124", 1456, "", "beltranin@umdois.tres");
		assertEquals("124 - Beltrano - 1456 - beltranin@umdois.tres", sys.recuperaAluno("124"));
	}

	@Test
	public void testListarAlunosSemAlunos() {
		assertEquals("", sys.listarAlunos());
	}

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
		assertEquals("5", sys.getInfoAluno("123", "notavaliacao"));
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

	@Test
	public void testTornarTutor() {
		sys.cadastrarAluno("Hemi", "564", 12516, "", "hemists@monitor.ia");
		sys.tornarTutor("564", "EDA", 1);
		assertFalse(sys.consultaLocal("hemists@monitor.ia", "Lá na esquina"));
	}

	@Test
	public void testRecuperaTutor() {
		sys.cadastrarAluno("Gauds", "1234", 1456, "", "gauds@dsc.top");
		sys.tornarTutor("1234", "APLP", 5);
		assertEquals("1234 - Gauds - 1456 - gauds@dsc.top", sys.recuperaTutor("1234"));
	}

	@Test
	public void testListarTutores() {
		sys.cadastrarAluno("Gauds", "1234", 1456, "", "gauds@dsc.top");
		sys.cadastrarAluno("Livia", "1235", 1456, "", "livia@dsc.top");

		sys.tornarTutor("1234", "P2", 5);
		sys.tornarTutor("1235", "P2", 4);

		assertEquals("1234 - Gauds - 1456 - gauds@dsc.top, 1235 - Livia - 1456 - livia@dsc.top", sys.listarTutores());
	}

	@Test
	public void testCadastrarHorario() {
		sys.cadastrarAluno("Anne amorzinho", "4321", 1456, "", "anne@mor.zinho");
		sys.tornarTutor("4321", "LP2", 5);
		sys.cadastrarHorario("anne@mor.zinho", "18:00", "seg");
	}

	@Test
	public void testCadastrarLocalDeAtendimento() {
		sys.cadastrarAluno("Anne amorzinho", "4321", 1456, "", "anne@mor.zinho");
		sys.tornarTutor("4321", "LP2", 5);
		sys.cadastrarLocalDeAtendimento("anne@mor.zinho", "la no lab ne");
	}

	@Test
	public void testConsultaHorario() {
		sys.cadastrarAluno("Anne amorzinho", "4321", 1456, "", "anne@mor.zinho");
		sys.tornarTutor("4321", "LP2", 5);

		sys.cadastrarHorario("anne@mor.zinho", "18:00", "seg");
		assertTrue(sys.consultaHorario("anne@mor.zinho", "18:00", "seg"));
		assertFalse(sys.consultaHorario("anne@mor.zinho", "15:00", "seg"));

	}

	@Test
	public void testConsultaLocal() {
		sys.cadastrarAluno("Anne amorzinho", "4321", 1456, "", "anne@mor.zinho");
		sys.tornarTutor("4321", "LP2", 5);
		sys.cadastrarLocalDeAtendimento("anne@mor.zinho", "lcchouse");
		assertTrue(sys.consultaLocal("anne@mor.zinho", "lcchouse"));
		assertFalse(sys.consultaLocal("anne@mor.zinho", "lugar nenhum"));
	}

	@Test(expected = NullPointerException.class)
	public void testCadastraAlunoNomeNulo() {
		sys.cadastrarAluno(null, "16516", 1645, "", "huasi@sijjk.com");
	}

	@Test(expected = NullPointerException.class)
	public void testCadastraAlunoMatriculaNula() {
		sys.cadastrarAluno("Issue", null, 1645, "", "huasi@sijjk.com");
	}

	@Test(expected = NullPointerException.class)
	public void testCadastraAlunoTelefoneNulo() {
		sys.cadastrarAluno("Issue", "156165", 1645, null, "huasi@sijjk.com");
	}

	@Test(expected = NullPointerException.class)
	public void testCadastraAlunoEmailNulo() {
		sys.cadastrarAluno("Issue", "156165", 1645, "", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoNomeVazio() {
		sys.cadastrarAluno("", "156165", 1645, "", "eae@men.kk");
		sys.cadastrarAluno("   ", "156165", 1645, "", "eae@men.kk");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoMatriculaVazia() {
		sys.cadastrarAluno("FruFru", "", 1645, "", "fru@fru.kk");
		sys.cadastrarAluno("FruFru", "   ", 1645, "", "fru@fru.kk");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoEmailVazio() {
		sys.cadastrarAluno("FruFru", "1453", 1645, "", "");
		sys.cadastrarAluno("FruFru", "1453", 1645, "", "    ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoCodigoCursoInvalido() {
		sys.cadastrarAluno("FruFru", "1453", 0, "", "hello@com.br");
		sys.cadastrarAluno("FruFru", "1453", -1, "", "hello@com.br");
	}
	
}

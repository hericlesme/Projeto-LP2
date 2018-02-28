package br.edu.ufcg.UnityTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.entities.Aluno;

/**
 * 
 * Formulário de Testes de Unidade da classe Aluno.
 * 
 * Projeto de Laboratório - Programação II
 *
 */
public class AlunoTest {

	private Aluno aluno, outroAluno;

	/**
	 * Inicializa o Aluno aluno, para a sessão de testes.
	 */
	@Before
	public void inicializaAluno() {
		aluno = new Aluno("Irineu", "116459781", 22345, "",
		        "irineu@vcnaosabe.nem.eu");
	}

	/**
	 * Testa o construtor de um objeto de tipo Aluno.
	 */
	@Test
	public void testAluno() {
		assertTrue(outroAluno == null);
		outroAluno = new Aluno("Jonas", "117113152", 12341, "4002-8922",
		        "jonas@grandepeixe.comeu");
		assertFalse(outroAluno == null);
	}

	/**
	 * Verifica a representação em String de um objeto Aluno quando este
	 * possui telefone.
	 */
	@Test
	public void testToStringComTelefone() {
		outroAluno = new Aluno("Jonas", "117113152", 12341, "4002-8922",
		        "jonas@grandepeixe.comeu");
		assertEquals(
		        "117113152 - Jonas - 12341 - 4002-8922 - jonas@grandepeixe.comeu",
		        outroAluno.toString());
	}

	/**
	 * Verifica a representação em String de um objeto Aluno quando este
	 * não possui telefone.
	 */
	@Test
	public void testToStringSemTelefone() {
		assertEquals(aluno.toString(),
		        "116459781 - Irineu - 22345 - irineu@vcnaosabe.nem.eu");
	}

	/**
	 * Testa o método getInfo com nota por parâmetro.
	 */
	@Test
	public void testGetInfoAlunoNota() {
		assertEquals("5", aluno.getInfoAluno("notaavaliacao"));
	}

	/**
	 * Testa o método getInfo com matrícula por parâmetro.
	 */
	@Test
	public void testGetInfoAlunoMatricula() {
		assertEquals("116459781", aluno.getInfoAluno("matricula"));
	}

	/**
	 * Testa o método getInfo com telefone por parâmetro.
	 */
	@Test
	public void testGetInfoAlunoTelefone() {
		assertEquals("", aluno.getInfoAluno("telefone"));
		outroAluno = new Aluno("PraqNome", "12345", 55478, "1234-5678",
		        "eu@sem.nome");
		assertEquals("1234-5678", outroAluno.getInfoAluno("telefone"));

	}

	/**
	 * Testa o método getInfo com código do Curso por parâmetro.
	 */
	@Test
	public void testGetInfoAlunoCodigoCurso() {
		assertEquals("22345", aluno.getInfoAluno("codigocurso"));
	}

	/**
	 * Testa o método getInfo com nome por parâmetro.
	 */
	@Test
	public void testGetInfoAlunoNome() {
		assertEquals("Irineu", aluno.getInfoAluno("nome"));
	}

	/**
	 * Testa o método getEmail de um Aluno.
	 */
	@Test
	public void testGetEmail() {
		assertEquals("irineu@vcnaosabe.nem.eu", aluno.getEmail());
	}

	/**
	 * Testa o método compareTo com saída positiva, baseado na ordenação
	 * lexicográfica do nomes de aluno.
	 */
	@Test
	public void testCompareToPositivo() {
		outroAluno = new Aluno("Babi", "12345", 55478, "1234-5678",
		        "babi@tranca.rua");
		assertTrue(aluno.compareTo(outroAluno) > 0);
	}

	/**
	 * Testa o método compareTo com saída negativa, baseado na ordenação
	 * lexicográfica dos nomes de aluno.
	 */
	@Test
	public void testCompareToNegativo() {
		outroAluno = new Aluno("Juao", "6666666", 16546, "",
		        "juao.paulo@na.merda");
		assertTrue(aluno.compareTo(outroAluno) < 0);
	}

	/**
	 * Testa o método compareTo com saída neutra, baseado na ordenação
	 * lexicográfica dos nomes de aluno.
	 */
	@Test
	public void testCompareToNeutro() {
		outroAluno = new Aluno("Irineu", "4156418", 16546, "",
		        "soucopia@do.irineu");
		assertTrue(aluno.compareTo(outroAluno) == 0);
	}

	/**
	 * Testa o método que torna o aluno um Tutor, garantindo o acesso aos
	 * métodos e funções de um Tutor.
	 */
	@Test
	public void testTornaTutor() {
		aluno.tornarTutor("LP2", 5);
		assertFalse(aluno.consultaLocal("Lá na esquina"));
	}

	/**
	 * Testa o cadastro de um horário de atendimento para um tutor.
	 */
	@Test
	public void testCadastrarHorario() {
		aluno.tornarTutor("Discreta", 1);
		aluno.cadastrarHorario("15:16", "seg");
		assertTrue(aluno.consultaHorario("15:16", "seg"));
	}

	/**
	 * Testa o cadastro de um local de atendimento para um tutor.
	 */
	@Test
	public void testCadastrarLocalDeAtendimento() {
		aluno.tornarTutor("P2", 5);
		aluno.cadastrarLocalDeAtendimento("LccHouse");
		assertTrue(aluno.consultaLocal("LccHouse"));
	}

	/**
	 * Testa a verificação de um horário de atendimento para um tutor,
	 * quando ele tem o horário marcado.
	 */
	@Test
	public void testConsultaHorarioTrue() {
		aluno.tornarTutor("Haskler do mau", 4);
		aluno.cadastrarHorario("12:00", "ter");
		assertTrue(aluno.consultaHorario("12:00", "ter"));
	}

	/**
	 * Testa a verificação de um horário de atendimento para um tutor,
	 * quando ele não tem horário marcado.
	 */
	@Test
	public void testConsultaHorarioFalse() {
		aluno.tornarTutor("Haskler do bem", 5);
		assertFalse(aluno.consultaHorario("12:00", "ter"));
		aluno.cadastrarHorario("12:50", "ter");
		assertFalse(aluno.consultaHorario("12:50", "seg"));
	}

	/**
	 * Testa a verificação de um local de atendimento para um tutor,
	 * quando ele tem local marcado.
	 */
	@Test
	public void testConsultaLocalTrue() {
		aluno.tornarTutor("ATAL", 1);
		aluno.cadastrarLocalDeAtendimento("Lcc3");
		assertTrue(aluno.consultaLocal("Lcc3"));
	}

	/**
	 * Testa a verificação de um local de atendimento para um tutor,
	 * quando ele não tem local marcado.
	 */
	@Test
	public void testConsultaLocalFalse() {
		aluno.tornarTutor("AA", 3);
		assertFalse(aluno.consultaLocal("Reenge"));
		aluno.cadastrarLocalDeAtendimento("Reenge");
		assertFalse(aluno.consultaLocal("CAA"));
	}

	/**
	 * Testa o método equals quando os alunos forem iguais.
	 */
	@Test
	public void testAlunosIguais() {
		outroAluno = new Aluno("Fulanim", "116459781", 4185, "0800 777 7000",
		        "fulano@detal.com");
		assertTrue(aluno.equals(outroAluno));
	}

	/**
	 * Testa o método equals quando os alunos forem diferentes.
	 */
	@Test
	public void testAlunosDiferentes() {
		outroAluno = new Aluno("Irineu", "116459782", 22345, "",
		        "irineu@vcnaosabe.nem.eu");
		assertFalse(aluno.equals(outroAluno));
	}

	/**
	 * Testa o método hashcode quando os alunos forem iguais.
	 */
	@Test
	public void testHashCodeIguais() {
		outroAluno = new Aluno("Fulanim", "116459781", 4185, "0800 777 7000",
		        "fulano@detal.com");
		assertTrue(aluno.hashCode() == outroAluno.hashCode());
	}

	/**
	 * Testa o método hashcode quando os alunos forem diferentes.
	 */
	@Test
	public void testHashCodeDiferentes() {
		outroAluno = new Aluno("Irineu", "116459782", 22345, "",
		        "irineu@vcnaosabe.nem.eu");
		assertFalse(aluno.hashCode() == outroAluno.hashCode());
	}

	/**
	 * Assegura o lançamento de uma exceção na tentativa de um cadastro de
	 * horário de atendimento, quando o aluno não é um tutor.
	 */
	@Test(expected = IllegalThreadStateException.class)
	public void testCadastrarHorarioTutelado() {
		aluno.cadastrarHorario("15:15", "qua");
	}

	/**
	 * Assegura o lançamento de uma exceção na tentativa de um cadastro de
	 * local de atendimento, quando o aluno não é um tutor.
	 */
	@Test(expected = IllegalThreadStateException.class)
	public void testCadastrarLocalDeAtendimentoTutelado() {
		aluno.cadastrarLocalDeAtendimento("Shopping");
	}

	/**
	 * Assegura o lançamento de uma exceção na tentativa de uma consulta
	 * de horário de atendimento, quando o aluno não é um tutor.
	 */
	@Test(expected = IllegalThreadStateException.class)
	public void testConsultaHorarioTutelado() {
		aluno.consultaHorario("15:16", "qui");
	}

	/**
	 * Assegura o lançamento de uma exceção na tentativa de um consulta de
	 * local de atendimento, quando o aluno não é um tutor.
	 */
	@Test(expected = IllegalThreadStateException.class)
	public void testConsultaLocalTutelado() {
		aluno.consultaLocal("Farmácia");
	}

}

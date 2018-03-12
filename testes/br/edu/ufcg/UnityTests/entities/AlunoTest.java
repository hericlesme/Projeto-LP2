package br.edu.ufcg.UnityTests.entities;

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
		        "irineu@vcnaosabe.nem.eu", 1);
	}

	/**
	 * Testa o construtor de um objeto de tipo Aluno.
	 */
	@Test
	public void testAluno() {
		assertTrue(outroAluno == null);
		outroAluno = new Aluno("Jonas", "117113152", 12341, "4002-8922",
		        "jonas@grandepeixe.comeu", 2);
		assertFalse(outroAluno == null);
	}

	/**
	 * Verifica a representação em String de um objeto Aluno quando este
	 * possui telefone.
	 */
	@Test
	public void testToStringComTelefone() {
		outroAluno = new Aluno("Jonas", "117113152", 12341, "4002-8922",
		        "jonas@grandepeixe.comeu", 3);
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
		assertEquals("5", aluno.getInfoAluno("nota_avaliacao"));
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
		        "eu@sem.nome", 4);
		assertEquals("1234-5678", outroAluno.getInfoAluno("telefone"));

	}

	/**
	 * Testa o método getInfo com código do Curso por parâmetro.
	 */
	@Test
	public void testGetInfoAlunoCodigoCurso() {
		assertEquals("22345", aluno.getInfoAluno("codigo_curso"));
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
		        "babi@tranca.rua", 5);
		assertTrue(aluno.compareTo(outroAluno) > 0);
	}

	/**
	 * Testa o método compareTo com saída negativa, baseado na ordenação
	 * lexicográfica dos nomes de aluno.
	 */
	@Test
	public void testCompareToNegativo() {
		outroAluno = new Aluno("Juao", "6666666", 16546, "",
		        "juao.paulo@na.merda", 6);
		assertTrue(aluno.compareTo(outroAluno) < 0);
	}

	/**
	 * Testa o método compareTo com saída neutra, baseado na ordenação
	 * lexicográfica dos nomes de aluno.
	 */
	@Test
	public void testCompareToNeutro() {
		outroAluno = new Aluno("Irineu", "4156418", 16546, "",
		        "soucopia@do.irineu", 7);
		assertTrue(aluno.compareTo(outroAluno) == 0);
	}

	/**
	 * Testa o método equals quando os alunos forem iguais.
	 */
	@Test
	public void testAlunosIguais() {
		outroAluno = new Aluno("Fulanim", "116459781", 4185, "0800 777 7000",
		        "fulano@detal.com", 8);
		assertTrue(aluno.equals(outroAluno));
	}

	/**
	 * Testa o método equals quando os alunos forem diferentes.
	 */
	@Test
	public void testAlunosDiferentes() {
		outroAluno = new Aluno("Irineu", "116459782", 22345, "",
		        "irineu@vcnaosabe.nem.eu", 9);
		assertFalse(aluno.equals(outroAluno));
	}

	/**
	 * Testa o método hashcode quando os alunos forem iguais.
	 */
	@Test
	public void testHashCodeIguais() {
		outroAluno = new Aluno("Fulanim", "116459781", 4185, "0800 777 7000",
		        "fulano@detal.com", 10);
		assertTrue(aluno.hashCode() == outroAluno.hashCode());
	}

	/**
	 * Testa o método hashcode quando os alunos forem diferentes.
	 */
	@Test
	public void testHashCodeDiferentes() {
		outroAluno = new Aluno("Irineu", "116459782", 22345, "",
		        "irineu@vcnaosabe.nem.eu", 11);
		assertFalse(aluno.hashCode() == outroAluno.hashCode());
	}

}

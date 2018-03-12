package br.edu.ufcg.UnityTests.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.entities.Ajuda;
import br.edu.ufcg.entities.AjudaOnline;

public class AjudaOnlineTest {

	private AjudaOnline ajudaO;
	private Ajuda outraAjudaO;

	@Before
	public void InicializaAjudaOnline() {
		ajudaO = new AjudaOnline("123", "333", "neuroanatomia funcional");
	}

	/**
	 * Mostra que a classe AjudaOnline Herda de Ajuda.
	 */
	@Test
	public void testAjuda() {
		assertFalse(outraAjudaO instanceof AjudaOnline);
		outraAjudaO = new AjudaOnline("123", "321", "Discreta");
		assertTrue(outraAjudaO instanceof Ajuda);
		assertTrue(outraAjudaO instanceof AjudaOnline);

	}

	@Test
	public void testAjudaOnline() {
		assertTrue(outraAjudaO == null);
		outraAjudaO = new AjudaOnline("123", "321", "Discreta");
		assertFalse(outraAjudaO == null);
	}

	@Test(expected = NullPointerException.class)
	public void testAjudaOnlineMatriculaAlunoNula() {
		outraAjudaO = new AjudaOnline(null, "321", "Discreta");

	}

	@Test(expected = IllegalArgumentException.class)
	public void testAjudaOnlineMatriculaAlunoVazia() {
		outraAjudaO = new AjudaOnline("", "321", "Discreta");

	}

	@Test(expected = NullPointerException.class)
	public void testAjudaOnlineMatriculaTutorNula() {
		outraAjudaO = new AjudaOnline("520", null, "Discreta");

	}

	@Test(expected = IllegalArgumentException.class)
	public void testAjudaOnlineMatriculaTutorVazia() {
		outraAjudaO = new AjudaOnline("000", "", "Discreta");

	}

	@Test(expected = NullPointerException.class)
	public void testAjudaOnlineDisciplinaNula() {
		outraAjudaO = new AjudaOnline("520", "55212", null);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testAjudaOnlineDisciplinaVazia() {
		outraAjudaO = new AjudaOnline("000", "55212", "");

	}

	@Test
	public void testGetInfo() {

		assertEquals("neuroanatomia funcional", ajudaO.getInfo("Disciplina"));
		assertEquals("123", ajudaO.getInfo("Matr_Aluno"));
		assertEquals("333", ajudaO.getInfo("Matr_Tutor"));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAtributoNaoExistente() {
		ajudaO.getInfo("Um atributo que não existe");
	}

	@Test
	public void testPegarTutor() {

		assertEquals("Tutor - 333, disciplina - neuroanatomia funcional", ajudaO.pegarTutor());
	}

}

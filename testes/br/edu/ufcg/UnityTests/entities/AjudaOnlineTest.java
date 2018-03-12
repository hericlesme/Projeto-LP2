package br.edu.ufcg.UnityTests.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.entities.Ajuda;
import br.edu.ufcg.entities.AjudaOnline;

/**
 * Classe de teste de AjudaOnline.
 * 
 * Projeto Laboratório de Programação II
 *
 * @author Rafael da Silva Pereira.
 */
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

	/**
	 * Teste mostra que o construtor da classe AjudaOnline inicializa o objeto.
	 */
	@Test
	public void testAjudaOnline() {
		assertTrue(outraAjudaO == null); /* Verifica que objeto é nulo */
		outraAjudaO = new AjudaOnline("123", "321", "Discreta");
		assertFalse(outraAjudaO == null); /* Verifica que depois da construçã passa a não ser mais nulo */
	}

	/**
	 * Teste mostra o comportamento do construtor quando tenta-se contruir um objeto
	 * da classe AjudaOnline com o parametro matriculaAluno igual ao um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testAjudaOnlineMatriculaAlunoNula() {
		outraAjudaO = new AjudaOnline(null, "321", "Discreta");

	}

	/**
	 * Teste mostra o comportamento do construtor quando tenta-se contruir um objeto
	 * da classe AjudaOnline com o parametro matriculaAluno igual a uma String
	 * invalida(vazia ou composta de espaços).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAjudaOnlineMatriculaAlunoVazia() {
		outraAjudaO = new AjudaOnline("", "321", "Discreta");

	}

	/**
	 * Teste mostra o comportamento do construtor quando tenta-se contruir um objeto
	 * da classe AjudaOnline com o parametro matriculaTutor igual ao um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testAjudaOnlineMatriculaTutorNula() {
		outraAjudaO = new AjudaOnline("520", null, "Discreta");

	}

	/**
	 * Teste mostra o comportamento do construtor quando tenta-se contruir um objeto
	 * da classe AjudaOnline com o parametro matriculaTutor igual a uma String
	 * invalida(vazia ou composta de espaços).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAjudaOnlineMatriculaTutorVazia() {
		outraAjudaO = new AjudaOnline("000", "", "Discreta");

	}

	/**
	 * Teste mostra o comportamento do construtor quando tenta-se contruir um objeto
	 * da classe AjudaOnline com o parametro disciplina igual ao um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testAjudaOnlineDisciplinaNula() {
		outraAjudaO = new AjudaOnline("520", "55212", null);

	}

	/**
	 * Teste mostra o comportamento do construtor quando tenta-se contruir um objeto
	 * da classe AjudaOnline com o parametro disciplina igual a uma String
	 * invalida(vazia ou composta de espaços).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAjudaOnlineDisciplinaVazia() {
		outraAjudaO = new AjudaOnline("000", "55212", "");

	}

	/**
	 * Mostra o comportamento do metodo getInfo quando lhe é passado parametro igual a:
	 * "Mart_Aluno, Mart_Tutor ou Disciplina".
	 */
	@Test
	public void testGetInfo() {

		assertEquals("neuroanatomia funcional", ajudaO.getInfo("Disciplina"));

		assertEquals("123", ajudaO.getInfo("Matr_Aluno"));

		assertEquals("333", ajudaO.getInfo("Matr_Tutor"));

	}

	/**
	 * Mostra o comportamento do metodo quando lhe é passado parametro igual a um
	 * atributo que não existe para classe.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAtributoNaoExistente() {
		ajudaO.getInfo("Um atributo que não existe");
	}

	/**
	 * Mostra o funcionamento do metodo pegarTutor na classe AjudaOnline.
	 */
	@Test
	public void testPegarTutor() {

		assertEquals("Tutor - 333, disciplina - neuroanatomia funcional", ajudaO.pegarTutor());
	}

}

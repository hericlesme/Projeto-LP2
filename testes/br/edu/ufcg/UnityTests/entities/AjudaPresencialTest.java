package br.edu.ufcg.UnityTests.entities;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.entities.Ajuda;
import br.edu.ufcg.entities.AjudaPresencial;


/**
 * Classe de teste de AjudaPresencial.
 * 
 * Projeto Laboratório de Programação II
*
 *@author Rafael da Silva Pereira.
 */
public class AjudaPresencialTest {

	private AjudaPresencial ajudaO;
	private Ajuda outraAjudaO;

	@Before
	public void InicializaAjudaPresencial() {
		ajudaO = new AjudaPresencial("455", "01203", "LEDA", "14:00", "quarta-feira", "LCC3");
	}

	/**
	 * Teste mostra que a classe AjudaPresencial Herda de Ajuda.
	 */
	@Test
	public void testAjuda() {
		assertFalse(outraAjudaO instanceof AjudaPresencial);
		outraAjudaO = new AjudaPresencial("455", "99901203", "LEDA", "14:00", "quarta-feira", "LCC3");
		assertTrue(outraAjudaO instanceof Ajuda);
		assertTrue(outraAjudaO instanceof AjudaPresencial);

	}

	/**
	 * Teste mostra que o construtor da classe funciona corretamente.
	 */
	@Test
	public void testAjudaPresencial() {
		assertTrue(outraAjudaO == null); /* Antes da construção o objeto é nulo. */
		outraAjudaO = new AjudaPresencial("455", "99901203", "LEDA", "14:00", "quarta-feira", "LCC3");
		assertFalse(outraAjudaO == null); /* Depois passa a não ser mais nulo. */
	}

	/**
	 * Teste mostra o comportamento do construtor quando se tenta instanciar um
	 * construtor passando o parametro matriculaAluno igual ao um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testAjudaPresencialMatriculaAlunoNula() {
		outraAjudaO = new AjudaPresencial(null, "99901203", "LEDA", "14:00", "quarta-feira", "LCC3");

	}

	/**
	 * Teste mostra o comportamento do construtor quando se tenta instanciar um
	 * construtor passando o parametro matriculaAluno como uma String invalida(nula
	 * ou composta apenas de espaços).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAjudaPresencialMatriculaAlunoVazia() {
		outraAjudaO = new AjudaPresencial("", "99901203", "LEDA", "14:00", "quarta-feira", "LCC3");

	}

	/**
	 * Teste mostra o comportamento do construtor quando se tenta instanciar um
	 * construtor passando o parametro matriculaTutor igual ao um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testAjudaPresencialMatriculaTutorNula() {
		outraAjudaO = new AjudaPresencial("455", null, "LEDA", "14:00", "quarta-feira", "LCC3");

	}

	/**
	 * Teste mostra o comportamento do construtor quando se tenta instanciar um
	 * construtor passando o parametro matriculaTutor igual ao uma String
	 * invalida(nula ou composta apenas de espaços).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAjudaPresencialMatriculaTutorVazia() {
		outraAjudaO = new AjudaPresencial("455", "", "LEDA", "14:00", "quarta-feira", "LCC3");

	}

	/**
	 * Teste mostra o comportamento do construtor quando se tenta instanciar um
	 * construtor passando o parametro disciplina igual ao um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testAjudaPresencialDisciplinaNula() {
		outraAjudaO = new AjudaPresencial("455", "99901203", null, "14:00", "quarta-feira", "LCC3");

	}

	/**
	 * Teste mostra o comportamento do construtor quando se tenta instanciar um
	 * construtor passando o parametro disciplina igual a uma String invalida(nula
	 * ou composta apenas de espaços).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAjudaPresencialDisciplinaVazia() {
		outraAjudaO = new AjudaPresencial("455", "99901203", "", "14:00", "quarta-feira", "LCC3");

	}

	/**
	 * Teste mostra o comportamento do construtor quando se tenta instanciar um
	 * construtor passando o parametro horario igual ao um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testAjudaPresencialHorarioNulo() {
		outraAjudaO = new AjudaPresencial("455", "99901203", "LEDA", null, "quarta-feira", "LCC3");

	}

	/**
	 * Teste mostra o comportamento do construtor quando se tenta instanciar um
	 * construtor passando o parametro horario igual a uma String invalida(nula ou
	 * composta apenas de espaços).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAjudaPresencialHorarioVazio() {
		outraAjudaO = new AjudaPresencial("455", "99901203", "LEDA", "", "quarta-feira", "LCC3");

	}

	/**
	 * Teste mostra o comportamento do construtor quando se tenta instanciar um
	 * construtor passando o parametro dia igual ao um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testAjudaPresencialDiaNulo() {
		outraAjudaO = new AjudaPresencial("455", "99901203", "LEDA", "06:30", null, "LCC3");

	}

	/**
	 * Teste mostra o comportamento do construtor quando se tenta instanciar um
	 * construtor passando o parametro dia igual a uma String invalida(nula ou
	 * composta apenas de espaços).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAjudaPresencialDiaVazio() {
		outraAjudaO = new AjudaPresencial("455", "99901203", "LEDA", "06:30", "", "LCC3");

	}

	/**
	 * Teste mostra o comportamento do construtor quando se tenta instanciar um
	 * construtor passando o parametro dia localInteresse ao um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testAjudaPresencialLocalInteresseNulo() {
		outraAjudaO = new AjudaPresencial("455", "99901203", "LEDA", "06:30", "quarta-feira", null);

	}

	/**
	 * Teste mostra o comportamento do construtor quando se tenta instanciar um
	 * construtor passando o parametro dia localInteresse a uma String invalida(nula
	 * ou composta apenas de espaços).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAjudaPresencialLocalInteresseVazio() {
		outraAjudaO = new AjudaPresencial("455", "99901203", "LEDA", "06:30", "quarta-feira", "");

	}

	/**
	 * Teste mostra o comportamento do getInfo quando o parametro passados são:
	 * "Disciplina, Matr_Aluno, Matr_Tutor, Horario, Dia ou LocalInteresse".
	 */
	@Test
	public void testGetInfo() {

		assertEquals("LEDA", ajudaO.getInfo("Disciplina"));

		assertEquals("455", ajudaO.getInfo("Matr_Aluno"));

		assertEquals("01203", ajudaO.getInfo("Matr_Tutor"));

		assertEquals("14:00", ajudaO.getInfo("Horario"));

		assertEquals("quarta-feira", ajudaO.getInfo("Dia"));

		assertEquals("LCC3", ajudaO.getInfo("LocalInteresse"));

	}

	/**
	 * Teste mostra o comportamento do getInfo quando o parametro passado não
	 * existe.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAtributoNaoExistente() {
		ajudaO.getInfo("Um atributo que não existe");
	}

	/**
	 * Teste mostra o funcionamento do metodo pegarTutor na classe ajudaPresencial.
	 */
	@Test
	public void testPegarTutor() {

		assertEquals("Tutor - 01203, horario - 14:00, dia - quarta-feira, local - LCC3, disciplina - LEDA",
				ajudaO.pegarTutor());
	}

}

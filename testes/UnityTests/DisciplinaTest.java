package UnityTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.entities.Disciplina;


/**
 * Classe de teste de Disciplina.
 * 
 * Projeto Laboratório de Programação II
*
 */
public class DisciplinaTest {

	private Disciplina disciplina, outraDisciplina;

	/**
	 * Constroi o objeto da disciplina.
	 */
	@Before
	public void inicializaDisciplina() {
		disciplina = new Disciplina("Mecanica Quantica", 4);
	}

	/**
	 * Teste Demonstra que o construtor da classe inicializa o objeto outraDisciplina
	 */
	@Test
	public void testDisciplina() {
		assertTrue(outraDisciplina == null); /* Verifica que o objeto antes da sua cosntrução é nulo */
		outraDisciplina = new Disciplina("Astrofísica nuclear", 3);
		assertFalse(outraDisciplina == null); /*
							 * Verifica que depois da contrução deste objeto ela já nãp é
							 * mais nulo
							 */

	}

	/**
	 * Teste Demonstra o comportamento do construtor quando lhe é passado o parametro nome
	 * igual a um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testDisciplinaNomeNulo() {
		outraDisciplina = new Disciplina(null, 3);

	}

	/**
	 * Teste Demonstra o comportamento do construtor quando lhe é passado o parametro nome
	 * igual a uma String invalida (vazia ou composta apenas de espaços).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDisciplinaNomeVazio() {
		outraDisciplina = new Disciplina("", 3);

	}

	/**
	 * Teste Demonstra o comportamento do construtor quando lhe é passado o parametro
	 * proeficiencia menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDisciplinaProeficienciaNegativa() {
		outraDisciplina = new Disciplina("", -1);

	}

	/**
	 * Teste Demonstra o comportamento do construtor quando lhe é passado o parametro
	 * proeficiencia maior que o limite permitido de 5.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDisciplinaProeficienciaInvalida() {
		outraDisciplina = new Disciplina("", 6);

	}

	/**
	 * Teste Demonstra o funcionamento do metodo getNome.
	 */
	@Test
	public void testGetNome() {
		assertEquals("Mecanica Quantica", disciplina.getNome());
	}

	/**
	 * Teste Demonstra o funcionamento do metodo getProeficiencia.
	 */
	@Test
	public void testGetProficiencia() {
		assertEquals(4, disciplina.getProficiencia());
	}

}

package UnityTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.controllers.Caixa;
import br.edu.ufcg.entities.Aluno;
import br.edu.ufcg.entities.Tutor;
import br.edu.ufcg.util.Dados;

/**
 * Classe de teste de Caixa.
 * 
 * Projeto Laboratório de Programação II
 * 
 */
public class CaixaTest {

	private Caixa caixa, outraCaixa;
	private Dados dados = new Dados();

	/**
	 * Inicializa o objeto dados, cadastra um Aluno e Tutor em dados e inicializa o
	 * caixa com esses dados.
	 */
	@Before
	public void iniciaCaixa() {
		dados.adicionaAluno("0001",
				new Aluno("fiqueisemideia", "0001", 222, "40028922", "emailfake@gmail.com", 1));
		dados.adicionaTutor("emailfake@gmail.com", new Tutor("p2", 2, "0001"));
		caixa = new Caixa(dados);
	}

	/**
	 * Testa a criação de um objeto do tipo Caixa.
	 */
	@Test
	public void testCaixa() {
		assertTrue(outraCaixa == null);
		outraCaixa = new Caixa(new Dados());
		assertFalse(outraCaixa == null);
	}

	/**
	 * Testa a doação de dinheiro para um tutor.
	 */
	@Test
	public void testDoar() {
		caixa.doar("0001", 33);
	}

	/**
	 * Testa o método doar passando um valor negativo. Espera-se uma exceção.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarValorNegativo() {
		caixa.doar("0001", -1);
	}

	/**
	 * Testa o método doar com matricula nula. Espera-se uma exceção.
	 */
	@Test(expected = NullPointerException.class)
	public void testDoarMatriculaTutorNula() {
		caixa.doar(null, 999999999);
	}

	/**
	 * Testa o método doar com matricula vazia. Espera-se uma exceção.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarMatriculaTutorVazia() {
		caixa.doar("", 999999999);
	}

	/**
	 * Testa o método doar com um tutor inexistente. Espera-se uma exceção.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarMatriculaTutorInexistente() {
		caixa.doar("898995656256", 999999999);
	}

	/**
	 * testa o método que recupera o total de dinheiro do sistema. Considerando um
	 * Tutor "Tutor", ele recebe 80% da doação. O sistema deveria receber então 20%.
	 */
	@Test
	public void testTotalDinheiroSistema() {
		assertEquals(0, caixa.totalDinheiroSistema());
		caixa.doar("0001", 600000);
		assertEquals(120000, caixa.totalDinheiroSistema());
	}

}

package UnityTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.entities.Aluno;
import br.edu.ufcg.entities.Tutor;
import br.edu.ufcg.util.Dados;


/**
 * Classe de teste de Dados.
 * 
 * Projeto Laboratório de Programação II
 * 
 */
public class DadosTest {

	private Dados dados, outrosDados;

	/**
	 * Inicializa o objeto dados.
	 */
	@Before
	public void inicializaDados() {
		dados = new Dados();
	}

	/**
	 * Teste verifica que o constutor da classe Dados, funciona corretamente.
	 */
	@Test
	public void testDados() {
		assertTrue(outrosDados == null); /* Objeto que ainda não foi construido é nulo */
		outrosDados = new Dados();
		assertFalse(outrosDados == null); /* Objeto depois da sua construção já não é nulo */

	}

	/**
	 * Teste verifica que o numero de alunos aumenta conforme eles são adicionados
	 * através do metodo "adicionaAluno".
	 */
	@Test
	public void testAdicionaAluno() {

		assertEquals(0, dados.getAlunos().size());

		dados.adicionaAluno("1111",
				new Aluno("Chicó", "1111", 123, "6969696", "chicoautodacomp@decida.com", 1));

		assertEquals(1, dados.getAlunos().size());

		dados.adicionaAluno("4587878", new Aluno("João Grilo", "4587878", 2061023, "69548769696",
				"joaoautodacomp@decida.com", 550));

		assertEquals(2, dados.getAlunos().size());
	}

	/**
	 * Teste verifica que o numero de tutores aumenta conforme eles são adicionados
	 * através do metodo "adicionaTutor".
	 */
	@Test
	public void testAdicionaTutor() {

		dados.adicionaAluno("123", new Aluno("Chicó", "1111", 123, "6969696", "chicoautodacomp@decida.com", 1));
		dados.adicionaAluno("4587878",
				new Aluno("João Grilo", "1234", 1023, "69548769696", "joaoautodacomp@decida.com", 2));

		assertEquals(0, dados.getTutores().size());

		dados.adicionaTutor("chicoautodacomp@decida.com", new Tutor("Tapeação", 5, "6969696"));

		assertEquals(1, dados.getTutores().size());

	}

}

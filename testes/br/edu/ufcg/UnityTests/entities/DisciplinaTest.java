package br.edu.ufcg.UnityTests.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.entities.Disciplina;

public class DisciplinaTest {

	private Disciplina disciplina, outraDisciplina;

	@Before
	public void inicializaDisciplina() {
		disciplina = new Disciplina("Mecanica Quantica", 4);
	}

	@Test
	public void testDisciplina() {
		assertTrue(outraDisciplina == null);
		outraDisciplina = new Disciplina("Astrofísica nuclear", 3);
		assertFalse(outraDisciplina == null);

	}

	@Test(expected=NullPointerException.class)
	public void testDisciplinaNomeNulo() {
		outraDisciplina = new Disciplina(null, 3);

	}

	@Test(expected=IllegalArgumentException.class)
	public void testDisciplinaNomeVazio() {
		outraDisciplina = new Disciplina("", 3);

	}

	@Test(expected=IllegalArgumentException.class)
	public void testDisciplinaProeficienciaNegativa() {
		outraDisciplina = new Disciplina("", -1);

	}

	@Test(expected=IllegalArgumentException.class)
	public void testDisciplinaProeficienciaInvalida() {
		outraDisciplina = new Disciplina("", 6);

	}

	@Test
	public void testGetNome() {
		assertEquals("Mecanica Quantica", disciplina.getNome());
	}

	@Test
	public void testGetProficiencia() {
		assertEquals(4, disciplina.getProficiencia());
	}

}

package br.edu.ufcg.UnityTests.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.controllers.Caixa;
import br.edu.ufcg.controllers.Dados;
import br.edu.ufcg.entities.Aluno;
import br.edu.ufcg.entities.Tutor;

public class CaixaTest {

	private Caixa caixa, outraCaixa;
	private Dados dados = new Dados();


	
	
	@Before
	public void iniciaCaixa() {
		dados.adicionaAluno("0001", new Aluno("fiqueisemideia", "0001", 222, "40028922", "emailfake@gmail.com", 1));
		dados.adicionaTutor("emailfake@gmail.com", new Tutor("p2", 2, "0001"));
		caixa = new Caixa(dados);
	}

	@Test
	public void testCaixa() {
		assertTrue(outraCaixa == null);
		outraCaixa = new Caixa(new Dados());
		assertFalse(outraCaixa == null);
	}

	@Test
	public void testDoar() {
		caixa.doar("0001", 33);
		fail();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDoarValorNegativo() {
		caixa.doar("0001", -1);
		fail();
	}
	
	@Test(expected = NullPointerException.class)
	public void testDoarMatriculaTutorNula() {
		caixa.doar(null, 999999999);
		fail();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDoarMatriculaTutorVazia() {
		caixa.doar("", 999999999);
		fail();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDoarMatriculaTutorInexistente() {
		caixa.doar("898995656256", 999999999);
		fail();
	}
	

	@Test
	public void testTotalDinheiroSistema() {
		assertEquals(0, caixa.totalDinheiroSistema());
		caixa.doar("0001", 600000);
		assertEquals(120000, caixa.totalDinheiroSistema());
	}

}

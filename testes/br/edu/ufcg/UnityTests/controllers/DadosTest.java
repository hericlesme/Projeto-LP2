package br.edu.ufcg.UnityTests.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.controllers.Dados;
import br.edu.ufcg.entities.Aluno;
import br.edu.ufcg.entities.Tutor;

public class DadosTest {

	private Dados dados, outrosDados;
	
	@Before
	public void inicializaDados() {
		dados = new Dados();
	}
	@Test
	public void testDados() {
		assertTrue(outrosDados == null);
		outrosDados = new Dados();
		assertFalse(outrosDados == null);

	}

	@Test
	public void testAdicionaAluno() {
		
		assertEquals(0, dados.getAlunos().size());
		
		dados.adicionaAluno("1111", new Aluno("Chicó", "1111", 123, "6969696", "chicoautodacomp@decida.com", 1));
		
		assertEquals(1, dados.getAlunos().size());
		
		dados.adicionaAluno("4587878", new Aluno("João Grilo", "4587878", 2061023, "69548769696", "joaoautodacomp@decida.com", 550));
		
		assertEquals(2, dados.getAlunos().size());
	}

	@Test
	public void testAdicionaTutor() {

		dados.adicionaAluno("123", new Aluno("Chicó", "1111", 123, "6969696", "chicoautodacomp@decida.com", 1));
		dados.adicionaAluno("4587878", new Aluno("João Grilo", "1234", 1023, "69548769696", "joaoautodacomp@decida.com", 2));

		
		assertEquals(0, dados.getTutores().size());
		
		dados.adicionaTutor("chicoautodacomp@decida.com", new Tutor("Tapeação", 5, "6969696"));
		
		assertEquals(1, dados.getTutores().size());
		
	
		assertEquals(2, dados.getTutores().size());

	}

}

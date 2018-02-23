package br.edu.ufcg.UnityTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.entities.Aluno;

public class AlunoTest {

	Aluno aluno, outroAluno;

	@Before
	public void inicializaAluno() {
		aluno = new Aluno("Irineu", "116459781", 22345, "", "irineu@vcnaosabe.nem.eu");
	}

	@Test
	public void testAluno() {
		assertTrue(outroAluno == null);
		outroAluno = new Aluno("Jonas", "117113152", 12341, "4002-8922", "jonas@grandepeixe.comeu");
		assertFalse(outroAluno == null);
	}

	@Test
	public void testToStringComTelefone() {
		outroAluno = new Aluno("Jonas", "117113152", 12341, "4002-8922", "jonas@grandepeixe.comeu");
		assertEquals("117113152 - Jonas - 12341 - 4002-8922 - jonas@grandepeixe.comeu", outroAluno.toString());
	}

	@Test
	public void testToStringSemTelefone() {
		assertEquals(aluno.toString(), "116459781 - Irineu - 22345 - irineu@vcnaosabe.nem.eu");
	}

	@Test
	public void testGetInfoAlunoNota() {
		assertEquals("5", aluno.getInfoAluno("notavaliacao"));
	}

	@Test
	public void testGetInfoAlunoMatricula() {
		assertEquals("116459781", aluno.getInfoAluno("matricula"));
	}
	
	
	@Test
	public void testGetInfoAlunoTelefone() {
		assertEquals("", aluno.getInfoAluno("telefone"));
		outroAluno = new Aluno("PraqNome", "12345", 55478, "1234-5678", "eu@sem.nome");
		assertEquals("1234-5678", outroAluno.getInfoAluno("telefone"));
		
	}
	
	@Test
	public void testGetInfoAlunoCodigoCurso() {
		assertEquals("22345", aluno.getInfoAluno("codigocurso"));
	}

	@Test
	public void testGetInfoAlunoNome() {
		assertEquals("Irineu", aluno.getInfoAluno("nome"));
	}
	
	@Test
	public void testGetEmail() {
		assertEquals("irineu@vcnaosabe.nem.eu", aluno.getEmail());
	}
	
	@Test
	public void testTornaTutor() {
		aluno.tornarTutor("LP2", 10);
		assertFalse(aluno.consultaLocal("Lá na esquina"));
	}
}

package UnityTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.comparators.OrdenacaoMatricula;
import br.edu.ufcg.entities.Aluno;

/**
 * Classe de teste de OrdenacaoMatricula.
 * 
 * Projeto Laboratório de Programação II
 * 
 */
public class OrdenacaoMatriculaTest {
	OrdenacaoMatricula ordMat, outroOrdMat;
	Aluno aluno, outroAluno;

	/**
	 * Inicializa um Aluno e um OrdenacaoMatricula
	 */
	@Before
	public void inicializa() {
		aluno = new Aluno("Pickle", "156", 48, "", "eu@pickle.com", 1);
		ordMat = new OrdenacaoMatricula();
	}

	/**
	 * Testa o construtor de um OrdenacaoMatricula.
	 */
	@Test
	public void testOrdenacaoMatricula() {
		assertTrue(outroOrdMat == null);
		outroOrdMat = new OrdenacaoMatricula();
		assertFalse(outroOrdMat == null);
	}

	/**
	 * Testa o método compare, quando um aluno tiver a matricula lexicograficamente
	 * maior que outro.
	 */
	@Test
	public void testCompareMaior() {
		outroAluno = new Aluno("Rubik", "15", 48, "", "eu@shua.com", 1);
		assertTrue(ordMat.compare(aluno, outroAluno) > 0);
	}

	/**
	 * Testa o método compare quando as matrículas dos alunos forem
	 * lexicograficamente equivalentes.
	 */
	@Test
	public void testCompareIgual() {
		outroAluno = new Aluno("Rubik", "156", 48, "", "eu@shua.com", 1);
		assertTrue(ordMat.compare(aluno, outroAluno) == 0);
	}

}

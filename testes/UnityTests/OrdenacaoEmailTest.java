package UnityTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.comparators.OrdenacaoEmail;
import br.edu.ufcg.entities.Aluno;

/**
 * Classe de teste de OrdenacaoEmailTest.
 * 
 * Projeto Laboratório de Programação II
 * 
 */
public class OrdenacaoEmailTest {
	OrdenacaoEmail ordMail, outroOrdMail;
	Aluno aluno, outroAluno;

	/**
	 * Inicializa um OrdenacaoEmailTest e dois objetos Aluno.
	 */
	@Before
	public void inicializa() {
		aluno = new Aluno("Pickle", "156", 48, "", "eu@pickle.com", 1);
		outroAluno = new Aluno("Rubik", "154", 48, "", "ae@rubik.com", 1);
		ordMail = new OrdenacaoEmail();
	}

	/**
	 * Testa o construtor de um OrdenacaoEmail.
	 */
	@Test
	public void testOrdenacaoEmail() {
		assertTrue(outroOrdMail == null);
		outroOrdMail = new OrdenacaoEmail();
		assertFalse(outroOrdMail == null);
	}

	/**
	 * Testa o método compare, quando um aluno tiver o email lexicograficamente
	 * maior que outro.
	 */
	@Test
	public void testCompareMaior() {
		assertTrue(ordMail.compare(aluno, outroAluno) > 0);
	}

	/**
	 * Testa o método compare quando os emails forem lexicograficamente equivalentes, mas
	 * a matrícula é maior.
	 */
	@Test
	public void testCompareIgualMatriculaMaior() {
		outroAluno = new Aluno("Rubik", "154", 48, "", "eu@pickle.com", 1);
		assertTrue(ordMail.compare(aluno, outroAluno) > 0);
	}

	/**
	 * Testa o método compare quando email e matrícula dos alunos forem
	 * lexicograficamente equivalentes.
	 */
	@Test
	public void testCompareIgual() {
		outroAluno = new Aluno("Rubik", "156", 48, "", "eu@pickle.com", 1);
		assertTrue(ordMail.compare(aluno, outroAluno) == 0);
	}

}

package UnityTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.comparators.OrdenacaoNome;
import br.edu.ufcg.entities.Aluno;

/**
 * Classe de teste de OrdenacaoNome.
 * 
 * Projeto Laboratório de Programação II
 * 
 */
public class OrdenacaoNomeTest {
	OrdenacaoNome ordNome, outroOrdNome;
	Aluno aluno, outroAluno;

	/**
	 * Inicializa um OrdenacaoNomeTest e dois objetos Aluno.
	 */
	@Before
	public void inicializa() {
		aluno = new Aluno("Pickle", "156", 48, "", "eu@pickle.com", 1);
		outroAluno = new Aluno("Rubik", "154", 48, "", "ae@rubik.com", 1);
		ordNome = new OrdenacaoNome();
	}

	/**
	 * Testa o construtor de um OrdenacaoNome.
	 */
	@Test
	public void testOrdenacaoNome() {
		assertTrue(outroOrdNome == null);
		outroOrdNome = new OrdenacaoNome();
		assertFalse(outroOrdNome == null);
	}

	/**
	 * Testa o método compare, quando um aluno tiver o nome lexicograficamente maior
	 * que outro.
	 */
	@Test
	public void testCompareMaior() {
		assertTrue(ordNome.compare(outroAluno, aluno) > 0);
	}

	/**
	 * Testa o método compare quando os nome forem lexicograficamente equivalentes,
	 * mas a matrícula é maior.
	 */
	@Test
	public void testCompareIgualMatriculaMaior() {
		outroAluno = new Aluno("Pickle", "154", 48, "", "eu@pickle.com", 1);
		assertTrue(ordNome.compare(aluno, outroAluno) > 0);
	}

	/**
	 * Testa o método compare quando nome e matrícula dos alunos forem
	 * lexicograficamente equivalentes.
	 */
	@Test
	public void testCompareIgual() {
		outroAluno = new Aluno("Pickle", "156", 48, "", "eu@pickle.com", 1);
		assertTrue(ordNome.compare(aluno, outroAluno) == 0);
	}

}

package UnityTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.comparators.OrdenacaoNotaTutor;
import br.edu.ufcg.entities.Aluno;
import br.edu.ufcg.entities.Tutor;

/**
 * Classe de teste de OrdenacaoEmail.
 * 
 * Projeto Laboratório de Programação II
 * 
 */
public class OrdenacaoNotaTutorTest {
	Map<String, Aluno> alunos;
	OrdenacaoNotaTutor ordNT, outroOrdNT;
	Aluno a1, a2, a3;
	Tutor t1, t2, t3;

	/**
	 * Inicializa os alunos, tutores, e o map de alunos para a sessão de testes
	 */
	@Before
	public void inicializa() {
		inicializaAlunos();
		inicializaTutores();
		alunos = new HashMap<>();
		alunos.put("123", a1);
		alunos.put("124", a2);
		alunos.put("125", a3);
		ordNT = new OrdenacaoNotaTutor(alunos);

	}

	/**
	 * Inicializa os alunos a1, a2, a3.
	 */
	private void inicializaAlunos() {
		a1 = new Aluno("eu", "123", 4564, "", "eu@tu.com", 1);
		a2 = new Aluno("nos", "124", 4564, "", "nos@tu.com", 2);
		a3 = new Aluno("tu", "125", 4564, "", "tu@ela.com", 2);
	}

	/**
	 * Inicializa os tutores t1, t2, t3.
	 */
	private void inicializaTutores() {
		t1 = new Tutor("discreta", 1, "123");
		t2 = new Tutor("p2", 2, "124");
		t3 = new Tutor("discreta", 5, "125");
	}

	/**
	 * Testa o construtor de um OrdenacaoTutor.
	 */
	@Test
	public void testOrdenacaoTutor() {
		assertTrue(outroOrdNT == null);
		outroOrdNT = new OrdenacaoNotaTutor(alunos);
		assertFalse(outroOrdNT == null);
	}

	/**
	 * Testa o método compare, quando um tutor tem nota de avaliação maior.
	 */
	@Test
	public void testCompareMaior() {
		t1.avaliarTutor(5);
		assertTrue(ordNT.compare(t1, t2) > 0);
	}

	/**
	 * Testa o método compare, quando dois tutores tem a mesma nota de avaliação,
	 * mas t1 tem id menor que t2.
	 */
	@Test
	public void testCompareIgualIdMaior() {
		assertTrue(ordNT.compare(t1, t2) < 0);
	}

	/**
	 * Testa o método compare, quando dois tutores tem a mesma nota de avaliação e
	 * id.
	 */
	@Test
	public void testCompareIgual() {
		assertTrue(ordNT.compare(t2, t3) == 0);
	}
}

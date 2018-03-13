package UnityTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.entities.Tutor;

/**
 * 
 * Formulário de Testes de Unidade da classe Tutor.
 * 
 * Projeto de Laboratório - Programação II
 *
 */
public class TutorTest {
	private Tutor tutor, outroTutor;

	/**
	 * Inicializa o Tutor tutor, para a sessão de testes.
	 */
	@Before
	public void inicializaTutor() {
		tutor = new Tutor("Discreta", 1, "40028922");
	}

	/**
	 * Testa o construtor de um Tutor.
	 */
	@Test
	public void testTutor() {
		assertTrue(outroTutor == null);
		outroTutor = new Tutor("Grafos", 5, "00001");
		assertFalse(outroTutor == null);
	}

	/**
	 * Testa o cadastro de um horário de atendimento para um tutor.
	 */
	@Test
	public void testCadastrarHorario() {
		tutor.cadastrarHorario("08:00", "seg");
		assertTrue(tutor.consultaHorario("08:00", "seg"));
	}

	/**
	 * Testa o cadastro de um local de atendimento para um tutor.
	 */
	@Test
	public void testCadastrarLocalDeAtendimento() {
		tutor.cadastrarLocalDeAtendimento("Quadra da UFCG");
		assertTrue(tutor.consultaLocal("Quadra da UFCG"));
	}

	/**
	 * Testa a verificação de um horário de atendimento para um tutor, quando ele
	 * tem o horário marcado.
	 */
	@Test
	public void testConsultaHorarioTrue() {
		tutor.cadastrarHorario("15:00", "qua");
		assertTrue(tutor.consultaHorario("15:00", "qua"));
	}

	/**
	 * Testa a verificação de um horário de atendimento para um tutor, quando ele
	 * não tem horário marcado.
	 */
	@Test
	public void testConsultaHorarioFalse() {
		assertFalse(tutor.consultaHorario("19:00", "qua"));
		tutor.cadastrarHorario("12:50", "qua");
		assertFalse(tutor.consultaHorario("12:50", "seg"));
	}

	/**
	 * Testa a verificação de um local de atendimento para um tutor, quando ele tem
	 * local marcado.
	 */
	@Test
	public void testConsultaLocalTrue() {
		tutor.cadastrarLocalDeAtendimento("Lcc4");
		assertTrue(tutor.consultaLocal("Lcc4"));
	}

	/**
	 * Testa a verificação de um local de atendimento para um tutor, quando ele não
	 * tem local marcado.
	 */
	@Test
	public void testConsultaLocalFalse() {
		assertFalse(tutor.consultaLocal("CA"));
		tutor.cadastrarLocalDeAtendimento("CA");
		assertFalse(tutor.consultaLocal("Lcc1"));
	}

	/**
	 * Testa o método adicionaDisciplina de um tutor.
	 */
	@Test
	public void testAdicionaDisciplina() {
		tutor.adicionaDisciplina("teste", 5);
		assertTrue(tutor.containsDisciplina("teste"));
	}

	/**
	 * Testa o método containsDisciplina de tutor, para o caso dele ensinar a
	 * disciplina e não.
	 */
	@Test
	public void testContainsDisciplina() {
		tutor.adicionaDisciplina("teste", 4);
		assertTrue(tutor.containsDisciplina("teste"));
		assertFalse(tutor.containsDisciplina("aquinao"));
	}

	/**
	 * Testa construção do tutor com disciplina nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testTutorDisciplinaNula() {
		new Tutor(null, 2, "123");
	}

	/**
	 * Testa construção do tutor com disciplina vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTutorDisciplinaVazia() {
		new Tutor("", 2, "123");
	}

	/**
	 * Testa construção do tutor com proficiencia menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTutorProficienciaMenorQueZero() {
		new Tutor("P2", -1, "123");
	}

	/**
	 * Testa construção do tutor com proficiencia maior que cinco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTutorProficienciaMaiorQueCinco() {
		new Tutor("Calculo", 97, "123");
	}

	/**
	 * Testa construção do tutor com matricula nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testTutorMatriculaNula() {
		new Tutor("Calculo", 4, null);
	}

	/**
	 * Testa construção do tutor com matricula vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTutorMatriculaVazia() {
		new Tutor("Calculo", 4, "");
	}

}

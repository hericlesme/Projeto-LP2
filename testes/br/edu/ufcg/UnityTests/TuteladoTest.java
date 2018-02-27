package br.edu.ufcg.UnityTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.entities.Tutelado;

/**
 * 
 * Formulário de Testes de Unidade da classe Tutelado.
 * 
 * Projeto de Laboratório - Programação II
 *
 */
public class TuteladoTest {
	Tutelado aluno, tutelado;

	/**
	 * Inicializa o Tutelado aluno, para a sessão de testes.
	 */
	@Before
	public void inicializaTutelado() {
		aluno = new Tutelado();
	}

	/**
	 * Testa o construtor de um Tutelado.
	 */
	@Test
	public void testTutelado() {
		assertTrue(tutelado == null);
		tutelado = new Tutelado();
		assertFalse(tutelado == null);

	}

	/**
	 * Assegura o lançamento de uma exceção na tentativa de um cadastro de horário
	 * de atendimento, quando o aluno é tutelado.
	 */
	@Test(expected = IllegalThreadStateException.class)
	public void testCadastrarHorario() {
		aluno.cadastrarHorario("18:00", "seg");
	}

	/**
	 * Assegura o lançamento de uma exceção na tentativa de um cadastro de local de
	 * atendimento, quando o aluno é tutelado.
	 */
	@Test(expected = IllegalThreadStateException.class)
	public void testCadastrarLocalDeAtendimento() {
		aluno.cadastrarLocalDeAtendimento("morrinho");
	}

	/**
	 * Assegura o lançamento de uma exceção na tentativa de uma consulta de horário
	 * de atendimento, quando o aluno é tutelado.
	 */
	@Test(expected = IllegalThreadStateException.class)
	public void testConsultaHorario() {
		aluno.consultaHorario("23:59", "sex");
	}

	/**
	 * Assegura o lançamento de uma exceção na tentativa de um consulta de local de
	 * atendimento, quando o aluno é tutelado.
	 */
	@Test(expected = IllegalThreadStateException.class)
	public void testConsultaLocal() {
		aluno.consultaLocal("sua residencia");
	}

	/**
	 * Assegura o lançamento de uma exceção na tentativa de uma adição de
	 * disciplina, quando o aluno é tutelado.
	 */
	@Test(expected = IllegalThreadStateException.class)
	public void testAdicionaDisciplina() {
		aluno.adicionaDisciplina("aah", 5);
	}

	/**
	 * Assegura o lançamento de uma exceção na tentativa do uso de
	 * containsDisciplina, quando o aluno é tutelado.
	 */
	@Test(expected = IllegalThreadStateException.class)
	public void testContainsDisciplina() {
		aluno.containsDisciplina("aah");
	}

}

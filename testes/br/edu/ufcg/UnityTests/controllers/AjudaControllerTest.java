package br.edu.ufcg.UnityTests.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.controllers.AjudaController;
import br.edu.ufcg.controllers.Dados;
import br.edu.ufcg.entities.Aluno;
import br.edu.ufcg.entities.Tutor;

/**
 * Classe de teste de Ajuda.
 * 
 * Projeto Laboratório de Programação II
 * 
 */
public class AjudaControllerTest {

	private AjudaController ajudaC, outroAjudaC;
	private Dados dados = new Dados();

	/**
	 * Inicializa o objeto AjudaControle, passando dados (outro objeto).
	 */
	@Before
	public void inicializaAjudaController() {
		ajudaC = new AjudaController(dados);
	}

	/**
	 * Adiciona um Aluno no objeto dados.
	 * 
	 * @param nome
	 *                nome do aluno.
	 * @param matricula
	 *                matrícula do aluno.
	 * @param codigoCurso
	 *                codigo do curso.
	 * @param telefone
	 *                telefone do aluno.
	 * @param email
	 *                email do aluno.
	 * @param id
	 *                id do aluno.
	 *
	 */
	private void adicionaAluno(String nome, String matricula, int codigoCurso, String telefone, String email,
			int id) {
		dados.adicionaAluno(matricula, new Aluno(nome, matricula, codigoCurso, telefone, email, id));
	}

	/**
	 * Adiciona um Tutor no objeto dados.
	 * 
	 * @param email:
	 *                o email do Tutor.
	 * 
	 * @param disciplina
	 *                a disciplina que o Tutor vai ensinar.
	 * @param proficiencia
	 *                um numero entre um e cinco indicando o quão habil na
	 *                disciplina o Tutor se considera.
	 * @param matricula
	 *                a matricula do Tutor.
	 */
	private void adicionaTutor(String email, String disciplina, int proeficiencia, String matricula) {
		dados.adicionaTutor(email, new Tutor(disciplina, proeficiencia, matricula));
	}

	/**
	 * Testa a criação de um objeto da classe AjudaController. No primeiro assert,
	 * mostra que o objeto é nulo. E depois da construção do objeto, mostra-se que
	 * ele já não é mais nulo.
	 */
	@Test
	public void testAjudaController() {
		assertTrue(outroAjudaC == null);
		outroAjudaC = new AjudaController(new Dados());
		assertFalse(outroAjudaC == null);
	}

	/**
	 * Testa o metodo: pedirAjudaPresencial quando em uma situação ideal, ou seja
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros corretamente.
	 */
	@Test
	public void testPedirAjudaPresencial() {
		this.adicionaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "IA", "15:00", "Sexta-Feira", "LCC2"));
	}

	/**
	 * Testa o metodo: pedirAjudaPresencial quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro matricula é null.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedirAjudaPresencialMatriculaNula() {
		this.adicionaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial(null, "IA", "15:00", "Sexta-Feira", "LCC2"));
	}

	/**
	 * Testa o metodo: pedirAjudaPresencial quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro matricula é uma String invalida
	 * (vazia ou composta de espaços).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialMatriculaVazia() {
		this.adicionaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("", "IA", "15:00", "Sexta-Feira", "LCC2"));
	}

	/**
	 * Testa o metodo: pedirAjudaPresencial quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro Disciplina é null.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedirAjudaPresencialDisciplinaNula() {
		this.adicionaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", null, "15:00", "Sexta-Feira", "LCC2"));
	}

	/**
	 * Testa o metodo: pedirAjudaPresencial quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro disciplina é uma String invalida
	 * (vazia ou composta de espaços).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDisciplinaVazia() {
		this.adicionaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "", "15:00", "Sexta-Feira", "LCC2"));
	}

	/**
	 * Testa o metodo: pedirAjudaPresencial quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro horario é null.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedirAjudaPresencialHorarioNulo() {
		this.adicionaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "IA", null, "Sexta-Feira", "LCC2"));
	}

	/**
	 * Testa o metodo: pedirAjudaPresencial quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro horario é uma String invalida (vazia
	 * ou composta de espaços).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialHorarioVazio() {
		this.adicionaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "IA", "", "Sexta-Feira", "LCC2"));
	}

	/**
	 * Testa o metodo: pedirAjudaPresencial quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro dia é null.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedirAjudaPresencialDiaNulo() {
		this.adicionaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "IA", "03:30", null, "LCC2"));
	}

	/**
	 * Testa o metodo: pedirAjudaPresencial quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro dia é uma String invalida (vazia ou
	 * composta de espaços).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDiaVazio() {
		this.adicionaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "IA", "03:30", "", "LCC2"));
	}

	/**
	 * Testa o metodo: pedirAjudaPresencial quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro local é null.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedirAjudaPresencialLocalNulo() {
		this.adicionaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "IA", "03:30", "Sexta-Feira", null));
	}

	/**
	 * 
	 * Testa o metodo: pedirAjudaPresencial quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro local é uma String invalida (vazia
	 * ou composta de espaços).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialLocalVazio() {
		this.adicionaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "IA", "03:30", "Sexta-Feira", ""));
	}

	/**
	 * Testa o metodo: pedirAjudaOnline quando em uma situação ideal, ou seja quando
	 * existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando os
	 * parametros corretamente.
	 */
	@Test
	public void testPedirAjudaOnline() {
		this.adicionaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaOnline("666", "IA"));
	}

	/**
	 * Testa o metodo: pedirAjudaOnline quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro Matricula é null.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedirAjudaOnlineMatriculaNula() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline(null, "IA");

		assertEquals(2, ajudaC.pedirAjudaOnline("012", ""));
	}

	/**
	 * 
	 * Testa o metodo: pedirAjudaOnline quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro Matricula é uma String invalida
	 * (vazia ou composta de espaços).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineMatriculaVazia() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("", "IA");

		assertEquals(2, ajudaC.pedirAjudaOnline("012", ""));

	}

	/**
	 * Testa o metodo: pedirAjudaOnline quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro Disciplina é null.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedirAjudaOnlineDisciplinaNula() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", null);

		assertEquals(2, ajudaC.pedirAjudaOnline("012", ""));

	}

	/**
	 * 
	 * Testa o metodo: pedirAjudaOnline quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro Disciplina é uma String invalida
	 * (vazia ou composta de espaços).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineDisciplinaVazia() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(2, ajudaC.pedirAjudaOnline("012", ""));
	}

	/**
	 * Testa o metodo: pegarTutor, em uma ajuda presencial quando a situação é
	 * ideal, ou seja quando existem Tutor e Aluno cadastrados, e a captura do tutor
	 * e feita passando os parametros corretamente.
	 */
	@Test
	public void testPegarTutorDeAjudaPresencial() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("666", "IA", "15:00", "Sexta-Feira", "LCC2");

		assertEquals("Tutor - 111, disciplina - IA", ajudaC.pegarTutor(1));

	}

	/**
	 * Testa o metodo: pegarTutor, em uma ajuda presencial quando a situação é
	 * adversa, ou seja quando existem Tutor e Aluno cadastrados, e a captura do
	 * tutor e feita passando os parametros incorretamente - parametro id é um
	 * inteiro menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorDeAjudaPresencialIdAjudaInvalido1() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("666", "IA", "15:00", "Sexta-Feira", "LCC2");

		assertEquals("Tutor - 111, disciplina - IA", ajudaC.pegarTutor(-1));

	}

	/**
	 * Testa o metodo: pegarTutor, em uma ajuda presencial quando a situação é
	 * adversa, ou seja quando existem Tutor e Aluno cadastrados, e a captura do
	 * tutor e feita passando os parametros incorretamente - parametro id é um
	 * inteiro é igual a zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorDeAjudaPresencialIdAjudaInvalido2() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("666", "IA", "15:00", "Sexta-Feira", "LCC2");

		assertEquals("Tutor - 111, disciplina - IA", ajudaC.pegarTutor(0));

	}

	/**
	 * Testa o metodo: pegarTutor, em uma ajuda presencial quando a situação é
	 * adversa, ou seja quando existem Tutor e Aluno cadastrados, e a captura do
	 * tutor e feita passando os parametros incorretamente - parametro id é um
	 * inteiro maior que o numero de pedidos de ajuda até então feitos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorDeAjudaPresencialIdAjudaInvalido3() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("666", "IA", "15:00", "Sexta-Feira", "LCC2");

		assertEquals("Tutor - 111, disciplina - IA", ajudaC.pegarTutor(2));

	}

	/**
	 * Testa o metodo: pegarTutor, em uma ajuda online quando a situação é ideal, ou
	 * seja quando existem Tutor e Aluno cadastrados, e a captura do tutor e feita
	 * passando os parametros corretamente.
	 */
	@Test
	public void testPegarTutorDeAjudaOnline() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor - 111, disciplina - IA", ajudaC.pegarTutor(1));

	}

	/**
	 * Testa o metodo: pegarTutor, em uma ajuda online quando a situação é adversa,
	 * ou seja quando existem Tutor e Aluno cadastrados, e a captura do tutor e
	 * feita passando os parametros incorretamente - parametro id é um inteiro menor
	 * que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorDeAjudaOnlineIdAjudaInvalido1() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor - 111, disciplina - IA", ajudaC.pegarTutor(-1));

	}

	/**
	 * Testa o metodo: pegarTutor, em uma ajuda online quando a situação é adversa,
	 * ou seja quando existem Tutor e Aluno cadastrados, e a captura do tutor e
	 * feita passando os parametros incorretamente - parametro id é um inteiro é
	 * igual a zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorDeAjudaOnlineIdAjudaInvalido2() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor - 111, disciplina - IA", ajudaC.pegarTutor(0));

	}

	/**
	 * Testa o metodo: pegarTutor, em uma ajuda online quando a situação é adversa,
	 * ou seja quando existem Tutor e Aluno cadastrados, e a captura do tutor e
	 * feita passando os parametros incorretamente - parametro id é um inteiro maior
	 * que o numero de pedidos de ajuda até então feitos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorDeAjudaOnlineIdAjudaInvalido3() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor - 111, disciplina - IA", ajudaC.pegarTutor(999));
	}

	/**
	 * Testa o metodo: getInfoAjuda, em uma ajuda presencial quando a situação é
	 * ideal, ou seja quando existem Tutor e Aluno cadastrados, e a captura da
	 * informação sobre a ajuda e feita passando os parametros corretamente.
	 */
	@Test
	public void testGetInfoAjudaPresencial() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("012", "IA", "05:00", "Sexta-Feira", "LCC2");

		assertEquals("IA", ajudaC.getInfoAjuda(1, "Disciplina"));

		assertEquals("111", ajudaC.getInfoAjuda(1, "Matr_Tutor"));

		assertEquals("012", ajudaC.getInfoAjuda(1, "Matr_Aluno"));

		assertEquals("LCC2", ajudaC.getInfoAjuda(1, "LocalInteresse"));

		assertEquals("05:00", ajudaC.getInfoAjuda(1, "Horario"));

		assertEquals("Sexta-Feira", ajudaC.getInfoAjuda(1, "Dia"));
	}

	/**
	 * Testa o metodo: getInfoAjuda, em uma ajuda presencial quando a situação é
	 * adversa, ou seja quando existem Tutor e Aluno cadastrados, porém captura da
	 * informação sobre a ajuda e feita passando os parametros incorretamente -
	 * parametro "atributo" é uma String invalida (vazia ou composta apenas de
	 * espaços).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialAtributoVazio() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("012", "IA", "05:00", "Sexta-Feira", "LCC2");

		assertEquals("IA", ajudaC.getInfoAjuda(1, ""));
	}

	/**
	 * Testa o metodo: getInfoAjuda, em uma ajuda presencial quando a situação é
	 * adversa, ou seja quando existem Tutor e Aluno cadastrados, porém a captura da
	 * informação sobre a ajuda e feita passando os parametros incorretamente -
	 * parametro "id" é menor que zero.
	 */
	@Test(expected = NullPointerException.class)
	public void testGetInfoAjudaPresencialAtributoNulo() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("012", "IA", "05:00", "Sexta-Feira", "LCC2");

		assertEquals("IA", ajudaC.getInfoAjuda(1, null));
	}

	/**
	 * Testa o metodo: getInfoAjuda, em uma ajuda presencial quando a situação é
	 * adversa, ou seja quando existem Tutor e Aluno cadastrados, captura da
	 * informação sobre a ajuda e feita passando os parametros incorretamente -
	 * parametro "atributo" é diferente de "Disciplina, Matr_aluno, Mart_tutor,
	 * LocalInteresse, Hohario, ou Dia".
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialAtributoNaoExiste() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("012", "IA", "05:00", "Sexta-Feira", "LCC2");

		assertEquals("IA", ajudaC.getInfoAjuda(1, "Idade"));
	}

	/**
	 * Testa o metodo: getInfoAjuda, em uma ajuda presencial quando a situação é
	 * adversa, ou seja quando existem Tutor e Aluno cadastrados, porém a captura da
	 * informação sobre a ajuda feita passando os parametros incorretamente -
	 * parametro "id" é menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialIdNegativo() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("012", "IA", "05:00", "Sexta-Feira", "LCC2");

		assertEquals("IA", ajudaC.getInfoAjuda(-1, "Matr_Aluno"));
	}

	/**
	 * Testa o metodo: getInfoAjuda, em uma ajuda presencial quando a situação é
	 * adversa, ou seja quando existem Tutor e Aluno cadastrados, porém a captura da
	 * informação sobre a ajuda e feita passando os parametros incorretamente -
	 * parametro "id" é zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialIdZero() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("012", "IA", "05:00", "Sexta-Feira", "LCC2");

		assertEquals("IA", ajudaC.getInfoAjuda(0, "Matr_Aluno"));
	}

	/**
	 * Testa o metodo: getInfoAjuda, em uma ajuda presencial quando a situação é
	 * adversa, ou seja quando existem Tutor e Aluno cadastrados, porém a captura da
	 * informação sobre a ajuda e feita passando os parametros incorretamente -
	 * parametro "id" é é maior que o numero de Ajudas.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialIdNaoExistente() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("012", "IA", "05:00", "Sexta-Feira", "LCC2");

		assertEquals("IA", ajudaC.getInfoAjuda(2, "Matr_Aluno"));
	}

	/**
	 * Testa o metodo: getInfoAjuda, em uma ajuda online quando a situação é ideal,
	 * ou seja quando existem Tutor e Aluno cadastrados, e a captura da informação
	 * sobre a ajuda e feita passando os parametros corretamente.
	 */
	@Test
	public void testGetInfoAjudaOnline() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("IA", ajudaC.getInfoAjuda(1, "Disciplina"));

		assertEquals("111", ajudaC.getInfoAjuda(1, "Matr_Tutor"));

		assertEquals("012", ajudaC.getInfoAjuda(1, "Matr_Aluno"));
	}

	/**
	 * Testa o metodo: getInfoAjuda, em uma ajuda online quando a situação é
	 * adversa, ou seja quando existem Tutor e Aluno cadastrados, porém a captura da
	 * informação sobre a ajuda e feita passando os parametros incorretamente -
	 * parametro "Atributo" é uma String invalida (vazia ou composta apenas de
	 * espaços).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineAtributoVazio() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("IA", ajudaC.getInfoAjuda(1, ""));
	}

	/**
	 * Testa o metodo: getInfoAjuda, em uma ajuda online quando a situação é
	 * adversa, ou seja quando existem Tutor e Aluno cadastrados, porém a captura do
	 * tutor e feita passando os parametros incorretamente - parametro "atributo" é
	 * um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testGetInfoAjudaOnlineAtributoNulo() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("IA", ajudaC.getInfoAjuda(1, null));
	}

	/**
	 * Testa o metodo: getInfoAjuda, em uma ajuda online quando a situação é
	 * adversa, ou seja quando existem Tutor e Aluno cadastrados, captura da
	 * informação sobre a ajuda e feita passando os parametros incorretamente -
	 * parametro "atributo" é diferente de "Disciplina, Matr_aluno, Mart_tutor".
	 */
	@Test(expected = NullPointerException.class)
	public void testGetInfoAjudaOnlineAtributoNaoExiste() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("IA", ajudaC.getInfoAjuda(1, "Peso_Materia"));
	}

	/**
	 * Testa o metodo: getInfoAjuda, em uma ajuda online quando a situação é
	 * adversa, ou seja quando existem Tutor e Aluno cadastrados, porém a captura da
	 * informação sobre a ajuda feita passando os parametros incorretamente -
	 * parametro "id" é menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineIdNegativo() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("IA", ajudaC.getInfoAjuda(-1, "Matr_Aluno"));
	}

	/**
	 * Testa o metodo: getInfoAjuda, em uma ajuda online quando a situação é
	 * adversa, ou seja quando existem Tutor e Aluno cadastrados, porém a captura da
	 * informação sobre a ajuda e feita passando os parametros incorretamente -
	 * parametro "id" é zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineIdZero() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("IA", ajudaC.getInfoAjuda(0, "Matr_Aluno"));
	}

	/**
	 * Testa o metodo: getInfoAjuda, em uma ajuda online quando a situação é
	 * adversa, ou seja quando existem Tutor e Aluno cadastrados, porém a captura da
	 * informação sobre a ajuda e feita passando os parametros incorretamente -
	 * parametro "id" é é maior que o numero de Ajudas.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineIdNaoExistente() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("IA", ajudaC.getInfoAjuda(2, "Matr_Aluno"));

	}

	/**
	 * Teste demonstra como ocorre o funcionamento do metodo avaliarTutor, demonstra
	 * em seu PRIMEIRO assert um tutor recem criado em que recebe nota de avalição
	 * "Tutor" por ter uma maior que três e menor ou igual a quatro. No SEGUNDO
	 * assert indica que se um tutor for avaliado negativamente de forma que sua
	 * avalição passe a ser menor ou igual a 3.0 ele passará a ser classificado como
	 * "Aprendiz". No TERCEIRO assert verifica-se que o quando o tutor recebe
	 * avaliações de forma com que sua media passe as ser maior que 4.5
	 */
	@Test
	public void testAvaliarTutor() {

		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		/*
		 * Mostra que se a avaliação do tutor for neutra isto é que não faça com que a
		 * avaliação do tutor ultrapasse 4.5 o que ela seja menor ou igual a 3.0, o
		 * Tutor será avaliado como "Tutor"
		 */
		assertEquals("Tutor", ajudaC.avaliarTutor(1, 3));

		/*
		 * Em um dado cenario Caso um Tutor, caso seja avaliado "negativamente" ou seja
		 * sua avaliação seja baixa o suficiente para diminuir o estado de "notaTutor"
		 * para menor ou igual a três. o Tutor passará então a ter o nivel de
		 * "Aprendiz".
		 */
		ajudaC.avaliarTutor(1, 0);

		assertEquals("Aprendiz", ajudaC.avaliarTutor(1, 0));

		/*
		 * Em um dado cenario Caso um Tutor, caso seja avaliado "positivamente" ou seja
		 * sua avaliação seja de forma que altere "notaTutor" para maior que quatro e
		 * meio. o Tutor passará então a ter o nivel de "Top".
		 */
		ajudaC.avaliarTutor(1, 5);
		ajudaC.avaliarTutor(1, 5);
		ajudaC.avaliarTutor(1, 5);
		ajudaC.avaliarTutor(1, 5);
		ajudaC.avaliarTutor(1, 5);
		ajudaC.avaliarTutor(1, 5);
		ajudaC.avaliarTutor(1, 5);
		ajudaC.avaliarTutor(1, 5);

		assertEquals("TOP", ajudaC.avaliarTutor(1, 5));
	}

	/**
	 * Teste mostra o funcionameneto do metodo avaliarTutor quando a nota passada é
	 * menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorNotaInvalida() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor", ajudaC.avaliarTutor(1, -1));
	}

	/**
	 * Teste mostra o funcionamento do metodo avaliarTutor quando a nota passada é
	 * maior que a maior nota isto é maior que quatro.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorNotaInvalida2() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor", ajudaC.avaliarTutor(1, 6));
	}

	/**
	 * Teste mostra o funcionamento do metodo avaliarTutor quando o id da Ajuda é
	 * menor que 0.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarIdAjudaInvalido() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor", ajudaC.avaliarTutor(-1, 2));
	}

	/**
	 * Teste mostra o funcionamento do metodo avaliarTutor quando o id da Ajuda é 0.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarIdAjudaInvalido2() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor", ajudaC.avaliarTutor(0, 3));
	}

	/**
	 * Teste mostra o funcionamento do metodo avaliarTutor quando o id da Ajuda é
	 * diferente do id de qualquer ajuda até então pedida.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarIdAjudaInvalido3() {
		this.adicionaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.adicionaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.adicionaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor", ajudaC.avaliarTutor(2, 3));
	}

}

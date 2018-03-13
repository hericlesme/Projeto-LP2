package UnityTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.controllers.AjudaController;
import br.edu.ufcg.controllers.AlunoController;
import br.edu.ufcg.controllers.TutorController;
import br.edu.ufcg.util.Dados;

/**
 * Classe de teste de Ajuda.
 * 
 * Projeto Laboratório de Programação II
 * 
 */
public class AjudaControllerTest {

	AjudaController ajudaC, outroAjudaC;
	TutorController tutorC;
	AlunoController alunoC;
	Dados dados;

	/**
	 * Inicializa o objeto AjudaControle, passando dados (outro objeto).
	 */
	@Before
	public void inicializaCondicoesDeTestes() {
		dados = new Dados();
		ajudaC = new AjudaController(dados);
		alunoC = new AlunoController(dados);
		tutorC = new TutorController(dados);
		alunoC.cadastrarAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo");
		alunoC.cadastrarAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu");
		tutorC.tornarTutor("111", "IA", 3);
		tutorC.cadastrarHorario("Irineu@vocenaosabeenem.eu", "15:00", "Sexta-Feira");
		tutorC.cadastrarLocalDeAtendimento("Irineu@vocenaosabeenem.eu", "LCC2");
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
		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "IA", "15:00", "Sexta-Feira", "LCC2"));
	}

	/**
	 * Testa o metodo: pedirAjudaPresencial quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro matricula é null.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedirAjudaPresencialMatriculaNula() {
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
		assertEquals(1, ajudaC.pedirAjudaPresencial("", "IA", "15:00", "Sexta-Feira", "LCC2"));
	}

	/**
	 * Testa o metodo: pedirAjudaPresencial quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro Disciplina é null.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedirAjudaPresencialDisciplinaNula() {
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
		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "", "15:00", "Sexta-Feira", "LCC2"));
	}

	/**
	 * Testa o metodo: pedirAjudaPresencial quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro horario é null.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedirAjudaPresencialHorarioNulo() {
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
		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "IA", "", "Sexta-Feira", "LCC2"));
	}

	/**
	 * Testa o metodo: pedirAjudaPresencial quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro dia é null.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedirAjudaPresencialDiaNulo() {

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

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "IA", "03:30", "", "LCC2"));
	}

	/**
	 * Testa o metodo: pedirAjudaPresencial quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro local é null.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedirAjudaPresencialLocalNulo() {

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

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "IA", "03:30", "Sexta-Feira", ""));
	}

	/**
	 * Testa o metodo: pedirAjudaOnline quando em uma situação ideal, ou seja quando
	 * existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando os
	 * parametros corretamente.
	 */
	@Test
	public void testPedirAjudaOnline() {

		assertEquals(1, ajudaC.pedirAjudaOnline("666", "IA"));
	}

	/**
	 * Testa o metodo: pedirAjudaOnline quando em uma situação adversa, gerada
	 * quando existem Tutor e Aluno cadastrados, e o pedido da ajuda ocorre passando
	 * os parametros incorretamente - parametro Matricula é null.
	 */
	@Test(expected = NullPointerException.class)
	public void testPedirAjudaOnlineMatriculaNula() {

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

		assertEquals(2, ajudaC.pedirAjudaOnline("012", ""));
	}

	/**
	 * Testa o metodo: pegarTutor, em uma ajuda presencial quando a situação é
	 * ideal, ou seja quando existem Tutor e Aluno cadastrados, e a captura do tutor
	 * e feita passando os parametros corretamente.
	 */
	@Test
	public void testPegarTutorDeAjudaPresencial() {
		ajudaC.pedirAjudaOnline("111", "IA");

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

		ajudaC.pedirAjudaPresencial("666", "IA", "15:00", "Sexta-Feira", "LCC2");
		ajudaC.pegarTutor(-1);

	}

	/**
	 * Testa o metodo: pegarTutor, em uma ajuda presencial quando a situação é
	 * adversa, ou seja quando existem Tutor e Aluno cadastrados, e a captura do
	 * tutor e feita passando os parametros incorretamente - parametro id é um
	 * inteiro é igual a zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorDeAjudaPresencialIdAjudaInvalido2() {

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

		ajudaC.pedirAjudaPresencial("666", "IA", "15:00", "Sexta-Feira", "LCC2");

		assertEquals("IA", ajudaC.getInfoAjuda(1, "Disciplina"));

		assertEquals("111", ajudaC.getInfoAjuda(1, "Matr_Tutor"));

		assertEquals("666", ajudaC.getInfoAjuda(1, "Matr_Aluno"));

		assertEquals("LCC2", ajudaC.getInfoAjuda(1, "LocalInteresse"));

		assertEquals("15:00", ajudaC.getInfoAjuda(1, "Horario"));

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

		ajudaC.pedirAjudaPresencial("666", "IA", "15:00", "Sexta-Feira", "LCC2");

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

		ajudaC.pedirAjudaPresencial("666", "IA", "15:00", "Sexta-Feira", "LCC2");

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

		ajudaC.pedirAjudaPresencial("666", "IA", "15:00", "Sexta-Feira", "LCC2");

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

		ajudaC.pedirAjudaPresencial("666", "IA", "15:00", "Sexta-Feira", "LCC2");

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

		ajudaC.pedirAjudaPresencial("666", "IA", "15:00", "Sexta-Feira", "LCC2");

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

		ajudaC.pedirAjudaPresencial("666", "IA", "15:00", "Sexta-Feira", "LCC2");

		assertEquals("IA", ajudaC.getInfoAjuda(2, "Matr_Aluno"));
	}

	/**
	 * Testa o metodo: getInfoAjuda, em uma ajuda online quando a situação é ideal,
	 * ou seja quando existem Tutor e Aluno cadastrados, e a captura da informação
	 * sobre a ajuda e feita passando os parametros corretamente.
	 */
	@Test
	public void testGetInfoAjudaOnline() {

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

		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("IA", ajudaC.getInfoAjuda(1, null));
	}

	/**
	 * Testa o metodo: getInfoAjuda, em uma ajuda online quando a situação é
	 * adversa, ou seja quando existem Tutor e Aluno cadastrados, captura da
	 * informação sobre a ajuda e feita passando os parametros incorretamente -
	 * parametro "atributo" é diferente de "Disciplina, Matr_aluno, Mart_tutor".
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineAtributoNaoExiste() {

		ajudaC.pedirAjudaOnline("666", "IA");

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

		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("IA", ajudaC.getInfoAjuda(2, "Matr_Aluno"));

	}

	/**
	 * Teste demonstra como ocorre o funcionamento do metodo avaliarTutor,
	 * considerando um tutor com nivel "Tutor".
	 */
	@Test
	public void testAvaliarTutorTutor() {
		ajudaC.pedirAjudaOnline("012", "IA");
		assertEquals("Tutor", ajudaC.avaliarTutor(1, 4));

	}

	/**
	 * Teste demonstra como ocorre o funcionamento do metodo avaliarTutor,
	 * considerando um tutor com nivel "Aprendiz".
	 */
	@Test
	public void testAvaliarTutorAprendiz() {
		ajudaC.pedirAjudaOnline("012", "IA");
		ajudaC.pedirAjudaOnline("012", "IA");
		ajudaC.avaliarTutor(1, 0);
		assertEquals("Aprendiz", ajudaC.avaliarTutor(2, 0));

	}

	/**
	 * Teste demonstra como ocorre o funcionamento do metodo avaliarTutor,
	 * considerando um tutor com nivel "TOP".
	 */
	@Test
	public void testAvaliarTutorTOP() {
		ajudaC.pedirAjudaOnline("012", "IA");
		ajudaC.pedirAjudaOnline("012", "IA");
		ajudaC.pedirAjudaOnline("012", "IA");
		ajudaC.pedirAjudaOnline("012", "IA");
		ajudaC.avaliarTutor(1, 5);
		ajudaC.avaliarTutor(2, 5);
		ajudaC.avaliarTutor(3, 5);
		assertEquals("TOP", ajudaC.avaliarTutor(4, 5));

	}

	/**
	 * Teste mostra o funcionameneto do metodo avaliarTutor quando a nota passada é
	 * menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorNotaInvalida() {

		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor", ajudaC.avaliarTutor(1, -1));
	}

	/**
	 * Teste mostra o funcionamento do metodo avaliarTutor quando a nota passada é
	 * maior que a maior nota isto é maior que quatro.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorNotaInvalida2() {

		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor", ajudaC.avaliarTutor(1, 6));
	}

	/**
	 * Teste mostra o funcionamento do metodo avaliarTutor quando o id da Ajuda é
	 * menor que 0.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarIdAjudaInvalido() {

		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor", ajudaC.avaliarTutor(-1, 2));
	}

	/**
	 * Teste mostra o funcionamento do metodo avaliarTutor quando o id da Ajuda é 0.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarIdAjudaInvalido2() {

		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor", ajudaC.avaliarTutor(0, 3));
	}

	/**
	 * Teste mostra o funcionamento do metodo avaliarTutor quando o id da Ajuda é
	 * diferente do id de qualquer ajuda até então pedida.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarIdAjudaInvalido3() {

		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor", ajudaC.avaliarTutor(2, 3));
	}

}

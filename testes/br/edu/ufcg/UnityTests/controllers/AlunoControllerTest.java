package br.edu.ufcg.UnityTests.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.controllers.AlunoController;
import br.edu.ufcg.controllers.Dados;

/**
 * Classe de teste de Aluno Controller.
 * 
 * Projeto Laboratório de Programação II
 * 
 * @author HERICLES NÂO SEI A PORRA DO TEU NOME
 * @author Rafael da Silva Pereira.
 */
public class AlunoControllerTest {

	private Dados dados = new Dados();
	private AlunoController alunoC, outroAlunoC;

	@Before
	public void inicializaAlunoController() {
		alunoC = new AlunoController(dados);
	}

	@Test
	public void testAlunoController() {
		assertTrue(outroAlunoC == null);
		outroAlunoC = new AlunoController(new Dados());
		assertFalse(outroAlunoC == null);

	}

	/**
	 * Cria um aluno, e o cadastra no sistema. - Teste verifica se a criação é dada com
	 * sucesso através do metodo "recuperaAluno".
	 */
	@Test
	public void testCadastrarAluno() {
		alunoC.cadastrarAluno("faela <3", "123451234", 54321, "40028922", "faela@rafa.pocutom");
		assertEquals("123451234 - faela <3 - 54321 - 40028922 - faela@rafa.pocutom",
				alunoC.recuperaAluno("123451234"));
	}

	/**
	 * Teste Mostra o uso correto metodo "recuperaAluno" quando o aluno cadastrado possui
	 * um numero de telefone.
	 */
	@Test
	public void testRecuperaAlunoComTelefone() {
		alunoC.cadastrarAluno("Fulano", "123", 1456, "88621845", "fulanim@umdois.tres");
		assertEquals("123 - Fulano - 1456 - 88621845 - fulanim@umdois.tres", alunoC.recuperaAluno("123"));
	}

	/**
	 * Teste Mostra o funcionamento do metodo "recuperaAluno" quando o aluno cadastrado
	 * não possui um numero de telefone.
	 */
	@Test
	public void testRecuperaAlunoSemTelefone() {
		alunoC.cadastrarAluno("Beltrano", "124", 1456, "", "beltranin@umdois.tres");
		assertEquals("124 - Beltrano - 1456 - beltranin@umdois.tres", alunoC.recuperaAluno("124"));
	}

	/**
	 * Teste Mostra o funcionamento do metodo "listarAlunos" quando não há alunos.
	 */
	@Test
	public void testListarAlunosSemAlunos() {
		assertEquals("", alunoC.listarAlunos());
	}

	/**
	 * Teste Mostra o funcionamento do metodo "listarAlunos" quando há alunos um ou mais
	 * alunos.
	 */
	@Test
	public void testListarAlunos() {
		alunoC.cadastrarAluno("hulk", "1", 12, "", "hulk@avenger.com");
		assertEquals("1 - hulk - 12 - hulk@avenger.com", alunoC.listarAlunos());

		alunoC.cadastrarAluno("stark", "2", 12, "40028922", "stark@avenger.com");
		assertEquals("1 - hulk - 12 - hulk@avenger.com, 2 - stark - 12 - 40028922 - stark@avenger.com",
				alunoC.listarAlunos());
	}

	/**
	 * Testa o método getInfo com nota por parâmetro.
	 */
	@Test
	public void testGetInfoAlunoNota() {
		alunoC.cadastrarAluno("Fulano", "123", 1456, "88621845", "fulanim@umdois.tres");
		assertEquals("5", alunoC.getInfoAluno("123", "nota_avaliacao"));
	}

	/**
	 * Testa o método getInfo com matrícula por parâmetro.
	 */
	@Test
	public void testGetInfoAlunoMatricula() {
		alunoC.cadastrarAluno("Fulano", "123", 1456, "88621845", "fulanim@umdois.tres");
		assertEquals("123", alunoC.getInfoAluno("123", "matricula"));
	}

	/**
	 * Testa o método getInfo com telefone por parâmetro.
	 */
	@Test
	public void testGetInfoAlunoTelefone() {
		alunoC.cadastrarAluno("Fulano", "123", 1456, "88621845", "fulanim@umdois.tres");
		assertEquals("88621845", alunoC.getInfoAluno("123", "telefone"));

	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta recuperarAluno
	 * passando uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRecuperaAlunoVazio() {
		alunoC.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		alunoC.recuperaAluno("");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta recuperarAluno
	 * passando um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testRecuperaAlunoNulo() {
		alunoC.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		alunoC.recuperaAluno(null);
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta usar o metodo
	 * getInfo passando o parametro matricula igual a uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGeInfoAlunoMatriculaVazia() {
		alunoC.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		alunoC.getInfoAluno("", "matricula");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta usar o metodo
	 * getInfo passando o parametro matricula igual a um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testGetInfoAlunoMatriculaNula() {
		alunoC.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		alunoC.getInfoAluno(null, "matricula");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta usar o metodo
	 * getInfo passando o parametro atributo igual a uma string vazia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAlunoAtributoVazio() {
		alunoC.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		alunoC.getInfoAluno("2121", "");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta usar o metodo
	 * getInfo passando o parametro atributo igual a um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testGetInfoAlunoAtributoNulo() {
		alunoC.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		alunoC.getInfoAluno("2121", null);
	}

	/**
	 * Testa o método getInfo com código do Curso por parâmetro.
	 */
	@Test
	public void testGetInfoAlunoCodigoCurso() {
		alunoC.cadastrarAluno("Fulano", "123", 1456, "88621845", "fulanim@umdois.tres");
		assertEquals("1456", alunoC.getInfoAluno("123", "codigo_curso"));
	}

	/**
	 * Testa o método getInfo com nome por parâmetro.
	 */
	@Test
	public void testGetInfoAlunoNome() {
		alunoC.cadastrarAluno("Fulano", "123", 1456, "88621845", "fulanim@umdois.tres");
		assertEquals("Fulano", alunoC.getInfoAluno("123", "nome"));
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta capturar
	 * informações de um aluno não cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAlunoInexistente() {
		alunoC.getInfoAluno("2121", "matricula");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta capturar
	 * informações de um aluno com informações compostas por um string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoInexistente() {
		alunoC.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		alunoC.getInfoAluno("2121", "altura");
	}

	/**
	 * Testa getInfo com atributo vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoVazia() {
		alunoC.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		alunoC.getInfoAluno("2121", "");
	}

	/**
	 * Testa getInfo com atributo nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testGetInfoNula() {
		alunoC.cadastrarAluno("fulanin", "2121", 2131, "", "HAHA@OTAKU.COM");
		alunoC.getInfoAluno("2121", null);
	}

	/**
	 * Teste verifica {@link NullPointerException} quando é passado para criação de um
	 * aluno o parametro nome: como um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraAlunoNomeNulo() {
		alunoC.cadastrarAluno(null, "16516", 1645, "", "huasi@sijjk.com");
	}

	/**
	 * Teste verifica {@link NullPointerException} quando é passado para criação de um
	 * aluno o parametro matricula: como um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraAlunoMatriculaNula() {
		alunoC.cadastrarAluno("Issue", null, 1645, "", "huasi@sijjk.com");
	}

	/**
	 * Teste verifica {@link NullPointerException} quando é passado para criação de um
	 * aluno o parametro telefone: como um null.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraAlunoTelefoneNulo() {
		alunoC.cadastrarAluno("Issue", "156165", 1645, null, "huasi@sijjk.com");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando é passado para criação de um
	 * aluno o parametro nome: como uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoNomeVazio() {
		alunoC.cadastrarAluno("   ", "156165", 1645, "", "eae@men.kk");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando é passado para criação de um
	 * aluno o parametro matricula: como uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoMatriculaVazia() {
		alunoC.cadastrarAluno("FruFru", "   ", 1645, "", "fru@fru.kk");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando é passado para criação de um
	 * aluno o parametro email: como uma string vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoEmailVazio() {
		alunoC.cadastrarAluno("FruFru", "1453", 1645, "", "    ");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando é passado para criação de um
	 * aluno o parametro o codigo: com um numero menor ou igual a zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoCodigoCursoInvalido() {
		alunoC.cadastrarAluno("FruFru", "1453", -1, "", "hello@com.br");
	}

	/**
	 * Teste verifica {@link IllegalArgumentException} quando se tenta recuperar um aluno
	 * não cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRecuperaAlunoInexistente() {
		alunoC.recuperaAluno("213212");
	}

}

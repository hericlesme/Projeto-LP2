package br.edu.ufcg.UnityTests.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufcg.controllers.AjudaController;
import br.edu.ufcg.controllers.Dados;
import br.edu.ufcg.entities.Aluno;
import br.edu.ufcg.entities.Tutor;

public class AjudaControllerTest {

	private AjudaController ajudaC, outroAjudaC;
	private Dados dados = new Dados();

	@Before
	public void inicializaAjudaController() {
		ajudaC = new AjudaController(dados);
	}

	private void iniciaAluno(String nome, String matricula, int codigoCurso, String telefone, String email,
			int id) {
		dados.adicionaAluno(matricula, new Aluno(nome, matricula, codigoCurso, telefone, email, id));
	}

	private void iniciaTutor(String email, String disciplina, int proeficiencia, String matricula) {
		dados.adicionaTutor(email, new Tutor(disciplina, proeficiencia, matricula));
	}

	@Test
	public void testAjudaController() {
		assertTrue(outroAjudaC == null);
		outroAjudaC = new AjudaController(new Dados());
		assertFalse(outroAjudaC == null);
	}

	@Test
	public void testPedirAjudaPresencial() {
		this.iniciaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "IA", "15:00", "Sexta-Feira", "LCC2"));
	}

	@Test(expected = NullPointerException.class)
	public void testPedirAjudaPresencialMatriculaNula() {
		this.iniciaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial(null, "IA", "15:00", "Sexta-Feira", "LCC2"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialMatriculaVazia() {
		this.iniciaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("", "IA", "15:00", "Sexta-Feira", "LCC2"));
	}

	@Test(expected = NullPointerException.class)
	public void testPedirAjudaPresencialDisciplinaNula() {
		this.iniciaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", null, "15:00", "Sexta-Feira", "LCC2"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDisciplinaVazia() {
		this.iniciaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "", "15:00", "Sexta-Feira", "LCC2"));
	}

	@Test(expected = NullPointerException.class)
	public void testPedirAjudaPresencialHorarioNulo() {
		this.iniciaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "IA", null, "Sexta-Feira", "LCC2"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialHorarioVazio() {
		this.iniciaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "IA", "", "Sexta-Feira", "LCC2"));
	}

	@Test(expected = NullPointerException.class)
	public void testPedirAjudaPresencialDiaNulo() {
		this.iniciaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "IA", "03:30", null, "LCC2"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDiaVazio() {
		this.iniciaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "IA", "03:30", "", "LCC2"));
	}

	@Test(expected = NullPointerException.class)
	public void testPedirAjudaPresencialLocalNulo() {
		this.iniciaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "IA", "03:30", "Sexta-Feira", null));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialLocalVazio() {
		this.iniciaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaPresencial("666", "IA", "03:30", "Sexta-Feira", ""));
	}

	@Test
	public void testPedirAjudaOnline() {
		this.iniciaAluno("Reaper", "666", 666000666, "666123", "reaper@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(1, ajudaC.pedirAjudaOnline("666", "IA"));
	}

	@Test(expected = NullPointerException.class)
	public void testPedirAjudaOnlineMatriculaNula() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline(null, "IA");

		assertEquals(2, ajudaC.pedirAjudaOnline("012", ""));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineMatriculaVazia() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("", "IA");

		assertEquals(2, ajudaC.pedirAjudaOnline("012", ""));

	}

	@Test(expected = NullPointerException.class)
	public void testPedirAjudaOnlineDisciplinaNula() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", null);

		assertEquals(2, ajudaC.pedirAjudaOnline("012", ""));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineDisciplinaVazia() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");

		assertEquals(2, ajudaC.pedirAjudaOnline("012", ""));
	}

	@Test
	public void testPegarTutorDeAjudaPresencial() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("666", "IA", "15:00", "Sexta-Feira", "LCC2");

		assertEquals("Tutor - 111, disciplina - IA", ajudaC.pegarTutor(1));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorDeAjudaPresencialIdAjudaInvalido1() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("666", "IA", "15:00", "Sexta-Feira", "LCC2");

		assertEquals("Tutor - 111, disciplina - IA", ajudaC.pegarTutor(-1));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorDeAjudaPresencialIdAjudaInvalido2() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("666", "IA", "15:00", "Sexta-Feira", "LCC2");

		assertEquals("Tutor - 111, disciplina - IA", ajudaC.pegarTutor(-1));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorDeAjudaPresencialIdAjudaInvalido3() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("666", "IA", "15:00", "Sexta-Feira", "LCC2");

		assertEquals("Tutor - 111, disciplina - IA", ajudaC.pegarTutor(999));

	}

	@Test
	public void testPegarTutorDeAjudaOnline() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor - 111, disciplina - IA", ajudaC.pegarTutor(1));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorDeAjudaOnlineIdAjudaInvalido1() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor - 111, disciplina - IA", ajudaC.pegarTutor(-1));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorDeAjudaOnlineIdAjudaInvalido2() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor - 111, disciplina - IA", ajudaC.pegarTutor(0));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorDeAjudaOnlineIdAjudaInvalido3() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor - 111, disciplina - IA", ajudaC.pegarTutor(999));
	}

	@Test
	public void testGetInfoAjudaPresencial() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("012", "IA", "05:00", "Sexta-Feira", "LCC2");

		assertEquals("IA", ajudaC.getInfoAjuda(1, "Disciplina"));

		assertEquals("111", ajudaC.getInfoAjuda(1, "Matr_Tutor"));

		assertEquals("012", ajudaC.getInfoAjuda(1, "Matr_Aluno"));

		assertEquals("LCC2", ajudaC.getInfoAjuda(1, "LocalInteresse"));

		assertEquals("05:00", ajudaC.getInfoAjuda(1, "Horario"));

		assertEquals("Sexta-Feira", ajudaC.getInfoAjuda(1, "Dia"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialAtributoVazio() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("012", "IA", "05:00", "Sexta-Feira", "LCC2");

		assertEquals("IA", ajudaC.getInfoAjuda(1, ""));
	}

	@Test(expected = NullPointerException.class)
	public void testGetInfoAjudaPresencialAtributoNulo() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("012", "IA", "05:00", "Sexta-Feira", "LCC2");

		assertEquals("IA", ajudaC.getInfoAjuda(1, null));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialAtributoNaoExiste() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("012", "IA", "05:00", "Sexta-Feira", "LCC2");

		assertEquals("IA", ajudaC.getInfoAjuda(1, "Idade"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialIdNegativo() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("012", "IA", "05:00", "Sexta-Feira", "LCC2");

		assertEquals("IA", ajudaC.getInfoAjuda(-1, "Matr_Aluno"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialIdZero() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("012", "IA", "05:00", "Sexta-Feira", "LCC2");

		assertEquals("IA", ajudaC.getInfoAjuda(0, "Matr_Aluno"));
	}

	@Test(expected = IllegalArgumentException.class) /* Existe mensagem? */
	public void testGetInfoAjudaPresencialIdNaoExistente() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaPresencial("012", "IA", "05:00", "Sexta-Feira", "LCC2");

		assertEquals("IA", ajudaC.getInfoAjuda(2, "Matr_Aluno"));
	}

	@Test
	public void testGetInfoAjudaOnline() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("IA", ajudaC.getInfoAjuda(1, "Disciplina"));

		assertEquals("111", ajudaC.getInfoAjuda(1, "Matr_Tutor"));

		assertEquals("012", ajudaC.getInfoAjuda(1, "Matr_Aluno"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineAtributoVazio() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("IA", ajudaC.getInfoAjuda(1, ""));
	}

	@Test(expected = NullPointerException.class)
	public void testGetInfoAjudaOnlineAtributoNulo() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("IA", ajudaC.getInfoAjuda(1, null));
	}

	@Test(expected = NullPointerException.class)
	public void testGetInfoAjudaOnlineAtributoNaoExiste() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("IA", ajudaC.getInfoAjuda(1, "Peso_Materia"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineIdNegativo() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("IA", ajudaC.getInfoAjuda(-1, "Matr_Aluno"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineIdZero() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("IA", ajudaC.getInfoAjuda(0, "Matr_Aluno"));
	}

	@Test(expected = IllegalArgumentException.class) /* Existe mensagem ? */
	public void testGetInfoAjudaOnlineIdNaoExistente() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("IA", ajudaC.getInfoAjuda(2, "Matr_Aluno"));

	}

	@Test
	public void testAvaliarTutorAprendiz() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		/*
		 * Em um dado cenario Caso um Tutor, caso seja avaliado "negativamente" ou seja
		 * sua avaliação seja baixa o suficiente para diminuir o estado de "notaTutor"
		 * para menor ou igual a três. o Tutor passará então a ter o nivel de
		 * "Aprendiz".
		 */
		ajudaC.avaliarTutor(1, 0);

		assertEquals("Aprendiz", ajudaC.avaliarTutor(1, 0));

	}

	@Test
	public void testAvaliarTutorTutor() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		/*
		 * Em um dado cenario Caso um Tutor, caso seja avaliado "neutramente" ou seja
		 * sua avaliação seja de forma que nao altere "notaTutor" para maior que três ou
		 * menor ou igual que quatro e meio. o Tutor passará então a ter o nivel de
		 * "Tutor".
		 */
		ajudaC.avaliarTutor(1, 3);

		assertEquals("Tutor", ajudaC.avaliarTutor(1, 3));

	}

	@Test
	public void testAvaliarTutorTop() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		/*
		 * Em um dado cenario Caso um Tutor, caso seja avaliado "positivamente" ou seja
		 * sua avaliação seja de forma que altere "notaTutor" para maior que quatro e
		 * meio. o Tutor passará então a ter o nivel de "Top".
		 */
		ajudaC.avaliarTutor(1, 5);
		ajudaC.avaliarTutor(1, 5);
		ajudaC.avaliarTutor(1, 5);

		assertEquals("TOP", ajudaC.avaliarTutor(1, 5));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorNotaInvalida() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor", ajudaC.avaliarTutor(1, -1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorNotaInvalida2() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor", ajudaC.avaliarTutor(1, 6));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarIdAjudaInvalido() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor", ajudaC.avaliarTutor(0, 2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarIdAjudaInvalido2() {
		this.iniciaAluno("Genji", "012", 666000666, "666123", "genji@overatch.ofensivo", 0);
		this.iniciaAluno("Irineu", "111", 000002545, "9856217", "Irineu@vocenaosabeenem.eu", 0);
		this.iniciaTutor("Irineu@vocenaosabeenem.eu", "IA", 3, "111");
		ajudaC.pedirAjudaOnline("012", "IA");

		assertEquals("Tutor", ajudaC.avaliarTutor(0, -1));
	}

}

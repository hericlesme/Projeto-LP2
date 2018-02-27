package br.edu.ufcg.controllers;

import easyaccept.EasyAccept;

/**
 * Classe Facade. Delega os métodos do controller QmaSistema.
 *
 */
public class Facade {
	/**
	 * Inicializa um objeto da classe QmaSistema, controller do sistema Quem Me Ajuda.
	 */
	QmaSistema sys = new QmaSistema();

	/**
	 * Testes EasyAccept.
	 * 
	 * @param args
	 *            array de testes.
	 */
	public static void main(String[] args) {
		args = new String[] { "br.edu.ufcg.controllers.Facade", "EasyAccept//us1_test.txt", "EasyAccept//us2_test.txt",
				"EasyAccept//us3_test.txt" };
		EasyAccept.main(args);
	}

	/**
	 * Chama o método cadastrarAluno de QmaSistema, cadastrando um aluno no sistema.
	 * 
	 * @param nome
	 *            nome do aluno.
	 * @param matricula
	 *            matricula do aluno.
	 * @param codigoCurso
	 *            codigo do curso.
	 * @param telefone
	 *            telefone do aluno.
	 * @param email
	 *            email do aluno.
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		sys.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}

	/**
	 * Chama o método recuperaAluno de QmaSistema, mostrando a representação do
	 * aluno a partir de sua matrícula.
	 * 
	 * @param matricula
	 *            matrícula do aluno a ser mostrado.
	 * @return uma String.
	 */
	public String recuperaAluno(String matricula) {
		return sys.recuperaAluno(matricula);
	}

	/**
	 * Chama o método listarAlunos de QmaSistema, mostrando todos os alunos
	 * cadastrados.
	 * 
	 * @return uma String.
	 */
	public String listarAlunos() {
		return sys.listarAlunos();
	}

	/**
	 * Chama o método getInfoAluno de QmaSistema, mostrando o atributo passado como
	 * parâmetro do aluno.
	 * 
	 * @param matricula
	 *            a matrícula do aluno.
	 * @param atributo
	 *            informação a ser recuperada.
	 * @return uma String.
	 */
	public String getInfoAluno(String matricula, String atributo) {
		return sys.getInfoAluno(matricula, atributo);
	}

	/**
	 * Chama o método tornarTutor de QmaSistema, tornando um Aluno cadastrado um
	 * Tutor.
	 * 
	 * @param matricula
	 *            matrícula do aluno.
	 * @param disciplina
	 *            disciplina que pode ensinar.
	 * @param proficiencia
	 *            proficiência na disciplina.
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		sys.tornarTutor(matricula, disciplina, proficiencia);
	}

	/**
	 * Chama o método recuperaTutor de QmaSistema, mostrando a representação do
	 * Aluno tutor.
	 * 
	 * @param matricula
	 *            matrícula do Aluno a ser mostrado.
	 * @return uma String.
	 */
	public String recuperaTutor(String matricula) {
		return sys.recuperaTutor(matricula);
	}

	/**
	 * Chama o método listarTutores de QmaSistema, mostrando todos os Alunos que são
	 * tutores.
	 * 
	 * @return uma String.
	 */
	public String listarTutores() {
		return sys.listarTutores();
	}

	/**
	 * Chama o método cadastrarHorario de QmaSistema, cadastrando um horário de
	 * atendimento para o tutor.
	 * 
	 * @param email
	 *            email do tutor.
	 * @param horario
	 *            horário a ser cadastrado.
	 * @param dia
	 *            dia referente ao horário.
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		sys.cadastrarHorario(email, horario, dia);
	}

	/**
	 * Chama o método cadastrarLocalDeAtendimento de QmaSistema, cadastrando um
	 * local disponível para atendimento do tutor.
	 * 
	 * @param email
	 *            email do tutor.
	 * @param local
	 *            local a ser cadastrado.
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		sys.cadastrarLocalDeAtendimento(email, local);
	}

	/**
	 * Chama o método consultaHorario de QmaSistema, consultando se o tutor tem
	 * determinado horário disponível para atendimento.
	 * 
	 * @param email
	 *            email do tutor
	 * @param horario
	 *            horário a ser consultado.
	 * @param dia
	 *            dia a ser consultado.
	 * @return um boolean.
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		return sys.consultaHorario(email, horario, dia);
	}

	/**
	 * Chama o método consultaLocal de QmaSistema, consultando se o tutor tem
	 * determinado local disponível para atendimento.
	 * 
	 * @param email
	 *            email do tutor.
	 * @param local
	 *            local a ser consultado.
	 * @return um boolean.
	 */
	public boolean consultaLocal(String email, String local) {
		return sys.consultaLocal(email, local);
	}

}

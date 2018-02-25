package br.edu.ufcg.entities;

/**
 * Representação de um aluno no sistema. Todo aluno possui uma nota de
 * avaliação, uma matrícula que o identifica, o codigo do seu curso, email, nome
 * e opcionalmente um telefone. Um aluno pode ter como função ser tutor ou
 * tutelado.
 * 
 * Projeto de Laboratório - Programação II.
 *
 */
public class Aluno implements Comparable<Aluno> {

	private int notaAvaliacao;
	private String matricula;
	private String telefone;
	private int codigoCurso;
	private Funcao funcao;
	private String email;
	private String nome;

	/**
	 * Constrói um aluno inicializando seus atributos. A nota de avaliação por
	 * padrão começa em 5, assim como sua função; tutelado. Uma String vazia é dada
	 * quando o telefone não é passado.
	 * 
	 * @param nome
	 *            nome do aluno.
	 * @param matricula
	 *            matrícula do aluno.
	 * @param codigoCurso
	 *            codigo do curso.
	 * @param telefone
	 *            telefone do aluno.
	 * @param email
	 *            email do aluno.
	 */
	public Aluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.notaAvaliacao = 5;
		this.matricula = matricula;
		this.telefone = telefone;
		this.codigoCurso = codigoCurso;
		this.email = email;
		this.nome = nome;
		this.funcao = new Tutelado();
	}

	/**
	 * Retorna uma String com algumas informações do Aluno. Com telefone, caso tenha
	 * sido passado, ou sem. Segue o formato: 
	 * 1. "Matricula - Nome - Código do Curso - Email" 
	 * 2. "Matricula - Nome - Código do Curso - Telefone - Email"
	 * 
	 * @return uma String.
	 */
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + toStringComplemento();
	}

	/**
	 * Método utilizado para decidir qual vai ser o complemento do toString, tendo
	 * telefone ou não.
	 * 
	 * @return uma String.
	 */
	private String toStringComplemento() {
		if (telefone.trim().isEmpty()) {
			return this.email;
		}
		return this.telefone + " - " + this.email;
	}

	/**
	 * Retorna uma String com uma informação do aluno. Lança uma exceção caso seja
	 * um atributo não existente.
	 * 
	 * @param atributo
	 *            informação a ser mostrada.
	 * @return uma String.
	 */
	public String getInfoAluno(String atributo) {
		switch (atributo.toLowerCase()) {

		case "notavaliacao":
			return Integer.toString(this.notaAvaliacao);

		case "matricula":
			return this.matricula;

		case "telefone":
			return this.telefone;

		case "codigocurso":
			return Integer.toString(this.codigoCurso);

		case "email":
			return this.email;

		case "nome":
			return this.nome;

		default:
			throw new IllegalArgumentException("Atributo invalido");
		}
	}

	/**
	 * Compara o próprio objeto com outro da classe Aluno, de acordo com o nome.
	 * 
	 * @return um int.
	 */
	@Override
	public int compareTo(Aluno a) {
		return this.nome.compareTo(a.getNome());

	}

	/**
	 * Retorna o nome do Aluno.
	 * 
	 * @return uma String.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Retorna o email do Aluno.
	 * 
	 * @return uma String.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Torna um aluno tutor. Muda o seu atributo funcão de Tutelado para Tutor,
	 * possibilitando o uso de alguns métodos.
	 * 
	 * @param disciplina
	 *            disciplina que pode ensinar.
	 * @param proficiencia
	 *            proficiência na disciplina.
	 */
	public void tornarTutor(String disciplina, int proficiencia) {
		this.funcao = new Tutor(disciplina, proficiencia);
	}

	/**
	 * Cadastra um horário e dia que o Tutor esteja disponível para ajudar
	 * 
	 * @param horario
	 *            horário disponível.
	 * @param dia
	 *            dia disponível.
	 */
	public void cadastrarHorario(String horario, String dia) {
		this.funcao.cadastrarHorario(horario, dia);
	}

	/**
	 * Cadastra um local que o Tutor esteja disponível para atendimento.
	 * 
	 * @param local
	 *            local disponível.
	 */
	public void cadastrarLocalDeAtendimento(String local) {
		this.funcao.cadastrarLocalDeAtendimento(local);
	}

	/**
	 * Retorna um boolean indicando se o tutor está disponível em determinado
	 * horário. Disponível: true. Ocupado: false.
	 * 
	 * @param horario
	 *            horário a ser consultado.
	 * @param dia
	 *            dia a ser consultado.
	 * @return um boolean.
	 */
	public boolean consultaHorario(String horario, String dia) {
		return this.funcao.consultaHorario(horario, dia);
	}

	/**
	 * Retorna um boolean indicando se o tutor está disponível em determinado local
	 * para atendimento.
	 * 
	 * @param local
	 *            local a ser consultado.
	 * @return um boolean.
	 */
	public boolean consultaLocal(String local) {
		return this.funcao.consultaLocal(local);
	}

	/**
	 * Retorna um int que representa o hashCode do objeto Aluno.
	 * 
	 * @return um int.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Retorna um boolean que diz se esse objeto é igual a outro. Caso seja igual,
	 * retorna true, caso não, false. Leva em consideração a matrícula do aluno.
	 * 
	 * @return um boolean.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

}

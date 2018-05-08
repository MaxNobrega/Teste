package exercicio02cap2;

public class Medico {
	
	//Atributos
	
	private String crm;
	private String nome;
	private String especialidade;
	
	//Construtores
	
	public Medico(String crm, String nome, String especialidade) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.especialidade = especialidade;
	}

	public Medico() {
		super();
	}

	//Getters and Setters
	
	public String getCrm() {
		return crm;
	}

	public String getNome() {
		return nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	//toString
	public String toString() {
		return "Medico [crm=" + crm + ", nome=" + nome + ", especialidade=" + especialidade + "]";
	}

	//Metodos
	

}

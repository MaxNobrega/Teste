package exercicio02cap2;

import java.time.LocalDate;

public class Paciente {
	
	//Atibutos
	
	private String documento;
	private String nome;
	private String sexo;
	private Endereco endereco;
	private LocalDate datanascimento;
	
	//Construtores
	
	public Paciente(String documento, String nome, String sexo, Endereco endereco, LocalDate datanascimento) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.sexo = sexo;
		this.endereco = endereco;
		this.datanascimento = datanascimento;
	}

	public Paciente() {
		super();
	}

	//Getters and Setters
	
	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public String getSexo() {
		return sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public LocalDate getDatanascimento() {
		return datanascimento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setDatanascimento(LocalDate datanascimento) {
		this.datanascimento = datanascimento;
	}

	//toString
	public String toString() {
		return "Paciente [documento=" + documento + ", nome=" + nome + ", sexo=" + sexo + ", endereco=" + endereco
				+ ", datanascimento=" + datanascimento + "]";
	}
	
	//Metodos
	
}

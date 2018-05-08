package exercicio02cap2;

import java.time.LocalDateTime;

public class Consulta {

	//Atributos
	private Paciente paciente;
	private Medico medico;
	private LocalDateTime datahora;
	
	//Construtores
	public Consulta(Paciente paciente, Medico medico, LocalDateTime datahora) {
		super();
		this.paciente = paciente;
		this.medico = medico;
		this.datahora = datahora;
	}

	public Consulta() {
		super();
	}

	//Getters and Setters
	public Paciente getPaciente() {
		return paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public LocalDateTime getDatahora() {
		return datahora;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public void setDatahora(LocalDateTime datahora) {
		this.datahora = datahora;
	}

	//toString
	public String toString() {
		return "Consulta [paciente=" + paciente + ", medico=" + medico + ", datahora=" + datahora + "]";
	}

	//equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datahora == null) ? 0 : datahora.hashCode());
		result = prime * result + ((medico == null) ? 0 : medico.hashCode());
		result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (datahora == null) {
			if (other.datahora != null)
				return false;
		} else if (!datahora.equals(other.datahora))
			return false;
		if (medico == null) {
			if (other.medico != null)
				return false;
		} else if (!medico.equals(other.medico))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		return true;
	}

	
	
	//Metodos
	
	
	
}//fim da classe

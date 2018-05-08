package exercicio02cap2;

import java.util.ArrayList;
import java.time.LocalDate;

public class ColecaoPacientes {
	
	//Atributos
	private ArrayList<Paciente> colpaciente;

	//Construtor
	
	public ColecaoPacientes() {
		colpaciente = new ArrayList<Paciente>();
	} 
	
	//Metodos
	
	public void adicionarPaciente(Paciente pcnt) {
		
		colpaciente.add(pcnt);
		
	}
	
	public void pesquisaPeloDocumento(String doc) {
		
		for (Paciente pcnt: colpaciente) {
			
			if (pcnt.getDocumento().equals(doc)) {
				System.out.println(pcnt);
			}//Fim do if de busca
			
		}//fim do for each
	}//fim do metodo
	
	public Boolean removePeloDocumento(String doc) {
		
		Boolean retorno = false;
		
		for (Paciente pcnt: colpaciente) {
			
			if (pcnt.getDocumento().equals(doc)) {
				System.out.print("O paciente a ser removido sera: ");
				System.out.println(pcnt);
				colpaciente.remove(pcnt);
				retorno=true;
				return retorno;
			}	
		}//fim do for each		
		
			System.out.print("O paciente com documento " + doc + "nao foi encontrado!");
			return retorno;		
	}//fim do metodo
	
	public int qtdPacientesPorSexo(String nsexo) {
		
		Integer retorno=0;
		for (Paciente pcnt: colpaciente) {
			
			if (pcnt.getSexo().equals(nsexo)) {
				
				retorno++;
			}	
		}//Fim do for each
		
		if (retorno==0) {
		
			System.out.print("Paciente(s) com o sexo " + nsexo + "nao fo(i)(ram) encontrado(s)!");
			
		}//fim do if de 
		
		return retorno;
	}

	public Boolean listagemPacientesComEndereco (Endereco endref) {
		
		Boolean retorno = false;
		
		for (Paciente pcnt: colpaciente) {
			
			if (pcnt.getEndereco().equals(endref)) {
				System.out.println(pcnt);
				return true;
			}//Fim do if de busca
			
		}//fim do for each
		
		return retorno;
	}
	
	public ArrayList<Paciente> listagemDePacientesMaioresDe60anos(ColecaoPacientes colpacientes) {
		
		ArrayList<Paciente> idosos = new ArrayList<Paciente>();
		
		LocalDate dataatual = LocalDate.now();
		
		Integer anoatual = dataatual.getYear(), anomenos60 = (anoatual - 60);
		
		LocalDate data60anosatras = LocalDate.of(anomenos60, dataatual.getMonthValue(), dataatual.getDayOfMonth() );
		
		for (Paciente pcnt: colpaciente) {
			
			if (pcnt.getDatanascimento().isBefore(data60anosatras) == true) {
				
				idosos.add(pcnt);
		
			}//Fim do if de busca
			
		}//fim do for each
			
		return idosos;
	}
	
	/* 
	 * adicionarPaciente p
	 * pesquisaPeloDocumento p 
	 * removePeloDocumento p
	 * qtdPacientesPorSexo p
	 * listagemPacientesComEndereço p
	 * listagemDePacientesMaioresDe60anos 
	 */
	
	public Integer tamanhoListaPacientes() {
		
		return colpaciente.size();
		
	}
	
	public Paciente pacienteNaPos(Integer i) {
		
		return colpaciente.get(i);
	}
		
	
}//fim da classe

package exercicio02cap2;

import java.util.ArrayList;

public class ColecaoConsultas {
	
	//Atributo
	private ArrayList<Consulta> coleconsulta;

	//Construtor
	
	public ColecaoConsultas() {
		
		coleconsulta = new ArrayList<Consulta>();
		
	}

	
	
	//Metodos
	
	/*adicionaConsulta 
	 * qtdeConsultasData p
	 * listagemConsultas p
	 * qtdConsultasPorMedico p
	 * listaConsultasPorPaciente p
	 */

	public void adicionaConsulta(Consulta nconsulta){
		
		coleconsulta.add(nconsulta);
		
	}
	
	public void listagemDeConsultas() {
		
				
		for (Consulta cslt: coleconsulta) {
			
			System.out.println(cslt);	
		}
	}
	
	public Integer qtdConsultasPorMedico(String nomemedico) {
		
		Integer numeroconsultas = 0; 
		
		for (Consulta cslt: coleconsulta) {
			
			if (cslt.getMedico().getNome().toLowerCase().equals(nomemedico.toLowerCase()) == true) {
				
				numeroconsultas++;
			}
			
		}
		
		return numeroconsultas;
		
	}
	
	public ArrayList<Consulta> listaConsultasPorPaciente(String nomepaciente) {
		
		ArrayList<Consulta> listaconsultapaciente = new ArrayList<Consulta>();
		
		for (Consulta cslt: coleconsulta) {
			
			if (cslt.getPaciente().getNome().toLowerCase().equals(nomepaciente.toLowerCase()) == true) {
				
				listaconsultapaciente.add(cslt);				
			}
			
		}
		
		return listaconsultapaciente;
		
	}
	
	
}//fim da classe

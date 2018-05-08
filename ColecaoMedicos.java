package exercicio02cap2;

import java.util.ArrayList;

public class ColecaoMedicos {

	//Atributo
	private ArrayList<Medico> colemedico;

	//Construtor
	public ColecaoMedicos() {
		colemedico = new ArrayList<Medico>();
		
	}
	
	/*
	 * adicionaMedico   p
	 *  pesquisaPeloCRM p
	 *  pesquisaMedicoPorParteDoNome p
	 */
	
	//Metodos
	
	public void adicionaMedico(Medico mdc) {
		
		colemedico.add(mdc);
		
	}
	
	public Medico pesquisaPeloCRM(String mcrm) {
				
		for (Medico mdc: colemedico) {
			
			if (mdc.getCrm().equals(mcrm) == true) {
				
				return mdc;
				}
		}
		
		System.out.println("Medicos com CRM: " + mcrm + ", nao foram encontrados!");
		return null;
	}
	
	
	
	public Boolean pesquisaPorParteDoNome(String partenome) {
		
		Boolean retorno = false, teste=false;
				
		for (Medico mdc: colemedico) {
			
			//teste = mdc.getNome().regionMatches(true, 0, partenome, 0,mdc.getNome().length());
			
			teste = mdc.getNome().contains(partenome);
			
			if (teste == true) {
				
				System.out.println(mdc);
				retorno = true;
			}
			
		}
		
		if (retorno = false) {
			
			System.out.println("Nenhum medico encontrado com '" + partenome + "' no nome");
			
		}
		
		return retorno;
	}
	
	//extra
	public Integer tamanhoListaMedicos() {
		
		Integer tamanho = colemedico.size();
		return tamanho;
		
	}
	
	public Medico medicoNaPos(Integer i) {
		
		return colemedico.get(i);
	}
	
}//fim da classe

	
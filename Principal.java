package exercicio02cap2;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {
				
	ColecaoPacientes colepacientes1 = new ColecaoPacientes();
	ColecaoMedicos colemedicos1 = new ColecaoMedicos();
	ColecaoConsultas coleconsultas1 = new ColecaoConsultas(); 
	
	menuPrincipal(colepacientes1, colemedicos1, coleconsultas1);
	
		
	}//fim do main
	
	//Metodos que asseguram a leitura
	
	private static int leInteiro(){
		
		Scanner tcl = new Scanner(System.in);
		
		System.out.print("Digite um inteiro: ");
		while (!tcl.hasNextInt()) {			
			tcl.nextLine();
		}
		
		int inteiro = tcl.nextInt();
		tcl.nextLine();
		return inteiro;
		
	}

	private static double leDouble(){
		
		Scanner tcl = new Scanner(System.in);
		
		System.out.print("Digite um numero real: ");
		while (!tcl.hasNextDouble()) {			
			tcl.nextLine();
		}
		
		double real = tcl.nextDouble();
		tcl.nextLine();
		return real;
		
	}
	
	private static String leString(){
		
		Scanner tcl = new Scanner(System.in);
		
		System.out.print("Digite um texto: ");
		String texto = tcl.nextLine();
		return texto;
		
	}
	
	private static LocalDate leData() {
		
		Scanner tcl = new Scanner(System.in);
		
		int ano = 0, mes = 0, dia = 0;
		
		System.out.println("Digite uma data <ano-mes-dia>");
		
		System.out.print("Digite o dia: ");
		dia = leInteiro();
		
		System.out.print("Digite o mes: ");
		mes = leInteiro();
		
		System.out.print("Digite o ano: ");
		ano = leInteiro();
	
		LocalDate datalocal = LocalDate.of(ano, mes, dia); //2018-05-03 (formato ISO-8601)
		return datalocal;
	}

	private static LocalDateTime leDataHora() {
		
		Scanner tcl = new Scanner(System.in);
		
		int ano = 0, mes = 0, dia = 0, hora = 0, minuto = 0;
		
		System.out.println("Digite uma data <ano-mes-dia>");
		
		System.out.print("Digite o dia: ");
		dia = leInteiro();
		
		System.out.print("Digite o mes: ");
		mes = leInteiro();
		
		System.out.print("Digite o ano: ");
		ano = leInteiro();
	
		System.out.print("Digite a hora: ");
		hora = leInteiro();
		
		System.out.print("Digite o minuto: ");
		minuto = leInteiro();
		
		LocalDateTime datahoralocal = LocalDateTime.of(ano, mes, dia, hora, minuto); //2018-05-03 T 7:50 (formato ISO-8601)
		return datahoralocal;
	}

	//Metodos de criacao 
	
	private static Endereco novoEndereco() {
		
		Endereco novoend = new Endereco();
		
		System.out.print("Digite o nome da rua: ");
		novoend.setRua(leString());
		
		System.out.print("Digite o numero da residencia: ");
		novoend.setNumero(leInteiro());
		
		System.out.print("Digite o complemento da residencia: ");
		novoend.setComplemento(leString());
		
		System.out.print("Digite o bairro da residencia: ");
		novoend.setBairro(leString());
		
		System.out.print("Digite o CEP da rua: ");
		novoend.setCep(leString());		
		
		return novoend;
	}
	
	private static Paciente novoPaciente() {
		
		Paciente novopcnt = new Paciente();
		
		System.out.print("Digite o nome do paciente: ");
		novopcnt.setNome(leString());
		
		System.out.print("Digite o documento do paciente: ");
		novopcnt.setDocumento(leString() );
		
		System.out.print("Digite o sexo do paciente: ");
		novopcnt.setSexo(leString() );
		
		System.out.print("Digite a data de nascimento do paciente: ");
		novopcnt.setDatanascimento(leData() );
		
		System.out.print("Digite o endereco do paciente");
		novopcnt.setEndereco(novoEndereco() );
		
		return novopcnt;
	}
	
	private static Medico novoMedico() {
		
		Medico novomedc = new Medico();
		
		System.out.print("Digite o nome do medico: ");
		novomedc.setNome(leString() );
		
		System.out.print("Digite a especialidade do medico: ");
		novomedc.setEspecialidade(leString() );
		
		System.out.print("Digite o crm do medico: ");
		novomedc.setCrm(leString() );
		
		return novomedc;
	}

	private static Consulta novaConsulta(ColecaoPacientes colepacientes, ColecaoMedicos colemedicos) {
		
		Consulta novaconslt = new Consulta();
		
		System.out.print("Defina a data e a hora da consulta: ");
		novaconslt.setDatahora(leDataHora() );
		
		System.out.print("Digite o nome do paciente: ");
		String npaciente = leString();
			
		if (procuraPaciente(npaciente, colepacientes).equals(null)) {
			
			System.out.println("Paciente nao encontrado, iniciando um novo registro");
			Paciente tmppaciente = novoPaciente();
			colepacientes.adicionarPaciente(tmppaciente);
			novaconslt.setPaciente(tmppaciente);
		
		} else {
			
			Paciente pcnt = procuraPaciente(npaciente, colepacientes);
			novaconslt.setPaciente(pcnt);
		  }
		
		System.out.print("Digite o nome do medico: ");
		String nmedico = leString();
		
		if (procuraMedico(nmedico, colemedicos).equals(null)) {
			
			System.out.println("Medico nao encontrado, iniciando um novo registro");
			Medico tmpmedico = novoMedico();
			colemedicos.adicionaMedico(tmpmedico);
			novaconslt.setMedico(tmpmedico);
					
		} else {
			
			Medico mdc = procuraMedico(nmedico, colemedicos);
			novaconslt.setMedico(mdc);
		  }
		
		return novaconslt;
	}

	//Menu com metodos de manipulacao de arrays

	private static void menuPrincipal(ColecaoPacientes colepacientes, ColecaoMedicos colemedicos, ColecaoConsultas coleconsultas) {
		
		Integer opmenu = 0;
		
		do{
			
				System.out.println("================================================");
				System.out.println("MENU PRINCIPAL");
				System.out.println("================================================");
				System.out.println("Digite [1] para entrar no submenu de Pacientes :");
				System.out.println("================================================");
				System.out.println("Digite [2] para entrar no submenu de Medicos :");
				System.out.println("================================================");
				System.out.println("Digite [3] para entrar no submenu de Consultas :");
				System.out.println("================================================");
				System.out.println("Digite [0] para sair:");
				System.out.println("================================================");
		
				opmenu=leInteiro();
		
				switch(opmenu) {
		
					case 1:
						submenuPaciente(colepacientes);
						break;
				
					case 2:
						submenuMedico(colemedicos);
						break;

					case 3:
						submenuConsulta(coleconsultas, colepacientes, colemedicos);
						break;
						
					case 0:
						break;
		
				default:
					System.out.println("Digite uma opcao valida [0] ou [1-3]");
					break;
				}
		
		
			}while(opmenu!=0);
		
	}

	private static void submenuPaciente(ColecaoPacientes colepacientes) {
		
		Integer opmenu = 0;
		
		do{
			
				System.out.println("================================================");
				System.out.println("MENU PRINCIPAL DO PACIENTE");
				System.out.println("================================================");
				System.out.println("Digite [1] para adicionar paciente: ");
				System.out.println("================================================");
				System.out.println("Digite [2] para pesquisar pelo documento: ");
				System.out.println("================================================");
				System.out.println("Digite [3] para remover pelo documento: ");
				System.out.println("================================================");
				System.out.println("Digite [4] para verificar a quantidade de pacientes por sexo:");
				System.out.println("================================================");
				System.out.println("Digite [5] para listar pacientes com tal endereco:");
				System.out.println("================================================");
				System.out.println("Digite [6] para listar pacientes acima de 60 anos:");
				System.out.println("================================================");
				System.out.println("Digite [0] para voltar:");
				System.out.println("================================================");
		
				opmenu=leInteiro();
		
				switch(opmenu) {
		
				case 1:
					colepacientes.adicionarPaciente(novoPaciente() );
					break;
				
				case 2:
					colepacientes.pesquisaPeloDocumento(leString() );
					break;
				
				case 3:
					colepacientes.removePeloDocumento(leString() );
					break;
					
				case 4:
					Integer qtdpcntsexo = colepacientes.qtdPacientesPorSexo(leString() );
					System.out.println(qtdpcntsexo);
					break;
					
				case 5:
					colepacientes.listagemPacientesComEndereco(novoEndereco() );
					break;
					
				case 6:
					ArrayList<Paciente> listaidosos = colepacientes.listagemDePacientesMaioresDe60anos(colepacientes);
					System.out.println("Lista de pacientes idosos: ");
					for (Paciente idoso: listaidosos) {
						System.out.println(idoso);
					}
					break;
					
				case 0:
					break;
		
				default:
					System.out.println("Digite uma opcao valida [1-6] ou [0]");
					break;
				}
		
		
			}while(opmenu!=0);
				
	}
	
	private static void submenuMedico(ColecaoMedicos colemedicos) {
		
		Integer opmenu = 0;
		
		do{
			
				System.out.println("================================================");
				System.out.println("MENU PRINCIPAL DO MEDICO");
				System.out.println("================================================");
				System.out.println("Digite [1] para adicionar medico: ");
				System.out.println("================================================");
				System.out.println("Digite [2] para pesquisar pelo CRM: ");
				System.out.println("================================================");
				System.out.println("Digite [3] para pesquisar medicos com uma parte do nome: ");
				System.out.println("================================================");
				System.out.println("Digite [0] para voltar:");
				System.out.println("================================================");
		
				opmenu=leInteiro();
		
				switch(opmenu) {
		
				case 1:
					colemedicos.adicionaMedico(novoMedico() );
					break;
				
				case 2:
					Medico medicocrm = colemedicos.pesquisaPeloCRM(leString() ) ;
					System.out.println(medicocrm);
					break;
				
				case 3:
					colemedicos.pesquisaPorParteDoNome(leString() ) ;
					break;
					
				case 0:
					break;
		
				default:
					System.out.println("Digite uma opcao valida [1-3] ou [0]");
					break;
				}
		
		
			}while(opmenu!=0);
	}
	
	private static void submenuConsulta( ColecaoConsultas coleconsultas, ColecaoPacientes colepacientes, ColecaoMedicos colemedicos) {
		
		Integer opmenu = 0;
		
		do{
			
				System.out.println("================================================");
				System.out.println("MENU PRINCIPAL DAS CONSULTAS");
				System.out.println("================================================");
				System.out.println("Digite [1] para adicionar consulta: ");
				System.out.println("================================================");
				System.out.println("Digite [2] para listar as consultas: ");
				System.out.println("================================================");
				System.out.println("Digite [3] para obter a contagem de consultas de certo medico: ");
				System.out.println("================================================");
				System.out.println("Digite [4] para as consultas com certo paciente");
				System.out.println("================================================");
				System.out.println("Digite [0] para voltar:");
				System.out.println("================================================");
		
				opmenu=leInteiro();
		
				switch(opmenu) {
		
				case 1:
					coleconsultas.adicionaConsulta(novaConsulta(colepacientes,colemedicos) );
					break;
				
				case 2:
					coleconsultas.listagemDeConsultas();
					break;
				
				case 3:
					System.out.print("Digite o nome do medico a ter a contagem de consultas pesquisadas: ");
					String nomedomedico = leString();
					System.out.println("Quantidade de consultas do medico" + nomedomedico + " : "+ coleconsultas.qtdConsultasPorMedico(nomedomedico) );
					break;
					
				case 4:
					System.out.print("Digite o nome do paciente a ter as consultas pesquisadas: ");
					String nomedopaciente = leString();
					ArrayList<Consulta> listadeconsultas  = coleconsultas.listaConsultasPorPaciente(nomedopaciente);
					System.out.print("O paciente " + nomedopaciente + " tem as seguintes consultas : ");
					for (Consulta cnstpcnt: listadeconsultas) {
						System.out.println(cnstpcnt);						
					}
					break;
					
				case 0:
					break;
		
				default:
					System.out.println("Digite uma opcao valida [1-6] ou [0]");
					break;
				}
		
		
			}while(opmenu!=0);
		
	}
	
	//Metodos de busca independentes
	
	private static Paciente procuraPaciente(String nomepaciente, ColecaoPacientes colepacientes) {
		
		Paciente tmppaciente = new Paciente();
		
//		for (Paciente tmppaciente: colepacientes) {
		
			for (int i = 0; i < colepacientes.tamanhoListaPacientes(); i++) {
				
				tmppaciente  =  colepacientes.pacienteNaPos(i);
				
				if (tmppaciente.getNome().toLowerCase().equals(nomepaciente) == true){
					return tmppaciente;
				}
			}
			
			System.out.println("Paciente " + nomepaciente + " nao existente");
			return tmppaciente;
		}
	
	private static Medico procuraMedico(String nomemedico, ColecaoMedicos colemedico) {
		
		Medico tmpmedico = new Medico();
		
	//	for (Medico tmpmedico: colemedico) {
		
		for (int i = 0; i < colemedico.tamanhoListaMedicos(); i++) {
			
			tmpmedico  =  colemedico.medicoNaPos(i);
			
			if (tmpmedico.getNome().toLowerCase().equals(nomemedico)== true) {
				return tmpmedico;
			}
		}
		
		System.out.println("Medico " + nomemedico + " nao existente ");
		return tmpmedico;
	}
	
}//fim da classe main


package com.agencia;

import com.agencia.dao.ClienteDAO;
import com.agencia.database.DatabaseConnection;
import com.agencia.model.Cliente;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		var connection = DatabaseConnection.createConnection();
			ClienteDAO clienteDAO = new ClienteDAO(connection);
			
			Scanner scanner = new Scanner(System.in);
			
			var option = 0;
			
			
			
			do {
				System.out.println("Escolha uma opção de 1 - 5\n"
						+ "1 - Create\n"
						+ "2 - Read\n"
						+ "3 - Update\n"
						+ "4 - Delete\n"
						+ "5 - Sair\n");
				option=scanner.nextInt();
				
				switch(option) {
				case 1:
					 scanner.nextLine();
				     Cliente cliente = new Cliente();
				     System.out.println("Nome completo: ");
				     cliente.setNomeCliente(scanner.nextLine());
				     System.out.println("CPF: ");
				     cliente.setCpfCliente(scanner.nextLine().trim());
				     System.out.println("Coloque seu endereço: ");
				     cliente.setEndereçoCliente(scanner.nextLine());
				     System.out.println("Coloque seu telefone: ");
				     cliente.setTelefoneCliente(scanner.next());
				     
				     clienteDAO.createCliente(cliente);
				     
				     
				     
				    break; 
				case 2: 
					clienteDAO.readALLCliente();
			       break;
	            case 3:
			           Cliente clienteAtualizado = new Cliente();
					   System.out.println("Digite o ID do cliente a ser atualizado: ");
					   clienteAtualizado.setIdCliente(scanner.nextInt());
					   scanner.nextLine();
					   System.out.println("Nome completo: ");
					   clienteAtualizado.setNomeCliente(scanner.nextLine());
					   System.out.println("CPF: ");
					   clienteAtualizado.setCpfCliente(scanner.nextLine().trim());
					   System.out.println("Coloque seu endereço: ");
					   clienteAtualizado.setEndereçoCliente(scanner.nextLine());
					   System.out.println("Coloque seu telefone: ");
					   clienteAtualizado.setTelefoneCliente(scanner.next());
					   
					   clienteDAO.updateCliente(clienteAtualizado);
				   break;
	            
	            
	            case 4:
	            	System.out.println("Digite o ID do Cliente a ser DELETADO: ");
				    int idcliente = scanner.nextInt();
				    clienteDAO.deleteCliente(idcliente);
				
				   default:
					break;
				  
					
				}
				
				} while(option != 5);
			
				
			}	

}

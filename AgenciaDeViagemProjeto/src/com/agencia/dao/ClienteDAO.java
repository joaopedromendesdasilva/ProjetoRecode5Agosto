package com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.model.Cliente;

public class ClienteDAO {

     private static String sql;
     
     private final Connection connection;
     
     public ClienteDAO(Connection connection) {
    	 this.connection = connection;
    	 
    	 }
     
     // CREATE
     public void createCliente(Cliente cliente) {
    	 sql = "INSET INTO cliente(nomeCliente, cpfCliente, endereçoCliente, telefoneCliente) VALUES (?,?,?,?)";
    	 try(PreparedStatement stmt = connection.prepareStatement(sql)){
    		stmt.setString(1, cliente.getNomeCliente());
    		stmt.setString(2, cliente.getCpfCliente());
    		stmt.setString(3, cliente.getEndereçoCliente());
    		stmt.setString(4, cliente.getTelefoneCliente());
    	 
    	    stmt.executeUpdate();
    	    System.out.println("Cliente criado com sucesso!");
    	 
    	 }catch(SQLException e) {
        	System.out.println(e.getMessage());
        	 
         }
     }

     
     // READ
     public void readALLCliente() {
    	 sql="SELECT * FROM Cliente";
    	 try(PreparedStatement stmt = connection.prepareStatement(sql)){
    		ResultSet r = stmt.executeQuery();
    		while(r.next()) {
    			Cliente cliente = new Cliente();
    			cliente.setNomeCliente(r.getString("nomeCliente"));
    			cliente.setCpfCliente(r.getString("cpfCliente"));
    			cliente.setEndereçoCliente(r.getString("endereçoCliente"));
    			cliente.setTelefoneCliente(r.getString("telefoneCliente"));
    			
    			System.out.printf("Nome: %s\n CPF: %s\n Endereço: %s\n Telefone: %s\n", 
    					cliente.getNomeCliente(), cliente.getCpfCliente(), cliente.getEndereçoCliente(), cliente.getTelefoneCliente());
    			
    		}
    		if (!r.next()) {
    			System.out.println("NÃO HA DADOS");
    			}
    	 }catch(SQLException e) {
    		 System.out.println("Não foi possível acessar as informações." + e.getMessage());
    	 }
    	 
     }

    
     
     // UPDATE
     public void updateCliente(Cliente cliente) {
    	 sql = "UPDATE cliente SET nomeCliente = ?, cpfCliente = ?, endereçoCliente = ?, telefoneCliente = ? WHERE idCliente = ?";
    	 try (PreparedStatement stmt = connection.prepareStatement(sql)) {
    	 stmt.setString(1, cliente.getNomeCliente());
         stmt.setString(2, cliente.getCpfCliente());
    	 stmt.setString(3, cliente.getEndereçoCliente());
    	 stmt.setString(4, cliente.getTelefoneCliente());
    	 stmt.setInt(5, cliente.getIdCliente());
    	 
    	 stmt.executeUpdate();
    	   System.out.println("Cliente atualizado com sucesso!");
 	 
    	 
    	 
    	 }catch (SQLException e) {
    		 System.out.println(e.getMessage());
         }
 
     }

     
     //DELETE
     public void deleteCliente(int id) {
    	 sql="DELETE FROM clinte WHERE idCliente = ?";
    	 try (PreparedStatement stmt = connection.prepareStatement(sql)) {
    	      stmt.setInt(1,id);
    	 
    	 
    	      stmt.executeUpdate();
    	      System.out.println("Cliente deletado com sucesso!");
    	      
    	 }catch (SQLException e) {
    		 System.out.println("Não foi possível deletar o cliente!" + e.getMessage());
    		 
    	 }
    	 
    	 
     }
     
}
     


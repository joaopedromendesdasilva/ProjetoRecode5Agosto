package com.agencia.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databaseconnection {

private static final String url = "jbdc:mysql://localhost/3306/agencia_crud";
private static final String user = "root";
private static final String  password = "vanpervion30082001";


public static Connection createConnection() {
    try {
    	Class.forName("com.sql.cj.jbdc.Driver");
    	System.out.println("Driver encontrado!");
    
    } catch(ClassNotFoundException e) {
    	System.out.println("Driver não encontrado! mensagem: " + e.getMessage());
    }

    try {
    	Connection connection = DriverManager.getConnection(url, user, password);
    	System.out.println("Conectado com sucesso!");
    
        return connection;
        
    } catch (SQLException e) {
    	
    	System.out.println("Não foi possivel conectar ao banco! mensagem ;" + e.getMessage());
        return null;
    }



 }

}

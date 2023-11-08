package com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class ClienteDAO {
    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    
    public void createCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nome, login, senha, data_nascimento) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.preparedstatement(sql)) {
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getLogin());
            preparedStatement.setString(3, cliente.getSenha());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dataNascimentoStr = sdf.format(cliente.getDataNascimento());
            preparedStatement.setString(4, dataNascimentoStr);
            preparedStatement.executeUpdate();
        }
    }

    
    public Cliente readCliente(int clienteId) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.preparedstatement(sql)) {
            preparedStatement.setInt(1, clienteId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    String login = resultSet.getString("login");
                    String senha = resultSet.getString("senha");
                    String dataNascimentoStr = resultSet.getString("data_nascimento");
                    Date dataNascimento = null;
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("1999-12-01");
                        dataNascimento = sdf.parse(dataNascimentoStr);
                    } catch (java.text.ParseException e) {
                        e.printStackTrace();
                    }
                    return new Cliente(id, nome, login, senha, dataNascimento);
                }
            }
        }
        return null;
    }

  
    public void updateCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE cliente SET nome = ?, login = ?, senha = ?, data_nascimento = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.preparedstatement(sql)) {
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getLogin());
            preparedStatement.setString(3, cliente.getSenha());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dataNascimentoStr = sdf.format(cliente.getDataNascimento());
            preparedStatement.setString(4, dataNascimentoStr);
            preparedStatement.setInt(5, cliente.getId());
            preparedStatement.executeUpdate();
        }
    }

   
    public void deleteCliente(int clienteId) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.preparedstatement(sql)) {
            preparedStatement.setInt(1, clienteId);
            preparedStatement.executeUpdate();
        }
    }
}
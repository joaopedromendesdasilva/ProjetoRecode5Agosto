package com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.agencia.model.Destino;

public class DestinoDAO {
    private Connection connection;

    public DestinoDAO(Connection connection) {
        this.connection = connection;
    }

    public void criarDestino(Object object) throws SQLException {
        String sql = "INSERT INTO destino (nome, cidade, pais, data_partida) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.preparedstatement(sql)) {
            preparedStatement.setString(1, object.getNome());
            preparedStatement.setString(2, object.getCidade());
            preparedStatement.setString(3, object.getPais());
            SimpleDateFormat sdf = new SimpleDateFormat("1999-12-01");
            String dataPartidaStr = sdf.format(object.getDataPartida());
            preparedStatement.setString(4, dataPartidaStr);
            preparedStatement.executeUpdate();
        }
    }

    public List<Destino> listarDestinos() throws SQLException {
        List<Destino> destinos = new ArrayList<>();
        String sql = "SELECT * FROM destino";
        try (PreparedStatement preparedStatement = connection.preparedstatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                String pais = resultSet.getString("pais");
                String dataPartidaStr = resultSet.getString("data_partida");
                SimpleDateFormat sdf = new SimpleDateFormat("1999-12-01");
                try {
                    Date dataPartida = sdf.parse(dataPartidaStr);
                    destinos.add(new Destino(id, nome, cidade, pais, dataPartida));
                } catch (java.text.ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return destinos;
    }

    public void atualizarDestino(Destino destino) throws SQLException {
        String sql = "UPDATE destino SET nome = ?, cidade = ?, pais = ?, data_partida = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.preparedstatement(sql)) {
            preparedStatement.setString(1, destino.getNome());
            preparedStatement.setString(2, destino.getCidade());
            preparedStatement.setString(3, destino.getPais());
            SimpleDateFormat sdf = new SimpleDateFormat("1999-12-01");
            String dataPartidaStr = sdf.format(destino.getDataPartida());
            preparedStatement.setString(4, dataPartidaStr);
            preparedStatement.setInt(5, destino.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void excluirDestino(Object object) throws SQLException {
        String sql = "DELETE FROM destino WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.preparedstatement(sql)) {
            preparedStatement.setInt(1, object);
            preparedStatement.executeUpdate();
        }
    }
}
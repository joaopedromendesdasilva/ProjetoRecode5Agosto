package com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.model.Destino;

public class DestinoDAO {

    private final Connection connection;

    public DestinoDAO(Connection connection) {
        this.connection = connection;
    }

    // CREATE
    public void createDestino(Destino destino) {
        String sql = "INSERT INTO destino(nomeDestino, descricaoDestino, preco) VALUES (?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, destino.getNomeDestino());
            stmt.setString(2, destino.getDescricaoDestino());
            stmt.setDouble(3, destino.getPreco());

            stmt.executeUpdate();
            System.out.println("Destino criado com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // READ
    public void readAllDestino() {
        String sql = "SELECT * FROM destino";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet r = stmt.executeQuery();
            while (r.next()) {
                Destino destino = new Destino();
                destino.setNomeDestino(r.getString("nomeDestino"));
                destino.setDescricaoDestino(r.getString("descricaoDestino"));
                destino.setPreco(r.getDouble("preco"));

                System.out.printf("Nome: %s\nDescrição: %s\nPreço: %s\n",
                        destino.getNomeDestino(), destino.getDescricaoDestino(), destino.getPreco());
            }
            if (!r.next()) {
                System.out.println("NÃO HA DADOS");
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível acessar as informações." + e.getMessage());
        }
    }

    // UPDATE
    public void updateDestino(Destino destino) {
        String sql = "UPDATE destino SET nomeDestino = ?, descricaoDestino = ?, preco = ? WHERE idDestino = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, destino.getNomeDestino());
            stmt.setString(2, destino.getDescricaoDestino());
            stmt.setDouble(3, destino.getPreco());
            stmt.setInt(4, destino.getIdDestino());

            stmt.executeUpdate();
            System.out.println("Destino atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // DELETE
    public void deleteDestino(int id) {
        String sql = "DELETE FROM destino WHERE idDestino = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            stmt.executeUpdate();
            System.out.println("Destino deletado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Não foi possível deletar o destino!" + e.getMessage());
        }
    }
}
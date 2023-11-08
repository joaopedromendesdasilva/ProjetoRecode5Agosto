package controller;

import java.sql.SQLException;

import com.agencia.dao.ClienteDAO;
import com.agencia.model.Cliente;

import view.ClienteView;

public class ClienteController {
    private Cliente model;
    private ClienteView view;
    private ClienteDAO dao;

    public ClienteController(Cliente model, ClienteView view, ClienteDAO dao) {
        this.model = model;
        this.view = view;
        this.dao = dao;
    }

   
    public void carregarCliente(int clienteId) {
        try {
            Cliente cliente = dao.readCliente(clienteId);
            if (cliente != null) {
                model = cliente;
                view.imprimirDetalhesCliente(model);
            } else {
                view.imprimirMensagem("Cliente não encontrado.");
            }
        } catch (SQLException e) {
            view.imprimirMensagem("Erro ao carregar o cliente: " + e.getMessage());
        }
    }

  
    public void atualizarCliente() {
        try {
            dao.updateCliente(model);
            view.imprimirMensagem("Cliente atualizado com sucesso.");
        } catch (SQLException e) {
            view.imprimirMensagem("Erro ao atualizar o cliente: " + e.getMessage());
        }
    }


    public void deletarCliente() {
        try {
            dao.deleteCliente(model.getId());
            view.imprimirMensagem("Cliente excluído com sucesso.");
        } catch (SQLException e) {
            view.imprimirMensagem("Erro ao excluir o cliente: " + e.getMessage());
        }
    }
}
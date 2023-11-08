package controller;

import java.sql.SQLException;

import com.agencia.dao.DestinoDAO;
import com.agencia.model.Destino;

import view.DestinoView;

public class DestinoController {
    private Destino model;
    private DestinoView view;
    private DestinoDAO dao;

    public DestinoController(Destino model, DestinoView view, DestinoDAO dao) {
        this.model = model;
        this.view = view;
        this.dao = dao;
    }

    public void criarDestino() {
        try {
            dao.criarDestino(model);
            view.imprimirMensagem("Destino criado com sucesso.");
        } catch (SQLException e) {
            view.imprimirMensagem("Erro ao criar o destino: " + e.getMessage());
        }
    }

    public void carregarDestino(int destinoId) {
        try {
            Destino destino = dao.listarDestinos().stream()
                    .filter(d -> d.getId() == destinoId)
                    .findFirst()
                    .orElse(null);

            if (destino != null) {
                model = destino;
                view.imprimirDestino(model);
            } else {
                view.imprimirMensagem("Destino não encontrado.");
            }
        } catch (SQLException e) {
            view.imprimirMensagem("Erro ao carregar o destino: " + e.getMessage());
        }
    }

    public void atualizarDestino() {
        try {
            dao.atualizarDestino(model);
            view.imprimirMensagem("Destino atualizado com sucesso.");
        } catch (SQLException e) {
            view.imprimirMensagem("Erro ao atualizar o destino: " + e.getMessage());
        }
    }

    public void excluirDestino() {
        try {
            dao.criarDestino(model.getId());
            view.imprimirMensagem("Destino excluído com sucesso.");
        } catch (SQLException e) {
            view.imprimirMensagem("Erro ao excluir o destino: " + e.getMessage());
        }
    }
}
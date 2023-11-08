package view;

import java.text.SimpleDateFormat;
import java.util.List;

import com.agencia.model.Destino;

public class DestinoView {
    public void imprimirDestino(Destino destino) {
        System.out.println("Detalhes do Destino:");
        System.out.println("ID: " + destino.getId());
        System.out.println("Nome: " + destino.getNome());
        System.out.println("Cidade: " + destino.getCidade());
        System.out.println("País: " + destino.getPais());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dataPartidaStr = sdf.format(destino.getDataPartida());
        System.out.println("Data de Partida: " + dataPartidaStr);
    }

    public void imprimirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void imprimirListaDestinos(List<Destino> destinos) {
        System.out.println("Lista de Destinos:");
        for (Destino destino : destinos) {
            imprimirDestino(destino);
            System.out.println("------------");
        }
    }
}
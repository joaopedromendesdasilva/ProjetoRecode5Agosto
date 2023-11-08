package view;

import com.agencia.model.Cliente;

public class ClienteView {
    public void imprimirDetalhesCliente(Cliente cliente) {
        System.out.println("Detalhes do Cliente:");
        System.out.println("ID: " + cliente.getId());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Login: " + cliente.getLogin());
        System.out.println("Senha: " + cliente.getSenha());
        System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
    }

    public void imprimirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
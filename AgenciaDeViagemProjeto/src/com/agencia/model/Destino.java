package com.agencia.model;

public class Destino {
    private int idDestino;
    private String nomeDestino;
    private String descricaoDestino;
    private double preco;

    public Destino() {
        super();
    }

    public Destino(String nomeDestino, String descricaoDestino, double preco) {
        super();
        this.nomeDestino = nomeDestino;
        this.descricaoDestino = descricaoDestino;
        this.preco = preco;
    }

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public String getNomeDestino() {
        return nomeDestino;
    }

    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
    }

    public String getDescricaoDestino() {
        return descricaoDestino;
    }

    public void setDescricaoDestino(String descricaoDestino) {
        this.descricaoDestino = descricaoDestino;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Destino [idDestino=" + idDestino + ", nomeDestino=" + nomeDestino + ", descricaoDestino=" + descricaoDestino + ", preco=" + preco + "]";
    }
}
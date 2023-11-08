package com.agencia.model;

import java.util.Date;

public class Destino {
    private int id;
    private String nome;
    private String cidade;
    private String pais;
    private Date dataPartida;

    public Destino() {
     
    }

    public Destino(int id, String nome, String cidade, String pais, Date dataPartida) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
        this.dataPartida = dataPartida;
    }

	public Object getId() {
	    return null;
	}

	public String getNome() {
		return null;
	}

	public Date getDataPartida() {
		return null;
	}


}
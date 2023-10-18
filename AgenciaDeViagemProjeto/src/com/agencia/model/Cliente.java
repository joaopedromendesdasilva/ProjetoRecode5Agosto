package com.agencia.model;

public class Cliente {

	private int idCliente;
	
	private String nomeCliente;
	
	private String cpfCliente;
	
	private String endereçoCliente;
	
	private String telefoneCliente;

	
	
	
	
	
	
	public Cliente() {
		super();
		
	}


     public Cliente(String nomeCliente, String cpfCliente, String endereçoCliente, String telefoneCliente) {
		super();
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.endereçoCliente = endereçoCliente;
		this.telefoneCliente = telefoneCliente;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getCpfCliente() {
		return cpfCliente;
	}


	public void setCpfCliente(String string) {
		this.cpfCliente = string;
	}


	public String getEndereçoCliente() {
		return endereçoCliente;
	}


	public void setEndereçoCliente(String endereçoCliente) {
		this.endereçoCliente = endereçoCliente;
	}


	public String getTelefoneCliente() {
		return telefoneCliente;
	}


	public void setTelefoneCliente(String i) {
		this.telefoneCliente = i;
	}


	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", cpfCliente=" + cpfCliente
				+ ", endereçoCliente=" + endereçoCliente + ", telefoneCliente=" + telefoneCliente + "]";
	}
	
	
	






}

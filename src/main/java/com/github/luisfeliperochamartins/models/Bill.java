package com.github.luisfeliperochamartins.models;

public class Bill extends Node {
	private Float price;
	private Client client;

	public Bill() {}

	public Bill(Float price, Client client) {
		this.price = price;
		this.client = client;
	}

	public Bill(Integer id, String name, Float price, Client client) {
		super(id, name);
		this.price = price;
		this.client = client;
	}

	public Bill(Integer id, String name, Node next, Node prev, Float price, Client client) {
		super(id, name, next, prev);
		this.price = price;
		this.client = client;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("COMPROVANTE DE PAGAMENTO");
		sb.append("NOME DO CLIENTE: ").append(client.getName());
		sb.append("VALOR DA CONTA: ").append(price);
		return sb.toString();
	}
}

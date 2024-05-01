package com.github.luisfeliperochamartins.models;

public class Table extends Node {
	private Client client;

	public Table(Client client) {
		this.client = client;
	}

	public Table(Integer id, String name, Client client) {
		super(id, name);
		this.client = client;
	}

	public Table(Integer id, String name, Node next, Node prev, Client client) {
		super(id, name, next, prev);
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Id: ").append(id).append(" ");
		sb.append("Client: ").append(client.getName());
		return sb.toString();
	}
}

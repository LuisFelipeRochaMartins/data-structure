package com.github.luisfeliperochamartins.models;

public class Client extends Node {

	public Client() {}

	public Client(String name) {
		this.name = name;
	}

	public Client(Integer id, String name) {
		super(id, name);
	}

	public Client(Integer id, Node next, Node prev, String name) {
		super(id, name,next, prev);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(name).append(" ").append(id).append(" ");
		return sb.toString();
	}
}

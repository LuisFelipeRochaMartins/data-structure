package com.github.luisfeliperochamartins.models;

public class Node{

	protected Integer id;
	protected String name;
	protected Node next;
	protected Node prev;

	public Node() {}

	public Node(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Node(Integer id, String name, Node next, Node prev) {
		this.id = id;
		this.name = name;
		this.next = next;
		this.prev = prev;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(id).append(" ");
		return sb.toString();
	}
}

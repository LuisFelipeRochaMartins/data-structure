package com.github.luisfeliperochamartins.models;

public class Order extends Node {
	private Float price;
	private OrderStatus status;

	public Order() {}

	public Order(String name, Float price) {
		this.name = name;
		this.price = price;
		this.status = OrderStatus.PREPARANDO;
	}

	public Order(Integer id, String name, Float price) {
		super(id, name);
		this.price = price;
		this.status = OrderStatus.PREPARANDO;
	}

	public Order(Integer id, Node next, Node prev, String name, Float price) {
		super(id, name,next, prev);
		this.price = price;
		this.status = OrderStatus.PREPARANDO;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Id: ").append(id).append(" ");
		sb.append("Name: ").append(name).append(" ");
		sb.append("Price: ").append(price).append(" ");
		sb.append("Status: ").append(status).append(" ");
		return sb.toString();
	}
}

package com.github.luisfeliperochamartins.models;

import com.github.luisfeliperochamartins.lists.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client extends Node {

	private List<Order> orders = new ArrayList<>();

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

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void addNewOrder(Order... newOrders) {
		orders.addAll(Arrays.asList(newOrders));
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(name).append(" ").append(id).append(" ");
		return sb.toString();
	}
}

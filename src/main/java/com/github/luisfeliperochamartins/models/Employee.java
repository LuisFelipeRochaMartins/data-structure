package com.github.luisfeliperochamartins.models;

import com.github.luisfeliperochamartins.lists.LinkedList;

public class Employee extends Node {
	private EmployeeType cargo;
	private String time;
	private LinkedList<Order> orders = new LinkedList<>();

	public Employee(EmployeeType cargo, String time) {
		this.cargo = cargo;
		this.time = time;
	}

	public Employee(Integer id, String name, EmployeeType cargo, String time) {
		super(id, name);
		this.cargo = cargo;
		this.time = time;
	}

	public Employee(Integer id, String name, Node next, Node prev, EmployeeType cargo, String time) {
		super(id, name, next, prev);
		this.cargo = cargo;
		this.time = time;
	}

	public EmployeeType getCargo() {
		return cargo;
	}

	public void setCargo(EmployeeType cargo) {
		this.cargo = cargo;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public LinkedList<Order> getOrders() {
		return orders;
	}

	public void setOrders(LinkedList<Order> orders) {
		this.orders = orders;
	}

	public void welcomeCustomer(LinkedList<Table> tables, LinkedList<Client> clients) {
		if (this.getCargo() == EmployeeType.GARCOM) {
			Table table = tables.getHead();
			Client client = clients.getHead();

			while(table != null) {
				if (table.getClient() == null) {
					table.setClient(client);
					clients.remove(client);
					client = (Client) client.getNext();
				}
				table = (Table) table.getNext();
			}
		}
	}

	public void createNewOrders(LinkedList<Table> tables) {
		if (this.getCargo() == EmployeeType.GARCOM) {
			var table = (Table) tables.getHead();

			while (table != null) {
				if (table.getClient().getOrders() != null) {
					for (Order order : table.getClient().getOrders()) {
						orders.append(order);
					}
				}

				table = (Table) table.getNext();
			}
		}
	}

	public void prepareOrders(LinkedList<Order> orders) {
		if (this.getCargo() == EmployeeType.COZINHEIRO) {
			var order = (Order) orders.getHead();

			while(order != null) {
				order.setStatus(OrderStatus.PRONTO);
				order = (Order) order.getNext();
			}
		}
	}

	public void deliverOrder(LinkedList<Order> orders) {
		if (this.getCargo() == EmployeeType.GARCOM) {
			var order = (Order) orders.getHead();

			while(order != null) {
				order.setStatus(OrderStatus.ENTREGUE);
				order = (Order) order.getNext();
			}
		}
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Id: ").append(id).append(", ");
		sb.append("Name: ").append(name).append(", ");
		sb.append("Cargo: ").append(cargo).append(", ");
		sb.append("Time:  ").append(time).append("\n");
		return sb.toString();
	}
}

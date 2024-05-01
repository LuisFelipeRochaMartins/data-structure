package com.github.luisfeliperochamartins.models;

public class Employee extends Node {
	private EmployeeType cargo;
	private String time;

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

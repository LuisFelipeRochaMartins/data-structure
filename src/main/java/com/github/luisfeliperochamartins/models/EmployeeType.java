package com.github.luisfeliperochamartins.models;

public enum EmployeeType {

	COZINHEIRO("COZINHEIRO"),
	FAZINEIRO("FAXINEIRO"),
	GARCOM("GARCOM"),
	CAIXA("CAIXA");

	private String type;

	EmployeeType(String type) {
		this.type = type;
	}
}

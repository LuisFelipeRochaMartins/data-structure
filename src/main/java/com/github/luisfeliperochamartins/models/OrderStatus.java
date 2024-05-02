package com.github.luisfeliperochamartins.models;

public enum OrderStatus {

	PREPARANDO("PREPARANDO"),
	PRONTO("PRONTO"),
	ENTREGUE("ENTREGUE");

	private String status;

	OrderStatus(String status) {
		this.status = status;
	}
}

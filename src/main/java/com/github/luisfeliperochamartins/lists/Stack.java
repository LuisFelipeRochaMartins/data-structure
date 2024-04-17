package com.github.luisfeliperochamartins.lists;

import com.github.luisfeliperochamartins.models.Node;

public class Stack<T extends Node> implements IRestrictedList<T> {

	private T top;
	private Integer size = 0;
	private Integer limit = 0;

	public Stack(Integer limit) {
		this.limit = limit;
	}

	public T getTop() {
		return top;
	}

	@Override
	public boolean empty() {
		return size == 0;
	}

	@Override
	public boolean hasSpace() {
		return limit > size;
	}

	@Override
	public void push(T node) {
		if (hasSpace()) {
			node.setNext(top);
			top = node;
			size ++;
		} else {
			System.out.println("Stack is full!");
		}
	}

	@Override
	public void pop() {
		if (!empty()) {
			top = (T) top.getNext();
			size --;
		} else {
			System.out.println("Stack is empty");
		}
	}

	@Override
	public String toString() {
		T node = top;
		StringBuilder sb = new StringBuilder();
		while (node != null) {
			sb.append(node.getId()).append(" ");
			node = (T) node.getNext();
		}

		return sb.toString();
	}
}

package com.github.luisfeliperochamartins.lists;

import com.github.luisfeliperochamartins.models.Node;

import java.util.Objects;

public class Queue<T extends Node> implements IRestrictedList<T>{

	private T head;
	private T tail;
	private Integer size = 0;
	private Integer limit = 0;

	public Queue(Integer limit) {
		this.limit = limit;
	}

	@Override
	public boolean hasSpace() {
		return limit > size;
	}

	@Override
	public boolean empty() {
		return size == 0;
	}

	@Override
	public void push(T node) {
		if (hasSpace()) {
			if (empty()) {
				head = node;
				tail = node;
			} else {
				tail.setNext(node);
				tail = node;
			}
			size ++;
		} else {
			System.out.println("Queue is full!");
		}
	}

	@Override
	public void pop() {
		T currentNode = head;
		T previousNode = null;

		while (currentNode != null) {
			if (currentNode == tail) {
				previousNode.setNext(null);
				size --;
				if (empty()) {
					tail = null;
					return;
				}
				return;
			}
			previousNode = currentNode;
			currentNode = (T) currentNode.getNext();
		}
	}

	public void pop(T node) {
		T currentNode = head;
		T previousNode = null;

		while (currentNode != null) {
			if (Objects.equals(node.getId(), currentNode.getId())) {
				if (previousNode == null) {
					head = (T) currentNode.getNext();
				} else {
					previousNode.setNext(currentNode.getNext());
					return;
				}
			}
			previousNode = currentNode;
			currentNode = (T) currentNode.getNext();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		T node = head;
		while (node != null) {
			sb.append(node.getId()).append(" ");
			node = (T) node.getNext();
		}

		return sb.toString();
	}
}

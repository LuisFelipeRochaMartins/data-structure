package com.github.luisfeliperochamartins.lists;

import com.github.luisfeliperochamartins.models.*;
import com.github.luisfeliperochamartins.lists.IList;

import java.util.Objects;

public class DoubleLinkedList<T extends Node> implements IList<T> {

	private T head;
	private T tail;

	public DoubleLinkedList() {}

	public DoubleLinkedList(T head, T tail) {
		this.head = head;
		this.tail = tail;
	}


	@Override
	public boolean empty() {
		return head == null;
	}

	@Override
	public void insert(T node) {
		if (!empty()) {
			head.setPrev(node);
			node.setNext(head);
		}
		head = node;
		if (tail == null) {
			tail = node;
		}
	}

	@Override
	public void append(T node) {
		if (tail != null) {
			tail.setNext(node);
			node.setPrev(tail);
		}
		tail = node;
		if (empty()) {
			head = node;
		}
	}

	@Override
	public void append(T... nodes) {

	}

	@Override
	public void deleteById(Integer id) {
		T node = head;

		while (node != null) {
			if (Objects.equals(node.getId(), id)) {
				node.getPrev().setNext(node.getNext());
			}

			node = (T) node.getNext();
		}
	}

	@Override
	public void deleteFirst() {
		if (!empty()) {
			T next = (T) head.getNext();
			next.setPrev(null);
			head = next;
		}
	}

	@Override
	public void deleteLast() {
		if (!empty()) {
			if (tail.getPrev() != null) {
				tail.getPrev().setNext(null);
			}
			tail = (T) tail.getPrev();
		}
	}

	@Override
	public void remove(T node) {
		T currentNode = head;

		while (currentNode != null) {
			if (Objects.equals(currentNode.getId(), node.getId())) {
				currentNode.getPrev().setNext(currentNode.getNext());
			}
			currentNode = (T) currentNode.getNext();
		}
	}

	@Override
	public void removeByPosition(int pos) {
		if (!empty()) {
			if (pos == 0) {
				head = (T) head.getNext();
				return;
			}

			T node = head;
			int count = 0;

			while (node != null) {
				if (count == pos) {
					node.getPrev().setNext(node.getNext());
					if (node == tail) {
						tail = (T) node.getPrev();
					}
				}

				count ++;
				node = (T) node.getNext();
			}
		}
	}

	@Override
	public Integer count() {
		int count = 0;
		T node = head;

		while (node != null) {
			count ++;
			node = (T) node.getNext();
		}
		return count;
	}

	@Override
	public Integer findById(Integer id) {
		if (empty()) {
			return -1;
		}
		T node = head;
		int count = 0;

		while(node != null) {
			if (Objects.equals(node.getId(), id)) {
				return count;
			}
			count ++;
			node = (T) node.getNext();
		}
		return -1;
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

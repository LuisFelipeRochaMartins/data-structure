package com.github.luisfeliperochamartins.lists;

import com.github.luisfeliperochamartins.models.Node;
import com.github.luisfeliperochamartins.lists.IList;

import java.util.Objects;

public class CircularLinkedList<T extends Node> implements IList<T> {

	private T head;
	private T tail;

	public CircularLinkedList() {}

	public CircularLinkedList(T head, T tail) {
		this.head = head;
		this.tail = tail;
	}

	public T getHead() {
		return head;
	}

	public void setHead(T head) {
		this.head = head;
	}

	public T getTail() {
		return tail;
	}

	public void setTail(T tail) {
		this.tail = tail;
	}

	@Override
	public boolean empty() {
		return head == null;
	}

	@Override
	public void insert(T node) {
		if (empty()) {
			head = node;
			head.setNext(head);
			tail = head;
		} else {
			node.setNext(head);
			head = node;
			tail.setNext(head);
		}
	}

	@Override
	public void append(T node) {
		if (empty()) {
			head = node;
			tail = node;
			return;
		}
		T currentNode = head;
		while (currentNode != null) {
			if (currentNode.getNext() == head){
				currentNode.setNext(node);
				node.setNext(head);
				tail = node;
				return;
			}
			currentNode = (T) currentNode.getNext();
		}
	}

	@Override
	public void append(T... nodes) {

	}

	@Override
	public void deleteById(Integer id) {
		if (empty()) {
			return;
		}
		if (Objects.equals(head.getId(), id)) {
			if (head == tail) {
				head = null;
				return;
			}
			head = (T) head.getNext();
			tail.setNext(head);
		}
	}

	@Override
	public void deleteFirst() {
		if (count() != 1) {
			head = (T) head.getNext();
		} else {
			head = null;
		}
	}

	@Override
	public void deleteLast() {
		T currentNode  = head;
		T previousNode = null;
		while(currentNode != null) {
			if (currentNode.getNext() == head) {
				if (count() > 1) {
					previousNode.setNext(head);
				} else {
					head = null;
				}
				return;
			}
			previousNode = currentNode;
			currentNode = (T) currentNode.getNext();
		}
	}

	@Override
	public void remove(T node) {
		T currentNode = head;
		T previousNode = null;
		while (currentNode != null) {
			if (Objects.equals(currentNode, node)) {
				if (count() > 1) {
					previousNode.setNext(currentNode.getNext());
				} else {
					head = null;
				}
				return;
			}

			previousNode = currentNode;
			currentNode = (T) currentNode.getNext();
		}
	}

	@Override
	public void removeByPosition(int pos) {
		T currentNode  = head;
		T previousNode = null;
		int count = 0;
		while (currentNode != null) {
			if (pos > count()) {
				return;
			}
			if (pos == 0) {
				head = null;
				return;
			} else if (count == pos) {
				previousNode.setNext(currentNode.getNext());
				return;
			}
			count ++;
			previousNode = currentNode;
			currentNode = (T) currentNode.getNext();
		}
	}

	@Override
	public Integer count() {
		T currentNode = head;
		Integer count = 1;
		while (currentNode != null) {
			if (currentNode.getNext() == head) {
				break;
			}
			count ++;
			currentNode = (T) currentNode.getNext();
		}
		return count;
	}

	@Override
	public Integer findById(Integer id) {
		if (!empty()) {
			T node = head;
			int count = 0;
			while (node != null) {
				if (Objects.equals(node.getId(), id)) {
					return count;
				}
				count ++;
				node = (T) node.getNext();
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		T node = head;
		StringBuilder sb = new StringBuilder();
		while (node != null ) {
			sb.append(node.getId()).append(" ");
			node = (T) node.getNext();
			if (node == head) {
				break;
			}
		}

		return sb.toString();
	}
}
package com.github.luisfeliperochamartins.lists;

import com.github.luisfeliperochamartins.models.Node;
import com.github.luisfeliperochamartins.models.Client;
import com.github.luisfeliperochamartins.models.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LinkedList<T extends Node> implements IList<T> {

	private T head;
	private List<T> data = new ArrayList<>();

	public LinkedList() {
		head = null;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public boolean empty() {
		return head == null;
	}


	@Override
	public void insert(T node) {
		node.setNext(head);
		head = node;
		data.add(node);
	}

	@Override
	public void append(T node) {
		if (empty()) {
			head = node;
			data.add(node);
			return;
		}

		T currentNode = head;

		while (currentNode.getNext() != null) {
			currentNode = (T) currentNode.getNext();
			data.add(node);
		}
		currentNode.setNext(node);
	}

	@SafeVarargs
	@Override
	public final void append(T... nodes) {
		if (empty()) {
			boolean isFirst = true;
			for(T node : nodes) {
				if (isFirst) {
					head = node;
					isFirst = false;
					data.add(node);
					continue;
				} else {
					T currentNode = head;

					while(currentNode.getNext() != null) {
						currentNode = (T) currentNode.getNext();
					}
					data.add(node);

					currentNode.setNext(node);
				}
			}
		}
	}

	@Override
	public void deleteById(Integer id) {
		if (!empty()) {
			T currentNode = head;
			T previousNode = null;

			if (Objects.equals(currentNode.getId(), id)) {
				head = (T) currentNode.getNext();
				return;
			}

			while (currentNode != null) {
				if (Objects.equals(currentNode.getId(), id)) {
					previousNode.setNext(currentNode.getNext());
					return;
				}
				previousNode = currentNode;
				currentNode = (T) currentNode.getNext();
			}
		}
	}

	@Override
	public void deleteFirst() {
		if (!empty()) {
			T node = head;
			if (node.getNext() != null) {
				head = (T) node.getNext();
			}
		}
	}

	@Override
	public void deleteLast() {
		if (!empty()) {
			T node = head;
			T previousNode = null;

			while (node != null) {
				if (node.getNext() == null) {
					previousNode.setNext(null);
				}
				previousNode = node;
				node = (T) node.getNext();
			}
		}
	}

	@Override
	public void remove(T node) {
		T currentNode = head;
		T previousNode = null;

		if (currentNode.equals(node)) {
			head = (T) currentNode.getNext();
			return;
		}

		while(currentNode != null) {
			if (currentNode.equals(node)) {
				previousNode.setNext(currentNode.getNext());
				return;
			}

			previousNode = currentNode;
			currentNode = (T) currentNode.getNext();
		}
	}

	@Override
	public void removeByPosition(int pos) {
		int counter = 0;

		T currentNode = (T) head;
		while(currentNode != null) {
			if (counter == pos) {
				remove(currentNode);
			}
			counter ++;
			currentNode = (T) currentNode.getNext();
		}
	}

	@Override
	public Integer count() {
		if (!empty()) {
			int counter = 0;
			T node = head;
			while (node != null) {
				node = (T) node.getNext();
				counter ++;
			}
			return counter;
		}
		return 0;
	}

	@Override
	public Integer findById(Integer id) {
		if (!empty()) {
			T node = head;
			Integer counter = 0;
			while (node != null) {
				if (Objects.equals(node.getId(), id)) {
					return counter;
				}
				counter ++;
				node = (T) node.getNext();
			}
		}
		return -1;
	}

	public void allocateClientToTable(Client client) {
		Table currentNode = (Table) head;

		while (currentNode != null) {
			if (currentNode.getClient() == null) {
				currentNode.setClient(client);
				return;
			}
			currentNode = (Table) currentNode.getNext();
		}
	}

	public String checkOccupiedTables() {
		Table currentNode = (Table) head;

		int occupiedTables = 0;
		int notOccupiedTables = 0;

		while (currentNode != null) {
			if (currentNode.getClient() != null) {
				occupiedTables ++;
			} else {
				notOccupiedTables ++;
			}

			currentNode = (Table) currentNode.getNext();
		}

		return "Mesas Ocupadas: " + occupiedTables + ", Mesas não Ocupadas: " + notOccupiedTables;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		T node = head;
		while (node != null) {
			sb.append(node.toString());
			node = (T) node.getNext();
		}
		return sb.toString();
	}
}

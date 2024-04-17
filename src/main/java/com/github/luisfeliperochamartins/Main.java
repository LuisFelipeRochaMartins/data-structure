package com.github.luisfeliperochamartins;

import com.github.luisfeliperochamartins.lists.LinkedList;
import com.github.luisfeliperochamartins.models.Employee;

public class Main {
	public static void main(String[] args) {
		LinkedList<Employee> list = new LinkedList<>();

		Employee employee1 = new Employee(1, "Luís", "Cozinheiro", "8:30 - 17:18");
		Employee employee2 = new Employee(2, "Marcos", "Limpeza", "8:30 - 17:18");

		list.append(employee1, employee2);

		System.out.println(list);
	}
}

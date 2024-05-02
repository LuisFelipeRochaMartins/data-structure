package com.github.luisfeliperochamartins;

import com.github.luisfeliperochamartins.lists.LinkedList;
import com.github.luisfeliperochamartins.models.*;

import javax.sound.sampled.Line;

public class Fluxo {

	public static void main(String[] args) {
		LinkedList<Table> tables = new LinkedList<>();
		LinkedList<Client> clients = new LinkedList<>();
		LinkedList<Client> caixa = new LinkedList<>();

		Table table1 = new Table(1, null, null);
		Table table2 = new Table(2, null, null);

		var client1 = new Client(1, "Luís");
		var client2 = new Client(2, "Felipe");
		var client3 = new Client(3, "João");

		var employee1 = new Employee(1, "Pedro", EmployeeType.GARCOM, "10:00 - 14:00");
		var employee2 = new Employee(2, "Pedro", EmployeeType.COZINHEIRO, "10:00 - 14:00");
		var employee3 = new Employee(3, "Pedro", EmployeeType.CAIXA, "10:00 - 14:00");

		tables.append(table1, table2);
		clients.append(client1, client2, client3);

		employee1.welcomeCustomer(tables, clients);

		client1.addNewOrder(new Order(1, "Pastel", 8.99F));
		client2.addNewOrder(new Order(2, "Coxinha", 5.99F));

		employee1.createNewOrders(tables);

		employee2.prepareOrders(employee1.getOrders());

		employee1.deliverOrder(employee1.getOrders());

		System.out.println("Pessoas Esperando na Fila para almoçar: " + clients.count());
		System.out.println("Pessoas esperando na Fila do Caixa: " + caixa.count());
		System.out.println("Pessoas Comendo no Restaurante: " + tables.peopleEating());
		System.out.println("Número total de pessoas que comeram no Restaurante:" + caixa.getData().size());
		System.out.println(tables.checkOccupiedTables());
	}
}

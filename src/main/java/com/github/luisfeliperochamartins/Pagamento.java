package com.github.luisfeliperochamartins;

import com.github.luisfeliperochamartins.lists.LinkedList;
import com.github.luisfeliperochamartins.models.Bill;
import com.github.luisfeliperochamartins.models.Client;
import com.github.luisfeliperochamartins.models.Order;

import java.util.Scanner;

public class Pagamento {
	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		LinkedList<Bill> bills = new LinkedList<>();
		var client = new Client(1, "Luís");

		var order1  = new Order(1, "Carbonara", 34.99F);
		var order2  = new Order(2, "Pizza", 14.95F);

		client.addNewOrder(order1, order2);
		float totalCost = 0F;

		for (Order order : client.getOrders()) {
			totalCost += order.getPrice();
		}

		paymentMethod(totalCost);

		Bill bill = new Bill(1, null, totalCost, client);
		bills.append(bill);

		emitirComprovante(bill);
		System.out.println(bills.getData());
	}

	private static void paymentMethod(float valor) {
		System.out.println("Qual o Método de Pagamento?\n" +
				"1 - Dinheiro\n" +
				"2 - Cartão de Débito\n" +
				"3 - Cartão de Crédito");
		int option = input.nextInt();
		input.nextLine();

		switch (option) {
			case 2:
			case 3:
				System.out.println("Insera ou aproxime o cartão para realizar o Pagamento");
				try {
					Thread.sleep(1750);
					System.out.println("Transação Aprovada");
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				break;

			default:
				System.out.print("Informe o valor: ");
				float dinheiro = input.nextFloat();
				if (dinheiro < valor) {
					do {
						System.out.println("Valor não suficiente, informe um valor maior ou igual à: " + valor);
						dinheiro = input.nextFloat();
					} while (dinheiro < valor);
				}
				System.out.println("Aqui está seu troco: " + (dinheiro - valor));
				break;
		}
	}

	public static void emitirComprovante(Bill... bills) {
		for (Bill bill : bills ) {
			System.out.println("COMPROVANTE DE PAGAMENTO");
			System.out.println("Nome Cliente: " + bill.getClient().getName() + "VALOR DA CONTA: " + bill.getPrice());
		}
	}
}

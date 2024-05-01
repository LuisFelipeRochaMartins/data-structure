import org.junit.jupiter.api.Test;

import com.github.luisfeliperochamartins.lists.LinkedList;
import com.github.luisfeliperochamartins.models.Client;

public class ClientTest {

	@Test
	void addClientToLinkedList() {
		LinkedList<Client> list = new LinkedList<>();

		Client client1 = new Client(1, "Luís");
		Client client2 = new Client(2, "Carol");
		Client client3 = new Client(3, "Marcos");
		Client client4 = new Client(4, "João");

		list.append(client1, client2, client3, client4);
		client1.setName("Felipe");

		System.out.println("Quatro clientes foram adicionados a Listas Encadeada");
		System.out.println(list);
	}

	@Test
	void removeClient() {
		LinkedList<Client> list = new LinkedList<>();

		Client client1 = new Client(1, "Luís");
		Client client2 = new Client(2, "Carol");

		list.append(client1, client2);

		list.remove(client1);

		System.out.println("Removido o primeiro cliente!");
		System.out.println(list);
	}

	@Test
	void updateClient() {
		LinkedList<Client> list = new LinkedList<>();

		var client1 = new Client(1, "Luís");
		var client2 = new Client(2, "Carol");

		list.append(client1, client2);

		client1.setName("João");

		System.out.println("Como pode ser visto logo abaixo o nome do cliente foi alterado!");
		System.out.println(list);
	}

	@Test
	void showAllClientsRegistered() {
		LinkedList<Client> list = new LinkedList<>();

		var client1 = new Client(1, "Luís");
		var client2 = new Client(2, "Carol");
		var client3 = new Client(3, "Marcos");
		var client4 = new Client(4, "João");

		list.append(client1, client2, client3, client4);

		//Removendo clientes
		list.remove(client1);
		list.remove(client3);

		System.out.println("Mostrando todos os Clientes até mesmo os que foram excluídos");
		System.out.println(list.getData());
	}
}

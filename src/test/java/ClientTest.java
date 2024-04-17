import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
		System.out.println(list.print());
		assertEquals(4, list.count());
	}

	@Test
	void removeClient() {
		LinkedList<Client> list = new LinkedList<>();

		Client client1 = new Client(1, "Luís");
		Client client2 = new Client(2, "Carol");

		list.append(client1, client2);

		list.remove(client1);

		System.out.println("Removido o primeiro cliente!");
		System.out.println(list.print());

		assertEquals(1, list.count());
	}

	@Test
	void updateClient() {
		LinkedList<Client> list = new LinkedList<Client>();

		Client client1 = new Client(1, "Luís");
		Client client2 = new Client(2, "Carol");

		list.append(client1, client2);

		client1.setName("Curvello");
		list.change(client1);

		System.out.println("Como pode ser visto logo abaixo o nome do cliente foi alterado!");
		System.out.println(list.print());
		assertTrue(true);
	}

	@Test
	void showAllClientsRegistered() {
		LinkedList<Client> list = new LinkedList<>();

		Client client1 = new Client(1, "Luís");
		Client client2 = new Client(2, "Carol");
		Client client3 = new Client(3, "Marcos");
		Client client4 = new Client(4, "João");

		list.append(client1, client2, client3, client4);

		//Removendo clientes
		list.remove(client1);
		list.remove(client3);

		System.out.println("Mostrando todos os Clientes até mesmo os que foram excluídos");
		System.out.println(list.getData());
	}
}

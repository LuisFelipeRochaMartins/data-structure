import com.github.luisfeliperochamartins.lists.LinkedList;
import com.github.luisfeliperochamartins.models.Client;
import com.github.luisfeliperochamartins.models.Order;
import org.junit.jupiter.api.Test;

public class OrderTest {

	@Test
	void addNewOrders() {
		LinkedList<Order> orders = new LinkedList<>();

		var order1 = new Order("Carbonara" , 34.99F);
		var order2 = new Order("Pizza" , 14.95F);

		orders.append(order1, order2);
		System.out.println(orders);
	}

	@Test
	void changeOrders() {
		LinkedList<Order> orders = new LinkedList<>();

		var order1 = new Order("Carbonara" , 34.99F);
		var order2 = new Order("Pizza" , 14.95F);

		orders.append(order1, order2);

		order2.setName("Focaccia");
		order2.setPrice(9.99F);

		System.out.println(orders);
	}

	@Test
	void cancelOrder() {
		LinkedList<Order> orders = new LinkedList<>();
		Client client = new Client(1, "Luís");

		var order1 = new Order("Carbonara" , 34.99F);
		var order2 = new Order("Pizza" , 14.95F);
		orders.append(order1, order2);

		orders.remove(order1);
		System.out.println(orders);
	}

	@Test
	void checkAllOrders() {
		LinkedList<Order> orders = new LinkedList<>();

		var order1 = new Order("Carbonara" , 34.99F);
		var order2 = new Order("Pizza" , 14.95F);

		orders.append(order1, order2);

		orders.remove(order1);
		orders.remove(order2);

		System.out.println(orders.getData());
	}
}

import com.github.luisfeliperochamartins.lists.LinkedList;
import com.github.luisfeliperochamartins.models.Client;
import com.github.luisfeliperochamartins.models.Table;
import org.junit.jupiter.api.Test;

public class TableTest {

	@Test
	public void allocateClientToTables() {
		LinkedList<Table> tables = new LinkedList<>();
		LinkedList<Client> clients = new LinkedList<>();

		Table table1 = new Table(1, null, null);
		Table table2 = new Table(2, null, null);
		Table table3 = new Table(3, null, null);

		Client client1 = new Client(1, "Luís");
		Client client2 = new Client(1, "Carol");

		tables.append(table1, table2, table3);
		clients.append(client1, client2);

		tables.allocateClientToTable(client1);
		System.out.println(tables.checkOccupiedTables());
	}

	@Test
	public void checkOccupiedTables() {
		LinkedList<Table> tables = new LinkedList<>();

		Table table1 = new Table(1, null, null);
		Table table2 = new Table(2, null, null);
		Table table3 = new Table(3, null, null);

		tables.append(table1, table2, table3);
		tables.checkOccupiedTables();
	}
}

import com.github.luisfeliperochamartins.lists.LinkedList;
import com.github.luisfeliperochamartins.models.Employee;
import com.github.luisfeliperochamartins.models.EmployeeType;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

	@Test
	void addEmployee() {
		LinkedList<Employee> employees = new LinkedList<>();

		Employee employee1 = new Employee(1, "Luís", EmployeeType.COZINHEIRO, "10:00 - 13:00");
		Employee employee2 = new Employee(2, "Carol", EmployeeType.FAZINEIRO, "09:00 - 13:00");
		Employee employee3 = new Employee(3, "Felipe", EmployeeType.GARCOM, "10:00 - 13:00");

		employees.append(employee1, employee2, employee3);
		System.out.println(employees);
	}

	@Test
	void removeEmployee() {
		LinkedList<Employee> employees = new LinkedList<>();

		Employee employee1 = new Employee(1, "Luís", EmployeeType.COZINHEIRO, "10:00 - 13:00");
		Employee employee2 = new Employee(2, "Carol", EmployeeType.FAZINEIRO, "09:00 - 13:00");
		Employee employee3 = new Employee(3, "Felipe", EmployeeType.GARCOM, "10:00 - 13:00");

		employees.append(employee1, employee2, employee3);
		employees.remove(employee2);

		System.out.println(employees);
	}

	@Test
	void getAllEmployee() {
		LinkedList<Employee> employees = new LinkedList<>();

		Employee employee1 = new Employee(1, "Luís", EmployeeType.COZINHEIRO, "10:00 - 13:00");
		Employee employee2 = new Employee(2, "Carol", EmployeeType.FAZINEIRO, "09:00 - 13:00");
		Employee employee3 = new Employee(3, "Felipe", EmployeeType.GARCOM, "10:00 - 13:00");

		employees.append(employee1, employee2, employee3);

		System.out.println(employees.getData());
	}
}

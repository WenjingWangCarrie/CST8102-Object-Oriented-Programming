import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonTester {

	public static void main(String[] args) {
		List<Person> person = new ArrayList<Person>();

		person.add(new Person("aaa", "bbb", 1));
		person.add(new Person("xyz", "abc", 2));
		person.add(new Person("kyj", "lmn", 3));

		System.out.println("Before sorting: (firstName, lastName, age)");

		for (Person p : person) {
			System.out.println(p);
		}

		System.out.println("After sorting: firstName");
		Collections.sort(person, new PersonFirstNameComparator());
		for (Person p : person) {
			System.out.println(p);
		}

		System.out.println("After sorting: lastName");
		Collections.sort(person, new PersonLastNameComparator());
		for (Person p : person) {
			System.out.println(p);
		}

		System.out.println("After sorting: age");
		Collections.sort(person, new PersonAgeComparator());
		for (Person p : person) {
			System.out.println(p);
		}

	}

}

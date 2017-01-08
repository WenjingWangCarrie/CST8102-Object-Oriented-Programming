import java.util.Comparator;

public class PersonFirstNameComparator implements Comparator<Person> {

	public int compare(Person p1, Person p2) {

		return p1.getFirstName().compareTo(p2.getFirstName());

	}

}

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {

	public int compare(Person p1, Person p2) {

		int ages = 0;
		ages = p1.getAge() - p2.getAge();
		return ages;

		// return Integer.valueOf(p1.getAge()).compareTo(p2.getAge());

	}

}
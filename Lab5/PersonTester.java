
public class PersonTester {

	public static void main(String[] args) {
		Person person1 = new Person("a1", "b1", "c1", 11);
		Person person2 = new Person(new Name("a2", "b2", "c2"), 22);
		Person person3 = new Person(new Name("a3", "c3"), 33);
		Person person4 = new Person(new Name("a4"), 44);
		Person person5 = new Person(new Name(), 55);

		System.out.println(person1.details());
		System.out.println(person2.details());
		System.out.println(person3.details());
		System.out.println(person4.details());
		System.out.println(person5.details());
	}

}


public class PersonTester {

	public static void main(String[] args) {

		try {
			Person p = new Person();
			// System.out.println("Test run1: null");
			// p.setFullName(null); // null

			// System.out.println("Test run2: empty string");
			// p.setFullName(""); // empty String

			// System.out.println("Test run3: whitespace only");
			// p.setFullName(" "); // white space

			// System.out.println("Test run4: length > 20");
			// p.setFullName("12345678901234567890tuna"); // length > 20

			System.out.println("Test run5: contains comma");
			p.setFullName("fish, tuna"); // contains comma

		} catch (FullNameException ex) {

			System.out.println(ex.getMessage());

		}
	}

}

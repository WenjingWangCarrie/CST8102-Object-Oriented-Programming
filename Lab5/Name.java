
public class Name {
	private String first;
	private String middle;
	private String last;

	public Name(String f, String m, String l) {
		first = f;
		middle = m;
		last = l;
	}

	public Name(String f, String l) {
		first = f;
		middle = "unknown";
		last = l;
	}

	public Name(String f) {
		first = f;
		middle = "unknown";
		last = "unknown";
	}

	public Name() {
		first = "unknown";
		middle = "unknown";
		last = "unknown";
	}

	public String getFirst() {
		return first;
	}

	public String getMiddle() {
		return middle;
	}

	public String last() {
		return last;
	}

	public String getFullName() {
		StringBuilder sb = new StringBuilder();
		sb.append(first + " ").append(middle + " ").append(last);

		return sb.toString();

	}

}

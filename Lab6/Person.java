
public class Person {
	private String fullName;

	public Person() {
		this.fullName = "unknown";
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) throws FullNameException {
		this.fullName = fullName;
		validateData(fullName);
	}

	private void validateData(String data) throws FullNameException {
		if (fullName == null) {
			throw new FullNameException("The String cannot be null");
		}
		if (fullName.length() == 0) {
			throw new FullNameException("The String cannot have a length of zero");
		}

		if (fullName.equals(" ")) {
			throw new FullNameException("The String cannot consist of only white space");
		}

		if (fullName.length() > 20) {
			throw new FullNameException("The String cannot have a length exceeding 20 characters");
		}

		if (fullName.contains(",")) {
			throw new FullNameException("The String cannot contain a comma");
		}
	}
}

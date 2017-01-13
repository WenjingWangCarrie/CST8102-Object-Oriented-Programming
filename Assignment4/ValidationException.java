
public class ValidationException extends Exception {

	public ValidationException() {
		super("There was a problem when validating data");
	}

	public ValidationException(String message) {
		super(message);
	}

	public ValidationException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public ValidationException(Throwable throwable) {
		super(throwable);
	}
}

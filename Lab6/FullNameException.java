import java.lang.Exception;

public class FullNameException extends Exception {

	public FullNameException() {
		super("Full name not correct format");
	}

	public FullNameException(String para) {
		super(para);
	}

	public FullNameException(String para, Throwable th) {
		super(para, th);
	}

	public FullNameException(Throwable th) {
		super(th);
	}
}

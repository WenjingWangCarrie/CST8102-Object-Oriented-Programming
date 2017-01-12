public class Task {

	private String title;
	private String priority;
	private boolean isComplete;

	public Task() {
		title = "No title";
		priority = "No priority";
	}

	public Task(String title, String priority) throws ValidationException {
		setTitle(title);
		setPriority(priority);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) throws ValidationException {

		if (title == null) {
			throw new ValidationException("Title cannot be null");
		} else if (title.trim() == "") {
			throw new ValidationException("Title cannot be empty string");
		} else if (title.length() > 25) {
			throw new ValidationException("Title cannot exceed 25 characters");
		} else {
			this.title = title.trim();
		}

	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) throws ValidationException {

		if (priority == null) {
			throw new ValidationException("Priority cannot be null");
		} else if (priority.trim() == "") {
			throw new ValidationException("Priority cannot be empty string");
		} else if (!(priority.toLowerCase().equals("high") || priority.toLowerCase().equals("medium")
				|| priority.toLowerCase().equals("low"))) {
			throw new ValidationException("Priority must be high, medium, or low");
		} else {
			this.priority = priority.trim();
		}
	}

	public boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(boolean isComplete) {

		this.isComplete = isComplete;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (isComplete) {
			 sb.append(" " + title)
			.append(" (" + priority + ") ")
			.append("is complete");
		} else {
			sb.append(" " + title)
			.append(" (" + priority + ") ")
			.append("is not complete");
		}
		
		return sb.toString();
	}

}

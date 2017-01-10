import java.util.Scanner;

public class Event {
	private OurDate date;
	private String description;
	private Scanner sc = new Scanner(System.in);

	public Event() {
		date = new OurDate();
		description = new String();
	}

	public Event(OurDate date, String description) {
		setDate(date);
		setDescription();
	}

	public Event(int day, int month, int year, String description) {
		setDate(day, month, year);
		setDescription();
	}

	public OurDate getDate() {
		return date;
	}

	public void setDate(OurDate date) {
		this.date = new OurDate(date);
	}

	public void setDate(int day, int month, int year) {
		this.date = new OurDate(day, month, year);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription() {
		System.out.println("Enter event description: ");
		description = sc.nextLine();

		if (description == null) {
			System.out.println("Nothing entered, please do it again.");
			description = sc.nextLine();
		}

	}

	public String toString() {
		return "    " + getDate().toString() + " - " + getDescription();

	}

}

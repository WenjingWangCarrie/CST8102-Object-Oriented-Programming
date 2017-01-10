import java.util.Scanner;

public class Planner {
	private static int MAXEVENTS = 10;
	private Event[] events;
	private int numEvents;
	private OurDate date;
	private Scanner sc = new Scanner(System.in);

	public Planner() {
		events = new Event[MAXEVENTS];

		for (int i = 0; i < MAXEVENTS; i++) {
			this.events[i] = null;
		}

		numEvents = 0;
		date = new OurDate();
	}

	public void runMenu() {
		boolean done = false;
		int option = 0;

		while (!done) {
			System.out.println("Make a selection: ");
			System.out.println("1. Add event for a day");
			System.out.println("2. Display event for a day");
			System.out.println("3. Display events for a week");
			System.out.println("4. Delete an event");
			System.out.println("0 to quit: ");
			option = sc.nextInt();

			switch (option) {
			case 1:
				addEvent();
				break;

			case 2:
				System.out.println("Enter date to display");
				enterDate();
				displayOneDay();
				break;

			case 3:
				System.out.println("Enter starting date to display");
				enterDate();
				displaySevenDays();
				break;

			case 4:
				System.out.println("Enter date to delete event from: ");
				enterDate();
				deleteEvent();
				break;

			case 0:
				System.out.println("Quit");
				done = true;
				break;

			default:
				System.out.println("Invalid option, please try again");
				System.out.println();
				break;

			}
		}

		System.out.println();
	}

	public void addEvent() {

		if (numEvents > MAXEVENTS) {
			System.out.println("Events out of bounds, cannot add events");
		} else {
			String description = null;

			System.out.println("Enter event date: ");
			enterDate();

			for (int i = 0; i < numEvents; i++) {
				if (events[i].getDate().isEqual(date)) {
					System.out.println("You already have an activity for that date and time...cannot be entered");
					return;
				}
			}
			events[numEvents] = new Event(date, description); // very important!!!
			numEvents++;
		}

	}

	public void enterDate() {
		date.setYear();
		date.setMonth();
		date.setDay();
	}

	public void displayOneDay() {

		if (numEvents == 0) {
			System.out.println("Nothing to display.");
		} else {
			System.out.println("Your events for " + date.toString() + " are: \n");

			for (int i = 0; i < numEvents; i++) {
				Event event = events[i];
				if (event.getDate().isEqual(date)) {
					System.out.println(event.toString());
					return;
				}
			}
			System.out.println();
		}

	}

	public void displaySevenDays() {
		if (numEvents == 0) {
			System.out.println("Nothing to display.");
		} else {

			for (int i = 0; i < 7; i++) {
				displayOneDay();
				date.addOne();

			}
			System.out.println();
		}

	}

	public void deleteEvent() {
		if (numEvents == 0) {
			System.out.println("Nothing to delete");
		} else {

			for (int i = 0; i < numEvents; i++) {
				Event ev = events[i];

				if (ev.getDate().isEqual(date)) {

					events[i] = events[i + 1];
					events[numEvents - 1] = null;

					System.out.println("Successfully removed");

					numEvents--;
					break;
				}
			}
		}
		System.out.println();
	}

}

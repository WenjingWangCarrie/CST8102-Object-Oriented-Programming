import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ToDoListManager {
	private static final int ADD_TASK = 1;
	private static final int TOGGLE_TASK = 2;
	private static final int REMOVE_TASK = 3;
	private static final int VIEW_TASKS = 4;
	private static final int EXIT = 5;
	private ArrayList<Task> tasks = null;
	private Scanner input = null;

	public ToDoListManager() {
		tasks = new ArrayList<Task>();

		for (int i = 0; i < tasks.size(); i++) {
			tasks.add(null);
		}

		input = new Scanner(System.in);
	}

	public void runToDoList() {
		boolean done = false;
		int option = -1;

		// while loop first, then try-catch
		while (!done) {
			try {
				showMenu();
				option = input.nextInt();
				input.nextLine();

				switch (option) {
				case ADD_TASK:
					addTask();
					break;

				case TOGGLE_TASK:
					toggleTaskComplete();
					break;

				case REMOVE_TASK:
					removeTask();
					break;

				case VIEW_TASKS:
					viewTasks();
					break;

				case EXIT:
					System.out.println("Quit");
					done = true;
					break;

				default:
					System.out.println("Invalid option, please try again.");
					break;
				}
			} catch (InputMismatchException e) {
				System.err.println("Please enter integer numbers for menu selection");
				input.nextLine();
			}

		}
	}

	private void showMenu() {
		System.out.println(ADD_TASK + " to add a task");
		System.out.println(TOGGLE_TASK + " to toggle a task's is completed");
		System.out.println(REMOVE_TASK + " to remove a task");
		System.out.println(VIEW_TASKS + " to view all tasks");
		System.out.println(EXIT + " to exit program");
	}

	private void addTask() {
		try {
			System.out.println("Please enter task title");
			System.out.println("(Title cannot be empty, max 25 characters)");
			String title = input.nextLine();
			System.out.println("Please enter task priority (high, medium, low)");
			String priority = input.nextLine();

			Task task = new Task(title, priority);

			tasks.add(task);
		} catch (ValidationException e) {
			System.err.println("Error to add a task! Please try again");
			System.err.println(e.getMessage());
		}

	}

	private void toggleTaskComplete() {
		if (tasks.size() == 0) {
			System.out.println("Nothing to toggle, no tasks");
		} else {

			try {
				System.out.println("Please enter index number of task to toggle complete / incomplete");
				int index = input.nextInt();
				input.nextLine();

				Task task = tasks.get(index);
				task.setIsComplete(!task.getIsComplete());

			} catch (InputMismatchException e) {
				System.err.println("Could not toggle task complete");
				System.err.println("Please enter only integers for index\nPlease try again");
				input.nextLine();

			} catch (IndexOutOfBoundsException e) {
				System.err.println("Could not toggle task complete");
				System.err.println("Please enter a valid index 0 to " + (tasks.size() - 1));
				input.nextLine();
			}

		}

	}

	private void removeTask() {
		if (tasks.size() == 0) {
			System.out.println("Nothing to remove, no tasks");
		} else {

			try {
				System.out.println("Please enter index number of task to remove");
				int index = input.nextInt();

				input.nextLine();
				tasks.remove(index); // ArrayList can invoke method remove() directly;


			} catch (InputMismatchException e) {
				System.err.println("Could not remove task");
				System.err.println("Enter only integers for index\nPlease try again");
				input.nextLine();

			} catch (IndexOutOfBoundsException e) {
				System.err.println("Could not remove task");
				System.err.println("Please enter a valid index 0 to " + (tasks.size() - 1));
				input.nextLine();
			}
		}

	}

	private void viewTasks() {
		if (tasks.size() == 0) {
			System.out.println("Nothing to show, no tasks");
		} else {
			for (int i = 0; i < tasks.size(); i++) {
				Task task = tasks.get(i);

				System.out.println("index: " + i + task.toString());
			}

		}

	}
}

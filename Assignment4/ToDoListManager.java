import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ToDoListManager {
	private static final int ADD_TASK = 1;
	private static final int TOGGLE_TASK = 2;
	private static final int REMOVE_TASK = 3;
	private static final int VIEW_TASKS = 4;
	private static final int SAVE_TASKS = 5;
	private static final int LOAD_TASKS = 6;
	private static final int SORT_BY_TITLE = 7;
	private static final int SORT_BY_PRIORITY = 8;
	private static final int SORT_BY_ISCOMPlETE = 9;
	private static final int EXIT = 10;

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
		int option = 0;

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

				case SAVE_TASKS:
					saveTasks();
					break;

				case LOAD_TASKS:
					loadTasks();
					break;

				case SORT_BY_TITLE:
					sortByTitle();
					break;

				case SORT_BY_PRIORITY:
					sortByPriority();
					break;

				case SORT_BY_ISCOMPlETE:
					sortByIsComplete();
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
		System.out.println(SAVE_TASKS + " to save tasks to file");
		System.out.println(LOAD_TASKS + " to load tasks from file");
		System.out.println(SORT_BY_TITLE + " to sort tasks by title");
		System.out.println(SORT_BY_PRIORITY + " to sort tasks by priority");
		System.out.println(SORT_BY_ISCOMPlETE + " to sort tasks by is-complete");
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
				tasks.remove(index); // ArrayList can invoke method remove()
										// directly;

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

	private void saveTasks() {
		if (tasks.size() == 0) {
			System.out.println("No tasks to save");
		} else {

			try {
				Formatter format = null;
				FileWriter fw = new FileWriter(new File("Tasks.txt"));
				format = new Formatter(fw);

				for (Task t : tasks) {
					fw.write(t + " \n");
					format.format("%s%n", t.createTabRecord());

				}

				format.flush(); // Very important !!!
				format.close(); // Very important !!!

				System.out.println("Saved " + tasks.size() + " records to file Tasks.txt");
			} catch (FileNotFoundException ex) {
				System.err.println("File not found" + ex.getMessage());
			}

			catch (IOException e) {
				System.err.println("");
				e.printStackTrace();
			}
		}

	}

	private void loadTasks() {
		File file = new File("Tasks.txt");

		if (file.exists()) {
			tasks.clear();
			BufferedReader reader = null;

			try {
				String line = null;
				reader = new BufferedReader(new FileReader(file));

				while ((line = reader.readLine()) != null) {
					String[] segments = line.split("\t");
					if (segments.length == 3) {
						try {
							Task task = new Task(segments[0], segments[1], Boolean.parseBoolean(segments[2]));
							tasks.add(task);
						} catch (ValidationException e) {
							System.err.printf("There was a problem loading a task: %s\n", e.getMessage());
						}
					}
				}

				System.out.printf("Loaded %d records from file %s\n", tasks.size(), file);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						// ignored
					}
				}
			}
			
		} else {
			System.out.printf("File not found %s (The system cannot find the file specified)\n", file);
		}
	}

	private void sortByTitle() {
		if (tasks.size() == 0) {
			System.out.println("Nothing to sort");
		} else {
			Collections.sort(tasks, new TaskTitleComparator());
			System.out.println("Successfully sort!");
		}

	}

	private void sortByPriority() {
		if (tasks.size() == 0) {
			System.out.println("Nothing to sort");
		} else {
			Collections.sort(tasks, new TaskPriotityComparator());
			System.out.println("Successfully sort!");
		}
	}

	private void sortByIsComplete() {
		if (tasks.size() == 0) {
			System.out.println("Nothing to sort");
		} else {
			Collections.sort(tasks, new TaskIsCompleteComparator());
			System.out.println("Successfully sort!");
		}
	}
}

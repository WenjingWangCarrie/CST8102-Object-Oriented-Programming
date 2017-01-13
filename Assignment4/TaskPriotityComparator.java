import java.util.Comparator;

public class TaskPriotityComparator implements Comparator<Task> {

	public int compare(Task o1, Task o2) {
		return o1.getPriority().compareTo(o2.getPriority());
	}

}

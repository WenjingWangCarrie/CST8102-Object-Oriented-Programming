import java.util.Comparator;

public class TaskTitleComparator implements Comparator<Task> {

	public int compare(Task o1, Task o2) {
		return o1.getTitle().compareTo(o2.getTitle());
	}

}

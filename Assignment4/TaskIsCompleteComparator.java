import java.util.Comparator;

public class TaskIsCompleteComparator implements Comparator<Task> {

	public int compare(Task o1, Task o2) {
		return Boolean.valueOf(o1.getIsComplete()).compareTo(o2.getIsComplete());
	}

}

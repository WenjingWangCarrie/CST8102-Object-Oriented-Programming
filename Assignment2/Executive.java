import java.util.Scanner;

public class Executive extends Employee {
	private double salary;
	private Scanner sc = new Scanner(System.in);

	public Executive() {
		salary = 0.0;
	}

	public Executive(String name, OurDate startDate) {
		this(name, startDate, 0.0);
	}

	public Executive(String name, OurDate startDate, double salary) {
		super(name, startDate);
		setSalary();
	}

	@Override
	public double calculatePay() {
		return salary / 52;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + getSalary();
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary() {
		do {
			System.out.println("Salary: ");
			salary = sc.nextDouble();
		} while (salary < 0);

	}

}

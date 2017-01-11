import java.util.Scanner;

public class Programmer extends Employee {
	private double hourWorked;
	private double rateOfPay;
	private Scanner sc = new Scanner(System.in);

	public Programmer() {
		hourWorked = 0.0;
		rateOfPay = 0.0;
	}

	public Programmer(String name, OurDate startDate) {
		this(name, startDate, 0.0, 0.0);
	}

	public Programmer(String name, OurDate startDate, double hourWorked, double rateOfPay) {
		super(name, startDate);
		setHourWorked();
		setRateOfPay();
	}

	@Override
	public double calculatePay() {
		return hourWorked * rateOfPay;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + getHourWorked() + " - " + getRateOfPay();
	}

	public double getHourWorked() {
		return hourWorked;
	}

	public void setHourWorked() {
		do {
			System.out.println("Total Hours Worked: ");
			hourWorked = sc.nextDouble();
		} while (hourWorked < 0);

	}

	public double getRateOfPay() {
		return rateOfPay;
	}

	public void setRateOfPay() {
		do {
			System.out.println("Hourly Wage: ");
			rateOfPay = sc.nextDouble();
		} while (rateOfPay < 0);

	}

}

import java.util.Scanner;

public class SaleRep extends Employee {
	private double saleAmount;
	private double commissionRate;
	private Scanner sc = new Scanner(System.in);

	public SaleRep() {
		saleAmount = 0.0;
		commissionRate = 0.0;
	}

	public SaleRep(String name, OurDate startDate) {
		this(name, startDate, 0.0, 0.0);
	}

	public SaleRep(String name, OurDate startDate, double saleAmount, double commissionRate) {
		super(name, startDate);
		setSaleAmount();
		setCommissionRate();
	}

	@Override
	public double calculatePay() {
		return saleAmount * commissionRate;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + getSaleAmount() + " - " + getCommissionRate();

	}

	public double getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount() {
		do {
			System.out.println("Total Sales: ");
			saleAmount = sc.nextDouble();
		} while (saleAmount < 0);

	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate() {
		do {
			System.out.println("Commission Rate: ");
			commissionRate = sc.nextDouble();
		} while (commissionRate < 0 || commissionRate > 1);

	}

}

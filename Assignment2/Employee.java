
public abstract class Employee {
	private String name;
	private OurDate startDate;
	private double taxableIncome;
	protected double netPay;
	private double tax;

	public Employee() {
		name = new String();
		startDate = new OurDate();
		taxableIncome = 0.0;
		netPay = 0.0;
		tax = 0.0;
	}

	public Employee(String name, OurDate startDate) {
		setName(name);
		setStartDate(startDate);
	}

	public Employee(String name, int day, int month, int year) {
		setName(name);
		setStartDate(day, month, year);
	}

	public String toString() {
		return "Name: " + getName() + "\tDate of Hire: " + startDate.toString();

	}

	/**
	 * An abstract method with concrete implementations in each of the subclass.
	 * 
	 * @return
	 */
	public abstract double calculatePay();

	public double calculateTax() {
		double baseIncome = getTaxableIncome();
		tax = 0.0;

		if (baseIncome > 200000) {
			tax += (baseIncome - 200000) * 0.33;
			baseIncome = 200000;
		}
		if (baseIncome > 140388) {
			tax += (baseIncome - 140388) * 0.29;
			baseIncome = 140388;
		}
		if (baseIncome > 90563) {
			tax += (baseIncome - 90563) * 0.26;
			baseIncome = 90563;
		}
		if (baseIncome > 45282) {
			tax += (baseIncome - 45282) * 0.205;
			baseIncome = 45282;
		}
		tax += baseIncome * 0.15;

		netPay = getTaxableIncome() - tax;

		return tax;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public OurDate getStartDate() {
		return startDate;
	}

	public void setStartDate(OurDate startDate) {

		this.startDate = startDate;
	}

	public void setStartDate(int day, int month, int year) {
		this.startDate = new OurDate(day, month, year);
	}

	public double getTaxableIncome() {
		return taxableIncome;
	}

	public void setTaxableIncome(double taxableIncome) {
		this.taxableIncome = taxableIncome;
	}

	public double getGrossPay() {
		return calculatePay() * 52;
	}

	public double getTax() {
		return tax;
	}

}

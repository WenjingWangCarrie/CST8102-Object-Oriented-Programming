import java.util.Scanner;

public class Company {
	private Employee[] employees;
	private static final int MAXNUMEMPLOYEES = 10;
	private int totalEmployees;
	private OurDate startDate = null;

	public Company() {
		this.employees = new Employee[MAXNUMEMPLOYEES];

		for (int i = 0; i < totalEmployees; i++) {
			this.employees[i] = null;
		}

		this.totalEmployees = 0;
		startDate = new OurDate();
	}

	public void menu() {
		int option = 0;
		boolean done = false;
		Scanner sc = new Scanner(System.in);

		while (!done) {
			System.out.println("1. Add employee");
			System.out.println("2. Print Payroll");
			System.out.println("3. Print Employee List");
			System.out.println("4. Print the name of the employee employeed the longest");
			System.out.println("0. Quit");

			System.out.println("Selection -> ");
			option = sc.nextInt();

			switch (option) {
			case 1:
				addEmployee();
				break;

			case 2:
				calculatePayroll();
				break;

			case 3:
				printEmployeeList();
				break;

			case 4:
				findLongestEmployee();
				break;

			case 0:
				System.out.println("Quit");
				done = true;
				break;

			default:
				System.out.println("Invalid option, please try again");
				break;
			}
		}
	}

	public void addEmployee() {
		if (totalEmployees == MAXNUMEMPLOYEES) {
			System.out.println("Employees out of range, cannot add.");
		} else {
			System.out.println("Enter new Employee Information: ");

			String name = enterName();
			startDate = enterDate();

			int option = 0;
			Employee e = null;
			Scanner sc = new Scanner(System.in);

			System.out.println("What kind of employee: ");
			System.out.println("1. Executive ");
			System.out.println("2. Sales Rep ");
			System.out.println("3. Programmer ");

			option = sc.nextInt();

			switch (option) {
			case 1:
				double salary = 0.0;
				e = new Executive(name, startDate, salary);// Encapsulation --
															// variables in the
															// ()
				break;

			case 2:
				double commissionRate = 0.0;
				double saleAmount = 0.0;
				e = new SaleRep(name, startDate, commissionRate, saleAmount);
				break;

			case 3:
				double rateOfpay = 0.0;
				double hours = 0.0;
				e = new Programmer(name, startDate, rateOfpay, hours);
				break;

			default:
				System.out.println("Invalid option, please try again");
				option = sc.nextInt();
				break;
			}

			employees[totalEmployees] = e;
			totalEmployees++;

		}
	}

	private String enterName() {
		String name = null;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Name: ");
			name = sc.nextLine();
		} while (name == null);

		return name;
	}

	private OurDate enterDate() {
		System.out.println("Hiring Date: ");
		startDate.setYear(startDate.getYear());
		startDate.setMonth(startDate.getMonth());
		startDate.setDay(startDate.getDay());

		return startDate;
	}

	public void printEmployeeList() {
		if (totalEmployees == 0) {
			System.out.println("There are no employees");
		} else {

			for (int i = 0; i < totalEmployees; i++) {
				Employee employee = employees[i];

				System.out.println(employee.toString());
			}
		}

	}

	public void calculatePayroll() {
		if (totalEmployees == 0) {
			System.out.println("There are no employees");
		} else {
			double totalPayRoll = 0.0;

			for (int i = 0; i < totalEmployees; i++) {
				Employee employee = employees[i];
				double weekly = employee.calculatePay();
				totalPayRoll += weekly;

				if (employee instanceof Executive) {
					Executive exe = (Executive) employee; // Polymorphism
					System.out.printf("Name: %s \tWeek Total: %.2f \tSalary: %.2f\n", employee.getName(), weekly,
							exe.getSalary());
				} else if (employee instanceof SaleRep) {
					SaleRep sale = (SaleRep) employee;
					System.out.printf("Name: %s \tWeek Total: %.2f \tSales Amount: %.2f \tCommission Rate: %.2f\n",
							employee.getName(), weekly, sale.getSaleAmount(), sale.getCommissionRate());
				} else if (employee instanceof Programmer) {
					Programmer pro = (Programmer) employee;
					System.out.printf("Name: %s \tWeek Total: %.2f \tHours Worked: %.2f \tHourly Wage: %.2f\n",
							employee.getName(), weekly, pro.getHourWorked(), pro.getRateOfPay());
				}

			}
			System.out.printf("TOTAL PAYROLL: %.2f\n", totalPayRoll);
		}

	}

	public void findLongestEmployee() {
		if (totalEmployees == 0) {
			System.out.println("There are no employees");
		} else {

			Employee em = null;
			int maxDays = 0;

			for (int i = 0; i < totalEmployees; i++) {
				Employee temp = employees[i];
				int hiredDays = temp.getStartDate().calDays(startDate);
				if (hiredDays > maxDays) {
					em = temp;
					maxDays = hiredDays;
				}

			}

			OurDate start = em.getStartDate();
			int years = startDate.getYear() - start.getYear();
			int days = startDate.calDays(startDate) - start.calDays(start);

			System.out.println("Employee employed for the longest is " + em.getName() + " for " + years + " years "
					+ days + " days");
		}
	}
}

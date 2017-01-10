import java.util.Scanner;

public class OurDate {
	private int day;
	private int month;
	private int year;
	private Scanner sc = new Scanner(System.in);

	public OurDate() {
		day = 1;
		month = 1;
		year = 2000;
	}

	public OurDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public OurDate(OurDate date) {
		this.day = date.getDay();
		this.month = date.getMonth();
		this.year = date.getYear();
	}

	public int getDay() {
		return day;
	}

	public void setDay() {
		do {
			System.out.println("Enter day: ");
			day = sc.nextInt();

		} while (day > 31 || day <= 0);

	}

	public int getMonth() {
		return month;
	}

	public void setMonth() {
		do {
			System.out.println("Enter month: ");
			month = sc.nextInt();

		} while (month > 12 || month <= 0);

	}

	public int getYear() {
		return year;
	}

	public void setYear() {
		do {
			System.out.println("Enter year: ");
			year = sc.nextInt();

		} while (year < 2000);

	}

	public boolean isEqual(OurDate date) {

		if (day == date.day && month == date.month && year == date.year)
			return true;
		else
			return false;
	}

	public void addOne() {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			if (day == 31 && month == 12) {
				year++;
				day = 1;
				month = 1;
			} else if (day == 31) {
				day = 1;
				month++;
			} else
				day++;

		} else if (month == 2) {
			if (isLeapYear(year)) { // 29 days
				day++;
				if (day == 30) {
					day = 1;
					month++;
				}

			} else if (day == 28) {
				day = 1;
				month++;
			} else
				day++;

		} else {
			if (day == 30) {
				day = 1;
				month++;
			} else
				day++;

		}
	}

	public String toString() {
		return year + "/" + month + "/" + day;
	}

	public int calDays(OurDate date) {
		int totalDays = 365 * (date.getYear() - 2000) + 12 * month + day;

		if (isLeapYear(year))
			totalDays++;

		return totalDays;

	}

	public boolean isLeapYear(int year) {
		if ((year % 400 == 0) || (year % 4 == 0) && (year % 100 != 0))
			return true;
		else
			return false;

	}

}

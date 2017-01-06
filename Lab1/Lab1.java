import java.util.Scanner;

public class Lab1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calculator calculate = new Calculator();
		int option;
		boolean done = false;

		while (!done) {

			System.out.println("Please enter an option: ");
			System.out.println("1 Addition");
			System.out.println("2 Substarction");
			System.out.println("3 Multiplication");
			System.out.println("4 Division");
			System.out.println("0 Quit");
			option = sc.nextInt();

			switch (option) {
			case 1:
				calculate.add();
				break;

			case 2:
				calculate.substract();
				break;

			case 3:
				calculate.multiply();
				break;

			case 4:
				calculate.divide();
				break;

			case 0:
				System.out.println("Quit");
				done = true;
				break;

			default:
				System.out.println("Invalid option, pleaase try again.");
				break;
			}

		}
	}

}

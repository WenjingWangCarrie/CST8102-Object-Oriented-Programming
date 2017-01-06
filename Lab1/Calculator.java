import java.util.Scanner;

public class Calculator {

	private Scanner sc = new Scanner(System.in);
	private double num1, num2, result;

	public void add() {
		System.out.println("Please enter number 1: ");
		num1 = sc.nextDouble();
		System.out.println("Please enter number 2: ");
		num2 = sc.nextDouble();

		result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " is " + result);
		System.out.println();
	}

	public void substract() {
		System.out.println("Please enter number 1: ");
		num1 = sc.nextDouble();
		System.out.println("Please enter number 2: ");
		num2 = sc.nextDouble();

		result = num1 - num2;
		System.out.println(num1 + " - " + num2 + " is " + result);
		System.out.println();
	}

	public void multiply() {
		System.out.println("Please enter number 1: ");
		num1 = sc.nextDouble();
		System.out.println("Please enter number 2: ");
		num2 = sc.nextDouble();

		result = num1 * num2;
		System.out.println(num1 + " * " + num2 + " is " + result);
		System.out.println();

	}

	public void divide() {
		System.out.println("Please enter number 1: ");
		num1 = sc.nextDouble();
		System.out.println("Please enter number 2: ");
		num2 = sc.nextDouble();

		result = num1 / num2;
		System.out.println(num1 + " / " + num2 + " is " + result);
		System.out.println();
	}
}

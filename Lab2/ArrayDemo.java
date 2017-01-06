public class ArrayDemo {

	public void demonstrateTask1() {

		System.out.println("Demonstrate Task 1");

		int[] numbers = null;
		numbers = new int[5];

		System.out.println("Array of primitives before assigning values");

		for (int i = 0; i < 5; i++) {
			System.out.print(0 + " ");
		}

		System.out.println("\nArray of primitives after assigning values");

		for (int i = 1; i <= 5; i++) {
			System.out.print(i + " ");
		}

	}

	public void demonstrateTask2() {

		System.out.println("\n\nDemonstrate Task 2");

		Goldfish[] fishes = new Goldfish[5];

		System.out.println("\nArray of references before assigning references");

		for (int i = 0; i < 5; i++) {
			System.out.print(null + " ");
		}

		System.out.println("\nArray of references after assigning references to Goldfish");

		for (double i = 1; i <= 5; i++) {
			System.out.print(i + " ");
		}

	}

	public void demonstrateTask3() {

		System.out.println("\nDemonstrate Task 3");

		int[][] numbers = new int[5][5];

		System.out.println("\n2D Array of primitives before assigning values");

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print(0 + " ");
			}
			System.out.println();
		}

		System.out.println("\n2D Array of primitives after assigning values");

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print(j * i + " ");
			}

			System.out.println();
		}
	}

	public void demonstrateTask4() {

		System.out.println("Demonstrate Task 4");

		Goldfish[][] fishes = new Goldfish[5][5];

		System.out.println("\n2D Array of references before assigning references");

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(null + " ");
			}
			System.out.println();
		}

		System.out.println("\n2D Array of references after assigning references to Goldfish");

		for (double i = 1; i <= 5; i++) {
			for (double j = 1; j <= 5; j++) {
				System.out.print(j * i + " ");
			}
			System.out.println();
		}

	}

}
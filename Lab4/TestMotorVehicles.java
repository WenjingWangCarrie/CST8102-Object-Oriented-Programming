
public class TestMotorVehicles {

	public static void main(String[] args) {
		MotorVehicle mv1 = new MotorVehicle(); // OPPORTUNITY FOR BONUS MARKS
		System.out.println(mv1);
		System.out.println();

		MotorVehicle mv2 = new Car();
		System.out.println(mv2);
		System.out.println();

		MotorVehicle mv3 = new Car("SampleData1", 125, 2);
		System.out.println(mv3);
		System.out.println();

		MotorVehicle mv4 = new Truck();
		System.out.println(mv4);
		System.out.println();

		MotorVehicle mv5 = new Truck("SampleData2", 95, 12000);
		System.out.println(mv5);
		System.out.println();

	}

}

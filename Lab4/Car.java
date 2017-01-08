
public class Car extends MotorVehicle {

	private int trunkCapacity;

	public Car() {
		this("UnknownCar", 100, 1);
		System.out.println("Returning from default Car constructor");
	}

	public Car(String manufacture, int topSpeed, int trunk) {
		super(manufacture, topSpeed);
		trunkCapacity = trunk;
		System.out.println("Returning from overload Car constructor");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(" trunkCapacity: " + trunkCapacity);
		return sb.toString();
	}
}

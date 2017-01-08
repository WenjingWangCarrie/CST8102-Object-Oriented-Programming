
public class Truck extends MotorVehicle {

	private int towingCapacity;

	public Truck() {
		this("UnknownTruck", 95, 100);
		System.out.println("Returning from default Truck constructor");
	}

	public Truck(String manufacture, int topSpeed, int towing) {
		super(manufacture, topSpeed);
		towingCapacity = towing;
		System.out.println("Returning from overload Truck constructor");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(" towingCapacity: " + towingCapacity);
		return sb.toString();
	}

}

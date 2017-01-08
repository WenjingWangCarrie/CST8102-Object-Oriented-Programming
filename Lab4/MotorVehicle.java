
public class MotorVehicle {

	private String manufacture;
	private int topSpeed;

	public MotorVehicle() {
		this("UnknownMotorVehicle", 0);
		System.out.println("Returning from default MotorVehicle constructor");
	}

	public MotorVehicle(String m, int t) {
		manufacture = m;
		topSpeed = t;
		System.out.println("Returning from overload MotorVehicle constructor");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(" manufacture: " + manufacture);
		sb.append(" topSpeed: " + topSpeed);
		return sb.toString();
	}

}

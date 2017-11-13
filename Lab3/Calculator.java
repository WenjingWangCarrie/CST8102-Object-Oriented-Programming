public class Calculator {
	private double accumulator;

	public Calculator() {	}
	
	public Calculator(double initialValue) { accumulator = initialValue; }

	public void add(double number) { accumulator += number; }
	public void subtract(double number) { accumulator -= number; }
	public void multiply(double number) { accumulator *= number; }
	public void divide(double number) { accumulator /= number; }
	public void sqrt() { accumulator = Math.sqrt(accumulator); }
	
	public void setAccumlator(double accumulator)
		 { this.accumulator = accumulator; }
	public double getAccumulator() { return accumulator; }
	
	@Override
	public String toString() { return "Result:" + accumulator; }
}

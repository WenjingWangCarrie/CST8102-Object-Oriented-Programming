import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
	@Test
	public void testAdd() {
		final double INITIAL_VALUE = 25.5;
		Calculator calculator = new Calculator(INITIAL_VALUE); // Pre-condition: Calculator object exists
		assertEquals(INITIAL_VALUE, calculator.getAccumulator(), 0.0);// Pre-condition: Accumulator starts with known value 
		final double CHANGE_IN_VALUE = -10.0;
		calculator.add(CHANGE_IN_VALUE);
		assertEquals(INITIAL_VALUE + CHANGE_IN_VALUE, calculator.getAccumulator(), 0.0); // Post-condition: result matches expectation with 0.0 variation (the "delta")
		System.err.println("testAdd:"+calculator); // using err stream to show output in "red" as a highlight that this is testing.
	} // end testAdd()
	
	@Test
	public void testDivideByZeroPositive() {
		final double INITIAL_VALUE = 123.4;
		Calculator calculator = new Calculator(INITIAL_VALUE); // Pre-condition: Accumulator starts with known value
		assertEquals(INITIAL_VALUE, calculator.getAccumulator(), 0.0); 
		calculator.divide(0.0);
		assertEquals(Double.POSITIVE_INFINITY, calculator.getAccumulator(), 0.0); // Post-condition: Accumulator contains divide-by-zero result: Double.POSITIVE_INFINITY 
		System.err.println("testDivideByZero:"+calculator); // using err stream to show output in "red" as a highlight that this is testing.
	} // end testDivideByZero()

	@Test
	public void testDivideByZeroNegative() {
		final double INITIAL_VALUE = -123.4;
		Calculator calculator = new Calculator(INITIAL_VALUE); // Pre-condition: Accumulator starts with known value
		assertEquals(INITIAL_VALUE, calculator.getAccumulator(), 0.0); 
		calculator.divide(0.0);
		assertEquals(Double.NEGATIVE_INFINITY, calculator.getAccumulator(), 0.0); // Post-condition: Accumulator contains divide-by-zero result: Double.POSITIVE_INFINITY 
		System.err.println("testDivideByZero:"+calculator); // using err stream to show output in "red" as a highlight that this is testing.
	} // end testDivideByZero()

	@Test
	public void testDivideBySelf() {
		final double INITIAL_VALUE = 25.5;
		Calculator calculator = new Calculator(INITIAL_VALUE); // Pre-condition: Accumulator starts with known value
		assertEquals(INITIAL_VALUE, calculator.getAccumulator(), 0.0);
		calculator.divide(INITIAL_VALUE);
		assertEquals(1.0, calculator.getAccumulator(), 0.0); // Post-condition: Accumulator contains 1.0 with 0.0 variation (0.0 is the "delta") 
		System.err.println("testDivideBySelf:"+calculator); // using err stream to show output in "red" as a highlight that this is testing.
	} // end testDivideBySelf()

	@Test
	public void testMultiplyOverFlow() {
		Calculator calculator = new Calculator(Double.MAX_VALUE); // Pre-condition: Accumulator starts with maximum possible double value
		System.err.println("testMultiplyOverflow:INITIAL_VALUE:BEFORE:Double.MAX_VALUE:"+calculator); // using err stream to show output in "red" as a highlight that this is testing.
		calculator.multiply(Double.MAX_VALUE);
		assertEquals(Double.POSITIVE_INFINITY, calculator.getAccumulator(), 0.0); // Post-condition: Accumulator contains overflow result: Double.POSITIVE_INFINITY
		System.err.println("testMultiplyOverflow:AFTER:"+calculator); // using err stream to show output in "red" as a highlight that this is testing.
	} // end testMultiply()
	
	@Test
	public void testSqrtPositive() {
		final double INITIAL_VALUE = 25.0; // perfect square
		Calculator calculator = new Calculator(INITIAL_VALUE); // Pre-condition: Accumulator starts with known value
		calculator.sqrt();
		assertEquals(5.0, calculator.getAccumulator(), 0.0); // Post-condition: Accumulator contains square root with 0.0 variation (0.0 is the "delta")
		System.err.println("testSqrtPositive:"+calculator); // using err stream to show output in "red" as a highlight that this is testing.
	} // end testSqrtPositive()

	@Test
	public void testSqrtNegative() {
		final double INITIAL_VALUE = -25.0; // not a square
		Calculator calculator = new Calculator(INITIAL_VALUE); // Pre-condition: Accumulator starts with known value that violates sqrt() rules.
		calculator.sqrt(); // would result in an "imaginary" number, also called a complex number, which cannot be handled by type "double"
		assertEquals(Double.NaN, calculator.getAccumulator(), 0.0); // Post-condition: Accumulator contains not-a-number constant Double.NaN
		System.err.println("testSqrtNegative:"+calculator); // using err stream to show output in "red" as a highlight that this is testing.
	} // end testSqrtNegative()
} // end class CalculatorTest
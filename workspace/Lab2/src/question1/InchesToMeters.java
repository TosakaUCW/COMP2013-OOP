package question1;
import java.util.Scanner;

public class InchesToMeters {
	public static void main(String[] args) {
		System.out.print("Input a value for inches: ");
		Scanner input = new Scanner(System.in);
		double inch = input.nextDouble();
		
        // Convert inches to meters (1 inch = 0.0254 meters)
		double meter = 0.0254 * inch;
		
		// Print out answer
		System.out.println(inch + " inches is " + meter + " meters");

        // Close the scanner
		input.close();
	}
}

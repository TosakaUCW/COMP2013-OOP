package question2;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input an integer between 0 and 1000: ");
        int n = scanner.nextInt();

        // Calculate the answer of the digits
        int ans = 0;
        int x = n;
        while (x > 0) {
            ans += x % 10;
            x /= 10;
        }

        // Print out the result
        System.out.println("The ans of all digits in " + n + " is " + ans);

        // Close the scanner
        scanner.close();
    }
}
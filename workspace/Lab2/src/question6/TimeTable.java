package question6;

public class TimeTable {
    public static void main(String[] args) {
        System.out.print("* |"); // Header
        for (int i = 1; i <= 9; i++) {
            System.out.print(String.format("%4d", i));
        }
        System.out.println();
        System.out.println("---------------------------------------");

        // Print each row
        for (int i = 1; i <= 9; i++) {
            System.out.print(String.format("%-2d|", i));
            for (int j = 1; j <= 9; j++) {
                System.out.print(String.format("%4d", i * j));
            }
            System.out.println(); // next row
        }
    }
}

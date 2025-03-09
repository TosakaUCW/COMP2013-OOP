package question1;

public class Code {

    // Tests
    public static void testCode() {
        // Test for the first constructor,the default values both should be false.
        Code code1 = new Code();
        System.out.println(code1.compile() == false);
        System.out.println(code1.run() == false);
        
        // Test for the second constructor,set the values
        Code code2 = new Code(true, false, 100);
        System.out.println(code2.compile() == true);
        System.out.println(code2.run() == false);
        System.out.println(code2.countLines() == 100);

        // Test Debug.
        code2.debug();

        // Then code should can both compile and run.
        System.out.println(code2.compile() == true);
        System.out.println(code2.run() == true);
        
        // Test Coding & countLines
        code2.coding(15);
        System.out.println(code2.countLines() == 15);
    }
}
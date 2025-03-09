package question1;

public class Assignment {

    // Tests
    public static void testAssignment() {
        // Test for the constructor
        Code code0 = new Code();
        Assignment a0 = new Assignment(code0, false, "xiaoyu");
        System.out.println(a0.getName() == "xiaoyu");
        System.out.println(a0.isSubmitted() == false);

        // Test for code
        // the default code can not be run
        System.out.println(a0.getCode().run() == false);

        // Test for submit
        a0.submit();
        System.out.println(a0.isSubmitted() == true);

        // Test for score
        a0.setScore(15);
        System.out.println(a0.getScore() == 15);
    }
}

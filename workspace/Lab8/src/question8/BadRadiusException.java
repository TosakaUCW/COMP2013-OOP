package question8;

public class BadRadiusException extends Exception{
    public BadRadiusException(String message) {
        super(message);
    }
    // The BadRadiusException class is not abstract (it has code for all methods) so
    // we can test it.
    public static void testBadRadiusException() {
        BadRadiusException ex = new BadRadiusException("Bad radius!");
        System.out.println(ex.getMessage().equals("Bad radius!"));
    }
}
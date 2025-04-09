package question6;

// The CannotResizeException class derives from the Exception class.
public class CannotResizeException extends Exception {
    // The constructor initializes the message.
    public CannotResizeException(String message) {
        super(message);
    }
    // The CannotResizeException class is not abstract (it has code for all methods) so
    // we can test it.
    public static void testCannotResizeException() {
        CannotResizeException ex = new CannotResizeException("Cannot resize a dot!");
        System.out.println(ex.getMessage().equals("Cannot resize a dot!"));
    }
}
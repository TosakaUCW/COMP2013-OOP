package question1;

import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        // Set the window size
        setSize(400, 300);

        // Set the title (commented out later for testing)
        setTitle("My Window");

        // Default close operation (commented out later for testing)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Make the window visible (commented out later for testing)
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}

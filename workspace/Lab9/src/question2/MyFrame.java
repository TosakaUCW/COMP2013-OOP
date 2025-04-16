package question2;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {

    public MyFrame() {
        // Set the window size
        setSize(400, 300);

        // Set the title (commented out later for testing)
        setTitle("My Window");

        // Set a layout manager (FlowLayout) with custom gaps
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

        // Create two buttons with different text
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        // Add the buttons to the frame
        add(button1);
        add(button2);
		// add(button1);

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

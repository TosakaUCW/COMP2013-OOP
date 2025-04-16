package question3;

import java.awt.FlowLayout;
import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        // Set the window size
        setSize(400, 300);

        // Set the title (commented out later for testing)
        setTitle("My Window");

        // Set a layout manager (FlowLayout) with custom gaps
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));
        
        JLabel l = new JLabel("Enter your name: ");
        add(l);
        JTextField tx = new JTextField("Type Text Here");
        add(tx);
        JCheckBox cb = new JCheckBox("I agree");
        add(cb);
        JRadioButton rb = new JRadioButton("Yes");
        add(rb);
        JComboBox<String> cb1 = new JComboBox<String>(new String[]{"Red", "Green", "Blue"});
        add(cb1);
        JComboBox<Integer> cb2 = new JComboBox<Integer>(new Integer[]{2, 7, -3, 24});
        add(cb2);
        
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

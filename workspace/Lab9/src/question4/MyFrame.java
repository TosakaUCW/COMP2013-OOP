package question4;

import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        // Set the window size
        setSize(400, 300);

        // Set the title (commented out later for testing)
        setTitle("My Window");

        // Set a layout manager (GridLayout) with 5 rows and 5 columns
        // setLayout(new GridLayout(5, 5));
        
        // Set the BorderLayout manager
        setLayout(new BorderLayout());
        
        // JLabel l = new JLabel("Enter your name: ");
        // add(l);
        // JTextField tx = new JTextField("Type Text Here");
        // add(tx);
        // JCheckBox cb = new JCheckBox("I agree");
        // add(cb);
        // JRadioButton rb = new JRadioButton("Yes");
        // add(rb);
        // JComboBox<String> cb1 = new JComboBox<String>(new String[]{"Red", "Green", "Blue"});
        // add(cb1);
        // JComboBox<Integer> cb2 = new JComboBox<Integer>(new Integer[]{2, 7, -3, 24});
        // add(cb2);
        
        // // Add more components to fill the grid if necessary
        // add(new JButton("Button 1"));
        // add(new JButton("Button 2"));
        // add(new JButton("Button 3"));
        // add(new JButton("Button 4"));
        // add(new JButton("Button 5"));
        
        // Create and add components with specific areas in the BorderLayout
        JLabel l = new JLabel("Enter your name: ");
        add(l, BorderLayout.PAGE_START);

        JTextField tx = new JTextField("Type Text Here");
        add(tx, BorderLayout.CENTER);

        JCheckBox cb = new JCheckBox("I agree");
        add(cb, BorderLayout.LINE_START);

        JRadioButton rb = new JRadioButton("Yes");
        add(rb, BorderLayout.LINE_END);

        JComboBox<String> cb1 = new JComboBox<String>(new String[]{"Red", "Green", "Blue"});
        add(cb1, BorderLayout.PAGE_END);

        JComboBox<Integer> cb2 = new JComboBox<Integer>(new Integer[]{2, 7, -3, 24});
        add(cb2, BorderLayout.CENTER); // Default area: CENTER
        
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

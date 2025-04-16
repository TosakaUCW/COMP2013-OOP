package question5;

import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        // Set the window size
        setSize(400, 300);

        // Set the frame layout to BorderLayout
        setLayout(new BorderLayout());

        // First JPanel (BorderLayout for buttons)
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setBackground(Color.BLUE); // Set background color
        // Add buttons to the panel
        panel1.add(new JButton("B1"), BorderLayout.LINE_START);
        panel1.add(new JButton("B2"), BorderLayout.LINE_END);

        // Second JPanel (FlowLayout for label and text field)
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel2.setBackground(Color.GREEN); // Set background color
        // Add a label and text field
        panel2.add(new JLabel("Enter your name: "));
        panel2.add(new JTextField("Type Text Here", 20));
        

        // Third JPanel (GridLayout for checkbox, radio button, and combo boxes)
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(2, 2)); // 2x2 grid layout
        panel3.setBackground(Color.WHITE); // Set background color

        // Add components to the panel
        panel3.add(new JCheckBox("I agree"));
        panel3.add(new JRadioButton("Yes"));
        panel3.add(new JComboBox<>(new String[]{"Red", "Green", "Blue"}));
        panel3.add(new JComboBox<>(new Integer[]{2, 7, -3, 24}));

        // Add the three panels to the frame using BorderLayout
        add(panel1, BorderLayout.PAGE_START); // Panel with buttons
        add(panel2, BorderLayout.CENTER);     // Panel with label and text field
        add(panel3, BorderLayout.PAGE_END);   // Panel with checkboxes, radio button, combo boxes

        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the window visible
        setVisible(true);

        // Center the frame on the screen
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Create the frame instance
        new MyFrame();
    }
}

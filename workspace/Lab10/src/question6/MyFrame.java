package question6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        super("MyFrame Title");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // center panel instance (we’ll need a reference to call clearAllPoints)
        MyPanel center = new MyPanel();
        add(center, BorderLayout.CENTER);

        // top panel with Reset and Undo buttons
        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton resetBtn = new JButton("Reset");
        JButton undoBtn = new JButton("Undo");

        // Reset clears all points
        resetBtn.addActionListener(e -> center.clearAllPoints());
        // Undo removes the last point
        undoBtn.addActionListener(e -> center.undoPoint());

        top.add(resetBtn);
        top.add(undoBtn);
        add(top, BorderLayout.NORTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

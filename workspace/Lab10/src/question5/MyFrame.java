package question5;

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

        // top panel with two buttons in a centered FlowLayout
        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton resetBtn = new JButton("Reset");        // first button renamed
        JButton rightBtn = new JButton("right");        // second button unchanged

        // add anonymous listener to resetBtn
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                center.clearAllPoints();
            }
        });

        top.add(resetBtn);
        top.add(rightBtn);
        add(top, BorderLayout.NORTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

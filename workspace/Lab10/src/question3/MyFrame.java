package question3;

import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        super("MyFrame Title");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // top panel with two buttons in a centered FlowLayout
        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        top.add(new JButton("left"));
        top.add(new JButton("right"));
        add(top, BorderLayout.NORTH);

        // center panel
        add(new MyPanel(), BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

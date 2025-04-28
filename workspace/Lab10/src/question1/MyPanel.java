package question1;

import java.awt.event.*;
import javax.swing.*;

class MyPanel extends JPanel {

    public MyPanel() {
        // listen for mouse clicks on the panel
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // only respond to left‐button clicks
                if (e.getButton() == MouseEvent.BUTTON1) {
                    int x = e.getX();
                    int y = e.getY();
                    System.out.println(
                            "Left mouse button clicked at (" + x + ", " + y + ")"
                    );
                }
            }
        });
    }
}

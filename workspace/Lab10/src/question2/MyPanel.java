package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyPanel extends JPanel {

    private int x = -1;
    private int y = -1;

    public MyPanel() {
        // listen for mouse clicks on the panel
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // only respond to left‐button clicks
                if (e.getButton() == MouseEvent.BUTTON1) {
                    x = e.getX();
                    y = e.getY();
                    System.out.println(
                            "Left mouse button clicked at (" + x + ", " + y + ")"
                    );
                    
                    // Trigger a repaint to update the panel with the new coordinates
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Ensure the panel is properly cleared before drawing

        // If x and y are valid (not -1, -1), draw a red square (1x1 pixel) at that position
        if (x != -1 && y != -1) {
            g.setColor(Color.RED);
            g.fillRect(x, y, 1, 1);  // Draw a red square (1x1)
        }
    }
}

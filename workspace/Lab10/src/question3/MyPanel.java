package question3;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

class MyPanel extends JPanel {

    private ArrayList<Point> points;

    public MyPanel() {
        points = new ArrayList<>();
        // listen for mouse clicks on the panel
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // only respond to left‐button clicks
                if (e.getButton() == MouseEvent.BUTTON1) {
                    Point p = e.getPoint();
                    points.add(p);
                    System.out.println("Left mouse button clicked at (" + p.x + ", " + p.y + ")");

                    // Trigger a repaint to update the panel with the new coordinates
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Ensure the panel is properly cleared before drawing

        // Draw all points stored in the list
        g.setColor(Color.RED);
        for (Point p : points) {
            // Cast the Point coordinates to int to use for drawing
            g.fillRect((int) p.getX(), (int) p.getY(), 1, 1);  // Draw a red square (1x1)
        }
    }
}

package question6;

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
                    points.add(e.getPoint());
                    System.out.println("Clicked at " + e.getPoint());
                    repaint();
                }
            }
        });
    }

    // public method to clear all points and repaint immediately
    public void clearAllPoints() {
        points.clear();
        repaint();
    }

    // Undoes the last point addition
    public void undoPoint() {
        if (!points.isEmpty()) {
            points.remove(points.size() - 1);
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Ensure the panel is properly cleared before drawing

        int n = points.size();
        g.setColor(Color.RED);

        if (n == 1) {
            // Only one point: draw it as before
            Point p = points.get(0);
            g.fillRect(p.x, p.y, 1, 1);
        } else if (n > 1) {
            // Multiple points: draw lines between successive points
            for (int i = 0; i < n - 1; i++) {
                Point p1 = points.get(i);
                Point p2 = points.get(i + 1);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }
}

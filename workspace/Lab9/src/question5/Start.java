package question5;

import javax.swing.SwingUtilities;

public class Start {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create a MyFrame object
                new MyFrame();
                // Create a MyFrame object
                // new MyFrame();
            }
        });
    }
}

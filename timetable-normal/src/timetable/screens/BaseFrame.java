package timetable.screens;

import javax.swing.*;
import java.awt.*;

/**
 * Used as the base template for the main frame, can be reused for other components by extending the base frame and overriding
 * the createComponents method with the components you want to render. Can be further decoupled by separating the title
 * and configurations into a daa file.
 */
public abstract class BaseFrame extends JFrame {

    /**
     * Create the components on the frame
     */
    public abstract void createComponents();

    /**
     * Initialize the frame with some pre-defined configurations, and show the
     */
    public BaseFrame() {
        // set title and layout
        setTitle("Timetable Management System T3G3");
        setLayout(new BorderLayout());

        // create components
        createComponents();

        // Frame configuration
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setResizable(false);
        setVisible(true);
    }
}

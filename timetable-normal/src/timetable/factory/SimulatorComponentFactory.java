package timetable.factory;

import timetable.utility.ImageUtils;

import javax.swing.*;
import java.awt.*;

public class SimulatorComponentFactory implements AbstractComponentFactory {

    private SimulatorComponentFactory() {
    }

    // Singleton factory
    private static SimulatorComponentFactory INSTANCE = null;

    public static SimulatorComponentFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (SimulatorComponentFactory.class) {
                if (INSTANCE == null) // check again within synchronized block to guard for race condition
                    INSTANCE = new SimulatorComponentFactory();
            }
        }
        return INSTANCE;
    }

    @Override
    public JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setBackground(Color.decode("#F8F8F8"));
        button.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        button.setForeground(Color.black);
        return button;
    }

    @Override
    public JLabel createLabel(String label) {
        JLabel title = new JLabel(label);
        title.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 15));
        title.setForeground(Color.black);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        return title;
    }

    @Override
    public JButton createIconButton(String path) {
        ImageUtils imageUtils = new ImageUtils();

        JButton button = new JButton(imageUtils.getScaledImageIcon(getClass().getResource(path), 180, 180));
        button.setBackground(Color.decode("#F8F8F8"));
        return button;
    }

    public JLabel createImageLabel(String path, int x, int y) {
        ImageIcon image = new ImageIcon(getClass().getResource(path));
        JLabel imageLabel = new JLabel(image);
        Dimension size = imageLabel.getPreferredSize();
        imageLabel.setBounds(0, 0, size.width, size.height);
        return imageLabel;
    }

    public JLabel createImageLabel(String path, int x, int y, int w, int h) {
        ImageUtils imageUtils = new ImageUtils();

        ImageIcon image = imageUtils.getScaledImageIcon(getClass().getResource(path), w, h);
        JLabel imageLabel = new JLabel(image);
        Dimension size = imageLabel.getPreferredSize();
        imageLabel.setBounds(x, y, size.width, size.height);
        return imageLabel;
    }
}

package timetable.components;

import timetable.factory.SimulatorComponentFactory;

import javax.swing.*;
import java.awt.*;

/**
 * Title to describe the simulator.
 */
public class NavPanel extends JPanel {

    /**
     * Initialize the title with white background
     */
    public NavPanel(String active) {
        super();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel logo = SimulatorComponentFactory.getInstance().createImageLabel("/images/logo.png",
                0, 0, 150, 150);
        add(logo, gbc);

        // buttons panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        JPanel buttonsPanel = new MenuButtonsPanel(active);
        add(buttonsPanel, gbc);

        setBackground(Color.white);
    }
}

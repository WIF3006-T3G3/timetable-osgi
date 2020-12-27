package timetable.screens;

import timetable.Main;
import timetable.components.MyTimetablePanel;
import timetable.components.NavPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Simulator frame inherits the base frame configuration with all the parent components for the simulator.
 */
public class MyTimetableFrame extends BaseFrame {

    @Override
    public void createComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        // nav bar
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 5, 20, 5);
        JPanel navPanel = new NavPanel("timetable");
        mainPanel.add(navPanel, gbc);

        // main content
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 5, 20, 5);
        JPanel timetablePanel = new MyTimetablePanel();
        mainPanel.add(timetablePanel, gbc);

        add(new JScrollPane(mainPanel), BorderLayout.CENTER);
        mainPanel.setBackground(Color.white);
        setBackground(Color.white);
    }
}

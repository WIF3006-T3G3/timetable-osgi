package timetable.components;

import timetable.constants.Events;
import timetabledto.Course;
import timetable.factory.SimulatorComponentFactory;

import javax.swing.*;
import java.awt.*;

public class CourseCard extends JPanel {

    public CourseCard(Course course, boolean add) {
        super();
        // layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(SimulatorComponentFactory.getInstance().createLabel(course.getCode()), gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        gbc.insets = new Insets(0, 50, 0, 0);
        JButton button = SimulatorComponentFactory.getInstance().createButton(add ? "Add" : "Remove");
        button.setBackground(Color.decode("#D13838"));
        button.setForeground(Color.white);
        if (add) {
            button.addActionListener((evt) -> {
                // fire event to add course
                firePropertyChange(Events.ADD_COURSE, null, course);
            });
        } else {
            button.addActionListener((evt) -> {
                // fire event to remove course
                firePropertyChange(Events.REMOVE_COURSE, null, course);
            });
        }
        add(button, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(SimulatorComponentFactory.getInstance().createLabel("Time: " + course.getStart() + " - " + course.getEnd()), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(SimulatorComponentFactory.getInstance().createLabel("Venue: " + course.getLocation()), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 50, 0, 0);
        add(SimulatorComponentFactory.getInstance().createLabel("Lecturer: " + course.getLecturerCode()), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(SimulatorComponentFactory.getInstance().createLabel("Group: " + course.getGroups()), gbc);

        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(700, 100));
    }
}

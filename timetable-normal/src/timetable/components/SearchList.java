package timetable.components;

import timetable.constants.Events;
import timetabledto.Course;
import timetable.factory.SimulatorComponentFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchList extends JPanel {

    public SearchList() {
        super();

        // layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.white);

        // add label indicating no search result
        add(SimulatorComponentFactory.getInstance().createLabel("None."));
        add(Box.createRigidArea(new Dimension(5, 40)));
    }

    public void update(ArrayList<Course> courses) {
        removeAll();
        // add label indicating no search result
        if (courses.size() == 0) {
            add(SimulatorComponentFactory.getInstance().createLabel("None."));
            add(Box.createRigidArea(new Dimension(5, 40)));
        }
        // add courses
        for (Course course : courses) {
            CourseCard cc = new CourseCard(course, true);
            // forward event back to parent
            cc.addPropertyChangeListener(evt -> {
                // fire event to add course
                if (evt.getPropertyName().equals(Events.ADD_COURSE))
                    firePropertyChange(evt.getPropertyName(), null, evt.getNewValue());
            });
            add(cc);
            add(Box.createRigidArea(new Dimension(5, 10)));
        }

        // revalidate
        revalidate();
        repaint();
    }
}

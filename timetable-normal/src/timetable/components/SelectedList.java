package timetable.components;

import timetable.constants.Events;
import timetabledto.Course;
import timetable.factory.SimulatorComponentFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SelectedList extends JPanel {

    public SelectedList(ArrayList<Course> selected) {
        super();

        // layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.white);
        update(selected);
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
            CourseCard cc = new CourseCard(course, false);
            // forward event back to parent
            cc.addPropertyChangeListener(evt -> {
                // fire event to remove course and reset search
                if (evt.getPropertyName().equals(Events.REMOVE_COURSE)) {
                    firePropertyChange(evt.getPropertyName(), null, evt.getNewValue());
                    firePropertyChange(Events.SEARCH_COURSES, null, new String[]{
                            course.getCode(), course.getTypes(),
                    });
                }
            });
            add(cc);
            add(Box.createRigidArea(new Dimension(5, 10)));
        }
        // revalidate
        revalidate();
        repaint();
    }

}

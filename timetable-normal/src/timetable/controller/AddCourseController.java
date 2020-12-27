package timetable.controller;

import timetable.components.SearchList;
import timetable.components.SelectedList;
import timetable.constants.Events;
import timetabledto.Course;
import timetableinterface.ITimetableDAO;
import timetable.model.CourseModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Handler for adding new component into the drawing panel.
 */
public class AddCourseController implements PropertyChangeListener {

    CourseModel courseModel;
    SearchList searchList;
    SelectedList selectedList;
    ITimetableDAO timetableDAO;

    public AddCourseController(SearchList sl, SelectedList sll, CourseModel cm, ITimetableDAO td) {
        searchList = sl;
        selectedList = sll;
        courseModel = cm;
        timetableDAO = td;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Events.ADD_COURSE)) {
            Course course = (Course) evt.getNewValue();
            courseModel.getSelectedCourses().add(course);
            Collections.sort(courseModel.getSelectedCourses());
            // update list
            selectedList.update(courseModel.getSelectedCourses());
            timetableDAO.updateTimetable(courseModel.getSelectedCourses());
            // clean up search list
            searchList.update(new ArrayList<>());
        }
    }
}

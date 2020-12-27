package timetable.components;

import timetable.Main;
import timetable.controller.AddCourseController;
import timetable.controller.RemoveCourseController;
import timetable.controller.SearchCoursesController;
import timetable.factory.SimulatorComponentFactory;
import timetableinterface.ICourseDAO;
import timetableinterface.ITimetableDAO;
import timetable.model.CourseModel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Chin Jia Xiong
 */
public class TimetablePanel extends JPanel {
    CourseModel courseModel;
    ICourseDAO courseDAO;
    ITimetableDAO timetableDAO;

    public TimetablePanel() {
        // init model
        courseDAO = Main.courseDAO;
        timetableDAO = Main.timetableDAO;
        courseModel = new CourseModel();
        courseModel.setSelectedCourses(timetableDAO.getTimetable());

        // init layout manager
        setLayout(new GridBagLayout());
        setBackground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();

        // init search bar
        SearchPanel searchPanel = new SearchPanel();
        add(searchPanel, gbc);

        // init search result label
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel searchTitle = SimulatorComponentFactory.getInstance().createLabel("Search Result");
        add(searchTitle, gbc);

        // init search result list
        SearchList searchList = new SearchList();
        gbc.gridy = 2;
        add(searchList, gbc);

        // init selected title
        gbc.gridy = 3;
        JLabel selectedTitle = SimulatorComponentFactory.getInstance().createLabel("Selected");
        add(selectedTitle, gbc);

        // init selected list
        SelectedList selectedList = new SelectedList(courseModel.getSelectedCourses());
        gbc.gridy = 4;
        add(selectedList, gbc);

        // search courses event
        searchPanel.addPropertyChangeListener(new SearchCoursesController(searchList, courseDAO, courseModel));
        // add course event
        searchList.addPropertyChangeListener(new AddCourseController(searchList, selectedList, courseModel, timetableDAO));
        // search courses event
        selectedList.addPropertyChangeListener(new SearchCoursesController(searchList, courseDAO, courseModel));
        // remove course event
        selectedList.addPropertyChangeListener(new RemoveCourseController(selectedList, courseModel, timetableDAO));
    }
}

package timetable.controller;

import timetabledto.Course;
import timetableinterface.ICourseDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class CodeComboController implements ActionListener {

    JComboBox<String> codeCombo, typeCombo;
    ICourseDAO courseDAO;

    public CodeComboController(JComboBox<String> cc, JComboBox<String> tc, ICourseDAO table) {
        codeCombo = cc;
        typeCombo = tc;
        courseDAO = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        typeCombo.removeAllItems();
        Course[] courses = courseDAO.getCourses();

        // update type combo
        ArrayList<String> selected = new ArrayList<>();
        Arrays.sort(courses, Comparator.comparing(Course::getTypes));
        for (Course c : courses) {
            if (codeCombo.getSelectedItem() != null &&
                    c.getCode().equals(codeCombo.getSelectedItem().toString()) &&
                    !selected.contains(c.getTypes())) {
                typeCombo.addItem(c.getTypes());
                selected.add(c.getTypes());
            }
        }
    }
}
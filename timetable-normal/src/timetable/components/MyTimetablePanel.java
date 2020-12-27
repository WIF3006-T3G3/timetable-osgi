package timetable.components;

import timetable.Main;
import timetableinterface.ITimetableDAO;

import javax.swing.*;
import java.awt.*;

public class MyTimetablePanel extends JPanel {

    ITimetableDAO timetableDAO;

    public MyTimetablePanel() {
        super();
        timetableDAO = Main.timetableDAO;
        setLayout(new BorderLayout());
        ViewTimetable viewTimetable = new ViewTimetable();
        viewTimetable.update(timetableDAO.getTimetable());
        add(viewTimetable, BorderLayout.CENTER);
    }
}

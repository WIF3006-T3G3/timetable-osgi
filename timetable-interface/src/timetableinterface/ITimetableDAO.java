package timetableinterface;

import timetabledto.Course;

import java.util.ArrayList;

public interface ITimetableDAO {
    public ArrayList<Course> getTimetable();

    public void updateTimetable(ArrayList<Course> courses);
}

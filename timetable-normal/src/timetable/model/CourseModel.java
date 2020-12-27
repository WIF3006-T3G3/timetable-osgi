package timetable.model;

import timetabledto.Course;

import java.util.ArrayList;

public class CourseModel {

    ArrayList<Course> searchCourses, selectedCourses;

    public CourseModel() {
        searchCourses = new ArrayList<>();
        selectedCourses = new ArrayList<>();
    }

    public ArrayList<Course> getSelectedCourses() {
        return selectedCourses;
    }

    public void setSelectedCourses(ArrayList<Course> sc) {
        selectedCourses = sc;
    }

    public void setSearchCourses(ArrayList<Course> sc) {
        searchCourses = sc;
    }

    public ArrayList<Course> getSearchCourses() {
        return searchCourses;
    }

}

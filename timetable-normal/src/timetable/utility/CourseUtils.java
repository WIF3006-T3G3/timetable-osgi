package timetable.utility;

import timetabledto.Course;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CourseUtils {
    public  boolean validate(Course course, ArrayList<Course> selectedCourses) {
        // check if code and type already exist or not
        ArrayList<Course> filteredCourses = (ArrayList<Course>) selectedCourses.stream().filter(
                c -> c.getCode().equals(course.getCode()) && c.getTypes().equals(course.getTypes()))
                .collect(Collectors.toList());
        if (filteredCourses.size() > 0) return false;
        // check if time clashes
        String date = course.getStart().substring(0, 3);
        double timeStart = Double.parseDouble(course.getStart().substring(3));
        double timeEnd = Double.parseDouble(course.getEnd().substring(3));
        for (Course curr : selectedCourses) {
            String currDate = curr.getStart().substring(0, 3);
            double currTimeStart = Double.parseDouble(curr.getStart().substring(3));
            double currTimeEnd = Double.parseDouble(curr.getEnd().substring(3));
            // if either of the time start or time end within the range of curr
            if (currDate.equals(date) &&
                    (
                            (
                                    (timeStart >= currTimeStart && timeStart <= currTimeEnd) ||
                                            (timeEnd >= currTimeStart && timeStart <= currTimeEnd)
                            ) ||
                                    (timeStart <= currTimeStart && timeEnd >= currTimeEnd)
                    )
            ) {
                return false;
            }
        }
        return true;
    }
}

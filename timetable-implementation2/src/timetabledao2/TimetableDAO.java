package timetabledao2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import timetabledto.Course;
import timetableinterface.ITimetableDAO;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TimetableDAO implements ITimetableDAO {
    public final String PATH = "dat\\timetable.json";

    public ArrayList<Course> getTimetable() {
        ArrayList<Course> rslt = new ArrayList<>();
        Gson gson = new Gson();

        try (Reader reader = new FileReader(PATH)) {
            Course[] courses = gson.fromJson(reader, Course[].class);
            rslt.addAll(Arrays.asList(courses));
            return rslt;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void updateTimetable(ArrayList<Course> courses) {
        try (Writer writer = new FileWriter(PATH)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(courses, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

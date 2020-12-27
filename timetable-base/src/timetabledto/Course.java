package timetabledto;

import java.io.Serializable;
import java.util.HashMap;

public class Course implements Comparable<Course>, Serializable {
    private static final long serialVersionUID = 1L;

    public Course() {
    }

    public Course(String i, String c, String g, String l, String lo, String s, String e, String t) {
        id = i;
        code = c;
        groups = g;
        lecturerCode = l;
        location = lo;
        start = s;
        end = e;
        types = t;
    }

    private String id, code, groups, lecturerCode, location, start, end, types;

    public String getID() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getGroups() {
        return groups;
    }

    public String getLecturerCode() {
        return lecturerCode;
    }

    public String getLocation() {
        return location;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getTypes() {
        return types;
    }

    @Override
    public String toString() {
        return String.format("%s : %s(%s) %s %s", code, groups, types, location, lecturerCode);
    }

    @Override
    public int compareTo(Course o) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("MON", 0);
        map.put("TUE", 0);
        map.put("WED", 0);
        map.put("THU", 0);
        map.put("FRI", 0);

        // sort by date if date different
        String date1 = getStart().substring(0, 3);
        String date2 = o.getStart().substring(0, 3);
        if (!date1.equals(date2)) {
            return map.get(date1) - map.get(date2);
        }

        // sort by start time
        double time1 = Double.parseDouble(getStart().substring(3));
        double time2 = Double.parseDouble(o.getStart().substring(3));
        if (time1 > time2) {
            return 1;
        } else if (time1 < time2) {
            return -1;
        }
        return 0;
    }
}

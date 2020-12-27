package timetable;

import org.osgi.framework.ServiceReference;
import org.osgi.service.component.ComponentContext;
import timetable.screens.MainMenuFrame;
import timetableinterface.ICourseDAO;
import timetableinterface.ITimetableDAO;

import javax.swing.*;

public class Main {

    ComponentContext context;
    private static JFrame currentFrame;
    public static ICourseDAO courseDAO;
    public static ITimetableDAO timetableDAO;
    ServiceReference courseRef, timetableRef;

    public void activate(ComponentContext context) {
        if (courseRef != null) {
            courseDAO = (ICourseDAO) context.locateService(
                    "ICourseDAO", courseRef);
        }
        if (timetableRef != null) {
            timetableDAO = (ITimetableDAO) context.locateService(
                    "ITimetableDAO", timetableRef);
        }
        navigate(new MainMenuFrame());
    }

    public void gotService(ServiceReference reference) {
        if (reference.toString().contains("CourseDAO")) {
            System.out.println("Bind Course Reference");
            courseRef = reference;
        } else {
            System.out.println("Bind Timetable Reference");
            timetableRef = reference;
        }
    }

    public void lostService(ServiceReference reference) {
        System.out.println("Unbind Service " + reference.toString());
    }

    public static void navigate(JFrame frame) {
        if (currentFrame != null) currentFrame.setVisible(false);
        currentFrame = frame;
        currentFrame.setVisible(true);
    }

    public static void main(String[] args) {
        navigate(new MainMenuFrame());
    }
}

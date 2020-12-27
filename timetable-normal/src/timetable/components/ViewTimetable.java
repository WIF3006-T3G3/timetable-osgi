package timetable.components;

import timetabledto.Course;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ViewTimetable extends JPanel {

    private JTable table1, table2;

    public ViewTimetable() {
        // initialize components
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        table1 = new JTable();
        table1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"MON", null, null, null, null, null, null, null},
                        {"TUE", null, null, null, null, null, null, null},
                        {"WED", null, null, null, null, null, null, null},
                        {"THU", null, null, null, null, null, null, null},
                        {"FRI", null, null, null, null, null, null, null}
                },
                new String[]{
                        "Day", "8.00-8.59", "9.00-9.59", "10.00-10.59", "11.00-11.59", "12.00-12.59", "13.00-13.59"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        table1.setRowHeight(100);
        table1.setGridColor(Color.BLACK);
        table1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        table2 = new JTable();
        table2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"MON", null, null, null, null, null, null, null},
                        {"TUE", null, null, null, null, null, null, null},
                        {"WED", null, null, null, null, null, null, null},
                        {"THU", null, null, null, null, null, null, null},
                        {"FRI", null, null, null, null, null, null, null}
                },
                new String[]{
                        "Day", "14.00-14.59", "15.00-15.59", "16.00-16.59", "17.00-17.59", "18.00-18.59", "19.00-19.59", "20.00-20.59"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        table2.setRowHeight(100);
        table2.setGridColor(Color.BLACK);
        table2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        setTableWrapper();

        JScrollPane scroller1 = new JScrollPane(table1);
        scroller1.setPreferredSize(new Dimension(700, 520));
        add(scroller1);
        add(Box.createRigidArea(new Dimension(5, 40)));
        JScrollPane scroller2 = new JScrollPane(table2);
        scroller2.setPreferredSize(new Dimension(700, 520));
        add(scroller2);
        setBackground(Color.white);
    }

    private void setTableWrapper() {
        table1.getColumnModel().getColumn(1).setCellRenderer(new WordWrapCellRenderer());
        table1.getColumnModel().getColumn(2).setCellRenderer(new WordWrapCellRenderer());
        table1.getColumnModel().getColumn(3).setCellRenderer(new WordWrapCellRenderer());
        table1.getColumnModel().getColumn(4).setCellRenderer(new WordWrapCellRenderer());
        table1.getColumnModel().getColumn(5).setCellRenderer(new WordWrapCellRenderer());
        table1.getColumnModel().getColumn(6).setCellRenderer(new WordWrapCellRenderer());
        table2.getColumnModel().getColumn(1).setCellRenderer(new WordWrapCellRenderer());
        table2.getColumnModel().getColumn(2).setCellRenderer(new WordWrapCellRenderer());
        table2.getColumnModel().getColumn(3).setCellRenderer(new WordWrapCellRenderer());
        table2.getColumnModel().getColumn(4).setCellRenderer(new WordWrapCellRenderer());
        table2.getColumnModel().getColumn(5).setCellRenderer(new WordWrapCellRenderer());
        table2.getColumnModel().getColumn(6).setCellRenderer(new WordWrapCellRenderer());
        table2.getColumnModel().getColumn(7).setCellRenderer(new WordWrapCellRenderer());
    }

    public void update(ArrayList<Course> courses) {
        for (Course course : courses) {
            int timeStart = Integer.parseInt(course.getStart().substring(3, course.getStart().indexOf(".")));
            int timeEnd = Integer.parseInt(course.getEnd().substring(3, course.getEnd().indexOf(".")));
            int col;
            String day = course.getStart().substring(0, 3);
            int row = 0;
            switch (day) {
                case "MON":
                    row = 0;
                    break;
                case "TUE":
                    row = 1;
                    break;
                case "WED":
                    row = 2;
                    break;
                case "THU":
                    row = 3;
                    break;
                case "FRI":
                    row = 4;
                    break;
            }
            DefaultTableModel model;
            for (int i = timeStart; i <= timeEnd; i++) {
                if (i <= 13) model = (DefaultTableModel) table1.getModel();
                else model = (DefaultTableModel) table2.getModel();
                if (i - 8 == 12) col = 6;
                else col = (i - 8) % 6 + 1;
                model.setValueAt(course.toString(), row, col);
            }
        }
    }
}

package timetable.components;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class WordWrapCellRenderer extends JTextArea implements TableCellRenderer {

    // wrap each cell to fit the words
    WordWrapCellRenderer() {
        setFont(new Font("Verdana", Font.PLAIN, 14));
        setLineWrap(true);
        setWrapStyleWord(true);
    }

    // draw the text and background color
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        try {
            setText(value.toString());
            setBackground(Color.decode("#D13838"));
            setForeground(Color.white);
            if (value.toString().equals("")) setBackground(Color.white);
        } catch (Exception e) {
            setText("");
            setBackground(Color.white);
        }
        return this;
    }
}
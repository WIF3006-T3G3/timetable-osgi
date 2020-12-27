package timetable.factory;

import javax.swing.*;

/**
 * Interface for creating the UI components.
 */
public interface AbstractComponentFactory {

    /**
     * Create normal button
     *
     * @param label button label
     * @return button
     */
    JButton createButton(String label);

    /**
     * Create button with icon as label
     *
     * @param path file path
     * @return icon button
     */
    JButton createIconButton(String path);

    /**
     * Create text label
     *
     * @param label text label
     * @return text label
     */
    JLabel createLabel(String label);

    /**
     * Create image as image label
     *
     * @param path file path
     * @param x    x coordinate
     * @param y    y coordinate
     * @return image label
     */
    JLabel createImageLabel(String path, int x, int y);

    /**
     * Create image as image label (with fixed width and height)
     *
     * @param path file path
     * @param x    x coordinate
     * @param y    y coordinate
     * @param w    width
     * @param h    height
     * @return image label
     */
    JLabel createImageLabel(String path, int x, int y, int w, int h);
}

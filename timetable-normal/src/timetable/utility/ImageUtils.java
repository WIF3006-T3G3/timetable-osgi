package timetable.utility;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility functions used for image operations such as scaling and screenshot.
 */
public class ImageUtils {

    /**
     * Scale and return the image
     *
     * @param srcImg image source
     * @param w      target width
     * @param h      target height
     * @return scaled image
     */
    public Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    /**
     * Get scaled image in the form of ImageIcon
     *
     * @param url Image file URL
     * @param w   target width
     * @param h   target height
     * @return scaled image icon
     */
    public ImageIcon getScaledImageIcon(URL url, int w, int h) {
        ImageIcon image = new ImageIcon(url);
        return new ImageIcon(getScaledImage(image.getImage(), w, h));
    }

    /**
     * Take a screenshot of the selected component (JFrame in the use case)
     *
     * @param component Component to take screenshot
     */
    public void screenshot(Component component) {
        Rectangle rect = component.getBounds();

        try {
            // get current datetime
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
            LocalDateTime now = LocalDateTime.now();

            String format = "png";
            String fileName = dtf.format(now) + "." + format;
            BufferedImage captureImage =
                    new BufferedImage(rect.width, rect.height,
                            BufferedImage.TYPE_INT_ARGB);
            component.paint(captureImage.getGraphics());

            ImageIO.write(captureImage, format, new File("screenshots/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

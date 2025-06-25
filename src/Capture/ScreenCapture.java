package Capture;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ScreenCapture {
    JFrame frame;
    public boolean CaptureDone;
    private int width;
    private int height;


    public ScreenCapture(Point Start, Point End){
        frame = new JFrame();
        CaptureDone = false;
        width = Math.abs(End.x - Start.x);
        height = Math.abs(End.y - Start.y);
    }

    public void SetCaptureScreen() throws AWTException {
        Rectangle Screen = new Rectangle(width,height);
        BufferedImage capture = new Robot().createScreenCapture(Screen);
        ImagetoClipBoard clipboard = new ImagetoClipBoard();
        clipboard.copyImage(capture);
    }
}

package Main;

import Capture.ScreenCapture;
import Window.Window;

import java.awt.*;

public class Main {

    public static void main(String[] args) throws AWTException {
        Window main = new Window();
        main.WindowCreat();
        Point Startpoint = new Point();
        Point Endpoint = new Point();

        while(main.WindowIsOpen)
        {
            // Optimize would not make it check the while statement
            // So WindowIsOpen would be set as volatile
        }
        Startpoint = main.getStartpoint();
        Endpoint = main.getEndpoint();
        System.out.println("Start point: [X,"+ Startpoint.x + "] [Y," + Startpoint.y + "]");
        System.out.println("End point: [X," + Endpoint.x + "] [Y," + Endpoint.y + "]");



        ScreenCapture Capture = new ScreenCapture(Startpoint,Endpoint);
        Capture.SetCaptureScreen();


    }
}
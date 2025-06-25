package Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Window extends JFrame implements MouseListener, WindowListener {
    private final JFrame frame;
    private final JLabel label;
    private Point Startpoint;
    private Point Endpoint;
    public volatile boolean WindowIsOpen = true;
    //private boolean UserDone = true;

    public Window() {
        Startpoint = new Point(0,0);
        Endpoint = new Point(0,0);
        frame = new JFrame();
        label = new JLabel();
    }

    public void WindowCreat()
    {
        Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("Screen Size: " + ScreenSize);
        frame.setSize((int) ScreenSize.getWidth(), (int) ScreenSize.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Window");
        frame.setUndecorated(true);
        frame.setBackground(new Color(0,0,0,10));
        frame.addWindowListener(this);


        label.setBounds(0, 0, (int) ScreenSize.getWidth(), (int) ScreenSize.getHeight());
        label.setBackground(new Color(0,0,0,50));
        label.setOpaque(true);
        label.addMouseListener(this); // Response to mouse events

        frame.add(label); // Needed to add label to our frame so we have mouse events
        frame.setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // System.out.println("mouseClicked");
        // Maybe you can implement a try again feature
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed");
        Startpoint = e.getPoint();
        Endpoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased");
        Endpoint = e.getPoint();
        RemoveLabel();
        frame.dispose();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
            System.out.println("mouseExited");
    }

    public Point getStartpoint()
    {
        return Startpoint;
    }

    public Point getEndpoint()
    {
        return Endpoint;
    }


    private void RemoveLabel()
    {
        label.removeMouseListener(this);
        label.revalidate();
        label.repaint();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        WindowIsOpen = true;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("windowClosing");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("windowClosed");
        WindowIsOpen = false;
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("windowActivated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("windowDeactivated");
    }

    // Start Activate & enter
    // User goes off-screen Exited and then Deactivated
    // User goes back in Entered, but It's still Deactivated
    // It's not that big of a deal tbh


    // Last feature implement a little window that shows where we at
}

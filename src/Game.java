import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Game extends JFrame {
    public final static int WIDTH = 300;
    public final static int HEIGHT = 300;
    public final static int FRAME_HEIGHT = 340;
    public final static int FRAME_WIDTH = 316;
    private Panel panel;
    private JFrame frame;



    public Game(){
        panel = new Panel();
        frame = new JFrame();
        panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        panel.setBackground(Color.GRAY);
        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.setSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

}

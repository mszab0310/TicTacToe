import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    public final static int WIDTH = 300;
    public final static int HEIGHT = 300;
    public final static int FRAME_HEIGHT = 400;
    public final static int FRAME_WIDTH = 316;
    private Panel panel;
    private JFrame frame;
    private JLabel label;
    private GameState gameState;


    public Game() {
        gameState = new GameState();
        label = new JLabel();
        panel = new Panel(gameState, label);
        frame = new JFrame();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setBackground(Color.GRAY);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        label.setPreferredSize(new Dimension(300, 65));
        label.setForeground(Color.WHITE);
        label.setFont(new Font("ComicSans", Font.PLAIN, 24));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.BLACK);
        frame.getContentPane().add(BorderLayout.SOUTH, label);
        frame.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

}

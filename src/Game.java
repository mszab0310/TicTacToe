import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Game extends JFrame {
    public final static int WIDTH = 300;
    public final static int HEIGHT = 300;
    public final static int FRAME_HEIGHT = 400;
    public final static int FRAME_WIDTH = 316;
    private final int step = Game.WIDTH / 3;
    private Panel panel;
    private JFrame frame;
    private JLabel label;
    private GameState gameState;
    private JButton startButton;
    private JButton resumeButton;
    private JButton restartButton;
    private JButton exitButton;
    private JButton exitButton2;
    private MenuPanel menuPanel;
    private MenuPanel pausePanel;
    private int whosTurn = 0;
    private boolean isInMenu;


    public Game() {
        gameState = new GameState();
        initPanel();
        isInMenu = true;
        frame = new JFrame("TicTacToe");
        startButton = new JButton("Start");
        restartButton = new JButton("Restart");
        resumeButton = new JButton("Resume");
        exitButton = new JButton("Exit");
        exitButton2 = new JButton("Exit");
        initMenuPanels();
        frame.getContentPane().add(menuPanel, BorderLayout.CENTER);
        frame.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationByPlatform(true);
        frame.setFocusable(true);
        frame.setVisible(true);
    }

    void initPanel() {
        label = new JLabel();
        panel = new Panel(gameState, label);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setBackground(Color.GRAY);
        label.setPreferredSize(new Dimension(300, 65));
        label.setForeground(Color.WHITE);
        label.setFont(new Font("ComicSans", Font.PLAIN, 24));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.BLACK);
    }

    void initMenuPanels(){

        menuPanel = new MenuPanel();
        pausePanel = new MenuPanel();
        pausePanel.add(resumeButton);
        menuPanel.add(startButton);
        menuPanel.add(exitButton);
        pausePanel.add(restartButton);
        pausePanel.add(exitButton2);

    }



    void mouseInput(){
        Random random = new Random();
        whosTurn = (int) Math.pow(-1, random.nextInt());
        String value = whosTurn == -1 ? "X" : "O";
        label.setText(value + "'s turn!");
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                int x = e.getX();
                int y = e.getY();
                int xc = ((x / step) * step) / step;
                int yc = ((y / step) * step) / step;
                if (gameState.getPos(xc, yc) != 0 || gameState.isWinner()) {
                    return;
                }
                gameState.setOnPos(xc, yc, whosTurn);
                whosTurn *= -1;
                String value = whosTurn == -1 ? "X" : "O";
                String labelText = value + "'s turn";
                if (gameState.isWinner()) {
                    labelText = (whosTurn == -1 ? "O" : "X") + " WON!";
                }
                if (gameState.isDraw()) {
                    labelText = "DRAW";
                }
                label.setText(labelText);
                panel.repaint();
            }
        });
    }

    public void start() {

        startButton.addActionListener(e -> {
            frame.getContentPane().remove(menuPanel);
            frame.getContentPane().add(BorderLayout.CENTER, panel);
            frame.getContentPane().add(BorderLayout.SOUTH, label);
            frame.getContentPane().invalidate();
            frame.getContentPane().validate();
            isInMenu = false;
        });
        mouseInput();

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if(!isInMenu) {
                        frame.getContentPane().remove(panel);
                        frame.getContentPane().remove(label);
                        initPanel();
                        mouseInput();
                        frame.getContentPane().add(pausePanel, BorderLayout.CENTER);
                        frame.getContentPane().invalidate();
                        frame.getContentPane().validate();
                    }
                }
            }
        });

        exitButton.addActionListener(e -> frame.dispose());

        exitButton2.addActionListener(e -> {
            frame.dispose();
        });

        restartButton.addActionListener(e -> {
            gameState = new GameState();
            initPanel();
            mouseInput();
            frame.getContentPane().remove(pausePanel);
            frame.getContentPane().add(BorderLayout.CENTER, panel);
            frame.getContentPane().add(BorderLayout.SOUTH, label);
            frame.getContentPane().invalidate();
            frame.getContentPane().validate();
            initMenuPanels();

        });

        resumeButton.addActionListener(e -> {
            frame.getContentPane().remove(pausePanel);
            frame.getContentPane().add(BorderLayout.CENTER, panel);
            frame.getContentPane().add(BorderLayout.SOUTH, label);
            frame.getContentPane().invalidate();
            frame.getContentPane().validate();
            initMenuPanels();
        });

    }


}

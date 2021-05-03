import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Panel extends JPanel {

    private final int step = Game.WIDTH / 3;
    private GameState gameState;
    private int x;
    private int y;
    private final int fontSize = 96;
    private int whosTurn = 0;

    public Panel(GameState gameState, JLabel label) {
        Random random = new Random();
        this.gameState = gameState;
        whosTurn = (int) Math.pow(-1, random.nextInt());
        String value = whosTurn == -1 ? "X" : "O";
        label.setText(value + "'s turn!");
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                x = e.getX();
                y = e.getY();
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
                repaint();

            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < Game.WIDTH; i += Game.WIDTH / 3) {
            g.drawLine(i, 0, i, Game.HEIGHT);
            for (int j = 0; j < Game.HEIGHT; j += Game.HEIGHT / 3) {
                g.drawLine(0, j, Game.WIDTH, j);
            }
        }
        for (int i = 0; i < gameState.getGrid().length; i++) {
            for (int j = 0; j < gameState.getGrid().length; j++) {
                if (gameState.getGrid()[i][j] != 0) {
                    g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
                    String value = gameState.getGrid()[i][j] == -1 ? "X" : "O";
                    g.drawString(value, i * step, j * step + fontSize);
                }
            }
        }

    }


}

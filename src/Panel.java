import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Panel extends JPanel {

    private final int step = Game.WIDTH / 3;
    private GameState gameState;
    private final int fontSize = 96;

    public Panel(GameState gameState, JLabel label) {
        this.gameState = gameState;
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

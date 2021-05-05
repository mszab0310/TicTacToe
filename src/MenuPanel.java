import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel(){
        this.setPreferredSize(new Dimension(Game.FRAME_WIDTH,Game.FRAME_HEIGHT));
        this.setBackground(Color.WHITE);
        this.setLayout(new GridLayout(10,1,10,5));
    }
}

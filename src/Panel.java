import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Panel extends JPanel {

    private  int step = WIDTH/3;

    public Panel(){
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                int x = e.getX();
                int y = e.getY();
                System.out.println(x + " , " + y);
            }
        });
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0;i < Game.WIDTH ;i+=Game.WIDTH/3){
            g.drawLine(i,0,i,Game.HEIGHT);
            for(int j = 0; j < Game.HEIGHT ;j+= Game.HEIGHT/3){
                g.drawLine(0,j,Game.WIDTH,j);
            }
        }

    }


}

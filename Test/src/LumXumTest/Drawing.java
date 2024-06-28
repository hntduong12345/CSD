package LumXumTest;

import java.awt.Graphics;
import javax.swing.JComponent;

public class Drawing extends JComponent{
    Coloring c = new Coloring();
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(c.getColor());
        g.fillOval(50, 3, 150, 150);
        g.fillOval(190, 3, 150, 150);
        g.fillArc(50, -87, 400, 350, -106, -87);
        g.fillArc(-60, -87, 400, 350, -74, 87);
    }
    
    public void changeTheColor(){
        c.changeColor();
        repaint();
    }
}

package LumXumTest;

import java.awt.Color;

public class Coloring {
    private Color color;
    
    public Coloring(){
        color = Color.BLACK;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public void changeColor(){
        int r = (int)(Math.random() * 256);
        int b = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        
        this.setColor(new Color(r, g, b));
    }
}

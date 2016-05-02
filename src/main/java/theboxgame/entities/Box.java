package theboxgame.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Box extends Movable {
    private final int id;

    public Box(int x, int y) {
        super(x, y);
        this.id = 3;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(x, y, width, height);

    }
    
    @Override
    public int getId() {
        return this.id;
    }
    
    @Override
    public String toString() {
        return "Box";
    }
    
    
}

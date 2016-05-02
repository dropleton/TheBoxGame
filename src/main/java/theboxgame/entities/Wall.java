package theboxgame.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends Entity {
    private final int id;
    
    public Wall(int x, int y) {
        super(x, y);
        this.id = 1;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, width, height);
    }
    
    @Override
    public int getId() {
        return this.id;
    }
    
    @Override
    public String toString() {
        return "Wall";
    }
    
}

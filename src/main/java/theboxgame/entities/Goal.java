package theboxgame.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Goal extends Entity {
    private final int id;

    public Goal(int x, int y) {
        super(x, y);
        this.id = 4;
    }
    
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, width, height);
    }
    
    @Override
    public String toString() {
        return "Goal";
    }
    
}

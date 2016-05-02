package theboxgame.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Movable{
    private final int id;
    
    public Player(int x, int y) {
        super(x, y);
        this.id = 2;
    }
    
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
    
    @Override
    public String toString() {
        return "Player";
    }
}

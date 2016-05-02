package theboxgame.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Entity {
    protected int x, y;
    public static int width = 20, height = 20;
    private Tile tile;
    private final int id;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
        this.id = 0;
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.clearRect(x, y, width, height);
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setTile(Tile tile) {
        this.tile = tile;
    }
    
    public Tile getTile() {
        return this.tile;
    }
    
    @Override
    public String toString() {
        return "(" + this.x + " " + this.y + ")";
    }
    

}

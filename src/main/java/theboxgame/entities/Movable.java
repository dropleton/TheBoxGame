package theboxgame.entities;

import java.awt.Graphics;

public class Movable extends Entity {

    public Movable(int x, int y) {
        super(x, y);
    }

    public void moveLeft() {
        this.x = this.x - 20;
    }

    public void moveRight() {
        this.x = this.x + 20;
    }

    public void moveUp() {
        this.y = this.y - 20;
    }

    public void moveDown() {
        this.y = this.y + 20;
    }

    @Override
    public void render(Graphics g) {

    }

}

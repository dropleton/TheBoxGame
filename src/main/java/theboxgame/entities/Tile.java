package theboxgame.entities;

public class Tile {

    public static final int TILEWIDTH = 20, TILEHEIGHT = 20;
    private final int x;
    private final int y;
    private Entity entity;
    private Tile up, down, left, right;
    

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setTile(Entity e) {
        this.entity = e;
    }

    public void setEntity(Entity e) {
        this.entity = e;
    }
    
    public Entity getEntity() {
        return this.entity;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setUp(Tile tile) {
        this.up = tile;
    }

    public void setDown(Tile tile) {
        this.down = tile;
    }

    public void setLeft(Tile tile) {
        this.left = tile;
    }

    public void setRight(Tile tile) {
        this.right = tile;
    }

    public Tile getUp() {
        return up;
    }

    public Tile getDown() {
        return down;
    }

    public Tile getLeft() {
        return left;
    }

    public Tile getRight() {
        return right;
    }
    
    @Override
    public String toString() {
        return this.x + "," + this.y;
    }

}

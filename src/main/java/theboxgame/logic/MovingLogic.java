package theboxgame.logic;

import java.util.ArrayList;
import theboxgame.entities.*;

public class MovingLogic {

    private Player player;
    private ArrayList<Box> boxes;
    private ArrayList<Wall> walls;
    private ArrayList<Entity> empties;
    private int boxesLeft;

    private WallCollisions wallCollisions;
    private BoxCollisions boxCollisions;

    public MovingLogic(Player player, ArrayList<Wall> walls, ArrayList<Box> boxes, ArrayList<Entity> empties) {
        this.player = player;
        this.boxes = new ArrayList();
        this.walls = new ArrayList();
        this.empties = new ArrayList();

        init(boxes, walls, empties);

        this.boxesLeft = this.boxes.size();
        this.wallCollisions = new WallCollisions();
        this.boxCollisions = new BoxCollisions();
    }

    private void init(ArrayList<Box> boxes, ArrayList<Wall> walls, ArrayList<Entity> entities) {
        for (Box box : boxes) {
            this.boxes.add(box);
        }
        for (Wall wall : walls) {
            this.walls.add(wall);
        }
        for (Entity empty : entities) {
            this.empties.add(empty);
        }
    }

    public boolean isCompleted() {
        if(this.boxesLeft <= 0) {
            return true;
        }
        return false;
    }

    public void playerMoveUp() {
        if (this.player.getTile().getUp() != null) {
            if (!wallCollisions.collisionToWallUp(this.player)) {
                if (boxCollisions.isAboveABox(player)) {
                    if (!(boxCollisions.isAboveABox(player.getTile().getUp().getEntity()) || wallCollisions.collisionToWallUp(player.getTile().getUp().getEntity()))) {
                        this.player.moveUp();
                        moveBoxUp();
                        this.player.setTile(this.player.getTile().getUp());
                    }
                } else {
                    this.player.moveUp();
                    this.player.setTile(this.player.getTile().getUp());
                }
            }
        }
    }

    public void playerMoveDown() {
        if (this.player.getTile().getDown() != null) {
            if (!wallCollisions.collisionToWallDown(this.player)) {
                if (boxCollisions.isUnderABox(player)) {
                    if (!(boxCollisions.isUnderABox(player.getTile().getDown().getEntity()) || wallCollisions.collisionToWallDown(player.getTile().getDown().getEntity()))) {
                        this.player.moveDown();
                        moveBoxDown();
                        this.player.setTile(this.player.getTile().getDown());
                    }
                } else {
                    this.player.moveDown();
                    this.player.setTile(this.player.getTile().getDown());
                }
            }
        }
    }

    public void playerMoveLeft() {
        if (this.player.getTile().getLeft() != null) {
            if (!wallCollisions.collisionToWallLeft(this.player)) {
                if (boxCollisions.isLeftABox(player)) {
                    if (!(boxCollisions.isLeftABox(player.getTile().getLeft().getEntity()) || wallCollisions.collisionToWallLeft(player.getTile().getLeft().getEntity()))) {
                        this.player.moveLeft();
                        moveBoxLeft();
                        this.player.setTile(this.player.getTile().getLeft());
                    }
                } else {
                    this.player.moveLeft();
                    this.player.setTile(this.player.getTile().getLeft());
                }
            }
        }
    }

    public void playerMoveRight() {
        if (this.player.getTile().getRight() != null) {
            if (!wallCollisions.collisionToWallRight(this.player)) {
                if (boxCollisions.isRightABox(player)) {
                    if (!(boxCollisions.isRightABox(player.getTile().getRight().getEntity()) || wallCollisions.collisionToWallRight(player.getTile().getRight().getEntity()))) {
                        this.player.moveRight();
                        moveBoxRight();
                        this.player.setTile(this.player.getTile().getRight());
                    }
                } else {
                    this.player.moveRight();
                    this.player.setTile(this.player.getTile().getRight());
                }
            }
        }
    }

    public void moveBoxUp() {
        if (this.player.getTile().getUp().getEntity().getId() == 3) {
            for (Box box : this.boxes) {
                if (box.getTile() == this.player.getTile().getUp()) {
                    if (!wallCollisions.collisionToWallUp(box)) {
                        if (!boxCollisions.isAboveABox(box)) {
                            box.moveUp();
                            box.getTile().setEntity(new Entity(box.getX(), box.getY()));
                            box.setTile(box.getTile().getUp());
                            if (!isBoxInGoal(box)) {
                                box.getTile().setEntity(box);
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveBoxDown() {
        if (this.player.getTile().getDown().getEntity().getId() == 3) {
            for (Box box : this.boxes) {
                if (box.getTile() == this.player.getTile().getDown()) {
                    if (!wallCollisions.collisionToWallDown(box)) {
                        if (!boxCollisions.isUnderABox(box)) {
                            box.moveDown();
                            box.getTile().setEntity(new Entity(box.getX(), box.getY()));
                            box.setTile(box.getTile().getDown());
                            if (!isBoxInGoal(box)) {
                                box.getTile().setEntity(box);
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveBoxLeft() {
        if (this.player.getTile().getLeft().getEntity().getId() == 3) {
            for (Box box : this.boxes) {
                if (box.getTile() == this.player.getTile().getLeft()) {
                    if (!wallCollisions.collisionToWallLeft(box)) {
                        if (!boxCollisions.isLeftABox(box)) {
                            box.moveLeft();
                            box.getTile().setEntity(new Entity(box.getX(), box.getY()));
                            box.setTile(box.getTile().getLeft());
                            if (!isBoxInGoal(box)) {
                                box.getTile().setEntity(box);
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveBoxRight() {
        if (this.player.getTile().getRight().getEntity().getId() == 3) {
            for (Box box : this.boxes) {
                if (box.getTile() == this.player.getTile().getRight()) {
                    if (!wallCollisions.collisionToWallRight(box)) {
                        if (!boxCollisions.isRightABox(box)) {
                            box.moveRight();
                            box.getTile().setEntity(new Entity(box.getX(), box.getY()));
                            box.setTile(box.getTile().getRight());
                            if (!isBoxInGoal(box)) {
                                box.getTile().setEntity(box);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean isBoxInGoal(Box box) {
        if (box.getTile().getEntity().getId() == 4) {
            box = null;
            boxesLeft--;
            return true;
        }
        return false;
    }

}

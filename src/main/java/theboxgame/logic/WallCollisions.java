package theboxgame.logic;

import theboxgame.entities.Entity;

public class WallCollisions {

    public boolean collisionToWallUp(Entity entity) {
        if (entity.getTile().getUp().getEntity().getId() == 1) {
            return true;
        }
        return false;
    }

    public boolean collisionToWallDown(Entity entity) {
        if (entity.getTile().getDown().getEntity().getId() == 1) {
            return true;
        }
        return false;
    }

    public boolean collisionToWallRight(Entity entity) {
        if (entity.getTile().getRight().getEntity().getId() == 1) {
            return true;
        }
        return false;
    }

    public boolean collisionToWallLeft(Entity entity) {
        if (entity.getTile().getLeft().getEntity().getId() == 1) {
            return true;
        }
        return false;
    }

}

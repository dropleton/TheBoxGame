package theboxgame.logic;

import theboxgame.entities.Entity;

public class BoxCollisions {
    
    public boolean isAboveABox(Entity e) {
        if(e.getTile().getUp().getEntity().getId() == 3) {
            return true;
        }
        return false;
    }

    public boolean isRightABox(Entity e) {
        if (e.getTile().getRight().getEntity().getId() == 3) {
            return true;
        }
        return false;
    }

    public boolean isLeftABox(Entity e) {
        if (e.getTile().getLeft().getEntity().getId() == 3) {
            return true;
        }
        return false;
    }

    public boolean isUnderABox(Entity e) {
        if (e.getTile().getDown().getEntity().getId() == 3) {
            return true;
        }
        return false;
    }

}

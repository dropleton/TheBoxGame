package theboxgame.states;

import java.awt.Graphics;
import theboxgame.theboxgame.Game;

public abstract class State {

    private Game game;

    public State(Game game) {
        this.game = game;
    }

    public abstract void render(Graphics g);

}

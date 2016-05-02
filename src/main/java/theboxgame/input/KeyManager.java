package theboxgame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import theboxgame.logic.MovingLogic;

public class KeyManager implements KeyListener {

    private MovingLogic logic;

    public KeyManager(MovingLogic logic) {
        this.logic = logic;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.logic.playerMoveUp();
                break;
            case KeyEvent.VK_DOWN:
                this.logic.playerMoveDown();
                break;
            case KeyEvent.VK_RIGHT:
                this.logic.playerMoveRight();
                break;
            case KeyEvent.VK_LEFT:
                this.logic.playerMoveLeft();
                break;
            default:
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}

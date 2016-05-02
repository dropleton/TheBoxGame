package theboxgame.theboxgame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import theboxgame.display.Display;

public class Render {

    private BufferStrategy bs;
    private Graphics g;

    public void render(Display display, int width, int height) {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(1);
            return;
        }
        g = bs.getDrawGraphics();

        g.clearRect(0, 0, width, height);

        bs.show();
        g.dispose();
    }

}

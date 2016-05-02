package theboxgame.theboxgame;

import theboxgame.logic.*;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.logging.*;
import theboxgame.display.Display;
import theboxgame.entities.*;
import theboxgame.input.KeyManager;
import theboxgame.states.*;

public class Game implements Runnable {

    private Display display;

    private Thread thread;
    private boolean running = false;

    public int width, height;
    public String title;

    private BufferStrategy bs;
    private Graphics g;

    private State gameState;

    private World world;
    private MovingLogic logic;
    private KeyManager manager;

    private String map;

    private Complete c;

    public Game(String title, int width, int height, String map) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.map = map;
        this.world = new World(width / Tile.TILEWIDTH, height / Tile.TILEHEIGHT, map);
        this.logic = new MovingLogic(this.world.getPlayer(), this.world.getWalls(), this.world.getBoxes(), this.world.getEmpties());
        this.manager = new KeyManager(this.logic);
        this.c = new Complete();
    }

    private void init() {
        this.display = new Display(title, width, height);
        this.display.getJFrame().addKeyListener(this.manager);

        this.gameState = new GameState(this);
        CurrentState.setState(this.gameState);
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        if (CurrentState.getState() != null) {
            CurrentState.getState().render(g);
        }

        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000) {
                if (this.c.getComplete()) {
                    stop();
                } else {
                    System.out.println("Ticks and frames: " + ticks);
                    ticks = 0;
                    timer = 0;
                }
            }

            if (this.logic.isCompleted()) {
                this.c.setComplete();
            }
        }

    }

    public synchronized void start() {
        if (running) {
            return;
        }
        this.running = true;
        this.thread = new Thread(this);
        this.thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        try {
            this.thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Player getPlayer() {
        return this.world.getPlayer();
    }

    public ArrayList<Box> getBoxes() {
        return this.world.getBoxes();
    }

    public Goal getGoal() {
        return this.world.getGoal();
    }

    public ArrayList<Wall> getWalls() {
        return this.world.getWalls();
    }

    public ArrayList<Entity> getEmpties() {
        return this.world.getEmpties();
    }

    public Complete getComplete() {
        return this.c;
    }
}

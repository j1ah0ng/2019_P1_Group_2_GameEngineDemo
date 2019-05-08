package game;

import engine.Actor;
import javafx.scene.image.Image;

public class Paddle extends Actor {

    // Attributes
    double prevX;
    long delay;
    long lastRun;
    double vel;

    // Constructors
    public Paddle() {
        super();
        try {
            super.setImage(new Image("file:assets/paddle.png"));
        } catch (Exception e) { e.printStackTrace(); }
        prevX = 0;
        delay = (long) (1e9 * 0.001);
        lastRun = System.currentTimeMillis();
        vel = 0;
    }

    @Override
    public void act(long now) {
        if (now - lastRun >= delay) {
            vel = (super.getX() - prevX) / delay;
        }
    }

    public double getVel() { return vel; }
}

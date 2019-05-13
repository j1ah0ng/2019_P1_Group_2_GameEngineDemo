package game;

import engine.Actor;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

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
            if (getWorld().hasKey(KeyCode.LEFT)) setX(getX() - 10 * 1.6667);
            else if (getWorld().hasKey(KeyCode.RIGHT)) setX(getX() + 10 * 1.6667);
        }

        if (getX() < 0.0) setX(0.0);
        else if (getX() + getWidth() > getWorld().getWidth()) setX(getWorld().getWidth() - getWidth());

        if (getY() < 0.0) setY(0.0);
        else if (getY() + getHeight() > getWorld().getHeight()) setY(getWorld().getHeight() - getHeight());
    }

    public double getVel() { return vel; }
}

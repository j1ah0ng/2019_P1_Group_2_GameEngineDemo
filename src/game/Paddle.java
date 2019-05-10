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
        }        	
        if (getWorld().hasKey(KeyCode.LEFT) && getX()>0) {   //improve left bound?
        	setX(getX() - getWidth() / 2); //change this to control speed
        }if (getWorld().hasKey(KeyCode.RIGHT) && getX()<(1079-getWidth()/2)) { //improve right bound?
        	setX(getX() + getWidth() / 2); //change this to control speed
        }
    }

    public double getVel() { return vel; }
}

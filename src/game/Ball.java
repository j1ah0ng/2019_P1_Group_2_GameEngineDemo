package game;

import engine.Actor;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Ball extends Actor {

    // Attributes
    double delX;         // X delta
    double delY;         // Y delta
    long delay;          // Delay between delta movements, such
                         // that velocity = sqrt(delX^2 + delY^2) / delay
                         // where delay is measured in ns
    long lastRun;        // timestamp of last run() invokation
    boolean paddle;      // helper flag to avoid unwanted behaviour with bouncing on the paddle

    // Lazy constructor
    public Ball() {
        this(20, 20);
    }

    // Constructors
    public Ball(double delX, double delY) {
        this(delX, delY, (long)(1e9 * 0.0166667));
    }

    public Ball(double delX, double delY, long delay) {
        super();
        super.setImage(new Image("file:assets/ball.png"));
        this.delX = delX;
        this.delY = delY;
        this.delay = delay;
        this.lastRun = 0;
        this.paddle = false;
    }

    // Methods
    public void setFps(int fps) {
        double velX = delX / (1e9 * delay);
        double velY = delY / (1e9 * delay);

        this.delay = ((long) 1e9 / fps);
        this.delX = velX * delay;
        this.delY = velY * delay;
    }

    @Override
    public void act(long now) {

        if (now - lastRun > delay) {
            // Perform movements
            if (getX() < 0) delX *= -1;
            else if (getX() + getWidth() > getWorld().getWidth()) delX *= -1;

            if (getY() < 0) delY *= -1;
            else if (getY() + getHeight() > getWorld().getHeight()) delY *= -1;

            move(delX, delY);
            lastRun = now;

            // Deal with bouncing behaviour
            try {
                ArrayList<Paddle> paddles = ((ArrayList<Paddle>)
                    super.getIntersectingObjects(((Class<Paddle>) Class.forName("game.Paddle"))));
                // For now, assume there is just one paddle.
                if (paddles.size() > 0) {
                    // only flip delY if it isn't already in a paddle
                    if (!paddle) {
                        // Literally just flip delY and set the flag
                        delY *= -1;
                        paddle = true;
                    }
                } else if (paddle) paddle = false;  // if it's exited the paddle, toggle paddle to rep this
            } catch (ClassNotFoundException e) { e.printStackTrace(); }

            // todo: explore different bouncing behaviour (vectors?)
        }
    }

    public void reverseX() { this.delX *= -1; }

    public void reverseY() { this.delY *= -1; }
}

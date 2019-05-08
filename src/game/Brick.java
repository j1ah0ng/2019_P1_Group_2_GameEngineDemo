package game;

import engine.Actor;
import java.util.ArrayList;

public class Brick extends Actor {

    public Brick() {
        super(new String[]{"file:assets/brick.png", "file:assets/brick2.png"}[(int) (2 * Math.random())]);
    }

    @Override
    public void act(long now) {
        try {
            ArrayList<Ball> balls = ((ArrayList<Ball>) super.getIntersectingObjects(((Class<Ball>) Class.forName("game.Ball"))));

            // There is only one ball.
            if (balls.size() > 0) {
                Ball ball = balls.get(0);

                if (ball.getX() > this.getX() && ball.getX() < this.getX() + this.getWidth()) {
                    // Reverse the ball's vertical velocity.
                    ball.reverseY();
                } else if (ball.getY() > this.getY() && ball.getY() < this.getY() + this.getHeight()) {
                    // Reverse its horizontal velocity.
                    ball.reverseX();
                } else {
                    // Hit corner.
                    ball.reverseX();
                    ball.reverseY();
                }

                // Remove this Brick.
                getWorld().getChildren().remove(this);
            }
        } catch (ClassNotFoundException e) { e.printStackTrace(); }
    }
}

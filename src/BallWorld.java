import java.util.ArrayList;
import java.util.List;

public class BallWorld extends World {

    // Attributes
    private ArrayList<Ball> balls;

    public BallWorld() {
        super();
    }

    @Override
    public void act(long now) {
        for (Ball ball : balls) ball.act(long now);
    }

    /**
     * Initialises the act() method. Call init() once before calling
     * the start() or act() methods, and after adding objects to the
     * World.
     */
    public void init() {
        ArrayList<Actor> actors = super.getObjects(Ball);
        balls = new ArrayList<Ball>();
        for (Actor a : actors) {
            if (a instanceof Ball) balls.add((Ball) a);
        }

        if (balls.size() < 1) throw new Exception("No balls.");
    }
}

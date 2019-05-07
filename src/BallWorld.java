import java.util.ArrayList;
import javafx.scene.Node;

public class BallWorld extends World {

    // Attributes
    private ArrayList<Ball> balls;

    public BallWorld() {
        super();
    }

    @Override
    public void act(long now) {
        for (Node ball : getChildren()) if (ball instanceof Ball) ((Ball)ball).act(now);
    }
}

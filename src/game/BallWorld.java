package game;

import engine.World;
import engine.Actor;
import javafx.scene.Node;

public class BallWorld extends World {

    // Attribute
    private Score score;

    public BallWorld() {
        super();
        score = new Score();
    }

    @Override
    public void act(long now) {
        for (Node actor: getChildren()) if (actor instanceof Actor) ((Actor) actor).act(now);
    }

    public Score getScore() { return score; }
}

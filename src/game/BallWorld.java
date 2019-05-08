package game;

import engine.World;
import engine.Actor;
import javafx.scene.Node;

public class BallWorld extends World {

    public BallWorld() {
        super();
    }

    @Override
    public void act(long now) {
        for (Node actor: getChildren()) if (actor instanceof Actor) ((Actor) actor).act(now);
    }
}

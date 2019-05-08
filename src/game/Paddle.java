package game;

import engine.Actor;
import javafx.scene.image.Image;

public class Paddle extends Actor {

    public Paddle() {
        super();
        try {
            // todo: fix relative filepaths
            super.setImage(new Image("file:assets/paddle.png"));
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void act(long now) {
        // do nothing
    }
}

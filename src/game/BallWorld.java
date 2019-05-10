package game;

import engine.World;
import javafx.scene.Node;

public class BallWorld extends World {

	private Score score;

	public BallWorld() {
		score = new Score();
		score.setX(50); // where should the x pos be? center?
		score.setY(50); // where should the y pos be? top center?
		getChildren().add(score);
	}

	@Override
	public void act(long now) {
		// according to the instructions this is left blank??
        for (Node child : getChildren()) {  //changed ball to child to make it clearer
        	if (child instanceof Ball) ((Ball)child).act(now);
    	    if (child instanceof Paddle) ((Paddle)child).act(now); //add this
    	    if (child instanceof Brick) ((Brick)child).act(now); //add this
        }
	}

	public Score getScore() {
		return score;
	}
}

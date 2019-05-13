package game;

import engine.Actor;
import javafx.scene.image.Image;

public class Brick extends Actor{
	
	double vel;
	int xPos;
	int yPos;
	
	public Brick() {
		super.setImage(new Image("file:assets/brick.png"));
	}
	
	public Brick(int x, int y) {
		super.setImage(new Image("file:assets/brick.png"));
		this.setX(x);
		this.setY(y);
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public double getVel() { return vel; }

}

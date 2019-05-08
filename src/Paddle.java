import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Paddle extends Actor {
	Image image = new Image("file:///C:/Users/pc/Desktop/ap cs game engine demo pics/paddle.png");
	
    public Paddle() {
    	setImage(image); 
    }

    @Override
    public void act(long now) {
    	if (getWorld().isKeyDown(KeyCode.LEFT)) {
    		//add code to world first
    		//add code to move paddle to the left
    	}if (getWorld().isKeyDown(KeyCode.RIGHT)) {
    		//add code to world first
    		//add code to move paddle to the right
    	}
    }
}

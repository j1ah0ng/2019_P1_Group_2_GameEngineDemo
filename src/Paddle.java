import javafx.scene.image.Image;
import java.io.FileInputStream;

public class Paddle extends Actor {

    public Paddle() {
        super();
        try {
            // todo: fix relative filepaths
            super.setImage(new Image(new FileInputStream(".\\..\\assets\\paddle.png")));
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void act(long now) {
        // do nothing
    }
}

import javafx.scene.image.Image;

public class Ball extends Actor {

    // Attributes
    double delX;         // X delta
    double delY;         // Y delta
    long delay;          // Delay between delta movements, such
                         // that velocity = sqrt(delX^2 + delY^2) / delay
                         // where delay is measured in ns
    long lastRun;        // timestamp of last run() invokation

    public Ball(double delX, double delY) {
        super();
        super.setImage(new Image("https://i.imgur.com/bHd31zm.jpg"));   // To be edited.
        this.delX = delX;
        this.delY = delY;
        this.delay = 1000;
        this.lastRun = 0;
    }

    public Ball(double delX, double delY, long delay) {
        super();
        super.setImage(new Image("https://i.imgur.com/bHd31zm.jpg"));   // To be edited.
        this.delX = delX;
        this.delY = delY;
        this.delay = delay;
        this.lastRun = 0;
    }
    @Override
    public void act(long now) {

        if (now - lastRun > delay) {
            if (getX() < 0) delX *= -1;
            else if (getX() + getWidth() > getWorld().getWidth()) delX *= -1;

            if (getY() < 0) delY *= -1;
            else if (getY() + getHeight() > getWorld().getHeight()) delY *= -1;

            move(delX, delY);
            lastRun = now;
            /* TODO: implement bouncing */
        }
    }
}

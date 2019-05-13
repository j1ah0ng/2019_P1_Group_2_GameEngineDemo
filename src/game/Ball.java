package game;

import engine.Actor;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Ball extends Actor {

	// Attributes
	double delX; // X delta
	double delY; // Y delta
	long delay; // Delay between delta movements, such
				// that velocity = sqrt(delX^2 + delY^2) / delay
				// where delay is measured in ns
	long lastRun; // timestamp of last run() invokation
	boolean flag; // helper flag to avoid unwanted behaviour with bouncing on the paddle

	// Lazy constructor
	public Ball() {
		this(20, 20);
	}

	// Constructors
	public Ball(double delX, double delY) {
		this(delX, delY, (long) (1e9 * 0.0166667));
	}

	public Ball(double delX, double delY, long delay) {
		super();
		super.setImage(new Image("file:assets/ball.png"));
		this.delX = delX;
		this.delY = delY;
		this.delay = delay;
		this.lastRun = 0;
		this.flag = false;
	}

	// Methods
	public void setFps(int fps) {
		double velX = delX / (1e9 * delay);
		double velY = delY / (1e9 * delay);

		this.delay = ((long) 1e9 / fps);
		this.delX = velX * delay;
		this.delY = velY * delay;
	}

	@Override
	public void act(long now) {

		if (now - lastRun > delay) {
			// Perform movements
			if (getX() < 0)
				delX *= -1;
			else if (getX() + getWidth() > getWorld().getWidth())
				delX *= -1;

			if (getY() < 0)
				delY *= -1;
			else if (getY() + getHeight() > getWorld().getHeight())
				delY *= -1;

			move(delX, delY);
			lastRun = now;

			// Deal with bouncing behaviour
			try {
				ArrayList<Paddle> paddles = ((ArrayList<Paddle>) super.getIntersectingObjects(
						((Class<Paddle>) Class.forName("game.Paddle"))));
				// For now, assume there is just one paddle.
				if (paddles.size() > 0) {
					// only flip delY if it isn't already in a paddle
					if (!flag) {
						Paddle paddle = paddles.get(0);
						double vel = paddle.getVel();

						if (getXCenter() > paddle.getX() && getXCenter() < paddle.getWidth() / 3.0 + paddle.getX()
								&& vel < 0) {
							delX = Math.abs(delX) * -1;
							delY *= -1;
						} else if (getXCenter() < paddle.getX()) {
							double r = Math.sqrt((delX * delX) + (delY * delY));
							delY = Math.random() * delY * -1;
							delX = Math.sqrt((r * r) - (delY * delY)) * -1;
						} else if (getXCenter() < paddle.getX() + paddle.getWidth()
								&& getXCenter() > paddle.getWidth() * 2 / 3 + paddle.getX() && vel > 0) {
							delX = Math.abs(delX);
							delY *= -1;
						} else if (getXCenter() > paddle.getX() + paddle.getWidth()) {
							double r = Math.sqrt((delX * delX) + (delY * delY));
							delY = Math.random() * delY * -1;
							delX = Math.sqrt((r * r) - (delY * delY));
						} else
							delY *= -1;

						flag = true;
					}
				} else if (flag)
					flag = false; // if it's exited the paddle, toggle paddle to rep this
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			// todo: explore different bouncing behaviour (vectors?)
		}

//		If (Ball is touching a Brick)
//		If Ball x-coord is between the Brick's left and right edges
//			reverse y-direction
//	else if Ball y-coord is between the Brick's top and bottom edges
//			reverse x-direction
//	else
//			reverse both x and y directions because we hit a corner
//	remove the Brick from the world

		try {
			ArrayList<Brick> bricks = ((ArrayList<Brick>) super.getIntersectingObjects(
					((Class<Brick>) Class.forName("game.Brick"))));
			if (bricks.size() > 0) { // if there's a brick touching the ball, bounce the ball and break the brick
				if (!flag) {
					Brick brick = bricks.get(0);
					double vel = brick.getVel();
					if (getXCenter() > brick.getX() && getXCenter() < brick.getWidth() / 3.0 + brick.getX()
							&& vel < 0) {
						delX = Math.abs(delX) * -1;
						delY *= -1;
					} else if (getXCenter() < brick.getX()) {
						double r = Math.sqrt((delX * delX) + (delY * delY));
						delY = Math.random() * delY * -1;
						delX = Math.sqrt((r * r) - (delY * delY)) * -1;
					} else if (getXCenter() < brick.getX() + brick.getWidth()
							&& getXCenter() > brick.getWidth() * 2 / 3 + brick.getX() && vel > 0) {
						delX = Math.abs(delX);
						delY *= -1;
					} else if (getXCenter() > brick.getX() + brick.getWidth()) {
						double r = Math.sqrt((delX * delX) + (delY * delY));
						delY = Math.random() * delY * -1;
						delX = Math.sqrt((r * r) - (delY * delY));
					} else
						delY *= -1;
					getWorld().remove(brick);

					flag = true;
				}

			} else if (flag)
				flag = false; // if it's exited the paddle, toggle paddle to rep this

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}

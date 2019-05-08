package game;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class Game extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        BallWorld world = new BallWorld();

        // Instantiate all Actors.
        Paddle paddle = new Paddle();
        Ball ball = new Ball();

        // Instantiate all Bricks (32x16 sprite size)
        Brick[][] bricks = new Brick[20][34];
        for (int i = 0; i < 20; ++i) {
            for (int j = 0; j < 34; ++j) {
                bricks[i][j] = new Brick();
                bricks[i][j].setX(32.0 * j);
                bricks[i][j].setY(16.0 * i);
            }
        }

        // Add all EventHandlers to engine.World.
        world.addEventHandler(MouseEvent.MOUSE_MOVED, e -> paddle.setX(e.getX() - paddle.getWidth() / 2));

        // Add all Actors to world.
        world.getChildren().addAll(paddle, ball);    // WORLD ROOT NODE
        for (Brick[] r : bricks) {
            for (Brick brick : r) {
                world.getChildren().add(brick);
            }
        }

        // Stage setup
        BorderPane root = new BorderPane(world);
        primaryStage.setTitle("Ferrante's BallBrickBuster");
        primaryStage.setScene(new Scene(root));
        primaryStage.setHeight(720);
        primaryStage.setWidth(1080);
        primaryStage.setResizable(false);

        // Final Stage-specific changes
        paddle.setY(720 * 0.85);
        world.getScore().setX(1080 * 0.10);
        world.getScore().setY(720 * 0.80);
        world.getChildren().add(world.getScore());

        // Show Stage
        primaryStage.show();

        // Begin acting
        world.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

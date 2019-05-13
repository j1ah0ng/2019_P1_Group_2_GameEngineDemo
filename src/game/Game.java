package game;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class Game extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Instantiate all Actors.
        Paddle paddle = new Paddle();
        Brick brick1 = new Brick(100, 100);
        Brick brick2 = new Brick(300, 50);
        Brick brick3 = new Brick(200, 100);
        Ball ball = new Ball();
        BallWorld world = new BallWorld();

        // Add all EventHandlers to engine.World.
        world.addEventHandler(MouseEvent.MOUSE_MOVED, e -> paddle.setX(e.getX() - paddle.getWidth() / 2));

        // Add all Actors to world.
        world.getChildren().addAll(paddle, ball, brick1, brick2, brick3);    // WORLD ROOT NODE

        // Stage setup
        BorderPane root = new BorderPane(world);
        primaryStage.setTitle("Ferrante's BallBrickBuster");
        primaryStage.setScene(new Scene(root));
        primaryStage.setHeight(720);
        primaryStage.setWidth(1080);
        primaryStage.setResizable(false);

        // Final Stage-specific changes
        paddle.setY(720 * 0.75);
        

        // Show Stage
        primaryStage.show();

        // Begin acting
        world.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package game;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Game extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Instantiate all Actors.
        Paddle paddle = new Paddle();
        Ball ball = new Ball();
        BallWorld world = new BallWorld();
        Brick brick1 = new Brick();
        Brick brick2 = new Brick();
        Brick brick3 = new Brick();
        Brick brick4 = new Brick();
        Brick brick5 = new Brick();
        Brick brick6 = new Brick();
        
        brick1.setX(110);
        brick1.setY(300);
        
        brick2.setX(160);
        brick2.setY(215);
        
        brick3.setX(500);
        brick3.setY(800);
        
        brick4.setX(400);
        brick4.setY(80);
        
        brick5.setX(420);
        brick5.setY(300);
        
        brick6.setX(800);
        brick6.setY(400);
        
        // Add all EventHandlers to engine.World.
        world.addEventHandler(MouseEvent.MOUSE_MOVED, e -> paddle.setX(e.getX() - paddle.getWidth() / 2));
        world.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
            	world.addKey(ke.getCode());

//                if (ke.getCode() == KeyCode.LEFT) {
//                	paddle.setX(paddle.getX() - paddle.getWidth() / 2);
//                } if (ke.getCode() == KeyCode.RIGHT) {
//                	paddle.setX(paddle.getX() + paddle.getWidth() / 2);
//                } 
            }
        });world.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
            	world.removeKey(ke.getCode());
          }
        });

        // Add all Actors to world.
        world.getChildren().addAll(paddle, ball, brick1, brick2, brick3, brick4, brick5, brick6);    // WORLD ROOT NODE

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
        
        //focus for keys
        world.requestFocus();

        // Begin acting
        world.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class Game extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Paddle paddle = new Paddle();

        BallWorld world = new BallWorld();

        world.addEventHandler(MouseEvent.MOUSE_MOVED, e -> paddle.setX(paddle.getWidth() / 2 + e.getX()));

        world.getChildren().add(paddle);    // WORLD ROOT NODE

        BorderPane root = new BorderPane(world);

        primaryStage.setTitle("Ferrante's BallBrickBuster");
        primaryStage.setScene(new Scene(root));
        primaryStage.setHeight(720);
        primaryStage.setWidth(1080);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

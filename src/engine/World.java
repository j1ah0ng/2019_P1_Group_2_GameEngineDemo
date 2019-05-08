package engine;

import java.util.ArrayList;
import java.lang.Class;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;

public abstract class World extends javafx.scene.layout.Pane {

    // Attributes
    private AnimationTimer t;

    // Constructor
    public World() {
        t = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
            }
        };
    }

    // Methods
    public abstract void act(long now);

    public void add(Actor a) {
        super.getChildren().add(a);
    }

    public <A extends Actor> List<A> getObjects(Class<A> type) {
        List<A> list = new ArrayList<A>();

        for (Node node : getChildren()) {
            if (type.isInstance(node)) list.add((A)node);
        }
        
        return list;
    }

    public void remove(Actor a) {
        for (int i = 0; i < getChildren().size(); ++i ){
            if (getChildren().get(i) == a) {
                getChildren().remove(a);
                return;
            }
        }
    }

    public void start() {
        t.start();
    }

    public void stop() {
        t.stop();
        t = null;
    }
}

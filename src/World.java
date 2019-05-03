import java.util.ArrayList;
import java.lang.Class;
import java.util.List;
import javafx.animation.AnimationTimer;

public abstract class World extends javafx.scene.layout.Pane {

    // Attributes
    protected ArrayList<Actor> actors;    // Holds all actors
    private AnimationTimer t;

    // Constructor
    public World() {
        actors = new ArrayList<Actor>();
    }

    // Methods
    public abstract void act(long now);

    public void add(Actor a) {
        actors.add(a);
    }

    public void getObjects() {
    }

    public <A extends Actor> List<A> getObjects(Class<A> type) {
        List<A> list = new ArrayList<A>();

        for (Actor actor : actors) {
            if (type.isInstance(actor)) list.add((A)actor);
        }
        
        return list;
    }

    public void remove(Actor a) {
        for (int i = 0; i < actors.size(); ++i ){
            if (actors.get(i) == a) {
                actors.remove(a);
                return;
            }
        }
    }

    public void start() {
        t = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(long now);
            }
        };
        t.start();
    }

    public void stop() {
        t.stop();
        t = null;
    }
}

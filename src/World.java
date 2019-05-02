import java.util.ArrayList;
import java.util.List;

public abstract class World extends javafx.scene.layout.Pane {

    // Attributes
    ArrayList<Actor> actors;    // Holds all actors

    // Constructor
    public World() {
        actors = new ArrayList<Actor>();
    }

    // Methods
    public abstract void act(long now);

    public void Add(Actor a) {
        actors.add(a);
    }

    public void getObjects() {
    }

    public <A extends Actor> List<A> getObjects(java.lang.Class<A> cls) {
        List<A> list = new <A extends Actor>List<A>();

        for (Actor : actors) {
            if (actor instanceof cls) list.add(actor);
        }
        
        return list;
    }

    public void remove(Actor a) {
        for (int i = 0; i < list.size(); ++i ){
            if (actors.get(i) == a) {
                list.remove(a);
                return;
            }
        }
    }

    public void start() {
    }

    public void stop() {
    }
}

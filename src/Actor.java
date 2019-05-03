import java.util.List;
import java.util.ArrayList;
import javafx.scene.Parent;

public abstract class Actor extends javafx.scene.image.ImageView {

    // Attributes
    
    // Constructor
    public Actor() { }

    // Methods
    public abstract void act(long now);

    public double getHeight() { return super.getFitHeight(); }

    public double getWidth() { return super.getFitWidth(); }

    public <A extends Actor> List<A> getIntersectingObjects(java.lang.Class<A>
            cls) {
        World k = this.getWorld();

        // Return empty list if no World exists
        if (k == null) return new ArrayList<A>();

        List<A> allActors = k.getObjects(cls);
        List<A> intersectors = new ArrayList<A>();
        
        for (A a : allActors) 
            if (super.intersects(a.getBoundsInLocal())) intersectors.add(a);

        return intersectors;
    }

    public World getWorld() { Parent p = super.getParent();

        return (p instanceof World) ? (World)p : null;

        /* TODO @sushisharkjl: Implement recursive traceback for nodes to trace
         * the real node parents. For example, if an Actor has a parent Node
         * that has a parent Node which is then parented by World, the uppermost
         * World node gets returned. Currently, this is difficult because the
         * standard JavaFX classes may not support this. Research is needed.
         */
    }

    public void move(double x, double y) { }
}

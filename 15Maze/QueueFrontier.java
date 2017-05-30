import java.util.*;
public class QueueFrontier implements Frontier{
    private Queue<Location> locations;
    public QueueFrontier(){
	locations = new LinkedList<Location>();
    }
    public void add (Location l){
	locations.add(l);
    }
    public Location next(){
	return locations.remove();
    }
    public int size(){
	return locations.size();
    }
}

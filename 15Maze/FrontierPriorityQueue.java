import java.util.*;
public class FrontierPriorityQueue implements Frontier{
    private PriorityQueue<Location> locations;
    public FrontierPriorityQueue(){
	locations = new PriorityQueue<Location>();
    }
    public void add(Location l){
	locations.add(l);
    }
    public Location next(){
	return locations.poll();
    }
}

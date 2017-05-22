import java.util.*;
public class StackFrontier implements Frontier{
    private Stack<Location> locations;
    public StackFrontier(){
	locations = new Stack<Location>();
    }
    public void add(Location l){
	locations.push(l);
    }
    public Location next(){
	return locations.pop();
    }
}

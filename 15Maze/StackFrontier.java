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
    public static void main(String[]args){
	StackFrontier s = new StackFrontier();
	Location h = new Location(5, 4, null, 5, 7);
	s.add(h);
	System.out.println(s.next());
    }
}

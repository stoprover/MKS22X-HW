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
    public static void main(String[]args){
	Location l = new Location (5, 4, null, 3, 5);
	QueueFrontier q = new QueueFrontier();
	q.add(l);
	System.out.println(q.next().getAStar());
    }
}

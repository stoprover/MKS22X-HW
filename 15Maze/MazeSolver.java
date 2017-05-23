import java.util.*;
public class MazeSolver{
    private Maze board;
    private boolean animate;
    public MazeSolver(String filename){
	this(filename, false);
    }
    public MazeSolver(String filename, boolean anim){
	board = new Maze(filename);
	animate = anim;
    }
    //public void solve(){
    public void solve(int type){
	//0: depth-first search- stack
	//1: breadth-first search- queue
	//2: best-first search- priority
	//3: a*- priority
	if (type == 0){
	    StackFrontier rest = new StackFrontier();
	}
	else if (type == 1){
	    QueueFrontier rest = new QueueFrontier();
	}
	else if (type == 2){
	    FrontierPriorityQueue rest = new FrontierPriorityQueue();
	}
	else if (type == 3){
	    FrontierPriorityQueue rest = new FrontierPriorityQueue();
	}
	else{
	    throw new IllegalArgumentException();
	}
	rest.add(board.getStart());
	//int i = 1;
	while(rest.size() > 0){
	    Location current = rest.next();
	    board.set(current.getRow(), current.getCol(), '.');
	    if (board.get(current.getRow(), current.getCol()) == 'E'){
		while(current.getPrevious() != null){
		   
		    board.set(current.getRow(), current.getCol(), '@');
		    current = current.getPrevious();
		}
		//trace stuff, but that's work		
		return;
	    }
	    for (Location l : getNeighbors(current)){
		rest.add(l);
	    }
	}
    }
    public static ArrayList<Location> getNeighbors(Location n){
	ArrayList<Location> friends = new ArrayList<Location>();
	int row = n.getRow();
	int col = n.getCol(); 
	if (board.get(row - 1, col) == ' '){
	    board.set(row - 1, col, '?');
	    friends.add(new Location(row - 1, col, n, 88, 88)); //does it matter what order they're added in, and does dist to start/end matter?
	}
	if (board.get(row + 1, col) == ' '){
	    board.set(row + 1, col, '?');
	    friends.add(new Location(row - 1, col, n, 88, 88));
	}
	if (board.get(row, col - 1) == ' '){
	    board.set(row, col - 1, '?');
	    friends.add(new Location(row - 1, col, n, 88, 88));
	}
	if (board.get(row, col + 1) == ' '){
	    board.set(row, col + 1, '?');
	    friends.add(new Location(row - 1, col, n, 88, 88));
	}
	return friends;
    }
    public String toString(){
        return board.toString();
    }
    public static void main(String[]args){


	//public String toString()

import java.util.*;
import java.lang.*;
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
	Frontier rest;
	if (type == 0){
	    rest = new StackFrontier();
	}
	else if (type == 1){
	    rest = new QueueFrontier();
	}
	else if (type == 2){
	    rest = new FrontierPriorityQueue();
	}
	else{
	    rest = new FrontierPriorityQueue();
	}
	rest.add(board.getStart());
	//int i = 1;
	while(rest.size() > 0){
	    Location current = rest.next();
	    this.board.set(current.getRow(), current.getCol(), '.');//herererere
	    if (this.board.get(current.getRow(), current.getCol()) == 'E'){
		board.set(current.getRow(), current.getCol(), '@');
		while(current.getPrevious() != null){
		   
		    board.set(current.getRow(), current.getCol(), '@');
		    current = current.getPrevious();
		}
		//trace stuff, but that's work		
		return;
	    }
	    for (int i = 0; i < current.getNeighbors().size(); i++){
		rest.add(getNeighbors().get(i));
		/**(Location l : current.getNeighbors()){
		   rest.add(l);*/
	    }
	}
    }
    public ArrayList getNeighbors(Location current){
	ArrayList<Location> friends = new ArrayList<Location>();
	int row = current.getRow();
	int col = current.getCol(); 
	if (this.board.get(row - 1, col) == ' '){
	    this.board.set(row - 1, col, '?');
	    friends.add(new Location(row - 1, col, current, current.getToStart() + 1, 88)); //does it matter what order they're added in, and does dist to start/end matter?
	}
	if (this.board.get(row + 1, col) == ' '){
	    this.board.set(row + 1, col, '?');
	    friends.add(new Location(row + 1, col, current, current.getToStart() + 1, 88));
	}
	if (this.board.get(row, col - 1) == ' '){
	    this.board.set(row, col - 1, '?');
	    friends.add(new Location(row, col - 1, current, current.getToStart() + 1, 88));
	}
	if (this.board.get(row, col + 1) == ' '){
	    this.board.set(row, col + 1, '?');
	    friends.add(new Location(row, col + 1, current, current.getToStart() + 1, 88));
	}
	return friends;
    }
    public String toString(){
        return board.toString();
    }
    public static void main(String[]args){
	MazeSolver m = new MazeSolver("AMaze.txt");
	m.solve(0);
	System.out.println(m.toString());
    }
}

	//public String toString()

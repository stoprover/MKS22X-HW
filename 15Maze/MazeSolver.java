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
    public void solve(){
	solve(1);
    }
    public void solve(int type){
	//0: depth-first search- stack
	//1: breadth-first search- queue
	//2: best-first search- priority
	//3: a*- priority
	//Frontier rest;
	if (type == 0){
	    solve0();
	}
	else if (type == 1){
	    solve1();
	}
        else if (type == 2){
	    solve2();
	}
	solve3();
    }
    
    private void solve0(){
	StackFrontier rest = new StackFrontier();
	rest.add(board.getStart());
	while(rest.size() > 0){
	    Location current = rest.next();
	    int row = current.getRow();
	    int col = current.getCol();
	    int start = current.getToStart();
	    int end = current.getToGoal();
	    if (this.board.get(row, col) == 'E'){
		board.set(row, col, '@');
		while(current.getPrevious() != null){
		    board.set(current.getRow(), current.getCol(), '@');
		    current = current.getPrevious();
		}
		board.set(current.getRow(), current.getCol(), '@');
		return;
	    }
	    //updating current's representation
	    this.board.set(row, col, '.');
	    //adding the neighbors into rest
	    if (board.get(row + 1, col) == ' ' || board.get(row + 1, col) == 'E' ){
		rest.add(new Location(row + 1, col, current, start + 1, end - 1));
	    }
	    if (board.get(row - 1, col) == ' ' || board.get(row - 1, col) == 'E' ){
		rest.add(new Location(row - 1, col, current, start + 1, end - 1));
	    }
	    if (board.get(row, col + 1) == ' ' || board.get(row, col + 1) == 'E' ){
		rest.add(new Location(row, col + 1, current, start + 1, end - 1));
	    }
	    if (board.get(row, col - 1) == ' ' || board.get(row, col - 1) == 'E' ){
		rest.add(new Location(row, col - 1, current, start + 1, end - 1));
	    }	    
	}
    }
    private void solve1(){
	QueueFrontier rest = new QueueFrontier();
	rest.add(board.getStart());
	while(rest.size() > 0){
	    Location current = rest.next();
	    int row = current.getRow();
	    int col = current.getCol();
	    int start = current.getToStart();
	    int end = current.getToGoal();
	    if (this.board.get(row, col) == 'E'){
		board.set(row, col, '@');
		while(current.getPrevious() != null){
		    board.set(current.getRow(), current.getCol(), '@');
		    current = current.getPrevious();
		}
		board.set(current.getRow(), current.getCol(), '@');
		return;
	    }
	    //updating current's representation
	    this.board.set(row, col, '.');
	    //adding the neighbors into rest
	    if (board.get(row + 1, col) == ' ' || board.get(row + 1, col) == 'E' ){
		rest.add(new Location(row + 1, col, current, start + 1, end - 1));
	    }
	    if (board.get(row - 1, col) == ' ' || board.get(row - 1, col) == 'E' ){
		rest.add(new Location(row - 1, col, current, start + 1, end - 1));
	    }
	    if (board.get(row, col + 1) == ' ' || board.get(row, col + 1) == 'E' ){
		rest.add(new Location(row, col + 1, current, start + 1, end - 1));
	    }
	    if (board.get(row, col - 1) == ' ' || board.get(row, col - 1) == 'E' ){
		rest.add(new Location(row, col - 1, current, start + 1, end - 1));
	    }	    
	}
    }
    private void solve2(){
	FrontierPriorityQueue rest = new FrontierPriorityQueue();
	rest.add(board.getStart());
	while(rest.size() > 0){
	    Location current = rest.next();
	    int row = current.getRow();
	    int col = current.getCol();
	    int start = current.getToStart();
	    int end = current.getToGoal();
	    if (this.board.get(row, col) == 'E'){
		board.set(row, col, '@');
		while(current.getPrevious() != null){
		    board.set(current.getRow(), current.getCol(), '@');
		    current = current.getPrevious();
		}
		board.set(current.getRow(), current.getCol(), '@');
		return;
	    }
	    //updating current's representation
	    this.board.set(row, col, '.');
	    //adding the neighbors into rest
	    if (board.get(row + 1, col) == ' ' || board.get(row + 1, col) == 'E' ){
		rest.add(new Location(row + 1, col, current, start + 1, end - 1));
	    }
	    if (board.get(row - 1, col) == ' ' || board.get(row - 1, col) == 'E' ){
		rest.add(new Location(row - 1, col, current, start + 1, end - 1));
	    }
	    if (board.get(row, col + 1) == ' ' || board.get(row, col + 1) == 'E' ){
		rest.add(new Location(row, col + 1, current, start + 1, end - 1));
	    }
	    if (board.get(row, col - 1) == ' ' || board.get(row, col - 1) == 'E' ){
		rest.add(new Location(row, col - 1, current, start + 1, end - 1));
	    }	    
	}
    }
    private void solve3(){
	FrontierPriorityQueue rest = new FrontierPriorityQueue();
	rest.add(board.getStart());
	while(rest.size() > 0){
	    Location current = rest.next();
	    int row = current.getRow();
	    int col = current.getCol();
	    int start = current.getToStart();
	    int end = current.getToGoal();
	    if (this.board.get(row, col) == 'E'){
		board.set(row, col, '@');
		while(current.getPrevious() != null){
		    board.set(current.getRow(), current.getCol(), '@');
		    current = current.getPrevious();
		}
		board.set(current.getRow(), current.getCol(), '@');
		return;
	    }
	    //updating current's representation
	    this.board.set(row, col, '.');
	    //adding the neighbors into rest
	    if (board.get(row + 1, col) == ' ' || board.get(row + 1, col) == 'E' ){
		rest.add(new Location(row + 1, col, current, start + 1, end - 1, true));
	    }
	    if (board.get(row - 1, col) == ' ' || board.get(row - 1, col) == 'E' ){
		rest.add(new Location(row - 1, col, current, start + 1, end - 1, true));
	    }
	    if (board.get(row, col + 1) == ' ' || board.get(row, col + 1) == 'E' ){
		rest.add(new Location(row, col + 1, current, start + 1, end - 1, true));
	    }
	    if (board.get(row, col - 1) == ' ' || board.get(row, col - 1) == 'E' ){
		rest.add(new Location(row, col - 1, current, start + 1, end - 1, true));
	    }
	}
    }
    public String toString(){
        return board.toString();
    }
    public String toString(int amnt){
	return board.toString(amnt);
    }
    public static void main(String[]args){
    }
}

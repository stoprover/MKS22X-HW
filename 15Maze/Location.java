public class Location implements Comparable<Location>{
    private int row, col;
    private int distToGoal, distToStart;
    private Location previous;
    private boolean aStar;
    public Location(int r, int c, Location prev, int toStart, int toGoal, boolean star){
	row = r;
	col = c;
	previous = prev;
	distToGoal = toGoal;
	distToStart = toStart;
	aStar = star;
    }
    public int getRow(){
	return row;
    }
    public int getCol(){
	return col;
    }
    public int getToGoal(){
	return distToGoal;
    }
    public int getToStart(){
	return distToStart;
    }
    public Location getPrevious(){
	return previous;
    }
    public int getAStar(){
	return aStar;
    }
    public int compareTo(Location other){
	if (getAStar()){
	    if (this.getToGoal() == other.getToGoal() && this.getToStart() == other.getToStart()){
		return 0;
	    }
	    //number that is sum of one' toGoal and toStart

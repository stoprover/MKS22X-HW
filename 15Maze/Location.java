public class MazeSolver{
    private class Location implements Comparable<Location>{
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
	public boolean getAStar(){
	    return aStar;
	}
	public int compareTo(Location other){
	    if (this.getAStar() && other.getAStar()){
		int thisData = this.getToGoal() + this.getToStart();
		int otherData = other.getToGoal() + other.getToStart();
		if (thisData > otherData){
		    return 1;
		}
		else if (thisData < otherData){
		    return -1;
		}
		return 0;
	    }
	    if (this.getToGoal() > other.getToGoal()){
		return 1;
	    }
	    else if (this.getToGoal() < other.getToGoal()){
		return -1;
	    }
	    return 0;
	}
    }
}

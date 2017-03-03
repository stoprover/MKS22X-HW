import java.util.*;
import java.io.*;

public class Maze{
    private char[][] maze;
    private boolean animate;
    private int numLines = 0;
    private int numCols = 0;

    public Maze(String filename){
	animate = false;
	this.setUpMaze(filename);
    }
    public void createMaze(String fileName){
	try{
	    File infile = new File(fileName);
	    Scanner inf = new Scanner (infile);
	    while(inf.hasNextLine()){
		numLines++;
		String line = inf.nextLine();
		numCols = line.length();
		
	    } 
	    maze = new char[numLines][numCols];		
	}catch(FileNotFoundException e){
	    maze = new char[0][0];
	    System.out.println("File does not exist.");
	}
    }
    public void setUpMaze(String fileName){
	try{
	    this.createMaze(fileName);
	    File infile = new File(fileName);
	    Scanner inf = new Scanner (infile);
	    for (int c = 0; c < numCols; c++){
		if (inf.hasNextLine()){
		    String line = inf.nextLine();
		    for (int l = 0; l < numLines; l++){
			maze[c][l] = line.charAt(l);
		    }
		}
	    }
	}catch(FileNotFoundException e){
	}
    }
    public String toString(){
	String sum = "";
	for (int i = 0; i < maze.length; i++){
	    for (int j = 0; j < maze[0].length; j++){
		sum += maze[i][j];
	    }
	    sum += "\n";
	}
	return sum;
    }
    public static void main(String[]args){
	Maze M = new Maze("input.txt");//test on a new file
	System.out.println(M.toString());
    }
}  

import java.util.*;
import java.io.*;

public class Maze{
    private char[][] maze;
    private boolean animate;
    private int numLines = 0;
    private int numCols = 0;
    private int sLine;
    private int sCol;

    public Maze(String filename){
	animate = false;
	this.setUpMaze(filename);
    }
    private void createMaze(String fileName){
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
	    System.exit(0);
	}
    }
    private void setUpMaze(String fileName){
	try{
	    this.createMaze(fileName);
	    File infile = new File(fileName);
	    Scanner inf = new Scanner (infile);
	    for (int c = 0; c < numCols; c++){
		if (inf.hasNextLine()){
		    String line = inf.nextLine();		    
		    for (int l = 0; l < line.length(); l++){
			maze[c][l] = line.charAt(l);
		    }
		}
	    }
	    if (!checkS() || !checkE()){
		System.out.println("Error: no start and or end.");
		System.exit(0);
	    }
	}catch(FileNotFoundException e){
	}
    }
    private boolean checkS(){
	for (int l = 0; l < maze.length; l++){
	    for (int c = 0; c < maze[0].length; c++){
		if (maze[l][c] == 83){
		    sLine = l;
		    sCol = c;
		    return true;
		}
	    }
	}
	return false;
    }
    private boolean checkE(){
	for (int l = 0; l < maze.length; l++){
	    for (int c = 0; c < maze[0].length; c++){
		if (maze[l][c] == 69){
		    return true;
		}
	    }
	}
	return false;
    }

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }
    
    private boolean solveH(int line, int col){
	if(animate){
	    System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }
	if (maze[line][col] == 'E'){
	    return true;
	}
	if (maze[line - 1][col] == ' ' || maze[line - 1][col] == 'E'){
	    maze[line][col] = '@';
	    if (solveH(line - 1, col)){
		return true;
	    }
	}
	if (maze[line][col + 1] == ' ' || maze[line][col + 1] == 'E'){
	    maze[line][col] = '@';
	    if (solveH(line, col + 1)){
		return true;
	    }
	}
	if (maze[line + 1][col] == ' ' || maze[line + 1][col] == 'E'){
	    maze[line][col] = '@';
	    if (solveH(line + 1, col)){
		return true;
	    }
	}
	if (maze[line][col - 1] == ' ' || maze[line][col - 1] == 'E'){
	    maze[line][col] = '@';
	    if (solveH(line, col - 1)){
		return true;
	    }
	}
	maze[line][col] = '.';
	return false;
    }
    public boolean solve(){
	return solveH(sLine, sCol);
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
    }
}  

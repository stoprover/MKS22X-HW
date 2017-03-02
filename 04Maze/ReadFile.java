import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFile{
    private String fileName;
    private int numLines = 0;
    private int numCols = 0;
    private char[][] maze;
    public ReadFile(String name){
    	fileName = name;
    }
    //public static void main(String args[]) throws FileNotFoundException {
    public void readIt() throws FileNotFoundException{
	try{
	    File infile = new File(fileName);
	    Scanner inf = new Scanner (infile);
	    // int lineNumber = 1;
	    while(inf.hasNextLine()){
		numLines++;
		//if (numLines == 0){
		//for (int i = 0; i < 
		//do string line = whatever, then do for int i = 0, i < line.length; i++ --> numCols++;
		//then that's
		String line = inf.nextLine();
		numCols = line.length();
		//System.out.println(line);
		
	    } 
	    maze = new char[numLines][numCols];
	    //while(inf.hasNextLine()){
	    //String line = inf.nextLine();
		for (int i = 0; i < numCols; i++){
		    String l = inf.nextLine();
		    for (int j = 0; j < numLines; j++){
			maze[i][j] = l.charAt(j);
		    }
		}
throw new FileNotFoundException();
	}catch(FileNotFoundException e){
	    System.out.println("file does not exist.");
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
    //public void setUpMaze(){
    //	maze = new char[numLines][numCols];
    //c
    public int getLines(){
	return numLines;
    }
    public int getCols(){
	return numCols;
    }
    public static void main(String args[]) throws FileNotFoundException{
	ReadFile R = new ReadFile("input.txt");	
	R.readIt();
	System.out.println(R.toString());
    }
}

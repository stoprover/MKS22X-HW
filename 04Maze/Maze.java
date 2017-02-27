import java.until.*;
import java.io.*;

public class Maze{
    private char[][] maze;
    private boolean animate;

    public Maze(String filename) throws FileNotFoundException{
	animate = false;
        File infile = new File(filename);// can be a path"/full/path/to/file.txt" 
        Scanner inf = new Scanner (infile);
        int lineNumber = 1;
	int c = 0;
	int r = 0;
        while(inf.hasNextChar()){
            //char letter = inf.nextChar();
	    c++;
	    if (inf.nextChar() == '\n'){
		break;
	    }
            //System.out.println(line);
        } 
	while(inf.hasNextLine()){
	    r++;
	}
	maze = new char[c][r];	
	while (inf.hasNextChar())//now we start filling maze      
 
    }  

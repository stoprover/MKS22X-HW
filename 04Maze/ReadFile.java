import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFile{
    private String fileName;
    private char[][] maze;
    public ReadFile(String name){
    	fileName = name;
    }
    //public static void main(String args[]) throws FileNotFoundException {
    public void readIt() throws FileNotFoundException{

        //instead of a try/catch, you can throw the FileNotFoundException.
        File infile = new File(fileName);// can be a path"/full/path/to/file.txt" 
        Scanner inf = new Scanner (infile);
        int lineNumber = 1;
	int numLines = 0;
	int numCols = 0;
        while(inf.hasNextLine()){
	    numLines++;
	    //if (numLines == 0){
	    //for (int i = 0; i < 
	    //do string line = whatever, then do for int i = 0, i < line.length; i++ --> numCols++;
	    //then that's
            String line = inf.nextLine();
            System.out.println(line);
        }       
    }
    public static void main(String args[]) throws FileNotFoundException{
	ReadFile R = new ReadFile("input.txt");	
	R.readIt();
    }
}

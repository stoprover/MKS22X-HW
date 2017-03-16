import java.io.*;
import java.util.*;
public class Silver2{
    private char[][]pasture;
    public int[][]past1;
    private int[][]past2;
    private int r1, c1, r2, c2, t;
    
    public Silver2(String fileName){
	readFile(fileName);
    }
    private void readFile(String fileName){
	try{
	    //deals with scanner and stuff before the array itself
	    Scanner sc = new Scanner (new File (fileName));
	    Scanner line1 = new Scanner (sc.nextLine());
	    int n = line1.nextInt();
	    int m = line1.nextInt();
	    t = line1.nextInt();

	    //deals with array
	    pasture = new char[n][m];
	    for (int row = 0; row < n; row++){
		String nc = sc.next();
		for (int col = 0; col < m; col++){
		    pasture[row][col] = nc.charAt(col);
		}
	    }

	    //deals with numbers after array
	    r1 = sc.nextInt();
	    c1 = sc.nextInt();
	    r2 = sc.nextInt();
	    c2 = sc.nextInt();
	    r1 -= 1;
	    c1 -= 1;
	    r2 -= 1;
	    c2 -= 1;
	}catch(FileNotFoundException e){
	    System.out.println(e);
	    System.exit(0);
	}
    }
    private void createPasts(){
	past1 = new int[pasture.length][pasture[0].length];
	past2 = new int[pasture.length][pasture[0].length];
	for (int i = 0; i < pasture.length; i++){
	    for (int j = 0; j < pasture[0].length; j++){
		if (pasture[i][j] == 42){ //if its a *
		    past1[i][j] = -1;
		    past2[i][j] = -1;
		}
		else { //if its a .
		    past1[i][j] = 0;
		    past2[i][j] = 0;
		}
	    }
	}
    }
    private String printArray(int[][] ary){ 
	String sum = "";
	for (int i = 0; i < ary.length; i++){
	    for (int j = 0; j < ary[0].length; j++){
		if (ary[i][j] >= 10000000){
		    sum += " " + ary[i][j];
		}
		else if (ary[i][j] >= 1000000){
		    sum += "  " + ary[i][j];
		}
		else if (ary[i][j] >= 100000){
		    sum += "   " + ary[i][j];
		}
		else if (ary[i][j] >= 10000){
		    sum += "    " + ary[i][j];
		}
		else if (ary[i][j] >= 1000){
		    sum += "     " + ary[i][j];
		}
		else if (ary[i][j] >= 100){
		    sum += "      " + ary[i][j];
		}
		else if (ary[i][j] >= 10 || ary[i][j] < 0){
		    sum += "       " + ary[i][j];
		}
		else{
		    sum += "        " + ary[i][j];
		}
	    }
	    sum += "\n";
	}
	return sum;
    }

    private void printAll(){
    	System.out.println("past1 \n" + printArray(past1));
	System.out.println("past2 \n" + printArray(past2));
    }
    private boolean inBound(int i, int j){
	return (i >= 0 && i < past1.length && j >= 0 && j < past1[0].length);
    }
    private boolean isBad(int i, int j, int[][]ary){
	return (ary[i][j] == -1);
    }

    private void genValsFromOther(int secs, int row, int col){ //something having to do with secs may have to be secs, secs - 1, or secs + 1 (idk)
	past1[row][col] = 1;
	for (int i = 1; i <= secs; i++){//1 bc 0 was taken care of in line above
	    if (i % 2 == 0){//take from past2 into past1
		for (int j = 0; j < past2.length; j++){
		    for (int k = 0; k < past2[0].length; k++){
			int toBeAdded = 0;
			if (inBound(j - 1, k) && !isBad(j, k, past2) && !isBad(j - 1, k, past2)){
			    toBeAdded += past2[j - 1][k];
			}
			if (inBound(j + 1, k) && !isBad(j, k, past2) && !isBad(j + 1, k, past2)){
			    toBeAdded += past2[j + 1][k];
			}
			if (inBound(j, k - 1) && !isBad(j, k, past2) && !isBad(j, k - 1, past2)){
			    toBeAdded += past2[j][k - 1];
			}
			if (inBound(j, k + 1) && !isBad(j, k, past2) && !isBad(j, k + 1, past2)){
			    toBeAdded += past2[j][k + 1];
			}
			if (past1[j][k] == -1){
			    past1[j][k] = -1;
			}
			else{
			    past1[j][k] = toBeAdded;
			}
		    }
		}
	    }
	    else{
		for (int j = 0; j < past1.length; j++){
		    for (int k = 0; k < past1[0].length; k++){
			int toBeAdded = 0;
			if (inBound(j - 1, k) && !isBad(j, k, past1) && !isBad(j - 1, k, past2)){
			    toBeAdded += past1[j - 1][k];
			}
			if (inBound(j + 1, k) && !isBad(j, k, past1) && !isBad(j + 1, k, past2)){
			    toBeAdded += past1[j + 1][k];
			}
			if (inBound(j, k - 1) && !isBad(j, k, past1) && !isBad(j, k - 1, past2)){
			    toBeAdded += past1[j][k - 1];
			}
			if (inBound(j, k + 1) && !isBad(j, k, past1) && !isBad(j, k + 1, past2)){
			    toBeAdded += past1[j][k + 1];
			}
			if (past2[j][k] == -1){
			    past2[j][k] = -1;
			}
			else{
			    past2[j][k] = toBeAdded;
			}
		    }
		}
	    }
	    System.out.println("i: " + i);
	    this.printAll();
	}
    }
    public void runAll(){
	this.createPasts();
	this.printAll();
	this.genValsFromOther(2, r1, c1); //this will need some more testing right (aka change first input) here but i could very well be close to the solution.
	//also you have to figure out from which board we're going to get our answer, but that's a minor issue
	//this.printAll();
    }
 
    public static void main(String[]args){
	Silver2 s = new Silver2("test2.txt");
	//System.out.println("Answer: " + s.runAll());
        s.runAll();
	//System.out.println(s.printPast2());
    }
}

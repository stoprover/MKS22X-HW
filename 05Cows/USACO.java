import java.util.*;
import java.io.*;

public class USACO{
    public USACO(){};

    private void setUpBronze(String fileName){
    }
    private void createBronze(String fileName){
	try{
	    Scanner sc = new Scanner (new File(fileName));
	    if (sc.hasNextLine()){
		Scanner firstLine = new Scanner (sc.nextLine());
		int r, c, e, n;
		int[][]lakeMap;
		if (firstLine.hasNextInt()){
		    r = firstLine.nextInt();
		}
		else{
		    throw new IllegalArgumentException("First row not formatted correctly");
		}
		if (firstLine.hasNextInt()){
		    c = firstLine.nextInt();
		}
		else{
		    throw new IllegalArgumentException("First row not formatted correctly");
		}
		if (firstLine.hasNextInt()){
		    e = firstLine.nextInt();
		}
		else{
		    throw new IllegalArgumentException("First row not formatted correctly");
		}
		if (firstLine.hasNextInt()){
		    n = firstLine.nextInt();
		}
		else{
		    throw new IllegalArgumentException("First row not formatted correctly");
		}
		System.out.println("r: " + r);
		System.out.println("c: " + c);
		System.out.println("e: " + e);
		System.out.println("n: " + n);

		lakeMap = new int[r][c];
		for (int row = 0; row < r; row++){
		    if (sc.hasNextLine()){
			for (int col = 0; col < c; col++){
			    if (sc.hasNextInt()){
				lakeMap[row][col] = sc.nextInt();
			    }
			    else{
				throw new IllegalArgumentException("Lake Grid has too few columns");
			    }
			}
		    }
		    else{
			throw new IllegalArgumentException("Lake Grid has too few rows");
		    }
		}
		//just prints lakemap
		String map = "";
		for (int i = 0; i < r; i++){
		    for (int j = 0; j < c; j++){
			map += lakeMap[i][j] + " ";
		    }
		    map += "\n";
		}
		System.out.println(map);

		String[]instructions = new String[n];
		sc.nextLine();
		for (int i = 0; i < n; i++){
		    if (!sc.hasNextLine()){
		    	throw new IllegalArgumentException("instructions not formatted correctly");
		    }
		    else{
			instructions[i] = sc.nextLine();
		    }
		}
		if (sc.hasNext()){
		    throw new IllegalArgumentException("first line does not correspond to rest of file");
		}
		
		String instruc = "";
		for (int i = 0; i < n; i ++){
		    instruc += instructions[i] + "\n";
		}
		System.out.println(instruc);

		String s = "";
		for (int i = 0; i < instructions.length; i ++) {
		    s = instructions[i];
		    Scanner forInst = new Scanner(instructions[i]);
		    int row = forInst.nextInt();
		    int col = forInst.nextInt();
		    int decrease = forInst.nextInt();
		    int largest = lakeMap[row][col];
		    for (int Ro = row; Ro < row + 3; Ro ++) {
			for (int Co = col; Co < col + 3; Co ++) {
			    if (lakeMap[Ro][Co] > largest) {
				largest = lakeMap[Ro][Co];
			    }
			    if (Ro + 1 >= row){
				break;
			    }
			    if (Co + 1 >= col){
				break;
			    }
			}
		    }
		    int maxHeight = largest - decrease;
		    System.out.println(maxHeight);
		    for (int Ro = row; Ro < row + 3; Ro ++) {
			for (int Co = col; Co < col + 3; Co ++) {
			    if (lakeMap[Ro][Co] > maxHeight) {
				lakeMap[Ro][Co] = maxHeight;
			    }
			    if (Ro + 1 >= row){
				break;
			    }
			    if (Co + 1 >= col){
				break;
			    }
			}
		    }
		    map = "";
		    for (int u = 0; i < r; i++){
			for (int j = 0; j < c; j++){
			    map += lakeMap[u][j] + " ";
			}
			map += "\n";
		    }
		    System.out.println(map);
		}
	    }
	    else{
		throw new IllegalArgumentException("File not formatted correctly");
	    }
	    /**public static int bronze(String fileName){
	int r, c, e, n;
	int[][]lakeMap;
	String[]instructions;
	try*/
	}catch(FileNotFoundException f){
	    System.out.println(f);
	    System.exit(0);
	}
    }
    
    public static void main(String[]args){
	USACO u = new USACO();
	u.createBronze("test1.txt");
    }
}

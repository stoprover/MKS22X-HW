import java.util.*;
import java.io.*;
//R is row, C is column, E is final elevation, number of commands to stomp
public class USACO{

    public USACO(){}
    public static int bronze(String fileName){
	int r, c, e, n;
	String s;
        int[][] lakeMap;
	String[] instructions;
	try{
	    Scanner sc = new Scanner(new File(fileName));
	    if (sc.hasNextLine()){
		s = sc.nextLine();
		Scanner forLine = new Scanner(s);
		/**r = s.nextInt();
		c = s.nextInt();
		e = s.nextInt();
		n = s.nextInt();*/
		r = Integer.parseInt(s.substring(0,s.indexOf(" ")));
		s = s.substring(s.indexOf(" ") + 1);
		c = Integer.parseInt(s.substring(0,s.indexOf(" ")));
		s = s.substring(s.indexOf(" ") + 1);
		e = Integer.parseInt(s.substring(0,s.indexOf(" ")));
		s = s.substring(s.indexOf(" ") + 1);
		n = Integer.parseInt(s);
		System.out.println("r: " + r);
		System.out.println("c: " + c);
		System.out.println("e: " + e);
		System.out.println("n: " + n);
		lakeMap = new int[r][c];
		for (int row = 0; row < r; row++){
		    if (sc.hasNextLine()){
			s = sc.nextLine();
			for (int col = 0; col < c; col++){
			    lakeMap[row][col] = Integer.parseInt(s.substring(0, s.indexOf(" ")));
			    s = s.substring(s.indexOf(" ") + 1);
			}
		    }
		    else throw new IllegalArgumentException("Lake grid not formatted correctly");
		}
		String map = "";
		    for (int i = 0; i < r; i++){
			for (int j = 0; j < c; j++){
			    map += lakeMap[i][j] + " ";
			}
			map += "\n";
		    }
		System.out.println(map);
	    }
	    else{
		throw new IllegalArgumentException("First row not formatted correctly");
	    }

	}catch(FileNotFoundException f){
	    System.out.println(f);
	    System.exit(0);
	}

	/**s = "";

	instructions = new String[n];
	s = "";
	for (int i = 0; i < n; i++){
	    if (sc.hasNextLine()){
		instructions[i] = sc.nextLine();
	    }
	    else throw new IllegalArgumentException("instructions not formatted correctly");
	}
	if (sc.hasNext()){
	    throw new IllegalArgumentException("first line does not correspond to rest of file");
	}
        for (int i = 0; i < instructions.length; i ++) {
	    s = instructions[i];
	    int row = Integer.parseInt(s.substring(0, s.subtring(0, s.indexOf(" "))));
	    s = s.substring(s.indexOf(" ") + 1);
	    int col = Integer.parseInt(s.substring(0, s.subtring(0, s.indexOf(" "))));
	    s = s.substring(s.indexOf(" ") + 1);
	    int decrease = Integer.parseInt(s);
	    int largest = lakeMap[row][col];
	    for (int Ro = row; Ro < row + 3; Ro ++) {
		for (int Co = col; Co < col + 3; Co ++) {
		    if (lakeMap[Ro][Co] > largest) {
			largest = lakeMap[Ro][Co];
		    }
		}
	    }
	    int maxHeight = largest - decrease;
	    for (int Ro = row; Ro < row + 3; Ro ++) {
		for (int Co = col; Co < col + 3; Co ++) {
		    if (lakeMap[Ro][Co] > maxHeight) {
			lakeMap[Ro][Co] = maxHeight;
		    }
		}
		}*/
	return 2;
    }
    public static void main(String[]args){
	USACO x = new USACO(); //does not have to do anything.
	x.bronze("test1.txt");
    }
}

    //for i in {1..10}; do hava USCO makelake.$i

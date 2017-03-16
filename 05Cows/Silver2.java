import java.io.*;
import java.util.*;
public class Silver{
    private char[][]pasture;
    private int[][]past1;
    private int[][]past2;
    private int[][]past3;
    private int r1, c1, r2, c2, t;
    
    public Silver(String fileName){
	readFile(fileName);
    }
    private void readFile(String fileName){
	try{
	    Scanner sc = new Scanner (new File (fileName));
	    Scanner line1 = new Scanner (sc.nextLine());
	    int n = line1.nextInt();
	    int m = line1.nextInt();
	    t = line1.nextInt();

	    pasture = new char[n][m];
	    for (int row = 0; row < n; row++){
		String nc = sc.next();
		for (int col = 0; col < m; col++){
		    // System.out.println(nc.charAt(col));
		    pasture[row][col] = nc.charAt(col);
		    // System.out.println(pasture[row][col]);
		    // System.out.println("next:" + sc.next());
		    // String nc = sc.next();
		    //Scanner inLine = new Scanner(nc);
		    //char lc = Character.parseChar(nc.substring(0, nc.indexOf(" ")));
		    //if (lc == '*' || lc == '.'){
		    //	pasture[row][col] = lc;
		    //}
		}
	    }
	    // System.out.println(this.printPasture());

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
	past3 = new int[pasture.length][pasture[0].length];
	for (int i = 0; i < pasture.length; i++){
	    for (int j = 0; j < pasture[0].length; j++){
		if (pasture[i][j] == 42){
		    past1[i][j] = -1;
		    past2[i][j] = -1;
		    past3[i][j] = -1;
		}
		else {
		    past1[i][j] = 0;
		    past2[i][j] = 0;
		    past3[i][j] = 0;
		}
	    }
	}
    }
    private String printPasture(){
	String sum = "";
	for (int i = 0; i < pasture.length; i++){
	    for (int j = 0; j < pasture[0].length; j++){
		sum += pasture[i][j];
	    }
	    sum += "\n";
	}
	return sum;
    }
    private String printPast1(){
	String sum = "";
	for (int i = 0; i < past1.length; i++){
	    for (int j = 0; j < past1[0].length; j++){
		sum += past1[i][j];
	    }
	    sum += "\n";
	}
	return sum;
    }
    private String printPast2(){
	String sum = "";
	for (int i = 0; i < past2.length; i++){
	    for (int j = 0; j < past2[0].length; j++){
		sum += past2[i][j];
	    }
	    sum += "\n";
	}
	return sum;
    }
    public static void main(String[]args){
	Silver s = new Silver("test2.txt");
	System.out.println("Answer: " + s.runAll());
	//System.out.println(s.printPast1());
	//System.out.println(s.printPast2());
    }
}

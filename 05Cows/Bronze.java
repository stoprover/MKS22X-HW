import java.util.*;
import java.io.*;
public class Bronze{
    private int r, c, e, n;
    private int[][]lakeMap;
    private String[]instructions;

    public Bronze(String fileName){
	readFile(fileName);
    }
    private void readFile(String fileName){
	try{
	    Scanner sc = new Scanner (new File(fileName));
	    if (sc.hasNextLine()){
		Scanner line1 = new Scanner(sc.nextLine());
		r = line1.nextInt();
		c = line1.nextInt();
		e = line1.nextInt();
		n = line1.nextInt();

		//sets up lakeMap
		lakeMap = new int[r][c];
		for (int row = 0; row < r; row++){
		    for (int col = 0; col < c; col++){
			lakeMap[row][col] = sc.nextInt();
		    }
		}

		//sets up instructions
		instructions = new String[n + 1];
		for (int i = 0; i < instructions.length; i++){
		    if (sc.hasNextLine()){
			instructions[i] = sc.nextLine();
		    }
		}
	    }
	    else{
		throw new IllegalArgumentException("First row not formatted correctly.");
	    }
	}catch(FileNotFoundException f){
	    System.out.println(f);
	    System.exit(0);
	}	
    }
    private void reduceHeight(){
	for (int i = 1; i < instructions.length; i++){
	    Scanner inst = new Scanner(instructions[i]);
	    int row = inst.nextInt() - 1;
	    int col = inst.nextInt() - 1;
	    int minus = inst.nextInt();
	    int maxHeight = lakeMap[row][col];
	    for (int ro = row; ro < row + 3; ro++){
		for (int co = col; co < col + 3; co++){
		    if (lakeMap[ro][co] > maxHeight){
			maxHeight = lakeMap[ro][co];
		    }
		    if (co + 1 >= lakeMap[0].length){
			break;
		    }
		}
		if (ro + 1 >= lakeMap.length){
		    break;
		}
	    }
	    maxHeight = maxHeight - minus;
	    for (int ro = row; ro < row + 3; ro++){
		for (int co = col; co < col + 3; co++){
		    if (lakeMap[ro][co] > maxHeight){
			lakeMap[ro][co] = maxHeight;
		    }
		    if (co + 1 >= lakeMap[0].length){
			break;
		    }
		}
		if (ro + 1 >= lakeMap.length){
		    break;
		}
	    }		
	}
    }
    private int makeLake(){
	for (int i = 0; i < lakeMap.length; i++){
	    for (int j = 0; j < lakeMap[0].length; j++){
		lakeMap[i][j] = e - lakeMap[i][j];
	    }
	}
	int total = 0;
	for (int i = 0; i < lakeMap.length; i++){
	    for (int j = 0; j < lakeMap[0].length; j++){
		if (lakeMap[i][j] >= 0){
		    total += lakeMap[i][j];
		}
	    }
	}
	return (total * 72 * 72);
    }
    private String printMap(){
	String sum = "";
	for (int i = 0; i < lakeMap.length; i++){
	    for (int j = 0; j < lakeMap[0].length; j++){
		if (lakeMap[i][j] >= 1000){
		    sum += lakeMap[i][j] + " ";
		}
		else if (lakeMap[i][j] >= 100){
		    sum += lakeMap[i][j] + "  ";
		}
		else if (lakeMap[i][j] >= 10){
		    sum += lakeMap[i][j] + "   ";
		}
		else{
		    sum += lakeMap[i][j] + "    ";
		}
	    }
	    sum += "\n";
	}
	return sum;
    }
    private String printInstruc(){
	String sum = "";
	for (int i = 0; i < instructions.length; i++){
	    sum += instructions[i] + "\n";
	}
	return sum;
    }
    public int runAll(){
	this.reduceHeight();
	return this.makeLake();
    }
		
    public static void main(String[]args){
	/**Bronze a = new Bronze("Btest1.txt");
	System.out.println(a.runAll()); //342144
	Bronze b = new Bronze("Btest2.txt");
	System.out.println(b.runAll()); //102762432
	Bronze c = new Bronze("Btest3.txt");
	System.out.println(c.runAll()); //1058992704
	Bronze d = new Bronze("Btest4.txt");
	System.out.println(d.runAll()); //753121152
	Bronze e = new Bronze("Btest5.txt");
	System.out.println(e.runAll()); //1028282688
	Bronze f = new Bronze("Btest6.txt");
	System.out.println(f.runAll()); //72207936
	Bronze g = new Bronze("Btest7.txt");
	System.out.println(g.runAll()); //265508928
	Bronze h = new Bronze("Btest8.txt");
	System.out.println(h.runAll()); //776609856
	Bronze i = new Bronze("Btest9.txt");
	System.out.println(i.runAll()); //2098830528
	Bronze j = new Bronze("Btest10.txt");
	System.out.println(j.runAll()); //211201344*/
    }
}

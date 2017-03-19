import java.util.*;
import java.io.*;

public class USACO{
    public USACO(){};

    public int bronze(String fileName){
	Bronze b = new Bronze(fileName);
	return b.runAll();
    }
    public int silver(String fileName){
	Silver2 s = new Silver2(fileName);
	return s.runAll();
    }
    public static void main(String[]args){
	/**USACO x = new USACO(); //does not have to do anything. 
	System.out.println(x.bronze("Btest2.txt"));
	System.out.println(x.silver("Stest6.txt"));*/
    }
}

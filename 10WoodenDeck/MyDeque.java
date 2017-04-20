import java.util.*;
public class MyDeque{
    private LinkedList<String> leDeque;
    private int frontInd;
    private int backInd;
    public MyDeque(){
	leDeque = new LinkedList();
	leDeque.add("fdfd");
	int frontInd = 0;
	int backInd = 0;
    }
    public void wat(){
	String l = leDeque.get(frontInd);
	System.out.println(l);
    }
    
    public String getFirst(){
	return leDeque.get(frontInd);
    }
    public String getLast(){
	return leDeque.get(backInd);
	}
    public static void main(String[]args){
	MyDeque f = new MyDeque();
	f.wat();
	
	System.out.println(f.getFirst());
	System.out.println(f.getLast());
	
    }
}

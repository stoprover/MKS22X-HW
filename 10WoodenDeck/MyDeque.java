import java.util.*;
public class MyDeque{
    private String[] leDeque;
    private int frontInd;
    private int backInd;
    public MyDeque(){
	leDeque = new String[2];
	//leDeque[0] = "fdfd";
	int frontInd = 0;
	int backInd = 0;
    }
    public void wat(){
	leDeque[0] = "5";
	leDeque[1] = "moooooo";
	backInd++;
    }
    /**private void reSize(){
	String[] newDeque = new String[leDeque.length * 2];
	if (frontInd > backInd){*/

    private boolean isFull(){
	return (frontInd == 0 && backInd == leDeque.length - 1) || (backInd == frontInd - 1);
    }
    private void reSize(){
	String[] newDeque = new String[leDeque.length * 2];
	if (front Ind > backInd) //do one thing
	    if (front Ind < backInd) //do antoher 
	/**int i = leDeque.length - 1;
	while (i > frontInd){

							     //public void addFirst(String toBeAdded){*/

    
    public String getFirst(){
	if (leDeque[frontInd] == null){
	    throw new NoSuchElementException();
	}
	return leDeque[frontInd];
    }
    public String getLast(){
	if (leDeque[backInd] == null){
	    throw new NoSuchElementException();
	}
	return leDeque[backInd];
    }
    public static void main(String[]args){
	MyDeque f = new MyDeque();
	f.wat();	
	System.out.println(f.getFirst());
	System.out.println(f.getLast());
	System.out.println(f.isFull());
	
    }
}

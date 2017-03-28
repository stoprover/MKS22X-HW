import java.util.*;
public class MyLinkedList{
    private LNode start;
    private Iterator it;

    private class LNode{
	private int size;
	private int value;
	private LNode start;
	public LNode(int val){
	    value = val;
	}
	public LNode(int val, LNode next){
	    value = val;
	    start = next;
	}
    }

    public MyLinkedList(){
	LNode takingLs = new LNode(0);
	//LNode.size = 0;
	takingLs.size = 0;
	takingLs.start = null;
	//Iterator it = this.iterator();
    }
    public String toString(){
	String sum = "[";
	Iterator current = start.iterator();
	while(current.next != null){
	    sum += current + ", ";
	    current = current.next;
	}
	sum = sum.substring(0, sum.lastIndexOf(","));
	sum += "]";
	return sum;
    }
    public static void main(String[]args){
	MyLinkedList idk = new MyLinkedList();
	System.out.println(idk.toString());
    }
}

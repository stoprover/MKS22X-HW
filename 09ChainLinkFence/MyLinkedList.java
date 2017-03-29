import java.util.*;
public class MyLinkedList{
    private LNode head;
    private int size;

    private class LNode{
	private int value;
	private LNode next;
	public LNode(int val){
	    value = val;
	}
	public LNode(int val, LNode nex){
	    value = val;
	    next = nex;
	}
    }

    public MyLinkedList(){
	head = new LNode (5);
	size = 1;
	head.next = null;
	System.out.println(head.value);
    }
    public boolean add(int val){
	LNode newOne = new LNode(val, head);
	size++;
	head = newOne;
	return true;
    }
    public String toString(){
	String sum = "[";
	LNode current = head;
	for (int i = 0; i < this.size; i++){
	    sum += current.value + ", ";
	    current = current.next;
	}
	sum = sum.substring(0, sum.lastIndexOf(","));
	sum += "]";
	return sum;
    }
    public static void main(String[]args){
	MyLinkedList idk = new MyLinkedList();
	System.out.println(idk.toString());
	System.out.println(idk.add(7));
	System.out.println(idk.toString());
    }
}

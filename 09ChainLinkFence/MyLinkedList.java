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
	head = new LNode (0);//what on earth is this
	size = 0;
	head.next = null;
	//System.out.println(head.value);
    }
    public boolean add(int val){
	LNode newOne = new LNode(val, head);
	size++;
	head = newOne;
	return true;
    }
    public int size(){
	return size;
    }
    public int get(int index){
	LNode current = head;
	for (int i = 0; i < this.size(); i++){
	    if (i == index){
		return current.value;
	    }
	    else{
		current = current.next;
	    }
	}
	return -1;//errors: too high, too low, doesn't exist, others?
    }
    public String toString(){
	if (this.size() == 0){
	    return "[]";
	}
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
	System.out.println(idk.add(6));
	System.out.println(idk.toString());
	System.out.println(idk.get(4));
	System.out.println("size: " + idk.size());
	MyLinkedList emp = new MyLinkedList();
	System.out.println("emp size: " + emp.size());
	System.out.println("emp toString: " + emp.toString());
    }
}

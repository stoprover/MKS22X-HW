import java.util.*;
public class MyLinkedList{
    private LNode head;
    private LNode tail;
    private int size;

    private class LNode{
	private int value;
	private LNode next;
	private LNode prev;
	public LNode(int val){
	    this.value = val;
	}
	public LNode(int val, LNode nex, LNode pre){
	    value = val;
	    next = nex;
	    prev = pre;
	}
    }

    public MyLinkedList(){
	head = new LNode (0);//what on earth is this
	size = 0;
	head.next = null;
	head.prev = null;
	//System.out.println(head.value);
    }
    
    public int size(){
	return size;
    }

    private LNode getNode(int index){
	if (index < 0 || index >= this.size()){    
	    throw new IndexOutOfBoundsException();
	}
        LNode current = head;
	for (int i = 0; i < this.size(); i++){
	    if (i == index){
		return current;
	    }
	    current = current.next;
	}
	return current;
    }

    private void addAfter(LNode location, LNode toBeAdded){
	//use with current!!!!!!! from getNode (aka results of it will be location)
	size++;
	if (location.next == null){
	    location.next = toBeAdded;
	    toBeAdded.prev = location;
	    toBeAdded.next = null;
	}
	else{
	    location.next.prev = toBeAdded;
	    toBeAdded.next = location.next;
	    toBeAdded.prev = location;
	    location.next = toBeAdded;
	}
    }
    private void remove (LNode target){
	size--;
	if (target.next == null){
	    target.prev.next = null;
	}
	else{
	    target.prev.next = target.next;
	    target.next.prev = target.prev;
	}
    }
    public boolean add(int val){
	LNode newOne = new LNode(val, head, null);
	size++;
       	head.prev = newOne;
	head = newOne;
	return true;
    }
    
    public int get(int index){
	/**if (index < 0 || index >= this.size()){    
	    throw new IndexOutOfBoundsException();
	    }*/
	return getNode(index).value;
    }
    public int set(int index, int newValue){
	/**if (index < 0 || index >= this.size()){    
	    throw new IndexOutOfBoundsException();
	    }*/
	int temp = getNode(index).value;
	getNode(index).value = newValue;
	return temp;
    }
    public int indexOf(int value){
	LNode current = head;
	for (int i = 0; i < this.size(); i++){
	    if (current.value == value){
		return i;
	    }
	    current = current.next;
	}
	return -1;
    }

    //private void addAfter(//int index???, LNode toBeAdded){//(LNode location, LNode toBeAdded){

    //public void add(int index, int value){
	
    /**public void add(int index, int value){
	if (index < 0 || index >= this.size()){    
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	if (index == 0){
	    LNode toBeAdded = new LNode(value, current);
	}
	if (index == size - 1){
	    LNode toBeAdded = new LNode(value);
	    for (int i = 0; i < this.size(); i++){
		if (i == index){
		    current.value = value;
		return;
	    }
	    current = current.next;
	}
	for (int i = 0; i < this.size(); i++){
	    if (i == index){
		current.value = value;
		return;
	    }
	    current = current.next;
	}
	}*/
    public String printList(){
	String sum = "[";	
	if (this.size() == 0){
	    sum += "P: null, 0: null, N: null]";
	}
	else{
	    LNode current = head;
	    for (int i = 0; i < size; i++){
		if (i == 0){
		    sum += "P: " + null + "; " + i + ": " + current.value + "; N: " + current.next.value + "\n";
		}
		else{
		    sum += "P: " + current.prev.value + "; " + i + ": " + current.value + "; N: " + current.next.value + "\n";
		}
		current = current.next;
	    }
	    sum = sum.substring(0, sum.lastIndexOf("\n"));
	    sum += "]";
	}
	return sum;
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
	System.out.println("MAIN");
	MyLinkedList idk = new MyLinkedList();
	System.out.println("basics");
	System.out.println(idk.add(7));
	System.out.println(idk.add(6));
	System.out.println(idk.add(8));
	System.out.println(idk.add(11));
	System.out.println(idk.add(14));
	//System.out.println(idk.toString());
	System.out.println(idk.printList());
	System.out.println(idk.size());
	//System.out.println(idk.set(5, 23));
	//System.out.println(idk.get(-1));
	//System.out.println(idk.size());
	//System.out.println(idk.toString());
	//System.out.println("size: " + idk.size());
	//System.out.println(idk.set(0, 4));
	//System.out.println("index: " + idk.indexOf(0));
	//System.out.println(idk.indexOf(11));
	//System.out.println(idk.indexOf(4));
	//System.out.println(idk.set(1, 4));
	//System.out.println(idk.indexOf(11));
	//System.out.println(idk.indexOf(4));
	//idk.add(2, 14343);
	//System.out.println(idk.getNode(-1).value);
	//LNode q = new LNode (null, 54, null);
	//LNode q = idk.new LNode (54, null, null);
        //idk.addAfter(idk.getNode(1),q);
	//System.out.println(idk.printList());
	//System.out.println(idk.size());
	//idk.remove(q);
	System.out.println(idk.printList());
	System.out.println(idk.size());
	//System.out.println(idk.toString());
	System.out.println("\n \n \n");
	/**
       	System.out.println("EMP");
	MyLinkedList emp = new MyLinkedList();
	System.out.println(emp.size());
	System.out.println(emp.toString());
	System.out.println(emp.printList());
	//System.out.println(emp.getNode(-1));
	//System.out.println(emp.indexOf(1));
	//System.out.println(emp.indexOf(0));
	//	System.out.println(emp.get(-1));
	//System.out.println(emp.get(-1));
	//System.out.println(emp.add(4));
	//System.out.println(emp.get(0));
	//System.out.println(emp.size());
	//System.out.println(emp.toString());
	//System.out.println(emp.set(-1, 4));
	System.out.println(emp.toString());
	System.out.println(emp.size());*/
    }
}

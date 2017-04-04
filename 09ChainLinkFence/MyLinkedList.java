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
	if (index < 0 || index >= this.size()){    
	    throw new IndexOutOfBoundsException();
	}
	return getNode(index).value;
    }
    public int set(int index, int newValue){
	if (index < 0 || index >= this.size()){    
	    throw new IndexOutOfBoundsException();
	}
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
	System.out.println(idk.toString());
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
	System.out.println(idk.size());
	System.out.println(idk.toString());
	System.out.println("\n \n \n");
	
       	System.out.println("EMP");
	MyLinkedList emp = new MyLinkedList();
	System.out.println(emp.size());
	System.out.println(emp.toString());
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
	System.out.println(emp.size());
    }
}

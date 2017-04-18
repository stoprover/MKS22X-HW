import java.util.*;
public class MyLinkedList implements Iterable<Integer>{//HAHAHAHA THIS IS A DISASTER
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
	public String toString(){
	    return value + "";
	}
    }

    
    private class LLIterator implements Iterator<Integer>{
	private LNode hd;
	private MyLinkedList l;
	public LLIterator(MyLinkedList mll){
	    l = mll;
	    hd = l.head;
	}
	public boolean hasNext(){
	    return hd != null;
	}
	public Integer next() {
	    if (hasNext()){
		int val = hd.value;
		hd = hd.next;
		return val;
	    }
	    else{
		throw new NoSuchElementException();
	    }
	    
	}
	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
    public MyLinkedList(){
	head = new LNode (0);
	size = 0;
	head.next = null;
	head.prev = null;
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
	if (size == 0){
	    throw new NullPointerException("Size is 0; there is nothing to add after.");
	}
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
	if (size == 0){
	    throw new NullPointerException("Size is 0; nothing can be removed.");
	}
	size--;
	if (target.next == null){
	    target.prev.next = null;
	}
	else if (target.prev == null){
	    target.next.prev = null;
	}
	else{
	    target.prev.next = target.next;
	    target.next.prev = target.prev;
	}
    }
    public int remove (int index){
	if (size == 0){
	    throw new NullPointerException("Size is 0; nothing can be removed");
	}
	LNode toBeRemoved = getNode(index);
       	int val = toBeRemoved.value;
	if (size == 1){
	    head = null;
	    tail = null;
	    size = 0;
	    return val;
	}
	if (toBeRemoved == head && toBeRemoved == tail){
	    head = null;
	    tail = null;
	}
	else if (toBeRemoved == head){
	    head = toBeRemoved.next;
	}
	else if (toBeRemoved == tail){
	    tail = toBeRemoved.prev;
	}
	remove(toBeRemoved);
	return val;
    }
    public boolean add(int val){
	if (size != 0){
	    LNode newOne = new LNode(val, null, tail);	    
	    tail.next = newOne;
	    tail = newOne;
	    size++;
	    return true;
	}
	else{
	    LNode newOne = new LNode(val);
	    tail = newOne;
	    head = newOne;
	    size++;
	    return true;
	}
    }
    
    public int get(int index){
	return getNode(index).value;
    }
    public int set(int index, int newValue){
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
    public void add (int index, int value){
	LNode toBeAdded;
	if (index == 0){
	    toBeAdded = new LNode(value, head, null);
	    head.prev = toBeAdded;
	    head = toBeAdded;
	    size++;
	}
	else if (index == size()){
	    toBeAdded = new LNode(value);
	    toBeAdded.prev = getNode(index - 1);
	    tail = toBeAdded;
	    addAfter(getNode(index - 1), toBeAdded);
	}
	else{
	    toBeAdded = new LNode (value, getNode(index), getNode(index - 1));
	    addAfter(getNode(index - 1), toBeAdded);
	}
    }

	 
    private String printList(){
	String sum = "[";
	if (this.size() == 0){
	    sum += "P: null, 0: null, N: null]";
	}
	else{
	    LNode current = head;
	    for (int i = 0; i < size; i++){
		if (current.prev == null && current.next == null){
		    sum += "P: " + null + "; " + i + ": " + current.value + "; N: " + null +  "\n";
		}
		else if (current.prev == null){
		    sum += "P: " + null + "; " + i + ": " + current.value + "; N: " + current.next.value + "\n";
		}
		else if (current.next == null){
		    sum += "P: " + current.prev.value + "; " + i + ": " + current.value + "; N: " + null + "\n";
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
    public Iterator<Integer> iterator() {
	return new LLIterator(this);
    }
    
    public static void main(String[]args){
    }
}

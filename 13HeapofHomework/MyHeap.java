import java.util.*;
public class MyHeap{
    private int cons;
    private ArrayList<String> heap;
    public MyHeap(){
	cons = 1;
	heap = new ArrayList<String>();
    }
    public MyHeap(boolean whichKind){
	if (whichKind){
	    cons = 1;
	}
	else{
	    cons = -1;
	}
	heap = new ArrayList<String>();
	heap.add(null);
    }
    
    public String rChild(){
	return heap.get(2 * heap.indexOf(this) + 1);
    }
    public String lChild(){
	return heap.get(2 * heap.indexOf(this));
    }
    public String parent(){
	return heap.get(heap.indexOf(this) / 2);
    }
    /**public void add (String s)
	public String remove()
	public String peek()*/
    private void pushUp(){//there are this problems
	if (thi.compareTo(this.parent()) * cons > 0){
	    int thisInd = heap.indexOf(this);
	    int parInd = heap.indexOf(this.parent());
	    heap.set(thisInd, this.parent());
	    heap.set(parInd, this);
	    this.pushUp();
	}
	else{
	    return;
	}
    }
    public String printHeap(){
	String sum = "";
	for (int i = 0; i < heap.size(); i++){
	    sum += heap.get(i);
	}
	return sum;
    }
    public static void main(String[]args){
	MyHeap h = new MyHeap();
	System.out.println(h.printHeap());
    }}
		


import java.util.*;
public class MyHeap{
    private int cons;
    private ArrayList<String> pile;
    public MyHeap(){
	cons = 1;
	pile = new ArrayList<String>();
	pile.add(null);
    }
    public MyHeap(boolean whichKind){
	if (whichKind){
	    cons = 1;
	}
	else{
	    cons = -1;
	}
	pile = new ArrayList<String>();
	pile.add(null);
    }
    
    public String rChild(int pos){
	return pile.get(2 * pos + 1);
    }
    public String lChild(int pos){
	return pile.get(2 * pos);
    }
    public String parent(int pos){
	if (pos / 2 == 0){
	    return null;
	}
	return pile.get(pos / 2);
    }
    
    /**public void add (String s)
	public String remove()
	public String peek()*/
    private void pushUp(int pos){
	if (parent(pos) == null){
	    return;
	}
	else if (pile.get(pos).compareTo(parent(pos)) * cons > 0){
	    return;
	}
	if (pile.get(pos).compareTo(parent(pos)) * cons < 0){
	    String par = parent(pos);
	    String examined = pile.get(pos);
	    int parInd = pile.indexOf(parent(pos));
	    pile.set(parInd, examined);
	    pile.set(pos, par);
	    pushUp(parInd);
	}
    }
    private void pushDown(int pos){
	if (lChild(pos) == null){
	    return;
	}
	else if (pile.get(pos).compareTo(lChild(pos)) * cons < 0){
	    return;
	}
	if (pile.get(pos).compareTo(lChild(pos)) * cons > 0){
	    String child = lChild(pos);
	    String examined = pile.get(pos);
	    int childInd = pile.indexOf(lChild(pos));
	    pile.set(childInd, examined);
	    pile.set(pos, child);
	    pushUp(childInd);
	}
    }
    public void remove(){
	pile.remove(1);
	//pushDown(

    public void add(String s){
	pile.add(s);
	//System.out.println(this.toString());
	pushUp(pile.size() - 1);
    }
    public String toString(){
	String sum = "";
	for (int i = 1; i < pile.size(); i++){
	    sum += i + ": " + pile.get(i) + " " + parent(i) + ",\n";
	    if (parent(i) != null && pile.get(i).compareTo(parent(i)) * cons < 0){
		sum += "ERROR SOMETHING IS WRONG \n";
	    } 
	}
	return sum;
    }
    public static void main(String[]args){
	MyHeap h = new MyHeap();
	h.add("n");
       	h.add("j");
	h.add("p");
	h.add("x");
	//System.out.println(h.toString());
	h.add("e");
	//System.out.println(h.toString());
	h.add("r");
	h.add("g");
	//System.out.println(h.toString());
	h.add("p");
	h.add("c");
	//System.out.println(h.toString());
	h.add("i");
	h.add("i");
	h.add("r");
	h.add("r");
	h.add("l");
	h.add("l");
	h.add("d");
	h.add("s");
	h.add("h");
	h.add("u");
	h.add("f");
	h.add("i");
	//System.out.println(h.toString());
	h.add("d");
	h.add("p");
	h.add("v");
	h.add("w");
	h.add("s");
	h.add("a");
	//h.pushUp(10);
	/**h.add("string");
	h.add("potato");
	h.add("apple");
	h.add("orange");*/
	System.out.println(h.parent(7));
	System.out.println(h.rChild(7));
	System.out.println(h.lChild(7));

	//	System.out.println(h.parent(1));
	System.out.println(h.toString());
    }
}

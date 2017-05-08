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
    
    public String rChild(String examined){
	return pile.get(2 * pile.indexOf(examined) + 1);
    }
    public String lChild(String examined){
	return pile.get(2 * pile.indexOf(examined));
    }
    public String parent(String examined){
	return pile.get(pile.indexOf(examined) / 2);
    }
    /**public void add (String s)
	public String remove()
	public String peek()*/
    private void pushUp(int pos){//there are this problems
	String examined = pile.get(pos);
	if (examined.compareTo(parent(examined)) * cons < 0){
	    int thisInd = pos;
	    int parInd = pile.indexOf(parent(examined));
	    pile.set(thisInd, parent(examined));
	    pile.set(parInd, examined);
	    pushUp(pos / 2);
	}
	else{
	    return;
	}
    }
    public void add(String s){
	pile.add(s);
	pushUp(pile.size() - 1);
    }
    public String toString(){
	String sum = "";
	for (int i = 1; i < pile.size(); i++){
	    sum += pile.get(i) + " " + parent(pile.get(i)) + ",\n";
	}
	return sum;
    }
    public static void main(String[]args){
	MyHeap h = new MyHeap();
	h.add("n");
	h.add("j");
	h.add("p");
	h.add("x");
	h.add("e");
	h.add("r");
	h.add("g");
	h.add("p");
	h.add("c");
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
	h.add("d");
	h.add("p");
	h.add("v");
	h.add("w");
	h.add("s");
	/**h.add("string");
	h.add("potato");
	h.add("apple");
	h.add("orange");*/
	//xSystem.out.println(h.parent("d"));


	System.out.println(h.toString());
    }
}

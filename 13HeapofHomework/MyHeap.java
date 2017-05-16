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
	if (2 * pos + 1 >= pile.size()){
	    return null;
	}
	return pile.get(2 * pos + 1);
    }
    public String lChild(int pos){
	if (2 * pos >= pile.size()){
	    return null;
	}
	return pile.get(2 * pos);
    }
    public String parent(int pos){
	if (pos / 2 == 0){
	    return null;
	}
	return pile.get(pos / 2);
    }
    
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
    public String peek(){
	return pile.get(1);
    }
    private void pushDown(int pos){
	int i = 1;
	while (i * 2 <= pile.size() - 1){
	    //if (lChild(i).comp
	    String examined = pile.get(i); 
	    //System.out.println(i);
	    //System.out.println(examined);
		if (lChild(i) == null){
		    //System.out.println(pile.get(i) + "no children");
		    return;
		}
		if (rChild(i) == null){
		    String child = lChild(i);
		    //System.out.println("only left child: " + child);
		    int childInd = 2 * i;
		    pile.set(i, child);
		    pile.set(childInd, examined);
		    //System.out.println(pile.get(i) + " no right child");
		    //System.out.println(pile.get(childInd));
		    return;
		}
		else if (examined.compareTo(lChild(i)) * cons > 0 || 
			 examined.compareTo(rChild(i)) * cons > 0){
		    if (lChild(i).compareTo(rChild(i)) * cons <= 0){
			String child = lChild(i);
			//System.out.println("lChild < rChild" + child);
			int childInd = 2 * i;
			pile.set(i, child);
			pile.set(childInd, examined);
			i *= 2;
		    }
		    else{
			String child = rChild(i);
			//System.out.println("rChild < lChild" + child);
			int childInd = 2 * i + 1;
			pile.set(i, child);
			pile.set(childInd, examined);
			i = i * 2 + 1;
		    }
		}
	    
		else if (examined.compareTo(lChild(i)) * cons <= 0 && examined.compareTo(rChild(i)) * cons <= 0){
		    //System.out.println(pile.get(i) + " sorted");
		    //System.out.println(pile.get(childInd));
		    return;
		}
	}
    }
    

       	/**System.out.println("removed toString\n" + toString());
	for (int i = 1; i < (pile.size()) / 2; i++){ //(pile.size() - 1) / 2; i++){
	    System.out.println("I IS: " + i);		
	    if (pile.get(i).compareTo(lChild(i)) * cons > 0 || pile.get(i).compareTo(rChild(i)) * cons > 0 ){
		System.out.println("i= " + i + "; lChild > i or rChild > i");
		if (lChild(i).compareTo(rChild(i)) * cons <= 0){
		    System.out.println("lChild < rChild");
		    String examined = pile.get(i);
		    System.out.println("examined: " + examined);
		    String child = lChild(i);
		    System.out.println("child: " + child);
		    int childInd = 2 * i;
		    System.out.println("childInd: " + childInd);
		    pile.set(i, child);
		    pile.set(childInd, examined);
		    i = childInd - 1;
		    System.out.println("current toString: \n" + toString());
		}
		else{
		    System.out.println("rChild < lChild");
		    String examined = pile.get(i);
		    System.out.println("examined: " + examined);
		    String child = rChild(i);
		    System.out.println("child: " + child);
		    int childInd = 2 * i + 1;
		    System.out.println("childInd: " + childInd);
		    pile.set(i, child);
		    pile.set(childInd, examined);
		    i = childInd = 1;
		    System.out.println("current toString: \n" + toString());
		}
	    }
	}
	}*/

    public void remove(){
	String child = pile.get(pile.size() - 1);
	pile.set(1, child);
	pile.remove(pile.size() - 1);
	pushDown(1);
	//System.out.println("removing");
    }

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
       	/**h.add("r"); 
	h.add("r");
	h.add("r");
	h.add("s");
	h.add("s");
	h.add("u");
	h.add("w");
	h.add("v");
	h.add("x");
	//h.add("v");
	System.out.println(h.toString());
	h.remove();*/
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
	h.remove();
	System.out.println(h.toString());
       	h.remove();
	h.remove();
	System.out.println(h.toString());
h.remove();
	System.out.println(h.toString());
h.remove();
	System.out.println(h.toString());
h.remove();
	System.out.println(h.toString());
h.remove();
	System.out.println(h.toString());
h.remove();
	System.out.println(h.toString());
h.remove();
	System.out.println(h.toString());
h.remove();
	System.out.println(h.toString());
h.remove();
	System.out.println(h.toString());
h.remove();
	System.out.println(h.toString());
h.remove();
	System.out.println(h.toString());

h.remove();
	System.out.println(h.toString());
h.remove();
	System.out.println(h.toString());
h.remove();
	System.out.println(h.toString());
h.remove();
	System.out.println(h.toString());
h.remove();
	System.out.println(h.toString());
h.remove();
	System.out.println(h.toString());
h.remove();
	System.out.println(h.toString());
h.remove();
	System.out.println(h.toString());
h.remove();
System.out.println(h.toString());
h.remove();
System.out.println(h.toString());
h.remove();
System.out.println(h.toString());
h.remove();
System.out.println(h.toString());
h.remove();
System.out.println(h.toString());
//h.remove();
//System.out.println(h.toString());
	System.out.println(h.toString());
	System.out.println(h.peek());
    }
}

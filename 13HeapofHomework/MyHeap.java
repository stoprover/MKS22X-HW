import java.util.*;
public class MyHeap{
    private int cons;
    private ArrayList<String> pile;
    public MyHeap(){
	cons = -1;
	pile = new ArrayList<String>();
	pile.add(null);
    }
    public MyHeap(boolean whichKind){
	if (whichKind){
	    cons = -1;
	}
	else{
	    cons = 1;
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
	    String examined = pile.get(i); 
		if (lChild(i) == null){;
		    return;
		}
		if (rChild(i) == null){
		    if (examined.compareTo(lChild(i)) * cons <= 0){
			    return;
			}
		    String child = lChild(i);
		    int childInd = 2 * i;
		    pile.set(i, child);
		    pile.set(childInd, examined);
		    return;
		}
		else if (examined.compareTo(lChild(i)) * cons > 0 || 
			 examined.compareTo(rChild(i)) * cons > 0){
		    if (lChild(i).compareTo(rChild(i)) * cons <= 0){
			String child = lChild(i);
			int childInd = 2 * i;
			pile.set(i, child);
			pile.set(childInd, examined);
			i *= 2;
		    }
		    else{
			String child = rChild(i);
			int childInd = 2 * i + 1;
			pile.set(i, child);
			pile.set(childInd, examined);
			i = i * 2 + 1;
		    }
		}
	    
		else if (examined.compareTo(lChild(i)) * cons <= 0 && examined.compareTo(rChild(i)) * cons <= 0){
		    return;
		}
	}
    }
    public void remove(){
	if (pile.size() == 1){
	    throw new IndexOutOfBoundsException();
	}
	String child = pile.get(pile.size() - 1);
	pile.set(1, child);
	pile.remove(pile.size() - 1);
	pushDown(1);
    }
    public void add(String s){
	pile.add(s);
	pushUp(pile.size() - 1);
    }
    private String printList(){
	String sum = "";
	for (int i = 1; i < pile.size(); i++){
	    sum += i + ": " + pile.get(i) + " " + parent(i) + ", \n";
	}    
	return sum;
    }
    public static void main(String[]args){
	MyHeap h = new MyHeap();
	h.remove();
    }
}

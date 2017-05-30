import java.util.*;
public class MyHeap{
    private int cons;
    private ArrayList<Integer> pile;
    public MyHeap(){
	cons = -1;
	pile = new ArrayList<Integer>();
	pile.add(0);
    }
    public MyHeap(boolean whichKind){
	if (whichKind){
	    cons = -1;
	}
	else{
	    cons = 1;
	}
	pile = new ArrayList<Integer>();
	pile.add(0);
    }
    
    public int rChild(int pos){
	if (2 * pos + 1 >= pile.size()){
	    return 0;
	}
	return pile.get(2 * pos + 1);
    }
    public int lChild(int pos){
	if (2 * pos >= pile.size()){
	    return 0;
	}
	return pile.get(2 * pos);
    }
    public int parent(int pos){
	if (pos / 2 == 0){
	    return 0;
	}
	return pile.get(pos / 2);
    }
    
    private void pushUp(int pos){
	if (parent(pos) == 0){
	    return;
	}
	else if (pile.get(pos).compareTo(parent(pos)) * cons > 0){
	    return;
	}
	if (pile.get(pos).compareTo(parent(pos)) * cons < 0){
	    int par = parent(pos);
	    int examined = pile.get(pos);
	    int parInd = pile.indexOf(parent(pos));
	    pile.set(parInd, examined);
	    pile.set(pos, par);
	    pushUp(parInd);
	}
    }
    public int peek(){
	return pile.get(1);
    }
    public int size(){
	return pile.size() - 1;
    }
    private void pushDown(int pos){
	int i = 1;
	while (i * 2 <= pile.size() - 1){
	    int examined = pile.get(i); 
		if (lChild(i) == 0){;
		    return;
		}
		if (rChild(i) == 0){
		    if ((examined <= lChild(i) && cons == 1) || (examined >= lChild(i) && cons == -1)){//examined.compareTo(lChild(i)) * cons <= 0){
			    return;
			}
		    int child = lChild(i);
		    int childInd = 2 * i;
		    pile.set(i, child);
		    pile.set(childInd, examined);
		    return;
		}
		else if (((examined > lChild(i) && cons == 1) || (examined < lChild(i) && cons == -1)) ||//examined.compareTo(lChild(i)) * cons > 0 || 
			 ((examined > rChild (i) && cons == 1) || (examined < rChild(i) && cons == -1))){//examined.compareTo(rChild(i)) * cons > 0){
		if ((lChild(i) <= rChild(i) && cons == 1) || (lChild(i) >= rChild(i) && cons == -1)){//lChild(i).compareTo(rChild(i)) * cons <= 0){
			int child = lChild(i);
			int childInd = 2 * i;
			pile.set(i, child);
			pile.set(childInd, examined);
			i *= 2;
		    }
		    else{
			int child = rChild(i);
			int childInd = 2 * i + 1;
			pile.set(i, child);
			pile.set(childInd, examined);
			i = i * 2 + 1;
		    }
		}
	    
	    else if ((examined <= lChild(i) && cons == 1) || (examined >= lChild(i) && cons == -1)){//examined.compareTo(lChild(i)) * cons <= 0 && examined.compareTo(rChild(i)) * cons <= 0){
		    return;
		}
	}
    }
    public void remove(){
	if (pile.size() == 1){
	    throw new IndexOutOfBoundsException();
	}
	int child = pile.get(pile.size() - 1);
	pile.set(1, child);
	pile.remove(pile.size() - 1);
	pushDown(1);
    }
    public void add(int s){
	if (s == 0){
	    throw new IllegalArgumentException();
	}
	pile.add(s);
	pushUp(pile.size() - 1);
    }
    public String printList(){
	String sum = "";
	for (int i = 1; i < pile.size(); i++){
	    sum += i + ": " + pile.get(i) + " " + parent(i) + ", \n";
	}    
	return sum;
    }
    public static void main(String[]args){
    }
}
   

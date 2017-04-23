import java.util.*;
public class MyDeque{
    private String[] leDeque;
    private int frontInd;
    private int backInd;
    public MyDeque(){
	leDeque = new String[2];
	int frontInd = 0;
	int backInd = 0;
    }

    private boolean isFull(){
	return (frontInd == 0 && backInd == leDeque.length - 1) || (backInd == frontInd - 1);
    }
    private void resize(){
	String[] newDeque = new String[leDeque.length * 2];
	if (frontInd > backInd){
	    int i = leDeque.length - frontInd;
	    frontInd = newDeque.length - i;
	    while (i > 0){
		newDeque[newDeque.length - i] = leDeque[leDeque.length - i];
		i--;
	    }
	    int j = 0;
	    while (j <= backInd){
		newDeque[j] = leDeque[j];
		j++;
	    }
	}
	else if (frontInd < backInd){
	    for (int i = frontInd; i <= backInd; i++){
		newDeque[i] = leDeque[i];
	    }
	    
	}
	leDeque = newDeque;
    }

    public void addFirst(String toBeAdded){
	if (toBeAdded == null){
	    throw new NullPointerException();
	}
	if (isFull()){
	    this.resize();
	}
	if (leDeque[frontInd] == null){
	    leDeque[frontInd] = toBeAdded;
	}
	else if (frontInd == 0){
	    frontInd = leDeque.length - 1;
	    leDeque[frontInd] = toBeAdded;
	}
	else{
	    frontInd--;
	    leDeque[frontInd] = toBeAdded;
	}
    }
    public void addLast(String toBeAdded){
	if (toBeAdded == null){
	    throw new NullPointerException();
	}
	if (isFull()){
	    this.resize();
	}
	if (leDeque[backInd] == null){
	    leDeque[backInd] = toBeAdded;
	}
	else if (backInd == leDeque.length - 1){
	    backInd = 0;
	    leDeque[backInd] = toBeAdded;
	}
	else{
	    backInd++;
	    leDeque[backInd] = toBeAdded;
	}
    }
   
    public String removeFirst(){
	if (leDeque[frontInd] == null){
	    throw new NoSuchElementException();
	}
	String pop = leDeque[frontInd];
	leDeque[frontInd] = null;
        if (frontInd == backInd){
	    return pop;
	}
	else if (frontInd == leDeque.length - 1){
	    frontInd = 0;
	}
	else{
	    frontInd++;
	}
	return pop;
    }
    public String removeLast(){
	if (leDeque[backInd] == null){
	    throw new NoSuchElementException();
	}
	String pop = leDeque[backInd];
	leDeque[backInd] = null;
	if (backInd == frontInd){
	    return pop;
	}
	else if (backInd == 0){
	    backInd = leDeque.length - 1;
	}
	else{
	    backInd--;
	}
	return pop;
    }
    
    public String getFirst(){
	if (leDeque[frontInd] == null){
	    throw new NoSuchElementException();
	    }
	return leDeque[frontInd];
    }
    public String getLast(){
	if (leDeque[backInd] == null){
	    throw new NoSuchElementException();
	    }
	return leDeque[backInd];
    }
    
    private String printDeque(){
	String sum = "";
	for (int i = 0; i < leDeque.length; i++){
	    sum += i + ": " + leDeque[i] + "\n";
	}
	if (leDeque[frontInd] != null && leDeque[backInd] != null){
	sum += "frontInd: " + this.getFirst() + "\n";
	sum += "backInd: " + this.getLast();
	}
	return sum;
    }
    
    public static void main(String[]args){
    }
}

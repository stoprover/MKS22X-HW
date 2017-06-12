public class RunningMedian{
    MyHeap leftHeap;
    MyHeap rightHeap;
    public RunningMedian(){
	leftHeap = new MyHeap(true);
	rightHeap = new MyHeap(false);
    }
    public void add(int i){
	if (leftHeap.size() == 0){
	    leftHeap.add(i);
	}
	else if (rightHeap.size() == 0){
	    rightHeap.add(i);
	}
	else if (leftHeap.size() == rightHeap.size()){
	    if (i > leftHeap.peek()){
		leftHeap.add(rightHeap.peek());
		rightHeap.remove();
		rightHeap.add(i);
	    }
	    else{
		leftHeap.add(i);
	    }
	}
	else if (leftHeap.size() > rightHeap.size()){
	    if (i > leftHeap.peek()){
		rightHeap.add(i);
	    }
	    else{
		rightHeap.add(leftHeap.peek());
		leftHeap.remove();
		leftHeap.add(i);
	    }
	}
    }
    public double getMedian(){
	if (leftHeap.size() == rightHeap.size()){
	    if (leftHeap.size() == 0){
		throw new IndexOutOfBoundsException();
	    }
	    return (leftHeap.peek() + rightHeap.peek()) / 2.0;
	}
	else if (leftHeap.size() > rightHeap.size()){
	    return leftHeap.peek();
	}
	return rightHeap.peek();
    }
    public static void main(String[]args){	
    }
}

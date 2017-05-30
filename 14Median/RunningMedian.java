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
	else if (leftHeap.size() > rightHeap.size()){
	    rightHeap.add(i);
	}
	else if (leftHeap.size() < rightHeap.size()){
	    leftHeap.add(i);
	}
	else{
	    leftHeap.add(i);
	}
    }
    public double getMedian(){
	if (leftHeap.size() == rightHeap.size()){
	    return (leftHeap.peek() + rightHeap.peek()) / 2;
	}
	else if (leftHeap.size() > rightHeap.size()){
	    return leftHeap.peek();
	}
	return rightHeap.peek();
    }
    public static void main(String[]args){
	RunningMedian r = new RunningMedian();
	r.add(1);
	System.out.println("left: " + r.leftHeap.printList());
	r.add(1);
	System.out.println("left: " + r.leftHeap.printList());
	System.out.println("right: " + r.rightHeap.printList());
	r.add(8);
	System.out.println("left: " + r.leftHeap.printList());
	System.out.println("right: " + r.rightHeap.printList());
	r.add(4);
	System.out.println("left: " + r.leftHeap.printList());
	System.out.println("right: " + r.rightHeap.printList());
	r.add(3);
	System.out.println("left: " + r.leftHeap.printList());
	System.out.println("right: " + r.rightHeap.printList());
	r.add(1);
	System.out.println("left: " + r.leftHeap.printList());
	System.out.println("right: " + r.rightHeap.printList());
	r.add(1);
	System.out.println("left: " + r.leftHeap.printList());
	System.out.println("right: " + r.rightHeap.printList());
	r.add(3);
	System.out.println("left: " + r.leftHeap.printList());
	System.out.println("right: " + r.rightHeap.printList());
	r.add(2);
	System.out.println("left: " + r.leftHeap.printList());
	System.out.println("right: " + r.rightHeap.printList());
	r.add(3);
	System.out.println("left: " + r.leftHeap.printList());
	System.out.println("right: " + r.rightHeap.printList());
	r.add(7);
	System.out.println("left: " + r.leftHeap.printList());
	System.out.println("right: " + r.rightHeap.printList());
	r.add(4);
	System.out.println("left: " + r.leftHeap.printList());
	System.out.println("right: " + r.rightHeap.printList());
	r.add(2);
	System.out.println("left: " + r.leftHeap.printList());
	System.out.println("right: " + r.rightHeap.printList());
	r.add(8);
	System.out.println("left: " + r.leftHeap.printList());
	System.out.println("right: " + r.rightHeap.printList());
	System.out.println(r.getMedian());
    }
}

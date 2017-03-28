public class Merge{
    public static void mergesort(int[]ary){
	if (ary.length == 1){
	    return;
	}
	else{
	    int[]left = new int[ary.length / 2];
	    for (int i = 0; i < left.length; i++){
		left[i] = ary[i];
	    }
	    int[]right = new int[ary.length - (ary.length / 2)];
	    for (int i = 0; i < right.length; i++){
		right[i] = ary[i + left.length];
	    }
	    mergesort(left);
	    mergesort(right);
	    recombine(left, right, ary);
	}
    }
    private static void recombine (int[]a, int[]b, int[]ultimate){
	int nextA = 0;
	int nextB = 0;
	for (int i = 0; i < ultimate.length; i++){
	    if (nextA >= a.length){
		ultimate[i] = b[nextB];
		nextB++;
	    }
	    else if (nextB >= b.length){
		ultimate[i] = a[nextA];
		nextA++;
	    }
	    else if (a[nextA] <= b[nextB]){
		ultimate[i] = a[nextA];
		nextA++;
	    }
	    else if (b[nextB] < a[nextA]){
		ultimate[i] = b[nextB];
		nextB++;
	    }
	}
    }
    public static String toString(int[]ary){
	String sum = "";
	for (int i = 0; i < ary.length; i++){
	    sum += ary[i] + " ";
	}
	return sum;
    }
    public static void main(String[]args){
    }
}

import java.util.Random;
public class Quick{
    public static int[] part(int [] data, int start, int end){
	Random r = new Random();
	int pivot = r.nextInt((end - start) + 1);
	pivot += start;
	if (data.length == 0){
	    int[]ary = new int[2];
	    ary[0] = start;
	    ary[1] = end;
	    return ary;
	}
	int atPivot = data[pivot];
	//System.out.println("pivot: " + pivot);
	//System.out.println("atPivot: " + atPivot);
	int i = start;
	int lt = start;
	int gt = end;
	while (i <= gt){
	    if (data[i] < atPivot){
		int temp = data[i];
		data[i] = data[lt];
		data[lt] = temp;
		lt++;
		i++;
	    }
	    else if (data[i] == atPivot){
		i++;
	    }
	    else{
		int temp = data[gt];
		data[gt] = data[i];
		data[i] = temp;
		gt --;
	    }
	}
	int[]ary = new int[2];
	ary[0] = lt;
	ary[1] = gt;
	return ary;
    }
    //dif sizes, approx 1 million; randomized min to max; randomized 0 to 10; all same value; sorted; reverse sorted
    private static void sortH(int[]ary, int lo, int hi){
	if (lo < hi){   
	    int[] ans = new int[2];
	    ans = part(ary, lo, hi);
	    sortH(ary, lo, ans[0] - 1);
	    sortH(ary, ans[1] + 1, hi);
	    //System.out.println("ans[0]: " + ans[0]);
	    //System.out.println("ans[1]: " + ans[1]);
	}
    }

    public static void quicksort (int[]ary){
	sortH(ary, 0, ary.length - 1);
    }

    private static int selectH(int[]ary, int lo, int hi, int k){
	int[]ans = new int[2];
	ans = part(ary, lo, hi);
	if (k < ans[0]){
	    //System.out.println("k < lt: \n" + toString(ary));
	    return selectH(ary, lo, ans[0] - 1, k);
	}
	if (k > ans[1]){
	    //System.out.println("k > gt: \n" + toString(ary));
	    return selectH(ary, ans[1] + 1, hi, k);
	}
	//System.out.println("were done: \n" + toString(ary));
	if (k >= ans[0] && k <= ans[1]){
	    return ary[k];
	}
	return ary[k];
    }
	//if (k 
    ////QUICKSELECT RETURNS AN INT
    public static int quickselect(int[]ary, int k){
	return selectH(ary, 0, ary.length - 1, k);
    }
    public static String toString(int[]ary){
	String sum = "";
	for (int i = 0; i < ary.length; i++){
	    sum += ary[i] + " ";
	}
	return sum;
    }
    public static void main(String[]args){
	int []kuzkinaMat = new int[1000000];
	Random r = new Random();
	for (int i = 0; i < kuzkinaMat.length; i++){
	    kuzkinaMat[i] = r.nextInt();
	}
	int[]potato = new int[11];
	/**	potato[0] = 10;
	potato[1] = 9;
	potato[2] = 8;
	potato[3] = 7;
	potato[4] = 6;
	potato[5] = 5;
	potato[6] = 4;
	potato[7] = 3;
	potato[8] = 2;
	potato[9] = 1;
	potato[10] = 0;
	/**potato[0] = 1; //v
	potato[1] = 7; //14; //v
	potato[2] = 23; //v
	potato[3] = 4; //v
	potato[4] = 7; //v
	potato[5] = 0;
	potato[6] = 3;
	potato[7] = 22; //v
	potato[8] = 7; //144; //v
	potato[9] = 2;
	potato[10] = 12;
	/**potato[0] = 999;
	potato[1] = 999;
	potato[2] = 999;
	potato[3] = 4;
	potato[4] = 1;
	potato[5] = 0;
	potato[6] = 3;
	potato[7] = 2;
	potato[8] = 999;
	potato[9] = 999;
	potato[10] = 999;*/
	int[]pop = new int[0];
	//pop[0] = 5;
	//System.out.println("original: \n" + toString(kuzkinaMat));
	//System.out.println("omg this is answer: " + quickselect(potato, potato.length - 1));
	//System.out.println("semimodified: \n" + toString(potato));	
	quicksort(kuzkinaMat);
	System.out.println("new: \n" + toString(kuzkinaMat));
	// java Quick >out.txt 2> err.txt

    }
}

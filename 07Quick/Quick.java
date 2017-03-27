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
    private static void sortH(int[]ary, int lo, int hi){
	if (lo < hi){   
	    int[] ans = new int[2];
	    ans = part(ary, lo, hi);
	    sortH(ary, lo, ans[0] - 1);
	    sortH(ary, ans[1] + 1, hi);
	}
    }

    public static void quicksort (int[]ary){
	sortH(ary, 0, ary.length - 1);
    }

    private static int selectH(int[]ary, int lo, int hi, int k){
	int[]ans = new int[2];
	ans = part(ary, lo, hi);
	if (k < ans[0]){
	    return selectH(ary, lo, ans[0] - 1, k);
	}
	if (k > ans[1]){
	    return selectH(ary, ans[1] + 1, hi, k);
	}
	if (k >= ans[0] && k <= ans[1]){
	    return ary[k];
	}
	return ary[k];
    }
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
    }
}

import java.util.Random;
public class Quick{
    public static int part(int [] data, int start, int end){
	Random r = new Random();
	int pivot = r.nextInt(data.length);
	int atPivot = data[pivot];
	System.out.println("atPivot: " + atPivot);
	data[pivot] = data[end];
	data[end] = atPivot;
	System.out.println("just moved to end" + toString(data));
	//this for loop (and that's it) is wrong somehow
	for (int i = start; i <= end; i++){
	    int k = 0;
	    if (data[k] > atPivot){
		int temp = data[k];
		for (int j = k; j < end; j++){
		    data[j] = data[j + 1];
		}
		data[end] = temp;
		k = i - 1;
		System.out.println(toString(data));
	    }
	}
	for (int i = start; i <= end; i++){
	    if (data[i] == atPivot){
		return i;
	    }
	}
	return -1;
    }
    public static String toString(int[]ary){
	String sum = "";
	for (int i = 0; i < ary.length; i++){
	    sum += ary[i] + " ";
	}
	return sum;
    }
    public static void main(String[]args){
	int[]potato = new int[11];
	potato[0] = 999;
	potato[1] = 999;
	potato[2] = 999;
	potato[3] = 4;
	potato[4] = 1;
	potato[5] = 0;
	potato[6] = 3;
	potato[7] = 2;
	potato[8] = 999;
	potato[9] = 999;
	potato[10] = 999;
	System.out.println(toString(potato));
	System.out.println(part(potato, 0, 10));
	System.out.println(toString(potato));
    }
}

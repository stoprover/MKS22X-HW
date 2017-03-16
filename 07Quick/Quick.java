import java.util.Random;
public class Quick{
    public static int part(int [] data, int start, int end){
	//Random r = new Random();
	//int pivot = r.nextInt(data.length);
	int pivot = 3;
	int atPivot = data[pivot];
	System.out.println("atPivot: " + atPivot);
	data[pivot] = data[end];
	data[end] = atPivot;
	System.out.println("just moved to end" + toString(data));
	//this for loop (and that's it) is wrong somehow
	int indOfChosen = end;
	int i = start;
	//possibly move the pivot thing to end of your subsection, then start moving everyone else over to just before it or just after it until you reach some placeholder for index of the first element you moved?
	int q = end;//possibly end - 1
	int p = start;//current var you're at
	while (q >= start){
	   
	    if (data[p] >= atPivot){
		int temp = data[p];
		for (int j = p; j < end; j++){
		    data[j] = data[j + 1];
		}
		data[end] = temp;
	    }
	    if (data[q] < atPivot){
		p++;
		//int temp = data[start];
	    }
	    q--;
	}

	/**while (i <= end){
	    if (data[i] > atPivot){
		int temp = data[i];
		for (int j = i; j < end; j++){
		    data[j] = data[j + 1];
		}
		data[end] = temp;
		i++;
	    }
	    else {
		i = i;
	    }
	    }*/
	/**for (int i = start; i <= indOfChosen; i++){
	    System.out.println("i: " + i);
	    //int k = i;
	    System.out.println("data[k] " + data[i]);
	    if (data[i] > atPivot){
		int temp = data[i];
		for (int j = i; j < end; j++){
		    data[j] = data[j + 1];
		}
		data[end] = temp;
		i -= 1;
		System.out.println(toString(data));
		}*/
	/**for (int k = start; k < end; k++){
	    if (data[k] == atPivot){
		indOfChosen = pivot;
	    }
	    }*/
	
	for (int l = start; l <= end; l++){
	    if (data[l] == atPivot){
		return l;
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
	potato[0] = 1;
	potato[1] = 14;
	potato[2] = 23;
	potato[3] = 4;
	potato[4] = 7;
	potato[5] = 0;
	potato[6] = 3;
	potato[7] = 2;
	potato[8] = 144;
	potato[9] = 22;
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
	System.out.println(toString(potato));
	System.out.println(part(potato, 0, 10));
	System.out.println(toString(potato));
    }
}

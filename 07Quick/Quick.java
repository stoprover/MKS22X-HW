import java.util.Random;
public class Quick{
    public static int[] part(int [] data, int start, int end){
	//Random r = new Random();
	//int pivot = r.nextInt(data.length);
	int pivot = 4;
	int atPivot = data[pivot]; //3
	System.out.println("atPivot: " + atPivot);
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




		


	/**for (int i = start; i < pivot; i++){
	    if (data[i] > atPivot){
		int temp = data[i];
		for (int j = i; j < end; j++){
		    data[j] = data[j + 1];
		}
		data[end] = temp;
		i--;
		System.out.println("1st \n" + toString(data));
	    }
	}
	for (int i = start; i <= end; i++){
	    if (data[i] == atPivot){
		pivot = i;
		break;
	    }
	}
	/**for (int k = pivot + 1; k <= end; k++){
	    if (data[k] < atPivot){
		int temp = data[k];
		for (int j = k; j > start; j--){
		    data[j] = data[j - 1];
		}
		data[start] = temp;
		k--;
		System.out.println("2nd \n" + toString(data));
	    }
	    }*/

	/**while (q >= start){
	   
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
	
	/**for (int l = start; l <= end; l++){
	    if (data[l] == atPivot){
		return l;
	    }
	    }*/
	int[]ary = new int[2];
	ary[0] = lt;
	ary[1] = gt;
	return ary;
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
	potato[0] = 1; //v
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
	System.out.println("original: \n" + toString(potato));
	System.out.println(part(potato, 1, 5)[0]);
	//System.out.println(part(potato, 0, 10)[0]);
	System.out.println("new: \n" + toString(potato));
    }
}

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
	System.out.println("pivot: " + pivot);
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
	int[]ary = new int[2];
	ary[0] = lt;
	ary[1] = gt;
	return ary;
    }
    public static void quicksort(int[]ary){
	//something needs to happen if it's length 0
	part(ary, 0, part(ary, 0, ary.length - 1)[0]);
	part(ary, part(ary, 0, ary.length - 1)[1], ary.length - 1);
	//this is probably a high key disaster but idk what's going on anymore so good night
	//for (int i = 0; i < ary.length - 1; i++){
	//  if (ary[i] > ary[i + 1]){
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
	potato[10] = 12;*/
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
	int[]pop = new int[1];
	
	System.out.println("original: \n" + toString(potato));
	int[]ary = new int[2];
	System.out.println(part(potato, 3, 7));
	//System.out.println(ary[0]);
	//System.out.println(ary[1]);
	//System.out.println(part(potato, 0, 10)[0]);
	System.out.println("new: \n" + toString(potato));
    }
}

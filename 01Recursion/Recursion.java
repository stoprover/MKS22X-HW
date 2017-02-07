import java.lang.*;
public class Recursion{
    public static String name(){
	return "Toprover,Steven";
    }
    public static boolean isCloseEnough(double a, double b){
	if (a < b){
	    return (Math.abs(a - b)) < a * .000000001;
	}
	else{
	    return (Math.abs(a - b)) < b * .000000001;
	}
    }
    public static double betterGuess(double num, double orig){
	if (isCloseEnough(orig*orig, num)){
	    return orig;
	}
	return betterGuess(num, ((num / orig) + orig)/2);
    }
    public static double sqrt (double n){
	if (n < 0){
	    throw new IllegalArgumentException("The input is negative.");
	}//exception and whatnot
	return betterGuess(n, 1);
    }
    public static void main (String[]args){
	    //the following are test cases
	/**System.out.println(name());
	System.out.println(isCloseEnough(.10000000000, .10000000010));
	System.out.println(sqrt(100));
	System.out.println(sqrt(-4));
	System.out.println(sqrt(4));*/
    }

}

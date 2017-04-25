import java.util.*;
public class StackCalc{
    private static String[]token = new String[0];
    private static Stack values = new Stack<Double>();
    public static double apply(String op, String a, String b){
	if (op.equals("+")){
	    return Double.parseDouble(a) + Double.parseDouble(b);
	}
	else if (op.equals("-")){
	    return Double.parseDouble(a) - Double.parseDouble(b);
	}
	else if (op.equals("*")){
	    return Double.parseDouble(a) * Double.parseDouble(b);
	}
	else if (op.equals("/")){
	    return Double.parseDouble(a) / Double.parseDouble(b);
	}
	return Double.parseDouble(a) % Double.parseDouble(b);
    }
    public static boolean isOp(String s){
	return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%");
    }
    public static void fillArray(String s){
	token = s.split(" ");
    }
    public static double eval(String s){
	fillArray(s);
	for (int i = 0; i < token.length; i++){
	    if (isOp(token[i])){
		String a = values.pop().toString();
		values.push(apply(token[i], values.pop().toString(), a));
	    }
	    else{
		values.push(token[i]);
	    }
	}
	return Double.parseDouble(values.pop().toString());
    }
    
    public static void main (String[]args){
    }
}

import java.util.*;
public class Quiz2Redux{  
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	if(s.length() == 0){
	    return words;
	}
	help( words , s);
	Collections.sort(words);
	return words;
    }
    
    private static void help( ArrayList<String> words, String s){
	words.add("");
	words.add("" + s.charAt(0));
	for (int i = 1; i < s.length(); i++){
	    int ws = words.size();
	    for (int j = 0; j < ws; j++){
		words.add(words.get(j) + s.charAt(i));
	    }
	}
    }

    public static void main(String[]args){
    }
}

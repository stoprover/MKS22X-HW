//R is row, C is column, E is final elevation, number of commands to stomp
public class Makelake{
    private int r;
    private int c;
    private int e;
    private int n;
    private int[][] lakeMap;

    public Makelake(String fileName){
	try{
	    Scanner sc = new Scanner(new File(fileName));
	    if (sc.hasNextLine()){
		String s = sc.nextLine();
	    }
	    else{
		throw new IllegalArgumentException("First row not formatted correctly");
	    }

	}catch(FileNotFoundException e){
	    System.out.println(e);
	    System.exit(0);
	}
	r = Integer.parseInt(s.substring(0,s.indexOf(" ")));
	s = s.substring(s.indexOf(" ") + 1);
	c = Integer.parseInt(s.substring(0,s.indexOf(" ")));
	s = s.substring(s.indexOf(" ") + 1);
	e = Integer.parseInt(s.substring(0,s.indexOf(" ")));
	s = s.substring(s.indexOf(" ") + 1);
	n = Integer.parseInt(s.substring(0,s.indexOf(" ")));
	lakeMap = new int[r][c];
	int currentRow = 1;
	s = "";
	while (currentRow < 1 + r){
	    if (sc.hasNextLine()){
		s += sc.nextLine();
	    }
	    else throw new IllegalArgumentException("Lake grid not formatted correctly");
	    for (
}

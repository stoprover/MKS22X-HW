public class QueenBoard{
    private int[][]board;
    private int solutionCount;
 
    public QueenBoard(int size){
	board = new int[size][size];
    }

    private boolean addQueen(int col, int row){
	if (board[col][row] == 0){
	    //North	
	    int k = 0;
	    while (row + k < board.length){
		board[col][row +k] += 1;
		k++;
	    }
	    //South
	    k = 0;
	    while (row - k > -1){
		board[col][row-k] += 1;
		k++;
	    }
	    //East
	    k = 0;
	    while (col + k < board.length){
		board[col +  k][row] += 1;
		k++;
	    }
	    //West
	    k = 0;
	    while (col - k > -1){
		board[col - k][row] += 1;
		k++;
	    }
	    //NE
	    k = 0;
	    while (col + k < board.length && row + k < board.length){
		board[col+k][row+k] += 1;
		k++;
	    }
	    //SE
	    k = 0;
	    while (col + k < board.length && row - k > -1){
		board[col+k][row-k] += 1;
		k++;
	    }
	    //NW
	    k = 0;
	    while (col - k > -1 && row + k < board.length){
		board[col - k][row+k] += 1;
		k++;
	    }
	    //SW
	    k = 0;
	    while (col - k > -1 && row - k > -1){
		board[col - k][row - k] += 1;
		k++;
	    }
	    board[col][row] = -1;
	    return true;
	}
	else{
	    return false;
	}
    }
    private boolean removeQueen(int col, int row){
	if (board[col][row] == -1){
	    //North	
	    int k = 0;
	    while (row + k < board.length){
		board[col][row +k] -= 1;
		k++;
	    }
	    //South
	    k = 0;
	    while (row - k > -1){
		board[col][row-k] -= 1;
		k++;
	    }
	    //East
	    k = 0;
	    while (col + k < board.length){
		board[col +  k][row] -= 1;
		k++;
	    }
	    //West
	    k = 0;
	    while (col - k > -1){
		board[col - k][row] -= 1;
		k++;
	    }
	    //NE
	    k = 0;
	    while (col + k < board.length && row + k < board.length){
		board[col+k][row+k] -= 1;
		k++;
	    }
	    //SE
	    k = 0;
	    while (col + k < board.length && row - k > -1){
		board[col+k][row-k] -= 1;
		k++;
	    }
	    //NW
	    k = 0;
	    while (col - k > -1 && row + k < board.length){
		board[col - k][row+k] -= 1;
		k++;
	    }
	    //SW
	    k = 0;
	    while (col - k > -1 && row - k > -1){
		board[col - k][row - k] -= 1;
		k++;
	    }
	    board[col][row] = 0;
	    return true;
	}
	else{
	    return false;
	}
    }
    private boolean solveY(int col){
	//base case
	if (col == board.length){
	    return true;
	}
	for (int r = 0; r < board.length; r++){
	    if (board[col][r] == 0){
		addQueen(col, r);
		if (solveY(col + 1)){
		    return true;
		}
	    }
	    removeQueen(col, r);
	}
	return false;
    }
    private boolean solveZ(int col){
	//base case
	if (col == board.length){
	    solutionCount++;
	    return true;
	}
	for (int r = 0; r < board.length; r++){
	    if (board[col][r] == 0){
		addQueen(col, r);
		if (solveZ(col + 1)){
		}    
		removeQueen(col, r);	
	    }
	}
        return false;	
    }	
	    
    public void solve(){
	this.solveY(0);
    }
    public void countSolutions(){
	solutionCount = 0;
       	this.solveZ(0);
    }
    public int getSolutionCount(){
	if (solutionCount == 0 && board.length != 2 && board.length != 3){
	    solutionCount = -1;
	}
	return solutionCount;
    }
    public String toString(){
	String sum = "";
	for (int row = 0; row < board.length; row++){
	    for (int col = 0; col < board.length; col++){
		if (board[col][row] == -1){
		    sum += " " + board[col][row];
		}
		else{
		    sum += "  " + board[col][row];
		}
	    }
	    sum += "\n";
	}
	return sum;
    }
    
    public static void main (String[]args){
	/**	QueenBoard Q = new QueenBoard(8);
		System.out.println(Q.addQueen(2,0));
		System.out.println(Q.toString());
		System.out.println(Q.addQueen(5,7));
		//System.out.println(Q.addQueen(0,2));
		System.out.println(Q.toString());
		System.out.println(Q.prevRow(0));
		System.out.println(Q.prevRow(2));
		System.out.println(Q.removeQueen(2,0));
		System.out.println(Q.toString());
		System.out.println(Q.removeQueen(5,1));
		System.out.println(Q.toString());
		System.out.println(Q.solveOne(8));
		System.out.println(Q.solveOne(5));
		Q.addQueen(7,2);
		System.out.println(Q.solveOne(8));*/
	//QueenBoard B = new QueenBoard(3);
	//System.out.println(B.solveY(0));
	//System.out.println(B.toString());
       	//B.solve();
	//System.out.println(B.solveO(0,0));
        //System.out.println(B.toString());
	//System.out.println(B.solveZ(0));
	//B.countSolutions();
	//System.out.println(B.toString());
	//System.out.println(B.getSolutionCount());
       	//B.countSolutions();
	//System.out.println(B.getSolutionCount());
    }
}

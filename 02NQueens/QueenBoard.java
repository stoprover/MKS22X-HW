public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    private int pr;
    //private int size;

    //THERE SHOULD BE AN EXCEPTION SOMEWHERE TO MAKESURE SIZE ISNT NEGATIVE!!!

    
    public QueenBoard(int size){
	//size = sizeOfBoard;
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
    private int prevRow(int col){
	for (int i = 0; i < board.length; i++){
	    if (board[col][i] == -1){
		return i;
	    }
	}
	return -1;
    }

    public boolean solveOne(int col, int pvrw){
	if (col == board.length){
	    for (int i = 0; i < board.length; i++){
		if (board[col - 1][i] == -1){
		    return true;
		}
		if (i == board.length - 1){
		    return false;
		}
	    }
	}
	//int pr;
	/**if (col == 0){
	    pr = 0;
	}
	else{
	    pr = prevRow(col - 1);
	    }*/
	for (int r = pvrw; r < board.length; r++){
	    if (board[col][r] == 0){
		addQueen(col, r);
		return solveOne(col + 1, 0);
	    }
	    else if (r == board.length - 1 && board[col][r] != 0){
		if (col == 0){
		    pvrw = prevRow(0);
		    removeQueen(0, pvrw);  
		    return solveOne(0, pvrw + 1);
		    }
		else{
		    pvrw = prevRow(col - 1);
		    removeQueen(col - 1, pvrw);
		    //pr++; 
		    if (pvrw + 1 >= board.length){
			pvrw = prevRow(col - 2);
			removeQueen(col - 2, pvrw);
			return solveOne(col - 2, pvrw + 1);
		    }
		    else{
			return solveOne(col - 1, pvrw + 1);
		    }
		}   
	    }
	}
	return false;
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
	QueenBoard B = new QueenBoard(9);
	
	System.out.println(B.solveOne(0, 3));
	System.out.println(B.toString());
    }
}

	//idea to find prevRow: set it equal 

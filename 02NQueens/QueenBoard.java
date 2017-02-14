//I was unable to finish the recursive part of the helper function for solutionCount(). I will finish it tomorrow.
public class QueenBoard{
    private int[][]board;
    private int solutionCount = -1;
    private int pr = 0;
 
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

    private boolean solveO(int col, int pvrw){
	if (board.length == 2 || board.length == 3){
	    return false;
	}
	if (col == board.length){
	    return true;
	}
	for (int r = pvrw; r < board.length; r++){
	    if (board[col][r] == 0){
		addQueen(col, r);
		if (solveO(col + 1, 0)){
		    return true;
		}	
	    }	    
	    else if (r == board.length - 1){
		pvrw = prevRow(col - 1);
		removeQueen(col - 1, pvrw);
		if (pvrw + 1 == board.length){
		    pvrw = prevRow(col - 2);
		    removeQueen(col - 2, pvrw);
		    return solveO(col - 2, pvrw + 1);
		}
		else{
		    return solveO(col - 1, pvrw + 1);
		}
	    }
	}
	return false;
    }

    private int solveC(int col, int pvrw){
	if (board.length == 2 || board.length == 3){
	    return solutionCount;
	}
	solveO(col, pvrw);
	pvrw = prevRow(board.length - 1);
	removeQueen(board.length - 1, pvrw);
	pvrw = prevRow(board.length - 2);
	removeQueen(board.length - 2, pvrw);
	solveC(board.length - 2, pvrw + 1);
	/**if (solveO (board.length - 2, pvrw)){
	    solutionCount++;
	    return solveO(board.length - 1, pvrw);*/
	//}
	//	else{
	    return solutionCount;
	    //}
    }
     private boolean solveD(int col, int pvrw){
	if (board.length == 2 || board.length == 3){
	    return false;
	}
	if (col == board.length){
	    solutionCount++;
	    return true;
	}
	for (int r = pvrw; r < board.length; r++){
	    if (board[col][r] == 0){
		addQueen(col, r);
		if (solveD(col + 1, 0)){
		    return true;
		}	
	    }	    
	    else if (r == board.length - 1){
		pvrw = prevRow(col - 1);
		removeQueen(col - 1, pvrw);
		if (pvrw + 1 == board.length){
		    pvrw = prevRow(col - 2);
		    removeQueen(col - 2, pvrw);
		    return solveD(col - 2, pvrw + 1);
		}
		else{
		    return solveD(col - 1, pvrw + 1);
		}
	    }
	}
	return false;
    }
    /**private int solveC(int col, int pvrw){
	if (board.length == 2 || board.length == 3){
	    return solutionCount;
	}
	if (col == board.length){
	    solutionCount++;
	    pvrw = prevRow(col - 1);
	    removeQueen(col - 1, pvrw);
	    pvrw = prevRow(col - 2);
	    removeQueen(col - 2, pvrw);
	    if (pvrw + 1 == board.length){
		pvrw = prevRow(col - 3);
		removeQueen(col - 3, pvrw);
		return solveC(col - 3, pvrw + 1);
	    }
	    else{
		return solveC(col - 2, pvrw + 1);
	    }
	}
	for (int r = pvrw; r < board.length; r++){
	    if (board[col][r] == 0){
		addQueen(col, r);
		if (col + 1 == board.length){
		    pvrw = prevRow (col - 1);
		    removeQueen(col - 1, pvrw);
		    return solveC(col - 1, pvrw + 1);
		}
		else{
		    return solveC(col + 1, 0);
		}
	    }	    
	    else if (r == board.length - 1){
		pvrw = prevRow(col - 1);
		removeQueen(col - 1, pvrw);
		if (pvrw + 1 == board.length){
		    pvrw = prevRow(col - 2);
		    removeQueen(col - 2, pvrw);
		    return solveC(col - 2, pvrw + 1);
		}
		else{
		    return solveC(col - 1, pvrw + 1);
		}
	    }
	}
	return solutionCount;
	}*/
    private int solveF(){
	removeQueen(board.length - 1, prevRow(board.length - 1));
	for (int i = board.length - 2; i > -1; i--){
	    if (solveO(i - 1, prevRow(i - 1))){
		solutionCount++;
		removeQueen(i - 1, prevRow(i - 1));
	    }
	}
	return solutionCount;
    }
    public void solve(){
	this.solveO(0,0);
    }
    public void countSolutions(){
	solutionCount = 0;
	this.solveD(0,0);
	if (solutionCount == 0 && board.length != 2 && board.length != 3){
	    solutionCount = -1;
	}
    }
    public int getSolutionCount(){
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
	//	QueenBoard B = new QueenBoard(1);
	
	//	B.solve();
	//	System.out.println(B.solveO(0,0));
	//System.out.println(B.toString());
       	//B.countSolutions();
	//System.out.println(B.getSolutionCount());
    }
}

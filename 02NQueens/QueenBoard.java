public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    //private int size;

    public QueenBoard(int size){
	//size = sizeOfBoard;
	board = new int[size][size];
    }

    public boolean addQueen(int col, int row){
	if (board[col][row] == 0){
	    //north	
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
 
    public String toString(){
	String sum = "";
	for (int col = 0; col < board.length; col++){
	    for (int row = 0; row < board.length; row++){
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
	QueenBoard Q = new QueenBoard(4);
	System.out.println(Q.addQueen(0,2));
	//System.out.println(Q.addQueen(0,2));
	System.out.println(Q.toString());

    }
}

	//idea to find prevRow: set it equal 

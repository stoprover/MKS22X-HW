public class KnightBoard{
    private int[][]board;
    
    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
    }
    private boolean solveH(int row, int col, int num){
	if (board.length * board[0].length == num){
	    board[row][col] = num;
	    return true;
	}
	if (row - 2 >= 0 && col - 1 >= 0){
	    if(board[row - 2][col - 1] == 0){
		board[row][col] = num;
		if (solveH(row - 2, col - 1, num + 1)){
		    return true;
		}
	    }
	}
        if (row - 2 >= 0 && col + 1 < board[0].length){
	    if (board[row - 2][col + 1] == 0){
		board[row][col] = num;
		if (solveH(row - 2, col + 1, num + 1)){
		    return true;
		}
	    }
	}
	if (row - 1 >= 0 && col - 2 >= 0){
	    if (board[row - 1][col - 2] == 0){
		board[row][col] = num;
		if (solveH(row - 1, col - 2, num + 1)){
		    return true;
		}
	    }
	}
        if (row - 1 >= 0 && col + 2 < board[0].length){
	    if (board[row - 1][col + 2] == 0){
		board[row][col] = num;;
		if (solveH(row - 1, col + 2, num + 1)){
		    return true;
		}
	    }
	}
	if (row + 1 < board.length && col - 2 >= 0){
	    if (board[row + 1][col - 2] == 0){
		board[row][col] = num;
		if (solveH(row + 1, col - 2, num + 1)){
		    return true;
		}
	    }
	}
	if (row + 1 < board.length && col + 2 < board[0].length){
	    if (board[row + 1][col + 2] == 0){
		board[row][col] = num;
		if (solveH(row + 1, col + 2, num + 1)){
		    return true;
		}
	    }
	}
	if (row + 2 < board.length && col - 1 >= 0){
	    if (board[row + 2][col - 1] == 0){
		board[row][col] = num;
		if (solveH(row + 2, col - 1, num + 1)){
		    return true;
		}
	    }
	}
	if (row + 2 < board.length && col + 1 < board[0].length){
	    if (board[row + 2][col + 1] == 0){
		board[row][col] = num;
		if (solveH(row + 2, col + 1, num + 1)){
		    return true;
		}
	    }
	}
	board[row][col] = 0;
	return false;
    }
    public void solve(){
	solveH(0, 0, 1);
    }
	    
    public String toString(){
	String sum = "";
	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board[r].length; c++){
		if (board[r][c] < 10){
		    sum += "  " + board[r][c];
		}
		else{
		    sum += " " + board[r][c];
		}
	    }
	    sum += "\n";
	}
	return sum;
    }
    public static void main(String[]args){
    }
}

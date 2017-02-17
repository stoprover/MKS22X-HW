public class KnightBoard{
    private int[][]board;
    private int[][]moves;

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	moves = new int[startingRows][startingCols];
    }
    public void createMoves(){
	for (int c = 2; c < moves.length - 2; c++){
	    for (int r = 2; r < moves[c].length - 2; r++){
		moves[c][r] = 8;
	    }
	}
	for (int r = 2; r < moves[0].length - 2; r++){
	    moves[0][r] = 4;
	    moves[1][r] = 6;
	    moves[moves.length - 2][r] = 6;
	    moves[moves.length - 1][r] = 4;
	    }
	for (int c = 2; c < moves.length - 2; c++){
	    moves[c][0] = 4;
	    moves[c][1] = 6;
	    moves[c][moves[c].length - 2] = 6;
	    moves[c][moves[c].length - 1] = 4;
	    }
	moves[0][0] = 2;
	moves[0][moves[0].length - 1] = 2;
	moves[moves.length - 1][0] = 2;
	moves[moves.length - 1][moves[moves.length - 1].length - 1] = 2;
	moves[1][1] = 4;
	moves[1][moves[1].length - 2] = 4;
	moves[moves.length - 2][1] = 4;
	moves[moves.length - 2][moves[moves.length - 2].length - 2] = 4;
	moves[0][1] = 3;
	moves[1][0] = 3;
	moves[0][moves[0].length - 2] = 3;
	moves[1][moves[1].length - 1] = 3;
	moves[moves.length - 1][1] = 3;
	moves[moves.length - 1][moves[moves.length - 1].length - 2] = 3;
	moves[moves.length - 2][0] = 3;
	moves[moves.length - 2][moves[moves.length - 2].length - 1] = 3;
    }


    /**public boolean helper(int row, int col, int num){
	if (row * col == num){
	    return true;
	}
	//update moves, update knights
	}*/
    public boolean updateMoves(int col, int row){
	moves[col][row] = 0;
	//update all the ones leading from this: (moves[x][y] = moves[x][y] - 1;
	return true;
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
    public String movesDebug(){
	String sum = "";
	for (int r = 0; r < moves.length; r++){
	    for (int c = 0; c < moves[r].length; c++){
		if (moves[r][c] < 10){
		    sum += "  " + moves[r][c];
		}
		else{
		    sum += " " + moves[r][c];
		}
	    }
	    sum += "\n";
	}
	return sum;
    }
    public static void main(String[]args){
	KnightBoard K = new KnightBoard(6, 8);
	K.createMoves();
	System.out.println(K.updateMoves(2, 5));
	System.out.println(K.movesDebug());
	System.out.println(K.toString());
    }
}

    //prioritize square w/ fewest possible moves?

public class KnightBoard{
    private int[][]board;

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
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
    //prioritize square w/ fewest possible moves?

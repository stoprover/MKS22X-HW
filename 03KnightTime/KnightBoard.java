public class KnightBoard{
    private int[][]board;
    private int[][]moves;
    private int[]order;
    private int[]rowOrder;
    private int[]colOrder;

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	moves = new int[startingRows][startingCols];
    }
    
    private void createMoves(){
	for (int r = 0; r < moves.length; r++){
	    for (int c = 0; c < moves[0].length; c++){
		int i = 0;
		if (r - 2 >= 0 && c - 1 >= 0 && board[r - 2][c - 1] == 0){
		    i++;
		}
		if (r - 2 >= 0 && c + 1 < moves[0].length && board[r - 2][c + 1] == 0){
		    i++;
		}
		if (r - 1 >= 0 && c - 2 >= 0 && board[r - 1][c - 2] == 0){
		    i++;
		}
		if (r - 1 >= 0 && c + 2 < moves[0].length && board[r - 1][c + 2] == 0){
		    i++;
		}
		if (r + 1 < moves.length && c - 2 >= 0 && board[r + 1][c - 2] == 0){
		    i++;
		}
		if (r + 1 < moves.length && c + 2 < moves[0].length && board[r + 1][c + 2] == 0){
		    i++;
		}
		if (r + 2 < moves.length && c - 1 >= 0 && board[r + 2][c - 1] == 0){
		    i++;
		}
		if (r + 2 < moves.length && c + 1 < moves[0].length && board[r + 2][c + 1] == 0){
		    i++;
		}
		moves[r][c] = i;
		if (board[r][c] != 0){
		    moves[r][c] = 0;
		}
	    }
	}
    }
    private void findOrder(int r, int c){
	order = new int[moves[r][c]];
	rowOrder = new int[moves[r][c]];
	colOrder = new int[moves[r][c]];
	int i = 0;
	if (r - 2 >= 0 && c - 1 >= 0 && moves[r - 2][c - 1] != 0){
	    order[i] = moves[r - 2][c - 1];
	    rowOrder[i] = -2;
	    colOrder[i] = -1;
	    i++;
	}
	if (r - 2 >= 0 && c + 1 < moves[0].length && moves[r - 2][c + 1] != 0){
	    order[i] = moves[r - 2][c + 1];
	    rowOrder[i] = -2;
	    colOrder[i] = 1;
	    i++;
	}
	if (r - 1 >= 0 && c - 2 >= 0 && moves[r - 1][c - 2] != 0){
	    order[i] = moves[r - 1][c - 2];
	    rowOrder[i] = -1;
	    colOrder[i] = -2;
	    i++;
	}
	if (r - 1 >= 0 && c + 2 < moves[0].length && moves[r - 1][c + 2] != 0){
	    order[i] = moves[r - 1][c + 2];
	    rowOrder[i] = -1;
	    colOrder[i] = 2;
	    i++;
	}
	if (r + 1 < moves.length && c - 2 >= 0 && moves[r + 1][c - 2] != 0){
	    order[i] = moves[r + 1][c - 2];
	    rowOrder[i] = 1;
	    colOrder[i] = -2;
	    i++;
	}
	if (r + 1 < moves.length && c + 2 < moves[0].length && moves[r + 1][c + 2] != 0){
	    order[i] = moves[r + 1][c + 2];
	    rowOrder[i] = 1;
	    colOrder[i] = 2;
	    i++;
	}
	if (r + 2 < moves.length && c - 1 >= 0 && moves[r + 2][c - 1] != 0){
	    order[i] = moves[r + 2][c - 1];
	    rowOrder[i] = 2;
	    colOrder[i] = -1;
	    i++;
	}
	if (r + 2 < moves.length && c + 1 < moves[0].length && moves[r + 2][c + 1] != 0){
	    order[i] = moves[r + 2][c + 1];
	    rowOrder[i] = 2;
	    colOrder[i] = 1;
	    i++;
	}
    }
    private void sortOrder(int r, int c){
	this.findOrder(r, c);
	for (int i = 0; i < order.length; i++){
	    int smallestSoFarO = order[i];
	    int smallestSoFarR = rowOrder[i];
	    int smallestSoFarC = colOrder[i];
	    int indOfSSF = i;
	    for (int j = i + 1; j < order.length; j++){
		if (order[j] < smallestSoFarO){
		    smallestSoFarO = order[j];
		    smallestSoFarR = rowOrder[j];
		    smallestSoFarC = colOrder[j];
		    indOfSSF = j;
		}
	    }
	    order[indOfSSF] = order[i];
	    order[i] = smallestSoFarO;
	    rowOrder[indOfSSF] = rowOrder[i];
	    rowOrder[i] = smallestSoFarR;
	    colOrder[indOfSSF] = colOrder[i];
	    colOrder[i] = smallestSoFarC;
	}
    }
    
    private String movesDebug(){
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
    
    private boolean solveH(int row, int col, int num){
	if (board.length * board[0].length == num){
	    board[row][col] = num;
	    return true;
	}
	this.createMoves();
	this.sortOrder(row, col);
	for (int i = 0; i < order.length; i++){
	    board[row][col] = num;
	    this.createMoves();
	    if (solveH(row + rowOrder[i], col + colOrder[i], num + 1)){
		return true;
	    }
	    board[row][col] = 0;
	    this.createMoves();
	}
	return false;
    }
    public void solve(){
	this.solveH(0, 0, 1);
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
	//KnightBoard T = new KnightBoard(29, 23);
	//T.createMoves();
	//System.out.println(T.movesDebug());
	//T.board[0][1] = 12;
	//System.out.println(T.toString());
	//T.createMoves();
	//System.out.println(T.movesDebug());
	//T.findOrder(0, 1);
	//T.sortOrder(0, 1);
	//T.createMoves();
	//System.out.println(T.toString());
	//System.out.println(T.solveH(0, 0, 1));
	//T.solve();
	//System.out.println(T.toString());
    }
}
    

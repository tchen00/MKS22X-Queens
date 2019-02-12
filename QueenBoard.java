public class QueenBoard{
  private int[][]board;
  private int size;
  // CONSTRUCTOR
  public QueenBoard(int size) {
    if (size < 0){
      throw new IllegalArgumentException("cannot have negative size");
    }
    board = new int[size][size];
    this.size = size;
  }
  // METHOD - adds a queen onto the board
  public boolean addQueen(int r, int c) {
    if (board[r][c]>0){
		  return false;
	  }
    board[r][c]=-1;
	  for (int x=1 ; c+x<size; x++){
      // does not take into consideration the columns bc thats what the adding queen does
		  board[r][c+x]+=1;
      //used for diagonals
  	  if (r+x<size){
  		  board[r+x][c+x]+=1;
  	  }
  		if (r-x>=0){
  			board[r-x][c+x]+=1;
  		}
	  } return true;
  }
    /*
    if (board[r][c] == 0){
      for (int i = 0; i < size; i++){
        if (i != c){
          board[i][c] += 1;
        } if (i != r){
          board[r][i] += 1;
        } if (r + i < size){
          board[r+i][c+i] += 1;
        } if (r - i >= 0){
          board[r-i][c+i] += 1;
        }
      }
      board[r][c] = -1;
      return true;
    } return false;
*/
/*
  public int[][] getBoard(){
    return board;
  }
*/
  // METHOD -- remove a Queen from the board
  private boolean removeQueen(int r, int c) {
    if (board[r][c] != -1) return false;
    board[r][c]+=1;
    for(int x=1;c+x<size;x++){
    	board[r][c+x]-=1;
      //used for diagonals
      if(r+x<size){
    		board[r+x][c+x]-=1;
    	}
    	if(r-x>=0){
    	   board[r-x][c+x]-=1;
    	}
    } return true;
    /*
    for (int i = 0; i < size; i++){
      if (i != c){
        board[i][c] -= 1;
      } if (i != r){
        board[r][i] -= 1;
      } if (r + i < size){
        board[r+i][c+i] -= 1;
      } if (r - i >= 0){
        board[r-i][c+i] -= 1;
      }
    }
    board[r][c] = 0;
    return true;
    */
  }
  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *"""_ _ Q _
  *Q _ _ _

  *_ _ _ Q

  *_ Q _ _"""
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */

  // METHOD - toString to visualize the board
  public String toString(){
    String output="";
  	for (int i=0;i<size;i++){
  	  for (int j=0;j<size;j++){
  		  if (board[i][j]!=-1){
  			  output+="_";
  		   }else {
  		    output+="Q";
  		    }
  	   } output+="\n";
  	} return output;
    /*
    // for debugging purposes
    String output = "";
    for (int i = 0; i < size; i++){
      for (int j = 0; j < size; j++){
        output += board[i][j];
        if (j != (size -1)) output += ", ";
      }
      if (i != (size - 1)) output += "\n";
    }
    //output += "";
    return output;
    */
  }
  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */

  public boolean solve(){
    for (int i=0;i<size;i++){
	    for (int j=0;j<size;j++){
		    if (board[i][j]!=0){
			    throw new IllegalStateException("board starts with non-zero value");
		    }
	    }
    } return solveHelper(0);
  }

  public boolean solveHelper(int col){
    /*
    PSEUDOCODE GIVEN BY MR.K IN CLASS
    boolean solveR(int col)
      if col is past end of board:
        return true
      for each row:
        if addQueen:
          if solveR(col+1):
            return true
        removeQueen
     return false
    */
    if (col>=size){
      //base case when the amount of queens is equal to the size of the board
      return true;
    }
    //for each row
    for (int i=0;i<size; i++){
      //check to see if you can add a queen
      if (addQueen(i,col)){
        //test to see iif you can add 1 to column + move on
        if (solveHelper(col+1)){
          return true;
        }
        //if you cannot backtrack!
        removeQueen(i,col);
      }
    }
    return false;
  }
  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */

  public int countSolutions() {
    // essentially same concept as solve
    for (int i=0;i<size;i++){
      for (int j=0;j<size;j++){
        if (board[i][j]!=0){
          throw new IllegalStateException("board starts with non-zero value");
        }
      }
    } return countSolutionsHelper(0);
   }

  public int countSolutionsHelper(int col){
    int output = 0;
    if (col>=size){
      return 1;
    }
    //one solution
    for (int i=0;i<size;i++){
      if (addQueen(i,col)){
        output += countSolutionsHelper(col+1);

      }
      //backtrack and delete
    }
    return output;
  }

  public static void main(String[] args){
    //christys driver
    QueenBoard board1 = new QueenBoard(1);
        QueenBoard board2 = new QueenBoard(2);
        QueenBoard board3 = new QueenBoard(3);
        QueenBoard board4 = new QueenBoard(4);
        QueenBoard board5 = new QueenBoard(5);
        QueenBoard board6 = new QueenBoard(6);
        QueenBoard board7 = new QueenBoard(7);
        QueenBoard board8 = new QueenBoard(8);

        System.out.println("");

        //System.out.println(board4.isEmpty());//should print true

        System.out.println("");

        System.out.println(board4);//should print 4x4 board

        System.out.println("");

        board1.solve();
        System.out.println(board1);
        System.out.println("");

        board2.solve();
        System.out.println(board2);
        System.out.println("");

        board3.solve();
        System.out.println(board3);
        System.out.println("");

        board4.solve();
        System.out.println(board4);
        System.out.println("");

        board5.solve();
        System.out.println(board5);
        System.out.println("");

        board6.solve();
        System.out.println(board6);
        System.out.println("");

        board7.solve();
        System.out.println(board7);
        System.out.println("");

        board8.solve();
        System.out.println(board8);
        System.out.println("");

/*
        //testing out count
        try {
          System.out.println(board8.countSolutions());
        }
        catch (IllegalStateException e){
          System.out.println("board is not empty");
        }
*/
        System.out.println("");
        System.out.println("");

        System.out.println(board1.countSolutions());//1
        System.out.println(board2.countSolutions());//0
        System.out.println(board3.countSolutions());//0
        System.out.println(board4.countSolutions());//2
        System.out.println(board5.countSolutions());//10
        System.out.println(board6.countSolutions());//4
        System.out.println(board7.countSolutions());//40
        System.out.println(board8.countSolutions());//92
  }
}

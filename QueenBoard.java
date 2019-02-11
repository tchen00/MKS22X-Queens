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
    return true;
  }

  public boolean solveHelper(){
    return true;
  }
  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */

  public int countSolutions() {
    return 0;
  }

  public int countSolutionsHelper(){
    return 0;
  }

  public static void main(String[] args){
    QueenBoard test = new QueenBoard(5);
    test.addQueen(0,0);
    System.out.println(test.toString());
    test.removeQueen(0,0);
    System.out.println(test.toString());
    test.addQueen(1,0);
    System.out.println(test.toString());
    //test.addQueen(10,10);
  }
}

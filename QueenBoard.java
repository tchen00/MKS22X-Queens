public class QueenBoard{
  private int[][]board;
  private int size;
  public QueenBoard(int size) {
    if (size < 0){
      throw new IllegalArgumentException("cannot have negative size");
    }
    board = new int[size][size];
    this.size = size;
  }
  public boolean addQueen(int r, int c) {
    if (board[r][c] == 0){
      board[r][c] = -1;
      for (int i = 0; i < size; i++){
        if (i != c){
          board[i][c] += 1;
        } if (i != r){
          board[r][i] += 1;
        }
      }
      return true;
    } return false;
  }
/*
  public int[][] getBoard(){
    return board;
  }
*/
  private boolean removeQueen(int r, int c) {
    return false;
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
  public String toString(){
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
  }
  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;

  *        true when the board is solveable, and leaves the board in a solved state

  *@throws IllegalStateException when the board starts with any non-zero value

  */
  public boolean solve(){
    return true;
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions() {
    return 0;
  }

  public static void main(String[] args){
    QueenBoard test = new QueenBoard(5);
    test.addQueen(0,0);
    System.out.println(test.toString());
  }
}

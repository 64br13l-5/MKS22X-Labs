public class QueenBoard{
  private int[][] Board;
  public QueenBoard(int size){
    Board = new int[size][size];
  }
  public String toString(){
    String output = "";
    for(int i = 0; i < Board.length;i++){
      for(int j = 0; j < Board[i].length;j++){
      if(Board[i][j] == 1) output +="Q ";
      else output +="_ ";
    }
     output += "\n";
  } return output;}
}

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
      else if(Board[i][j] < 0) output +="N ";
      else output +="_ ";
    }
     output += "\n";
  } return output;}
  public boolean addQueen(int r, int c){
    if(Board[r][c] != 0)return false;
    Board [r][c]++;
    for(int i = 1; i < Board.length-r; i++){
    Board[i+r][c]--;
    try{
      Board[i+r][c+i]--;
      Board[i+r][c-i]--;
    }catch(Exception e){}
  }
    return true;
     }
     public void removeQueen(int r, int c){
       Board [r][c] = 0;
       for(int i = 1; i < Board.length-r; i++){
       Board[i+r][c]++;
       try{
         Board[i+r][c+i]++;
         Board[i+r][c-i]++;
       }catch(Exception e){}
     }
      }

}

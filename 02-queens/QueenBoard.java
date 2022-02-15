class Text{
            public static final String CLEAR_SCREEN =  "\033[2J";
            public static final String HIDE_CURSOR =  "\033[?25l";
            public static final String SHOW_CURSOR =  "\033[?25h";
            //use this to go back to normal terminal colors
            public static final String RESET = "\033[0m"+SHOW_CURSOR;

            //terminal specific character to move the cursor to a location
            //top left is 1,1
            public static String go(int x,int y){
              return ("\033[" + x + ";" + y + "H");
            }

            public static void wait(int millis){
              try {
                Thread.sleep(millis);
              }
              catch (InterruptedException e) {
              }
            }
          }
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
public boolean IsBlank(){
  for(int i =0 ; i< Board.length;i++){
    for(int j = 0; j < Board[i].length;j++){
      if(Board[i][j] != 0)return false;
  }}
  return true;
}
public boolean solve(){
  if(!IsBlank()) throw new IllegalStateException();
  return solve(0);
}
public boolean solve(int row){
  if(row == 8) return true;
  else{
    for(int i  = 0; i < Board[row].length; i++){
      if(addQueen(row,i)){

        if(solve(row+1)) return true;
        removeQueen(row,i);
      }
    }
    return false;
  }
}
public int countSolutions(){
  if(!IsBlank()) throw new IllegalStateException();
  return countSolutions(0);
           }
public int countSolutions(int row){
  if(row == 8)return  1;
  else{
    for(int i  = 0; i < Board[row].length; i++){
      if(addQueen(row,i)){
      //change the delay 1000 = 1 second
        if(solve(row+1)) return 1 +countSolutions(row+1);
        removeQueen(row,i);
      }
    }
    return   countSolutions(row+1);}
}

}

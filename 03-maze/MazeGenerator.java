import java.util.*;
public class MazeGenerator{
  private static int[][] dirs = { {0,1},{0,-1},{1,0},{-1,0}};
  private static void wait(int millis){
              try {
                Thread.sleep(millis);
              }
              catch (InterruptedException e) {
              }
            }
            public static void clearTerminal(){
             //erase terminal
             System.out.println("\033[2J");
           }
  public static void gotoTop(){
             //go to top left of screen
             System.out.println("\033[1;1H");
           }
           public static int checkns(char[][] maze,int row, int col){
             int ns = 0;
             for(int[]dir:dirs){
              if(maze[row+dir[0]][col+dir[1]]== ' '  || maze[row+dir[0]][col+dir[1]]== '.')ns++;
             }
             return ns;
           }
  public static int solve(int row, int col, char[][] maze){ //you can add more parameters since this is private
              //automatic animation! You are welcome.

				if(maze[row][col] == 'S') return 1;
                              if(maze[row][col] != 'E')   maze[row][col] = ' ';
                                          Collections.shuffle(Arrays.asList(dirs));

                                          for(int[] dir : dirs){

                                          if(row + dir[0] < maze.length-1 &&col + dir[1] < maze[0].length-1&& row + dir[0] > 0 && col + dir[1]  > 0&&checkns(maze,row+dir[0],col+dir[1]) <2 &&(maze[row+dir[0]][col+dir[1]] == 'S' || maze[row+dir[0]][col+dir[1]] == '#')) return 1 +solve(row+dir[0],col+dir[1],maze);
                                          }
                                          maze[row][col] = '.';
                                          for(int[] dir:dirs){
                                          if(row + dir[0] < maze.length-1 &&col + dir[1] < maze[0].length-1&& row + dir[0] > 0 && col + dir[1]  > 0 && maze[row+dir[0]][col+dir[1]] == ' ') return solve(row+dir[0],col+dir[1],maze)-1;
                                          }
              //COMPLETE SOLVE
              return -1; //so it compiles
  }


  private static int solvez(int row, int col,char[][] maze){ //you can add more parameters since this is private
              //automatic animation! You are welcome.

              if(maze[row][col] == 'E') return 0;
              maze[row][col] = '@';
              for(int[] dir : dirs){
              if(maze[row+dir[0]][col+dir[1]] != '#'&& maze[row+dir[0]][col+dir[1]] != '.' && maze[row+dir[0]][col+dir[1]] != '@') return 1 +solvez(row+dir[0],col+dir[1],maze);
              }
              maze[row][col] = '.';
              for(int[] dir:dirs){
              if(maze[row+dir[0]][col+dir[1]] == '@') return solvez(row+dir[0],col+dir[1],maze)-1;
              }
              //COMPLETE SOLVE
              return -1; //so it compiles
  }
  public static void generate(char[][] maze, int startrow,int startcol){


      for(int i =0; i<maze.length;i++){
        for(int j = 0; j<maze[0].length; j++){
          maze[i][j] = '#';
        }
      }


    generate(maze,startrow,startcol,1);
  }
  public static void generate(char[][] maze,int startrow, int startcol, int on){
    Random rng = new Random();//seed of 100 is stored.
    int endrow = Math.abs(rng.nextInt() % (maze.length-2))+1;
    int endcol = Math.abs(rng.nextInt() % (maze[0].length-2))+1;
    while(((Math.abs(endrow - startrow) == 0 && Math.abs(endcol - startcol) ==  0) && (maze.length <= 4 || maze[0].length <= 4 )) || ((Math.abs(endrow - startrow) <= 1 && Math.abs(endcol - startcol)  <= 1) && (maze.length > 4 || maze[0].length > 4 ))){
       endrow = Math.abs(rng.nextInt() % (maze.length-2))+1;
       endcol = Math.abs(rng.nextInt() % (maze[0].length-2))+1;
    }
  maze[startrow][startcol] = 'S';
  maze[endrow][endcol] = 'E';
  solve(endrow,endcol,maze);
  for(int i = 0; i < maze.length;i++){
    for(int j = 0; j < maze[i].length;j++){
     if(maze[i][j] == '.') maze[i][j] = ' ';
    }
}
  if(solvez(startrow,startcol,maze) == -1) {
    for(int i = 0; i < maze.length;i++){
      for(int j = 0; j < maze[i].length;j++){
      maze[i][j] = '#';
      }
  }
    generate(maze,startrow,startcol);
}
else{
  for(int i = 0; i < maze.length;i++){
    for(int j = 0; j < maze[i].length;j++){
     if(maze[i][j] == '@' ||maze[i][j] == '.') maze[i][j] = ' ';
    }
}
maze[startrow][startcol] = 'S';
}
  }
  public static String toStr(char[][] maze){
    String output = "";
    for(int i = 0; i < maze.length;i++){
      for(int j = 0; j < maze[i].length;j++){
        output += maze[i][j];
      }
      output   += "\n";
    }
    return output;
  }
  public static char[][] mazegen(int size){
    char[][] ret = new char[size][size];
    for(int i =0; i<ret.length;i++){
      for(int j = 0; j<ret[0].length; j++){
        ret[i][j] = '#';
      }
    }
    return ret;
  }
  public static void main(String[] args){
    char[][]n = new char[61][61];
    generate(n,1,1);
    System.out.println(toStr(n));
  }
}

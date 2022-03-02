import java.util.*;
public class MazeGenerator{
  private static int[][] dirs = { {0,1},{0,-1},{1,0},{-1,0}};

  public static int solve(int row, int col, char[][] maze){ //you can add more parameters since this is private
              //automatic animation! You are welcome.



              if(maze[row][col] == 'S') return 0;
              maze[row][col] = '@';
              Random rand = new Random();
              int rng = rand.nextInt(4);

              if(maze[row+dirs[rng][0]][col+dirs[rng][1]] == '#') return 1 + solve(row+dirs[rng][0],col+dirs[rng][1],maze);


              //COMPLETE SOLVE
              return -1; //so it compiles
  }
  public static void generate(char[][] maze,int startrow, int startcol){
    Random rng = new Random();//seed of 100 is stored.
    int endrow = Math.abs(rng.nextInt() % (maze.length-2))+1;
    int endcol = Math.abs(rng.nextInt() % (maze.length-2))+1;
    while(Math.abs(endrow - startrow) <= 1 || Math.abs(endcol - startcol) <= 1){
       endrow = Math.abs(rng.nextInt() % (maze.length-2))+1;
       endcol = Math.abs(rng.nextInt() % (maze.length-2))+1;
    }
  maze[startrow][startcol] = 'S';
  maze[endrow][endcol] = 'E';
  solve(endrow,endcol,maze);
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
    char[][] n = mazegen(15);
    generate(n,1,1);
    System.out.println(toStr(n));
  }
}

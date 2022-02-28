import java.io.*;
import java.util.*;
public class Maze{
  private char[][]maze;
  private boolean animate;//false by default
  private int startRow,startCol;
  public char[][] getMaze(String file) {
    String output = "";
    int l = 0;
    int w = 0;
try{
                File maze = new File(file);
                Scanner input = new Scanner(maze);
                while (input.hasNextLine()) {
                  String next = input.nextLine();
                   l = next.length();
                   w++;
                   output += next;
                }
                input.close();//releases the file from your program
              }
              catch (FileNotFoundException e){
                e.printStackTrace();
              }
    char[][] ret = new char[w][l];
    for(int i = 0; i < ret.length;i++){
      String str = output.substring(i*l,(i+1)*l);
      if(str.contains("S")){
        startCol = str.indexOf("S") ;
        startRow = i;
      }
      ret[i] = str.toCharArray();
    }
    return ret;
  }
  public void setAnimate(boolean b){
              animate = b;
  }
  private void wait(int millis){
              try {
                Thread.sleep(millis);
              }
              catch (InterruptedException e) {
              }
            }
  public Maze(String filename){
    maze = getMaze(filename);
  }
  public static void clearTerminal(){
             //erase terminal
             System.out.println("\033[2J");
           }
  public static void gotoTop(){
             //go to top left of screen
             System.out.println("\033[1;1H");
           }
  public int solve(){
              //only clear the terminal if you are running animation
              if(animate){
                clearTerminal();
              }
              //start solving at the location of the s.
              return solve(startRow,startCol);

  }
  private int solve(int row, int col){ //you can add more parameters since this is private
              //automatic animation! You are welcome.
              if(animate){
                gotoTop();
                System.out.println(this);
                wait(50);
              }

              //COMPLETE SOLVE
              return 0; //so it compiles
  }
  public  String toString(){
    String output = "";
    for(int i = 0; i < maze.length;i++){
      for(int j = 0; j < maze[i].length;j++){
        output += maze[i][j];
      }
      output += "\n";
    }
    return output;
  }
  public static void main(String[] args){

    Maze a = new Maze("Maze1.txt");
    System.out.println(a);

  }
}

import java.io.*;
import java.util.*;
public class Maze{
  public static char[][] getMaze(String file){
    String output = "";
    int l = 0;
    int w = 0;
    try {
                File maze = new File(file);
                Scanner input = new Scanner(maze);
                while (input.hasNextLine()) {
                  String next = input.nextLine();
                   l = next.length();
                   w++;
                   output += next;
                }
                input.close();//releases the file from your program
              } catch (FileNotFoundException ex) {
                output = "File not Found!";
              }
    char[][] ret = new char[w][l];
    for(int i = 0; i < ret.length;i++){
      String str = output.substring(i*w,(i+1)*w);
      ret[i] = str.toCharArary();
    }
    return ret;
  }
  public static String charprint(char[][] ret){
    String output = "";
    for(int i = 0; i < ret.length;i++){
      for(int j = 0; j < ret[i].length;j++){
        output += ret[i][j];
      }
      output += "\n";
    }
    return output;
  }
  public static void main(String[] args){
    System.out.println(charprint(getMaze("Maze1.txt")));
  }
}

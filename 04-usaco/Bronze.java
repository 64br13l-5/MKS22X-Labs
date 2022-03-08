import java.util.*;
import java.io.*;
public class Bronze{
  private static int[][] ary;
  public static void stomp(int R, int C, int D,int max){
    for(int i =0; i < 3; i++){
      for(int j =0; j < 3; j++){
        if(ary[i][j] > max -D )
        ary[i][j] = max-D;
      }
    }
  }

public static long solve(String filename){
    try{
                    File maze = new File(filename);
                    Scanner input = new Scanner(maze);
                    while (input.hasNextLine()) {
                      String next = input.nextLine();

                    }
                    input.close();//releases the file from your program
                  }
                  catch (FileNotFoundException e){
                    e.printStackTrace();
                  }
}}

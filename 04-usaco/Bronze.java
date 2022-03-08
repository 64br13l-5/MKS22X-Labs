import java.util.*;
import java.io.*;
public class Bronze{
public static void main(String[] args){
  System.out.println(solve("makelake.in"));
}
  public static void stomp(int C, int R, int D,int max,int[][] ary){
    for(int i =0; i < 3; i++){
      for(int j =0; j < 3; j++){
        if(ary[i+C][j+R] > max -D )
        ary[i+C][j+R] = max-D;
      }
    }
  }
public static int findmax(int C, int R,int[][] ary){
  int ret =0;
  for(int i =0; i < 3; i++){
    for(int j =0; j < 3; j++){
      if(ary[i+C][j+R] > ret )
      ret = ary[i+C][j+R];
    }
  }return ret;
}

public static int retsum(int[][] ary,int E){
  int ret =0;

  for(int i =0; i <ary.length; i++){
    for(int j =0; j < ary[0].length; j++){
      ary[i][j] = E - ary[i][j];
      if(ary[i][j] < 0) ary[i][j]= 0;
      ret += ary[i][j];
  }}return ret *72*72;
}
public static long solve(String filename){
  int R = 0;
  int C = 0;
  int E = 0;
  int N = 0;
  int R_s=0;
  int C_s = 0;
  int D = 0;
    try{
                    File maze = new File(filename);
                    Scanner input = new Scanner(maze);
                    if (input.hasNextLine()) {
                      R = input.nextInt();
                      C = input.nextInt();
                      E = input.nextInt();
                      N = input.nextInt();
                        int[][] land = new int[R][C];
                        for(int j = 0; j<R; j++)for(int i=0; i < C; i++)
                        land[j][i] = input.nextInt();
                        for(int x = 0; x < N; x++){
                         C_s = input.nextInt()-1;
                         R_s = input.nextInt()-1;
                         D = input.nextInt();
                         stomp(C_s,R_s,D,findmax(C_s,R_s,land),land);

                       }
                       return retsum(land,E);

                    }
                    input.close();//releases the file from your program
                  }
                  catch (FileNotFoundException e){
                    e.printStackTrace();
                  }
                  return 0;
}}

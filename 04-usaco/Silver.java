import java.io.*;
import java.util.*;
public class Silver{
  private static int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
  public static void main(String[] args){
    System.out.println(solve("ctravel.in"));
  }
  public static int[][] add(int[][] ary){
    int[][] ary2 = new int[ary.length][];

    for(int i =0; i < ary.length; i++){
    ary2[i] = ary[i].clone();
      for(int j =0; j < ary[0].length; j++){
        int sum = 0;
        for(int[] dir:dirs){
          if(!(i + dir[0] == ary.length || i + dir[0] == -1 ||j + dir[1] == ary[0].length || j + dir[1] == -1  ||ary[i+dir[0]][j+dir[1]] == -1 ) ) sum+= ary[i+dir[0]][j+dir[1]];
        }
        if(ary[i][j] != -1 )ary2[i][j] = sum;

      }
    }
    return ary2;
  }
  public static long solve(String filename){
    int N;
    int M;
    int T;
    int r1;
    int c1;
    int r2;
    int c2;
      try{
                      File maze = new File(filename);
                      Scanner input = new Scanner(maze);
                      if (input.hasNextLine()) {
                        N = input.nextInt();
                        M = input.nextInt();
                        T = input.nextInt();
                        input.nextLine();
                          int[][] pstr = new int[N][M];
                          for(int j = 0; j<N; j++){ String line = input.nextLine();

                            for(int i=0; i < M; i++){
                              if(line.charAt(i) == '.') pstr[j][i] = 0;
                              else pstr[j][i] = -1;
                          }
                        }
                        r1 = input.nextInt()-1;
                        c1 = input.nextInt()-1;
                        r2 = input.nextInt()-1;
                        c2 = input.nextInt()-1;

                        for(int[] dir:dirs){
                          if(!(r1 + dir[0] == pstr.length || r1 + dir[0] == -1 ||c1 + dir[1] == pstr[0].length || c1 + dir[1] == -1 || pstr[r1+dir[0]][c1+dir[1]] == -1) )pstr[r1+dir[0]][c1+dir[1]] += 1;
                        }
                  
                        for(int l = 0; l < T-1;l++)pstr = add(pstr);

                        return pstr[r2][c2];



                      }
                      input.close();//releases the file from your program
                    }
                    catch (FileNotFoundException e){
                      return -1;
                    }
                    return -1;
  }}

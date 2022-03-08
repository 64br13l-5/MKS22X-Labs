public class Bronze{
  private int[][] ary;
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
}}
private static final long serialVersionUID = l;

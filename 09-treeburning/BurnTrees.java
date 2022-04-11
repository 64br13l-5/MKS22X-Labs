import java.util.*;
public class BurnTrees{
  private int[][]map;
  private int ticks;
  private static final int TREE = 2;
  private static final int FIRE = 1;
  private static final int ASH = 3;
  private static final int SPACE = 0;
  private Frontier frontier;
  private int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};

  /*Determine if the simulation is still burning
   *@return false if any fires are still burning, true otherwise
   */
  public boolean done(){
    if(frontier.size() == 0)return true;
    return false;//placeholder for compilation purposes
  }


  /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
   *All existing fires spread new fires, and turn to ash
   *new fires should remain fire, and not spread.
   */
  public void tick(){
    ticks++;//leave this here.
    int l = frontier.size();
    for(int i = 0; i< l;i++){
      int[] coord = frontier.remove();
      map[coord[0]][coord[1]] = ASH;
      for(int[] dir : dirs){
        if(coord[0]+dir[0] < map.length && coord[0]+dir[0] >=0 && coord[1]+dir[1] >=0 && coord[1]+dir[1] < map[0].length && map[coord[0]+dir[0]][coord[1]+dir[1]] == TREE){
            map[coord[0]+dir[0]][coord[1]+dir[1]] = FIRE;
            int[] loc = {(coord[0]+dir[0]),(coord[1]+dir[1])};
            frontier.add(loc);
        }


      }
    }
        //YOU MUST IMPLEMENT THE REST OF THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
  }

  /***********************YOU MIGHT UPDATE THIS**************************/

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    for(int r=0; r<map.length; r++ ){
      for(int c=0; c<map[r].length; c++ ){
        if(Math.random() < density){
           map[r][c]=TREE;
         }
       }
     }
     frontier = new Frontier();
     start();//set the left column on fire.
  }


  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        map[i][0]=FIRE;
        int[] loc = {i,0};
        frontier.add(loc);
      }
    }
  }


    
 
  public static void main(String[] args){
    System.out.println(maxruntimePerDensity(100,100,0.05,0,1));
    System.out.println();
    System.out.println(maxruntimePerDensity(20,2000,0.01,0.58,0.65));
  }
  public static double averageOfNRuns(int n, int size, double density){
    BurnTrees b;
    double sum = 0;
    for(int i =0; i< n; i++){
      b =  new BurnTrees(size,size,density);
      sum += b.run();
    }
    return sum / 100;
  }
  public static String maxruntimePerDensity(int n, int size, double densityIncrement,double start, double end){
    double maxruntime = 0;
    double maxruntimedensity = 0;
    double density = start;
    while(density <= end){
      double runtime = averageOfNRuns(n,size,density);
      System.out.println("| " +  (int)(density*100) + "% | "+runtime + " |");
      if(runtime > maxruntime){
        maxruntime = runtime;
        maxruntimedensity = density;

      }
      density += densityIncrement;
    }
    return "maxruntime = " +maxruntime + ", density = "+maxruntimedensity;
  }




  /***********************DO NOT UPDATE THINGS BELOW HERE**************************/

  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }


  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }

  /*DO NOT UPDATE THIS*/
  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==0)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==FIRE)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==ASH)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }

  /*DO NOT UPDATE THIS*/
  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }


}
class Frontier{
      private Queue<int[]> frontier;
      public Frontier(){frontier= new  LinkedList<>();}
      public int size(){return frontier.size();}
      public void add(int[]location){frontier.add(location);}
      public int[] remove(){return frontier.remove();}
    }

public class Driver{
  public static void main(String[] args){
    System.out.println(maxruntimePerDensity(100,100,0.005));
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
  public static String maxruntimePerDensity(int n, int size, double densityIncrement){
    double maxruntime = 0;
    double maxruntimedensity = 0;
    double density = densityIncrement;
    while(density < 1){
      double runtime = averageOfNRuns(n,size,density);

      if(runtime > maxruntime){
        maxruntime = runtime;
        maxruntimedensity = density;

      }
      density += densityIncrement;
    }
    return "maxruntime = " +maxruntime + ", density = "+maxruntimedensity;
  }
}

public class test{
  public static void main(String[] args){
    System.out.println(recurstest(6));
  }
  public static int recurstest(int X){
    if(X == 0)return 1;

    return recurstest(X-1) +recurstest(X-1) + recurstest(X-1) + recurstest(X-1);
  }
  }

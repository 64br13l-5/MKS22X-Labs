public class Driver{
  public static void main(String[] args){
    QueenBoard a = new QueenBoard(8);

    System.out.println(a);
    System.out.println(Text.CLEAR_SCREEN);
      System.out.println(Text.HIDE_CURSOR);
      System.out.println(Text.go(1,1));
      //call your solve
      System.out.println(Text.RESET);
      System.out.println(a.countSolutions()); }
}

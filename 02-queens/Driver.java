public class Driver{
  public static void main(String[] args){
    QueenBoard a = new QueenBoard(8);
    a.addQueen(2,2);
      a.addQueen(2,3);

    System.out.println(a);
    a.removeQueen(2,2);
    System.out.println(a);
  }
}

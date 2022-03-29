public class Driver{
  public static void main(String[] args){
    MyDeque d = new MyDeque();
    for(int i = 0; i < 100000; i++){
      d.addFirst(i);
      d.addLast(200000-i);
    }
    for(int i = 0; i < 200000; i++){
      if((Integer)d.removeFirst() != i) return;
    }
    System.out.println("add gud");
  }
}

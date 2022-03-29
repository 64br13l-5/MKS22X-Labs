public class Driver{
  public static void main(String[] args){
    MyDeque d = new MyDeque();
    for(int i =0; i<100;i++){
        d.addLast(1);
    }
    System.out.println(d);
  }
}

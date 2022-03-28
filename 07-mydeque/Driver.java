public class Driver{
  public static void main(String[] args){
    MyDeque d = new MyDeque();
    d.addFirst(1);
      d.addLast(1);
  System.out.println(  d.toStringDebug());
  d.addFirst(2);
    d.addLast(2);
System.out.println(  d.toStringDebug());
d.addFirst(3);
  d.addLast(3);
System.out.println(  d.toStringDebug());
d.addFirst(4);
  d.addLast(4);
System.out.println(  d.toStringDebug());
d.addFirst(5);
  d.addLast(5);
System.out.println(  d.toStringDebug());

d.addFirst(6);
  d.addLast(6);
System.out.println(  d.toStringDebug());

d.addFirst(7);
  d.addLast(7);
System.out.println(  d.toStringDebug());
d.addFirst(8);
  d.addLast(8);
System.out.println(  d.toStringDebug());
System.out.println(  d.getFirst());
System.out.println(  d.getLast());
System.out.println(  d.removeLast());
System.out.println(  d.removeFirst());
System.out.println(  d.toStringDebug());
System.out.println(  d.getFirst());
System.out.println(  d.getLast());
  }
}

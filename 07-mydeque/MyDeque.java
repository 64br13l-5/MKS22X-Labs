import java.util.*;
public class MyDeque<E>{
    private E[] data;
    private int size;
    private int start, end;
    private void resize(E[] data){}
    public MyDeque(){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[10];
        data = d;
    }
    public MyDeque(int initialCapacity){
      @SuppressWarnings("unchecked")
      E[] d = (E[])new Object[initialCapacity];
      data = d;
    }
    public int size(){ return size;}
    public String toString(){ return Arrays.toString(data);}
    public void addFirst(E element){ }
    public void addLast(E element){ }
    public E removeFirst(){ }
    public E removeLast(){ }
    public E getFirst(){ }
    public E getLast(){ }
}

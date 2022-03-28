import java.util.*;
public class MyDeque<E>{
    private E[] data;
    private int size;
    public int start, end;
    public void resize(){
        @SuppressWarnings("unchecked")
      E[] d = (E[])new Object[data.length*2];
      for(int i = 0; i < start;i++){
        d[i] = data[i];
      }
      for(int i = end; i < data.length;i++){
        d[i+data.length] = data[i];
      }
        end += data.length;
      data = d;

    }
    public MyDeque(){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[10];
        data = d;
        start = 0;
        size = 0;
        end = d.length-1;
    }
    public MyDeque(int initialCapacity){
      @SuppressWarnings("unchecked")
      E[] d = (E[])new Object[initialCapacity];
      data = d;
      start = 0;
      size = 0;
      end = d.length-1;
    }
    public int size(){ return size;}
    public String toStringDebug(){ return Arrays.toString(data);}

    public void addFirst(E element){
      if(start == end+1) resize();
      data[start++] = element;
      size++;
    }
    public void addLast(E element){
      if(start == end+1) resize();
    data[end--] = element;
  size++;}
    public E removeFirst(){
      E d = data[start-1];
      data[(start++)-1] = null;
    size--;
    return d;
    }
    public E removeLast(){
      E d = data[end+1];
      data[(end--)+1] = null;
    size--;
    return d;
    }
    public E getFirst(){return data[start-1]; }
    public E getLast(){ return data[end+1];}
}

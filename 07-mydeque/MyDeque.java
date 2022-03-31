import java.util.*;
public class MyDeque<E>{
    private E[] data;
    private int size;
    private int start, end;
    private void resize(){
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
        end = d.length;
    }
    public MyDeque(int initialCapacity){
      @SuppressWarnings("unchecked")
      E[] d = (E[])new Object[initialCapacity];
      data = d;
      start = 0;
      size = 0;
      end = d.length;
    }
    public int size(){ return size;}
    public String toStringDebug(){ return Arrays.toString(data);}
    public String toString(){
      String out = "[";
      if(size == 0) return "[]";
      for(int i = start-1; i>=0;i--){
          if(end == data.length && i ==0) return out + data[0] + "]";
        out+= data[i]+ ", ";
      }

      for(int i = data.length-1; i >end;i--){

        out += data[i] + ", ";
      }
      return out + data[end]+"]";
    }
    public void addFirst(E element) {

      if(element == null) throw new NullPointerException("cannot add null value");
      if(start == end) resize();
      data[start] = element;
      start++;
      size++;
    }
    public void addLast(E element) {

      if(element == null) throw new NullPointerException("cannot add null value");
      if(start == end) resize();
    data[end-1] = element;
    end--;
  size++;}
    public E removeFirst(){
      if(size == 0) throw new NoSuchElementException("array is empty");
      E d = data[start-1];
      data[(start)-1] = null;
    size--;
    start--;
    return d;
    }
    public E removeLast(){
        if(size == 0) throw new NoSuchElementException("array is empty");
      E d = data[end];
      data[end] = null;
      end++;
    size--;
    return d;
    }
    public E getFirst(){  if(size == 0) throw new NoSuchElementException("array is empty");return data[start-1]; }
    public E getLast() {   if(size == 0) throw new NoSuchElementException("array is empty");return data[end+1];}
}

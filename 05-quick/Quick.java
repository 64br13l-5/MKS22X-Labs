import java.util.*;
public class Quick{
  public static int partition ( int [] data, int start, int end){
    if(end == start) return end;
    Random rng = new Random();
    int pivot = start + rng.nextInt(end-start);
    int val = data[pivot];
    data[pivot] = data[start];
    data[start] = val;
    pivot = start;
    int i = start+1;
   while (i<=end){
      if(data[i] < val) {
        i++;pivot++;
      }
      else{
        int x = data[i];
        data[i] = data[end];
        data[end]=x;
        end--;
      }
    }
    data[start] = data[pivot];
    data[pivot]=val;
    return pivot;
}
public static void quicksort(int[] data){
  int start = 0;
  int end = data.length-1;
  quicksort(data,start,end);
}
public static void quicksort(int[] data, int s, int e){
  if(s >= e) return;
  int i = partition(data,s,e);
  quicksort(data,i+1,e);
  quicksort(data,s,i);
}
/*return the value that is the kth smallest value of the array.
*@param data must have a length > 0
*@param k is 0 to data.length-1 inclusive
*@postcondition The array may be modified. */
public static int quickselect(int []data, int k){
  int start = 0;
  int end = data.length-1;
  while(true){
    int i = partition(data,start,end);
  if(k == i) return data[k];
  if(k < i) end = i-1;
  else start = i+1;
}
}
public static void main(String[] args){
  int [] data = new int[] {5,1,7,26,36,2,15,2,567,9,3,36};
 quicksort(data);
 System.out.println(Arrays.toString(data));

}

}

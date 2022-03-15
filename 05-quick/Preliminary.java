import java.util.*;
public class Preliminary{
  public static int partition ( int [] data, int start, int end){
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
      System.out.println(Arrays.toString(data));
    }
    data[start] = data[pivot];
    data[pivot]=val;
    return pivot;

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
  int [] data = new int[] {993,994,995,4,3,2,1,0,997,998,999};
System.out.println("Original: "+Arrays.toString(data));
int pivot = partition( data , 0, data.length-1);
System.out.println("Pivot value: "+data[pivot]+ ", Pivot index: "+pivot);
System.out.println("Modified: "+Arrays.toString(data));
System.out.println();

}

}

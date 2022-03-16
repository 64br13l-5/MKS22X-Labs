import java.util.*;
public class Quick{
  public static void swap(int[] data, int a, int b){
    int val = data[a];
    data[a] = data[b];
    data[b] = val;
  }
  public static int partition ( int [] data, int start, int end){
    if(end == start) return end;
    Random rng = new Random();
    int pivot = start + rng.nextInt(end-start);
    int val = data[pivot];
    swap(data,pivot,start);
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
    swap(data,pivot,start);
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
public static int[] arrgen(int len){
  int[] arr = new int[len];
  for(int i = 0;i< len;i++){
    arr[i]=(int)(Math.random() * 10000 -5000);
  }
  return arr;
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
  int[] nums =
    arrgen(1000000);

  int[] nums2 = nums.clone();
  quicksort(nums);
  Arrays.sort(nums2);
  if(Arrays.equals(nums,nums2)) System.out.println("Big Random Array Works");

}

}

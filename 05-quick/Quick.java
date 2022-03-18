import java.util.*;
public class Quick{
  private static void swap(int[] data, int a, int b){
    int val = data[a];
    data[a] = data[b];
    data[b] = val;
  }
  private static   Random rng = new Random();
  public static int partitionDutch ( int [] data, int lo, int hi){
    int c = 0;
    swap(data,(lo + rng.nextInt(hi-lo)),lo);
    while (lo+1<=hi){
      if(data[lo+1] < data[lo-c]) {
        swap(data,lo-c,lo+1);
        lo++;
      }
      else if(data[lo+1] > data[lo]){
        swap(data,lo+1,hi);
        hi--;
      }else{
        lo++;c++;
      }
    }
    return lo-c;
}
public static int partition ( int [] data, int lo, int hi){
int st = lo;
swap(data,(lo + rng.nextInt(hi-lo)),lo);
while (lo<hi)
  if(data[lo+1] < data[st]) lo++;
  else swap(data,lo+1,hi--);
swap(data,lo,st);
return lo;
}
public static void quicksort(int[] data){
  int lo = 0;
  int hi = data.length-1;
  quicksort(data,lo,hi);
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
  int lo = 0;
  int hi = data.length-1;
  while(true){
    int i = partition(data,lo,hi);
  if(k == i) return data[k];
  if(k < i) hi = i-1;
  else lo = i+1;
}
}
public static void main(String[] args){

  int[] nums = {
   2,2,3,3,1,1,-2,-2
  };
  int[] nums2 = {
   2,2,3,3,1,1,-2,-2
  };
  quicksort(nums);
  Arrays.sort(nums2);
  if(Arrays.equals(nums,nums2)) System.out.println("repeating works");
  nums = new int[] {
   1,2,3,4,5,6,7
  };
    nums2 = new int[] {
  1,2,3,4,5,6,7
  };
  quicksort(nums);
  Arrays.sort(nums2);
  if(Arrays.equals(nums,nums2)) System.out.println("presorted works");
  nums = new int[] {
   0,0,0,000,0
  };
  nums2 = new int[] {
   0000,0,0,00,0
  };
  quicksort(nums);
  Arrays.sort(nums2);
  if(Arrays.equals(nums,nums2)) System.out.println("0s work");
  nums = new int[] {
   5,4,3,2,1
  };
  nums2 = new int[] {
   5,4,3,2,1
  };
  quicksort(nums);
  Arrays.sort(nums2);
  if(Arrays.equals(nums,nums2)) System.out.println("reverse works");
  nums =
    arrgen(5000000);

  nums2 = nums.clone();
  quicksort(nums);
  Arrays.sort(nums2);
  if(Arrays.equals(nums,nums2)) System.out.println("Big Random Array Works");
  nums = new int[] {
   6,7,89,4,2,4
  };
  nums2 = new int[] {
    6,7,89,4,2,4
  };
  quicksort(nums);
  Arrays.sort(nums2);

  if(Arrays.equals(nums,nums2)) System.out.println("Test Array works");


}

}

import java.util.*;
public class Merge{

public static int[] arrgen(int len){
  int[] arr = new int[len];
  for(int i = 0;i< len;i++){
    arr[i]=(int)(Math.random() * 10000 -5000);
  }
  return arr;
}
public static void merge(int[]destination, int[]temp, int leftIndex,int rightIndex , int middleIndex ){

}
  public static int[] merge(int [] left, int[] right){
          //return a new array that is the merged version of left and right
          int[] sol = new int[left.length+right.length];
          int j = 0;
          int i = 0;
          while(i < left.length || j < right.length){
            if(i == left.length) {sol[i+j] = right[j++];continue;}
            if(j ==right.length){sol[i+j] = left[i++];continue;}
            if(left[i] < right[j])sol[i+j] = left[i++];
            else sol[i+j] = right[j++];
          }
          return sol;
        }
        public static int[] insertionSort(int[] ary){
        for(int i =1; i < ary.length; i++){
          int j = i-1;
          int oldi = ary[i];
          while ( j >= 0 && oldi <= ary[j] ){
            ary[j+1] = ary[j];
            j--;
          }
          ary[j+1] = oldi;
        }
        return ary;
        }
        public static int[] mergesortH(int [] data){
           if(data.length > 43) return merge(mergesortH(Arrays.copyOfRange(data, 0, data.length/2)),mergesortH(Arrays.copyOfRange(data, data.length/2, data.length)));
           return insertionSort(data); //so this compiles
         }

         /*mergesort uses the recursive mergesortH method to create a sorted
         *version of the array. It then copies the data back into the original
         *array. (This is for compatibility with prior sort testers)
         *@param data the array to be sorted, this will be modified by the method
         */
         public static void mergesort(int [] data){
           int [] temp  =  mergesortH(data);
           for(int i = 0; i < data.length; i++){
             data[i] = temp[i];
           }
         }

        public static void main(String[] args){
          int[] nums = {
       2,2,3,3,1,1,-2,-2
     };

    int[] nums2 = {
     2,2,3,3,1,1,-2,-2
    };
    mergesort(nums);
    Arrays.sort(nums2);
    if(Arrays.equals(nums,nums2)) System.out.println("repeating works");
    nums = new int[] {
     1,2,3,4,5,6,7
    };
      nums2 = new int[] {
    1,2,3,4,5,6,7
    };
    mergesort(nums);
    Arrays.sort(nums2);
    if(Arrays.equals(nums,nums2)) System.out.println("presorted works");
    nums = new int[] {
     0,0,0,000,0
    };
    nums2 = new int[] {
     0000,0,0,00,0
    };
    mergesort(nums);
    Arrays.sort(nums2);
    if(Arrays.equals(nums,nums2)) System.out.println("0s work");
    nums = new int[] {
     5,4,3,2,1
    };
    nums2 = new int[] {
     5,4,3,2,1
    };
    mergesort(nums);

    Arrays.sort(nums2);

    if(Arrays.equals(nums,nums2)) System.out.println("reverse works");
    nums =
      arrgen(5000000);

    nums2 = nums.clone();
      long start =System.currentTimeMillis();
    mergesort(nums);
      long end =System.currentTimeMillis();
      System.out.println("size 5 million array took: "+ ((float)(end - start)/1000) + " (s)");
    Arrays.sort(nums2);
    if(Arrays.equals(nums,nums2)) System.out.println("Big Random Array Works");
    nums = new int[] {
     6,7,89,4,2,4
    };
    nums2 = new int[] {
      6,7,89,4,2,4
    };
    mergesort(nums);
    Arrays.sort(nums2);

    if(Arrays.equals(nums,nums2)) System.out.println("Test Array works");
        }
      }

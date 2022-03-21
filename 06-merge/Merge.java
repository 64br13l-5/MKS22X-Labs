import java.util.*;
public class Merge{
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

       public static  void mergesort(data){
          int [] temp  =  mergeSortH(data);
          copy temp into data
        }

         public static int[] mergesortH(data){
          if more than 1 element{
            left = copy half of data
            right = copy other half of data
            return merge(mergesortH(left),mergesortH(right))


        public static void main(String[] args){
          System.out.println(Arrays.toString(merge(new int[] {0,1,2,3},new int[] {2,4,6,8})));
        }
      }

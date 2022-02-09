public class PartialSum{
  public static void main(String[]   args){
    int[] nums = {1,3,2,267};
      System.out.println(partialSum(0,nums,3));
      int[] nums2 = {2,4,8};
      System.out.println(partialSum(0,nums2,10));
      System.out.println(partialSum(0,nums2,14));
      System.out.println(partialSum(0,nums2,9));
      int[] nums3 = {2,3,7,10};
      System.out.println(partialSum(0,nums3,9));

  }

  public static boolean partialSum(int start,int[] arr,int targetValue){
    if(arr.length == 0) return targetValue == 0;
    if(arr.length == 1) return targetValue == 0 || targetValue == arr[0];
    if(targetValue-arr[start] == 0 )return true;
    if(start == arr.length-1)return false;
    return (partialSum(start+1,arr,targetValue-arr[start]) ||  partialSum(start+1,arr,targetValue));


  }


}

public class PartialSum{
  public static void main(String[]   args){
    int[] nums = {1,3,2,267};
      System.out.println(partialSum(0,nums,3));
  }

  public static boolean partialSum(int start,int[] arr,int targetValue){
    if(targetValue-arr[start] == 0 )return true;
    if(start == arr.length-1)return false;
    return (partialSum(start+1,arr,targetValue-arr[start]) ||  partialSum(start+1,arr,targetValue));


  }


}

public  class Recursion4Real{
  public static void main (String[] args){
    int[] arr = {9};
    System.out.println(groupSum(0,arr,0));
  }
  public static boolean groupSum(int start, int[] nums, int target) {
  //just PartialSum
  if(nums.length == 0) return target == 0;
  if(nums.length == 1) return target == 0 || target == nums[0];
  if(target-nums[start] == 0 )return true;
  if(start == nums.length-1)return false;
  return (groupSum(start+1,nums,target-nums[start]) ||  groupSum(start+1,nums,target));
}
}

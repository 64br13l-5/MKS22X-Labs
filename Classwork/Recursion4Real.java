public  class Recursion4Real{
  public static void main (String[] args){

  }
  public static boolean groupSum(int start, int[] nums, int target) {
  //just PartialSum
  if(target-nums[start] == 0 )return true;
  if(start == nums.length-1)return false;
  return (groupSum(start+1,nums,target-nums[start]) ||  groupSum(start+1,nums,target));
}
}

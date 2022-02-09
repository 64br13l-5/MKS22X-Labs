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
public static boolean splitArray(int[] nums) {
  return splitArray(0,0,0,nums);
}
public static boolean splitArray(int i, int t1, int t2, int[] nums){
if(i == nums.length-1)return t1 == t2;
if(splitArray(start+1,nums,t1-nums[start],t2) ||  splitArray(start+1,nums,t1,t2-nums[start])){
return true;
}
return false;
}
}
